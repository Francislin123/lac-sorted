package com.sorted.lac.service.enums;

public enum StatusProcessoEnum {

    PROCESSO_CADASTRADO(1, "Processo Cadastrado"),
    PROCESSO_CANCELADO(2, "Processo Cancelado"),
    PROCESSO_ARQUIVADO(3, "Processo Arquivado"),;

    Integer valor;
    String descricao;

    private StatusProcessoEnum(Integer valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public Integer getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusProcessoEnum valueOf(Integer valor){
        for(StatusProcessoEnum status : StatusProcessoEnum.values()){
            if(status.getValor().equals(valor)){
                return status;
            }
        }
        return null;
    }
}
