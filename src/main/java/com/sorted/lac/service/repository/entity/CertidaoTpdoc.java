package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Entity
@Table(name = "CERTIDAO_TPDOC")
public class CertidaoTpdoc implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CertidaoTpdocPk id;

    @ManyToOne
    @MapsId("certiCodigo") // Mapeia certi_codigo da chave composta
    @JoinColumn(name = "certi_codigo", referencedColumnName = "certi_codigo")
    private Certidao certidao;

    @ManyToOne
    @MapsId("tpdocCodigo") // Mapeia tpdoc_codigo da chave composta
    @JoinColumn(name = "tpdoc_codigo", referencedColumnName = "tpdoc_codigo")
    private TipoDocumento tipoDocumento;

    @Column(name = "cetpd_obrigatorio", length = 1)
    private String cetpdObrigatorio; // bpchar(1)

    @Column(name = "cetpd_sequencia")
    private Integer cetpdSequencia;


    @Tolerate
    public CertidaoTpdoc() {
        // Method default for hibernate
    }

    @Builder
    public CertidaoTpdoc(CertidaoTpdocPk id, Certidao certidao, TipoDocumento tipoDocumento, String cetpdObrigatorio, Integer cetpdSequencia) {
        this.id = id;
        this.certidao = certidao;
        this.tipoDocumento = tipoDocumento;
        this.cetpdObrigatorio = cetpdObrigatorio;
        this.cetpdSequencia = cetpdSequencia;
    }
}
