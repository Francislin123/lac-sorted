package com.sorted.lac.service.auxiliar;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sorted.lac.service.auxiliar.CheckBoxVariaveis.checkBoxVariaveis;
import static com.sorted.lac.service.auxiliar.SetRegionaisMap.setRegionaisMap;

@Slf4j
public class GetFilteredRegionaisMap {

    public static Map<String, Integer> getFilteredRegionaisMap(List<Boolean> listaCheckBoxes) {

        Map<String, Boolean> checkBoxRegionaisList = new HashMap<>();
        Map<String, Integer> regionaisMap = new HashMap<>();

        setRegionaisMap(regionaisMap);

        checkBoxVariaveis(checkBoxRegionaisList, listaCheckBoxes);

        Map<String, Integer> filteredRegionaisMap = new HashMap<>();

        for (Map.Entry<String, Boolean> entry : checkBoxRegionaisList.entrySet()) {
            if (entry.getValue()) {
                String regionalName = entry.getKey();
                Integer regionalCode = regionaisMap.get(regionalName);
                if (regionalCode != null) {
                    filteredRegionaisMap.put(regionalName, regionalCode);
                } else {
                    log.warn("Aviso: Chave '{}' encontrada em checkBoxRegionaisList com 'true' mas não em regionaisMap. Ignorando esta regional.", regionalName);
                }
            }
        }
        return filteredRegionaisMap;
    }
}
