package com.sorted.lac.service.enums;

public enum StatusTramiteGuiaEnum {

    AGUARDANDO_RECEBIMENTO(1, "Aguardando recebimento"),
    RECEBIDO(2,"Recebido"),
    CANCELADO(3,"Cancelado"),
    AGUARDANDO_ENVIO(4,"Aguardando envio"),
    ENVIADO(5,"Enviado");

    Integer valor;
    String name;

    StatusTramiteGuiaEnum(Integer valor, String name) {
        this.valor = valor;
    }

    public Integer getValor() {
        return valor;
    }

    public String getName() {
        return name;
    }
}
