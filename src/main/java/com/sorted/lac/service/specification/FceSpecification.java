package com.sorted.lac.service.specification;

import com.sorted.lac.service.enums.FaseEnum;
import com.sorted.lac.service.enums.TipoJsonEnum;
import com.sorted.lac.service.enums.TipoLicencaEnum;
import com.sorted.lac.service.repository.auditoria.Auditoria;
import com.sorted.lac.service.repository.fce.Fce;
import com.sorted.lac.service.repository.regional.Regional;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

public class FceSpecification {

    @Cacheable("listaLicencaAutomaticaPorRegional")
    public static Specification<Fce> listaLicencaAutomaticaPorRegional(final TipoJsonEnum tipoJsonEnum, final Regional regional, final boolean porteG, final boolean potencialGeralM, final boolean ultimoMes, String tipologiaSigla) {
        return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            // Auditoria dataSorteio > (um ano atrás)
            Subquery<Long> subAuditoriaData = query.subquery(Long.class);
            Root<Auditoria> auditoriaRoot = subAuditoriaData.from(Auditoria.class);
            subAuditoriaData.select(auditoriaRoot.get("fce").get("fceCodigo")).where(cb.greaterThan(auditoriaRoot.get("dataSorteio"), Timestamp.valueOf(LocalDateTime.now().minusYears(1).withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0))));
            predicates.add(cb.not(root.get("fceCodigo").in(subAuditoriaData)));

            // Auditoria com count > 1
            Subquery<Long> subAuditoriaCount = query.subquery(Long.class);
            Root<Auditoria> auditoriaCountRoot = subAuditoriaCount.from(Auditoria.class);
            subAuditoriaCount.select(auditoriaCountRoot.get("fce").get("fceCodigo")).groupBy(auditoriaCountRoot.get("fce").get("fceCodigo")).having(cb.gt(cb.count(auditoriaCountRoot.get("fce").get("fceCodigo")), 1));
            predicates.add(cb.not(root.get("fceCodigo").in(subAuditoriaCount)));

            // Fase não cancelado e fase LICENCA_CONCEDIDA
            predicates.add(cb.notEqual(root.get("fase"), FaseEnum.FCEI_CANCELADO));
            predicates.add(cb.equal(root.get("fase"), FaseEnum.LICENCA_CONCEDIDA));

            // TipoJsonEnum
            predicates.add(cb.equal(root.get("tipoJsonEnum"), tipoJsonEnum));

            // Regional
            predicates.add(cb.equal(root.get("empreendimento").get("endereco").get("municipio").get("regional").get("regCodigo"), regional.getRegCodigo()));

            // Tipologias específicas
            if (tipoJsonEnum == TipoJsonEnum.LAC_AVICULTURA || tipoJsonEnum == TipoJsonEnum.LAC_SUINO || tipoJsonEnum == TipoJsonEnum.LAC_TRANSPORTE || tipoJsonEnum == TipoJsonEnum.LAC_ANTENA) {

                predicates.add(root.get("fceAtividade").get("tipoLicenca").get("tplicCodigo").in(TipoLicencaEnum.LAC.getValor(), TipoLicencaEnum.RENLAC.getValor()));

            } else if (tipoJsonEnum == TipoJsonEnum.CONF_LAO || tipoJsonEnum == TipoJsonEnum.CONF_AUA_AUT) {

                predicates.add(cb.like(root.get("processo").get("procNumero"), tipologiaSigla + "%"));
            }

            // Porte G
            if (porteG) {
                predicates.add(cb.equal(root.get("fceAtividade").get("fceatPorte"), 'G'));
                predicates.add(cb.equal(root.get("fceAtividade").get("potencialGeral"), potencialGeralM ? 'M' : 'G'));
            }

            // Último mês
            if (ultimoMes) {
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime primeiroDiaMesAnterior = now.minusMonths(1).withDayOfMonth(1);
                LocalDateTime primeiroDiaMesAtual = now.withDayOfMonth(1);

                predicates.add(cb.between(root.get("fceDataCadastro"), primeiroDiaMesAnterior, primeiroDiaMesAtual));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
