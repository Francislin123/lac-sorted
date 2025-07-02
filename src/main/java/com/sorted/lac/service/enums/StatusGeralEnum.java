package com.sorted.lac.service.enums;

import lombok.Getter;

@Getter
public enum StatusGeralEnum {
    SEM_STATUS(0, ""),
    CADASTRADO(1, "Cadastrado"),
    SOLICITADO_CANCELAMENTO(2,"Cancelamento solicitado"),
    CANCELADO(3,"Cancelado"),
    RASCUNHO(4,"Em rascunho"),
    RECEBIDO(5,"Recebido"),
    EXCLUIDO(6,"Excluído"),
    ERRO_VERIFICAR(7,"Erro"),
    ASSINADO(8,"Assinado"),
    AUC_INDEFERIDA(9,"Indeferido");

    private Integer valor;
    private String descricao;

    StatusGeralEnum(Integer valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public static StatusGeralEnum valueOf(int id){
        for(StatusGeralEnum e : StatusGeralEnum.values()){
            if(e.ordinal() == id){
                return e;
            }
        }
        return SEM_STATUS;
    }

}
