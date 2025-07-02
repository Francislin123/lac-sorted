package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Entity
@Table(name = "TIPO_DOCUMENTO")
@SequenceGenerator(name = "SEQ_TIPO_DOCUMENTO", sequenceName = "SEQ_TIPO_DOCUMENTO", allocationSize = 1)
public class TipoDocumento implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "SEQ_TIPO_DOCUMENTO")
    @Column(name = "tpdoc_codigo")
    private Integer tpdocCodigo;

    @Column(name = "tipo_documento_codigo_sgpe")
    private Integer tipoDocumentoCodigoSgpe;

    @Column(name = "tpdoc_descricao", nullable = false, length = 1000)
    private String tpdocDescricao;

    @Column(name = "tpdoc_resumo", nullable = false, length = 500)
    private String tpdocResumo;

    @Column(name = "tpdoc_versao_atual", nullable = false)
    private Integer tpdocVersaoAtual;

    @Column(name = "interno")
    private Boolean interno;

    @Column(name = "ativo")
    private Boolean ativo;

    @Tolerate
    public TipoDocumento() {
        // Method default for hibernate
    }

    @Builder
    public TipoDocumento(Integer tpdocCodigo, Integer tipoDocumentoCodigoSgpe, String tpdocDescricao,
                         String tpdocResumo, Integer tpdocVersaoAtual, Boolean interno, Boolean ativo) {
        this.tpdocCodigo = tpdocCodigo;
        this.tipoDocumentoCodigoSgpe = tipoDocumentoCodigoSgpe;
        this.tpdocDescricao = tpdocDescricao;
        this.tpdocResumo = tpdocResumo;
        this.tpdocVersaoAtual = tpdocVersaoAtual;
        this.interno = interno;
        this.ativo = ativo;
    }
}
