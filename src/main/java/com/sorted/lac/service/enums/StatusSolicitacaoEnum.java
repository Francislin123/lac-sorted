package com.sorted.lac.service.enums;

public enum StatusSolicitacaoEnum {
    PENDENTE("PENDENTE"),
    ACEITA("ACEITA"),
    REJEITADA("REJEITADA");

    private String descricao;

    StatusSolicitacaoEnum(String descricao) {
        this.descricao = descricao;
    }


    public String getDescricao() {
        return descricao;
    }

}
