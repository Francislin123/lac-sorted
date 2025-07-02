package com.sorted.lac.service.enums;

public enum StatusAuditoriaEnum {
    NAO_INICIADA(0, "Não iniciada"),
    RASCUNHO(1, "Rascunho"),
    CADASTRADO(2, "Cadastrado"),
    AGUARDANDO_ESCLARECIMENTO(3,"Aguardando Esclarecimento"),
    ANALISANDO_ESCLARECIMENTO(4,"Analisando Esclarecimento"),
    VALIDADO(5, "Validado"),
    CANCELADO(6, "CANCELADO");

    private Integer valor;
    private String descricao;

    StatusAuditoriaEnum(Integer valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public Integer getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public static StatusAuditoriaEnum valueOf(Integer valor){
        for(StatusAuditoriaEnum sA : StatusAuditoriaEnum.values()){
            if(sA.getValor().equals(valor)){
                return sA;
            }
        }
        return StatusAuditoriaEnum.NAO_INICIADA;
    }

}
