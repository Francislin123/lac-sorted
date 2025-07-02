package com.sorted.lac.service.enums;

public enum StatusEmpreendimentoEnum {
    EMPREENDIMENTO_CADASTRADO(1), SOLICITADO_CANCELAMENTO_EMPREENDIMENTO(2), EMPREENDIMENTO_CANCELADO(3);

    private Integer valor;

    StatusEmpreendimentoEnum(Integer valor) {
        this.valor = valor;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

}
