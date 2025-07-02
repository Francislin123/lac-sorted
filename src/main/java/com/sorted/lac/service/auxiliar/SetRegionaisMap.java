package com.sorted.lac.service.auxiliar;

import com.sorted.lac.service.enums.RegionalEnum;

import java.util.Map;

public class SetRegionaisMap {

    public static void setRegionaisMap(Map<String, Integer> regionaisMap) {
        regionaisMap.put("cbBlumenau", RegionalEnum.COORDENADORIA_DE_DESENVOLVIMENTO_AMBIENTAL_DE_BLUMENAU.getValor());
        regionaisMap.put("cbCacador", RegionalEnum.COORDENADORIA_DE_DESENVOLVIMENTO_AMBIENTAL_DE_CACADOR.getValor());
        regionaisMap.put("cbCanoinhas",
                RegionalEnum.COORDENADORIA_DE_DESENVOLVIMENTO_AMBIENTAL_DE_CANOINHAS.getValor());
        regionaisMap.put("cbChapeco", RegionalEnum.COORDENADORIA_DE_DESENVOLVIMENTO_AMBIENTAL_DE_CHAPECO.getValor());
        regionaisMap.put("cbConcordia",
                RegionalEnum.COORDENADORIA_DE_DESENVOLVIMENTO_AMBIENTAL_DE_CONCORDIA.getValor());
        regionaisMap.put("cbCriciuma", RegionalEnum.COORDENADORIA_DE_DESENVOLVIMENTO_AMBIENTAL_DE_CRICIUMA.getValor());
        regionaisMap.put("cbFlorianopolis",
                RegionalEnum.COORDENADORIA_DE_DESENVOLVIMENTO_AMBIENTAL_DA_GRANDE_FLORIANOPOLIS.getValor());
        regionaisMap.put("cbItajai", RegionalEnum.COORDENADORIA_DE_DESENVOLVIMENTO_AMBIENTAL_DE_ITAJAI.getValor());
        regionaisMap.put("cbJaraguadosul",
                RegionalEnum.COORDENADORIA_DE_DESENVOLVIMENTO_AMBIENTAL_DE_JARAGUA_DO_SUL.getValor());
        regionaisMap.put("cbJoacaba", RegionalEnum.COORDENADORIA_DE_DESENVOLVIMENTO_AMBIENTAL_DE_JOACABA.getValor());
        regionaisMap.put("cbJoinville",
                RegionalEnum.COORDENADORIA_DE_DESENVOLVIMENTO_AMBIENTAL_DE_JOINVILLE.getValor());
        regionaisMap.put("cbLages", RegionalEnum.COORDENADORIA_DE_DESENVOLVIMENTO_AMBIENTAL_DE_LAGES.getValor());
        regionaisMap.put("cbMafra", RegionalEnum.COORDENADORIA_DE_DESENVOLVIMENTO_AMBIENTAL_DE_MAFRA.getValor());
        regionaisMap.put("cbRiodosul",
                RegionalEnum.COORDENADORIA_DE_DESENVOLVIMENTO_AMBIENTAL_DE_RIO_DO_SUL.getValor());
        regionaisMap.put("cbSaomigueldooeste",
                RegionalEnum.COORDENADORIA_DE_DESENVOLVIMENTO_AMBIENTAL_DE_SAO_MIGUEL_DO_OESTE.getValor());
        regionaisMap.put("cbTubarao", RegionalEnum.COORDENADORIA_DE_DESENVOLVIMENTO_AMBIENTAL_DE_TUBARAO.getValor());
        regionaisMap.put("cbGRL", RegionalEnum.GERAL_TRANSPORTE_FORA_DO_ESTADO.getValor());
    }
}
