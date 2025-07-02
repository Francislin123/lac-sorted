package com.sorted.lac.service.component;

import com.sorted.lac.service.enums.SiglaEnum;
import com.sorted.lac.service.enums.TipoJsonEnum;
import com.sorted.lac.service.enums.TipoLicencaLacEnum;
import com.sorted.lac.service.exception.RegionalNaoEncontradaException;
import com.sorted.lac.service.repository.fce.Fce;
import com.sorted.lac.service.repository.regional.Regional;
import com.sorted.lac.service.repository.regional.RegionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class GetFceSorteados {

    @Autowired
    private RegionalRepository regionalRepository;

    @Autowired
    private SorteiaAutomaticas automaticas;

    public List<Fce> getFceSorteados(Map<String, Integer> filteredRegionaisMap, TipoLicencaLacEnum tipoLicencaEnum) {

        List<Fce> listFceSorteados = new ArrayList<>();

        for (Map.Entry<String, Integer> regionaisMap : filteredRegionaisMap.entrySet()) {

            Regional regional = getRegional(regionaisMap);

            TipoJsonEnum tipoJsonEnum = TipoJsonEnum.valueOf(tipoLicencaEnum.getNomeDaLicencaItemValue());

            if (tipoJsonEnum == TipoJsonEnum.CONF_LAO || tipoJsonEnum == TipoJsonEnum.CONF_AUA_AUT) {

                String[] siglas = Arrays.stream(SiglaEnum.values()).map(Enum::name).toArray(String[]::new);

                for (String tipologiaSigla : siglas) {
                    listFceSorteados = this.automaticas.sorteiaAutomaticas(tipoJsonEnum, regional, tipologiaSigla);
                }

            } else {
                listFceSorteados = this.automaticas.sorteiaAutomaticas(tipoJsonEnum, regional, "");
            }
        }
        return listFceSorteados;
    }

    @Cacheable("getRegional")
    private Regional getRegional(Map.Entry<String, Integer> regionaisMap) {
        return regionalRepository.findById(regionaisMap.getValue()).orElseThrow(() -> new RegionalNaoEncontradaException(regionaisMap.getValue()));
    }
}
