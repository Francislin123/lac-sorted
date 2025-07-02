package com.sorted.lac.service.enums;


public enum EtapaAuditoriaEnum {

    AUDITORIA_OUT(0, "AUDITORIA_OUT"),
    NOMEACAO_EQUIPE(1, "Nomeacao da Equipe"),
    ANALISE_DOCUMENTAL(2, "Análise Documental"),
    ANALISE_PRESENCIAL(3, "Análise Presencial"),
    ANALISE_DOCUMENTAL_PRESENCIAL(4, "Análise Documental / Análise Presencial"),
    //	AGUARDANDO_ESCLARECIMENTO_DOC(5, "Aguardando Esclarecimento Documentos"),
    AGUARDANDO_ESCLARECIMENTO_DOC_PRES(5, "Aguardando Esclarecimento Documentos - Análise Doc/Pre."),
    ELABORACAO_RELATORIO_FINAL(6, "Elaboração Relatório Final"),
    AGUARDANDO_ASSINATURA_GERENTE(7, "Aguardando Assinatura Gerente"),
    FINALIZADO(8, "Finalizado"),
    //	SOLICITADO_RECURSO(9, "Solicitado Recurso"),
    EM_RECURSO(10, "Em Recurso"),
    AGUARDANDO_ASSINATURA_PRESIDENTE(11, "Aguardando Assinatura Presidente"),
    CONCLUIDO(12, "Concluído"),
    CANCELADO(13,"Cancelado");

    private Integer valor;
    private String descricao;

    EtapaAuditoriaEnum(Integer valor, String descricao) {
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

    public static EtapaAuditoriaEnum valueOf(Integer valor){
        for(EtapaAuditoriaEnum ae : EtapaAuditoriaEnum.values()){
            if(ae.getValor().equals(valor)){
                return ae;
            }
        }

        return EtapaAuditoriaEnum.AUDITORIA_OUT;
    }

}
