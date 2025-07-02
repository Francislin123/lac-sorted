package com.sorted.lac.service.enums;

public enum StatusTpdocEnum {
    SEM_STATUS(0,"SEM"),
    CANCELADO(1,"Cancelado"),
    OBRIGATORIO(2,"Obrigatório"),
    NAO_OBRIGATORIO(3,"Não Obrigatório"),
    EMITIDO(4,"Emitido"),
    RECEBIDO(5,"Recebido"),
    SOLICITADO_EXCLUSAO(6,"Solicitado Exclusão (Doc.Obrigatório)"),
    NEGADO_PEDIDO_EXCLUSAO(7,"Negado Pedido de Exclusão (Doc.Obrigatório)"),
    SOLICITADO_DOCUMENTO_AUSENTE(8,"Solicitado documento ausente"),
    SOLICITADO_DOCUMENTO_INADEQUADO(9,"Solicitado documento inadequado"),
    EXCLUIDO(10,"Excluido"),
    DIGITALIZADO(11,"Digitalizado"),
    AGUARDANDO_APROVACAO(12,"Aguardando Aprovação"),
    APROVADO_AGUARDANDO_DIGITALIZACAO(13,"Aprovado - Aguardando Digitalização"),
    APROVADO_AGUARDANDO_CONFIRMACAO(14,"Aprovado - Aguardando Confirmação"),
    RECEBIDO_DOCUMENTO_AUSENTE(15,"Recebido documento ausente"),
    RECEBIDO_DOCUMENTO_ADEQUADO(16,"Recebido documento adequado"),
    DOCUMENTO_COMPLEMENTAR(17,"Documento complementar"),
    SOLICITADO_DOCUMENTO_COMPLEMENTAR(18,"Solicitado documento complementar"),
    RECEBIDO_DOCUMENTO_COMPLEMENTAR(19,"Recebido documento complementar"),
    DOCUMENTO_PERDIDO_EM_CATATROFE_NATURAL(20,"Documento perdido em catástrofe natural"),
    SOLICITADA_DARE_COMPLEMENTAR(21,"Solicitada Dare Complementar"),
    RECEBIDO_FORMALIZACAO_CORRETIVA(22,"Recebido - Formalização Corretiva"),
    PENDENTE_FORMULARIO_DE_FORMALIZACAO_CORRETIVA(23,"Pendente - Formulário de Formalização Corretiva"),
    AGUARDANDO_ENVIO_DOCUMENTO_DIGITAL(24,"Aguardando Envio de Documento Digital"),
    DOCUMENTO_DIGITAL_ENVIADO(25,"Documento Digital Carregado"),
    DOCUMENTO_DIGITAL_ACEITO(26,"Documento Digital Aceito"),
    DOCUMENTO_DIGITAL_REJEITADO(27,"Documento Digital Rejeitado"),
    DOCUMENTO_SOLICITADO_ENVIADO(28,"Documento Solicitado Enviado"),
    DOCUMENTO_SOLICITADO_REJEITADO(29,"Documento Solicitado Rejeitado"),
    DOCUMENTO_SOLICITADO_ACEITO(30,"Documento Solicitado Aceito"),
    RESSARCIDO(31,"Ressarcido"),
    SUGERIDO_ALTERACAO_TIPO_LICENCA(32,"Sugestão Alterado Tipo Licenca"),
    DOCUMENTO_EXTERNO_SGPE(33,"Documento Externo SGPE"),
    DOCUMENTO_EXTERNO_PROTOCOLO(34,"Documento Externo Protocolo"),
    DOCUMENTO_ASSINADO_DIGITALMENTE(35,"Documento Assinado Digitalmente"),
    AGUARDANDO_ENVIO_PELA_PREFEITURA(36,"Aguardando Envio pela Prefeitura"),
    SOLICITADO_DOCUMENTO_ESCLARECIMENTO(37,"Solicitado Documento Esclarecimento"),
    DOCUMENTO_ESCLARECIMENTO_ENVIADO(38,"Documento Esclarecimento Enviado"),
    DOCUMENTO_ESCLARECIMENTO_ACEITO(39,"Documento Esclacerimento Aceito"),
    DOCUMENTO_ESCLARECIMENTO_REJEITADO(40,"Documento Esclarecimento Rejeitado"),
    AGUARDANDO_ASSINATURA_PRESIDENTE(41,"Aguardando Assinatura Presidente"),
    DOCUMENTO_DIGITAL_CONDICIONANTE(42,"Documento Digital Condicionante"),
    AGUARDANDO_ASSINATURA_GERENTE(43,"Aguardando Assinatura Gerente"),
    AGUARDANDO_ASSINATURA_DIRETOR(44,"Aguardando Assinatura Diretor"),
    SOLICITADO_MONITORAMENTO(45,"Solicitado Monitoramento"),
    ENVIADO_MONITORAMENTO(46,"Enviado Monitoramento"),
    RECEBIDO_MONITORAMENTO(47,"Recebido Monitoramento"),
    EMITIDO_MONITORAMENTO(48,"Emitido Monitoramento"),
    ;

    private Integer valor;
    private String descricao;

    StatusTpdocEnum(Integer valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public Integer getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusTpdocEnum valueOf(Integer valor) {
        for (StatusTpdocEnum st : StatusTpdocEnum.values()) {
            if (st.getValor().equals(valor)) {
                return st;
            }
        }

        return null;
    }

}
