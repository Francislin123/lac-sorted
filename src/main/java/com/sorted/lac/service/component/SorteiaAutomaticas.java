package com.sorted.lac.service.component;

import com.sorted.lac.service.enums.TipoJsonEnum;
import com.sorted.lac.service.repository.fce.Fce;
import com.sorted.lac.service.repository.fce.FceRepository;
import com.sorted.lac.service.repository.licenca.Licenca;
import com.sorted.lac.service.repository.licenca.LicencaRepository;
import com.sorted.lac.service.repository.regional.Regional;
import com.sorted.lac.service.specification.FceSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Component
public class SorteiaAutomaticas {

    @Autowired
    private FceRepository fceRepository;

    @Autowired
    private QuantidadeSortear sortear;

    @Autowired
    private LicencaRepository licencaRepository;

    @Autowired
    private AdicionarAuditoria auditoria;

    List<Fce> totalFces = new ArrayList<>();

    public List<Fce> sorteiaAutomaticas(final TipoJsonEnum tipoJsonEnum, final Regional regional, final String tipologiaSigla) {

        int qtdSortearDesejada = sortear.quantidadeSortear(tipoJsonEnum, regional, tipologiaSigla);

        if (qtdSortearDesejada <= 0) {
            log.info("Nenhuma quantidade para sortear (qtdSortearDesejada <= 0). Retornando lista vazia para a regional: " + regional.getRegResumo());
            return totalFces;
        }

        Specification<Fce> fceSpecification = FceSpecification.listaLicencaAutomaticaPorRegional(tipoJsonEnum, regional, false, false, false, tipologiaSigla);
        List<Fce> fces = fceRepository.findAll(fceSpecification);

        if (fces.isEmpty()) {
            log.info("Nenhum FCE encontrado pela especificação inicial. Retornando lista vazia.");
            return totalFces;
        }

        List<Fce> fcesFiltrados = fces.parallelStream().filter(fce -> {
            Optional<Licenca> licencaOptional = getLicenca(fce);
            boolean passaFiltro = licencaOptional.map(licenca -> {
                boolean dataValidadeNaoNula = licenca.getLicenDataValidade() != null;
                boolean dataFutura = false;
                if (dataValidadeNaoNula) {
                    dataFutura = licenca.getLicenDataValidade().isAfter(LocalDateTime.now());
                }
                return dataValidadeNaoNula && dataFutura;
            }).orElseGet(() -> {
                System.out.println("FCE Código: " + fce.getFceCodigo() + ", Licença não encontrada.");
                return false;
            });
            return passaFiltro;
        }).collect(Collectors.toList());

        if (fcesFiltrados.isEmpty()) {
            log.info("Nenhum FCE válido após filtragem por data de validade. Retornando lista vazia.");
            return totalFces;
        }

        int quantidadeEfetivaASortear = Math.min(qtdSortearDesejada, fcesFiltrados.size());

        log.info("qtd fce inicial: {} | qtd fce filtrados e válidos: {} | qtd sorteado efetiva: {}", fces.size(), fcesFiltrados.size(), quantidadeEfetivaASortear);

        Random random = new Random();
        Collections.shuffle(fcesFiltrados, random);

        for (int i = 0; i < quantidadeEfetivaASortear; i++) {
            Fce sorteado = fcesFiltrados.get(i);

            this.auditoria.adicionarAuditoria(sorteado, regional);

            log.info(" Fce sorteado codigo {} , fase {} do tipo {}", sorteado.getFceCodigo(), sorteado.getFase().toString(), sorteado.getTipoJsonEnum());

            totalFces.add(sorteado);
        }

        return totalFces;
    }

    @Cacheable("getLicenca")
    private Optional<Licenca> getLicenca(Fce fce) {
        return this.licencaRepository.findUltimaLicencaConcedidaByFceCodigo(fce.getFceCodigo());
    }
}
