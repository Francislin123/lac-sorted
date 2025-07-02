package com.sorted.lac.service.enums;

/**
 * Tipos de estudos determinados no CONSEMA, ou Indefinido para quando nao tem
 */
public enum TipoEstudoEnum {

    INDEFINIDO("Indefinido"),
    RAP("Relatório Ambiental Prévio"),
    EAS("Estudo Ambiental Simplificado"),
    EIA("Estudo de Impacto Ambiental"),
    ECA("Estudo de Conformidade Ambiental");

    private String descricao;

    private TipoEstudoEnum(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

    public String getName(){
        return this.name();
    }

}
