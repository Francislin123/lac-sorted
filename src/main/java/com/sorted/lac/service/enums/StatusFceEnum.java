package com.sorted.lac.service.enums;


public enum StatusFceEnum {
    SEM_STATUS(0, "Sem"),
    FCEI_CADASTRADO(1, "Cadastrado"),
    SOLICITADO_CANCELAMENTO_FCEI(2, "Solicitado o cancelamento desse FCEI"),
    FCEI_CANCELADO(3, "Cancelado"),
    INTEGRANTE_DE_EVENTO_PERDIDO(4, "Integrante de Evento ou Perdido"),
    FCEI_CANDIDATO_A_FORMALIZACAO_CORRETIVA(5, "Candidato a Formalização Corretiva"),
    FCEI_CANCELADO_120_240(6, "Cancelado pelo prazo"),
    FCEI_REATIVADO(7, "Reativado"),
    FCEI_ENVIADO_AO_MUNICIPIO(8, "Enviado ao município"),
    ARQUIVADO_PRAZO_MAXIMO_EXCLARECIMENTO(9, "Arquivado Prazo Maximo Esclarecimento"),
    ARQUIVADO_SOLICITACAO_REQUERENTE(10, "Arquivado Solicitação Requerent"),
    ARQUIVADO_OUTROS_MOTIVOS(11, "Arquivado Outros"),
    SOLICITADO_DILACAO_PRAZO(12,"Solicitado dilação de prazo da doc complementar");

    private Integer valor;
    private String descricao;

    StatusFceEnum(Integer valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public Integer getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusFceEnum valueOf(Integer valor) {
        for (StatusFceEnum tipoArquivFce : StatusFceEnum.values()) {
            if (tipoArquivFce.getValor().equals(valor)) {
                return tipoArquivFce;
            }
        }

        return FCEI_CANCELADO;
    }
}
