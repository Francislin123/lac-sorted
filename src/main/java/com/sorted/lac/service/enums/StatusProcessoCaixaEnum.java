package com.sorted.lac.service.enums;

public enum StatusProcessoCaixaEnum {

    INSERIDO(1,"Inserido"),
    RETIRADO_TEMPORARIAMENTE(2,"Retirado Temporariamente"),
    DEVOLVIDO(3,"Devolvido"),
    REMOVIDO_PERMANENTEMENTE(4,"Removido Permanentemente"),
    REMANEJADO(5,"Remanejado");

    private Integer valor;
    private String descricao;

    StatusProcessoCaixaEnum(Integer valor, String descricao) {
        this.valor = valor;
    }

    public Integer getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

}
