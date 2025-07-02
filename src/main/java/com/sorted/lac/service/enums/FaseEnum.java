package com.sorted.lac.service.enums;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum FaseEnum {
    SEM_FASE("Sem"),
    CADASTRADO_AGUARDANDO_FORMALIZACAO("Cadastrado (aguardando formalização)"),
    FORMALIZADO_ENTREGA_DA_DOCUMENTACAO("Formalizado (entrega da documentação)"),
    CADASTRADO_NO_LEGADO("Cadastrado no legado"),
    EM_ANALISE_TECNICA("Em analise técnica"),
    EFETUADO_PARECER_TECNICO("Efetuado o parecer técnico"),
    SOLICITADO_DOCUMENTACAO_COMPLEMENTAR("Solicitado documentação complementar"),
    ENTREGUE_DOCUMENTACAO_COMPLEMENTAR("Entregue documentação complementar"),
    CANCELADO_SOLICITACAO_DE_DOCUMENTACAO_COMPLEMENTAR("Cancelado solicitação de documentação complementar"),
    EM_JULGAMENTO("Em julgamento"),
    EFETUADO_JULGAMENTO("Efetuado o julgamento"),
    EM_EIA("Em EIA"),
    EFETUADO_EIA("Efetuado o EIA"),
    LICENCA_CONCEDIDA("Licença ou certidão concedida"),
    LICENCA_INDEFERIDA("Licença indeferida"),
    LICENCA_ENTREGUE_AO_EMPREENDEDOR("Licença entregue ao Empreendedor"),
    SOLICITADO_CANCELAMENTO_FCEI("Solicitado cancelamento do FCEI"),
    SOLICITADO_CANCELAMENTO_DO_PROCESSO("Solicitado cancelamento do Processo"),
    SOLICITADO_CANCELAMENTO_DA_LICENCA("Solicitado cancelamento da Licença"),
    ENTROU_EM_PERIODO_DE_RECURSO_DIAS("Entrou em período de recurso (30 dias)"),
    EM_ANALISE_DO_RECURSO("Em análise do recurso"),
    EFETUADO_ANALISE_DO_RECURSO("Efetuado a análise do recurso"),
    PROCESSO_RETOMADO_POR_RECURSO("Processo retomado por recurso"),
    FCEI_CANCELADO("FCEI cancelado"),
    LICENCA_CANCELADA("Licença cancelada"),
    LICENCA_COM_VALIDADE_VENCIDA("Licença com validade vencida"),
    PROCESSO_ARQUIVADO_POR_NAO_APRESENTACAO_DE_RECURSO("Processo arquivado por não apresentação de recurso"),
    PROCESSO_ARQUIVADO_POR_REJEICAO_AO_RECURSO("Processo arquivado por rejeição ao recurso"),
    LAP_ENTREGUE_AO_EMPREENDEDOR(""),
    LAI_ENTREGUE_AO_EMPREENDEDOR(""),
    LAO_ENTREGUE_AO_EMPREENDEDOR(""),
    REN_LAO_ENTREGUE_AO_EMPREENDEDOR(""),
    AMP_LAP_ENTREGUE_AO_EMPREENDEDOR(""),
    AMP_LAI_ENTREGUE_AO_EMPREENDEDOR(""),
    AMP_LAO_ENTREGUE_AO_EMPREENDEDOR(""),
    LAP_CADASTRADA_NO_LEGADO(""),
    LAI_CADASTRADA_NO_LEGADO(""),
    LAO_CADASTRADA_NO_LEGADO(""),
    REN_LAO_CADASTRADA_NO_LEGADO(""),
    AMP_LAP_CADASTRADA_NO_LEGADO(""),
    AMP_LAI_CADASTRADA_NO_LEGADO(""),
    AMP_LAO_CADASTRADA_NO_LEGADO(""),
    AUA_CADASTRADA_NO_LEGADO(""),
    REN_AUA_CADASTRADA_NO_LEGADO(""),
    REN_LAI_CADASTRADA_NO_LEGADO(""),
    LAP_CONCEDIDA(""),
    LAI_CONCEDIDA(""),
    LAO_CONCEDIDA(""),
    LAP_COM_DISPENSA_DE_LAI_CONCEDIDA(""),
    LAP_INDEFERIDA(""),
    LAI_INDEFERIDA(""),
    LAO_INDEFERIDA(""),
    LAP_COM_DISPENSA_DE_LAI_INDEFERIDA(""),
    NAO_EXISTE(""),
    LAP_CANCELADA(""),
    LAI_CANCELADA(""),
    LAO_CANCELADA(""),
    LAP_COM_DISPENSA_DE_LAI_CANCELADA(""),
    AUC_CONCEDIDA("AuC concedida"),
    AUC_ENTREGUE_AO_EMPREENDEDOR(""),
    AUC_INDEFERIDA("AuC indeferida"),
    FORMALIZADO_CORRETIVAMENTE("Formalizado Corretivamente"),
    EFETUADO_CADASTRO_DA_CAMARA_TECNICA("Efetuado cadastro da Câmara Técnica"),
    CADASTRADO_AGUARDANDO_DOCUMENTO_DIGITAL("Cadastrado(Aguardando Documento Digital)"),
    ENCAMINHADO("Encaminhado"),
    REJEITADO_AGUARDANDO_REENVIO_DOCUMENTO_DIGITAL("Rejeitado(Aguardando Reenvio de Documento Digital)"),
    DOCUMENTACAO_COMPLEMENTAR_REJEITADA("Documentação Complementar Rejeitada"),
    CANCELADO_FCEI_DARE_RESSACIDA("Cancelado (Fcei Dare Ressarcida)"),
    EMISSAO_DA_LICENCA_OU_ATO_DE_INDEFERIMENTO("Emissão da Licença ou Ato de Indeferimento"),
    ENCAMINHADO_PARA_REATIVACAO("Encaminhado para Reativação"),
    REATIVADO("Reativado"),
    FCE_ARQUIVADO("Arquivado"),
    SOLICITADO_ARQUIVAMENTO("Solicitado_Arquivamento"),
    AGUARDANDO_ASSINATURA_DIGITAL("Aguardando Assinatura Digital"),
    DOCUMENTO_ASSINADO_DIGITALMENTE("Documento Assinado Digitalmente"),
    PROCESSO_PARECER_CONCLUIDO("Processo de Parecer Concluído"),
    EM_AUDITORIA("Em Auditoria"),
    //	SOLICITADO_ESCLARECIMENTO_AUDITORIA("Solicitado Esclarecimento Auditoria"),
    SOLICITADO_ESCLARECIMENTO_AUDITORIA("Solicitado Esclarecimento Docs - Aud. Doc/Pres"),
    SOLICITADO_DILACAO_ESCL_AUDITORIA("Solicitado Dilação Docs - Aud. Doc/Pres"),
    LICENCA_SUSPENSA_AUDITORIA("Licença Suspensa na Auditoria"),
    LICENCA_CANCELADA_AUDITORIA("Licença Cancelada na Auditoria"),
    ENTROU_EM_PERIODO_DE_RECURSO_DIAS_AUDITORIA("Entrou em período de recurso de Auditoria(30 dias)"),
    EM_ANALISE_DO_RECURSO_AUDITORIA("Em análise do recurso de Auditoria")
    ;

    public static List<FaseEnum> ABERTAS = new ArrayList<FaseEnum>();

    static {
        ABERTAS.add(CADASTRADO_AGUARDANDO_FORMALIZACAO);
        ABERTAS.add(FORMALIZADO_ENTREGA_DA_DOCUMENTACAO);
        ABERTAS.add(EM_ANALISE_TECNICA);
        ABERTAS.add(EFETUADO_PARECER_TECNICO);
        ABERTAS.add(SOLICITADO_DOCUMENTACAO_COMPLEMENTAR);
        ABERTAS.add(ENTREGUE_DOCUMENTACAO_COMPLEMENTAR);
        ABERTAS.add(CANCELADO_SOLICITACAO_DE_DOCUMENTACAO_COMPLEMENTAR);
        ABERTAS.add(EM_JULGAMENTO);
        ABERTAS.add(EM_EIA);
        ABERTAS.add(EFETUADO_EIA);
        ABERTAS.add(CADASTRADO_AGUARDANDO_DOCUMENTO_DIGITAL);
        ABERTAS.add(ENCAMINHADO);
        ABERTAS.add(REJEITADO_AGUARDANDO_REENVIO_DOCUMENTO_DIGITAL);
        ABERTAS.add(DOCUMENTACAO_COMPLEMENTAR_REJEITADA);
        ABERTAS.add(ENCAMINHADO_PARA_REATIVACAO);
        ABERTAS.add(REATIVADO);
        ABERTAS.add(AGUARDANDO_ASSINATURA_DIGITAL);

    }

    private String descricao;

    FaseEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public boolean isAguardandoDocumento() {
        return this.equals(CADASTRADO_AGUARDANDO_DOCUMENTO_DIGITAL);
    }

    public boolean isEntregeDdocumentacaoComplementar() {
        return this.equals(ENTREGUE_DOCUMENTACAO_COMPLEMENTAR);
    }

    public boolean isEncaminhado() {
        return this.equals(ENCAMINHADO) || this.equals(ENTROU_EM_PERIODO_DE_RECURSO_DIAS);
    }

    public boolean isReativado() {
        return this.equals(REATIVADO) || this.equals(ENCAMINHADO_PARA_REATIVACAO);
    }

    public boolean isemAditoria() {
        return this.equals(EM_AUDITORIA);
    }

    public boolean isSolicitadoEsclarecimentoAuditoria(){
        return this.equals(SOLICITADO_ESCLARECIMENTO_AUDITORIA);
    }
}
