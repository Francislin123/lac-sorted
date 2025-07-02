package com.sorted.lac.service.component;

import com.sorted.lac.service.enums.TipoJsonEnum;
import com.sorted.lac.service.repository.fce.Fce;
import com.sorted.lac.service.repository.fce.FceRepository;
import com.sorted.lac.service.repository.regional.Regional;
import com.sorted.lac.service.specification.FceSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class QuantidadeSortear {

    @Autowired
    private FceRepository fceRepository;

    public int quantidadeSortear(TipoJsonEnum tipoJsonEnum, final Regional regional, String tipologiaSigla) {

        Specification<Fce> fceSpecification = FceSpecification.listaLicencaAutomaticaPorRegional(tipoJsonEnum, regional, false, false, true, tipologiaSigla);

        List<Fce> totalFces = fceRepository.findAll(fceSpecification);

        log.info("qtd total: {} Sigla: {}", totalFces.size(), tipologiaSigla);

        return (int) Math.ceil(totalFces.size() * 0.1);
    }
}
