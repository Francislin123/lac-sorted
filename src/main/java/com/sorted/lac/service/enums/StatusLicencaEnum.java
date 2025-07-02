package com.sorted.lac.service.enums;

public enum StatusLicencaEnum {

    CONCEDIDA(1,"Concedida"),
    INDEFERIDA(2,"Indeferida"),
    CANCELADA(3,"Cancelada"),
    RASCUNHO(4,"Em rascunho"),
    VERSIONADA(5,""),
    SUSPENSA(6,"Suspensa");

    Integer valor;
    String descricao;

    StatusLicencaEnum(Integer valor,String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public Integer getValor() {
        return valor;
    }

    public static StatusLicencaEnum valueOf(Integer codStLic){
        for(StatusLicencaEnum status : StatusLicencaEnum.values()){
            if(status.valor.equals(codStLic)){
                return status;
            }
        }

        return null;
    }
    public String getDescricao(){
        return descricao;
    }

}

