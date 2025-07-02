package com.sorted.lac.service.enums;


public enum StatusDocumentoAuditEnum {
    NAO_AUDITADO(0,"Não auditado"),
    DOC_CORRETA(1,"Conforme"),
    DOC_INCORRETA(2,"Não Conforme"),
    //	DOC_INADEQUADA(3,"Doc. Inadequada"),
    SOLICITADO_COMPLEMENTO(4,"Solicitado Complementar"),
    //	EM_ANALISE(5,"Em análise"),
    CANCELADO(6,"Cancelado")
    ;

    private Integer valor;
    private String descricao;

    StatusDocumentoAuditEnum(Integer valor,String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static StatusDocumentoAuditEnum valueOf(Integer valor){
        for(StatusDocumentoAuditEnum ae : StatusDocumentoAuditEnum.values()){
            if(ae.getValor().equals(valor)){
                return ae;
            }
        }
        return StatusDocumentoAuditEnum.NAO_AUDITADO;
    }

}

