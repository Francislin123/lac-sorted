package com.sorted.lac.service.repository.fce;

import com.sorted.lac.service.repository.entity.TipoDocumento;
import com.sorted.lac.service.repository.entity.Tramite;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Entity
@Table(name = "FCE_TPDOC")
@SequenceGenerator(name = "SEQ_FCE_TPDOC", sequenceName = "SEQ_FCE_TPDOC", allocationSize = 1)
public class FceTpdoc implements java.io.Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "SEQ_FCE_TPDOC")// Assumindo sequence ou auto-incremento para 'fcetd_numero'
    @Column(name = "fcetd_numero", nullable = false)
    private Integer fcetdNumero;

    @Column(name = "fcetd_observacao", length = 800)
    private String fcetdObservacao; // bpchar(800) mapeado para String

    @Column(name = "fcetd_qtde_paginas", nullable = false)
    private Integer fcetdQtdePaginas;

    @Column(name = "fcetd_sequencia", nullable = false)
    private Integer fcetdSequencia;

    @Column(name = "fcetd_versao_utilizada", nullable = false)
    private Double fcetdVersaoUtilizada; // float4 mapeado para Double

    @ManyToOne
    @JoinColumn(name = "fce_codigo", referencedColumnName = "fce_codigo", nullable = false)
    private Fce fce; // Assumindo que a entidade Fce existe

    @ManyToOne
    @JoinColumn(name = "tpdoc_codigo", referencedColumnName = "tpdoc_codigo", nullable = false)
    private TipoDocumento tipoDocumento; // Assumindo que a entidade TipoDocumento existe

    @ManyToOne
    @JoinColumn(name = "trmte_codigo", referencedColumnName = "trmte_codigo", nullable = false)
    private Tramite tramite; // Assumindo que a entidade Tramite existe

    @Column(name = "obrigatorio")
    private Boolean obrigatorio;

    @Column(name = "digital", nullable = false)
    private Boolean digital;

    @Column(name = "fcetd_juntada_status")
    private Boolean fcetdJuntadaStatus;

    @Column(name = "fcetd_outro_documento_status")
    private Boolean fcetdOutroDocumentoStatus;

    // Assumindo que "enum" na FK public.status_tpdoc("enum") é uma coluna varchar
    // Se StatusTpdoc for uma entidade ou um Enum Java, o mapeamento pode ser alterado.
    @Column(name = "status", length = 200)
    private String status;

    @Column(name = "status_auditoria")
    private String statusAuditoria;

    @Column(name = "justificativa_auditoria")
    private String justificativaAuditoria;

    @Column(name = "sem_assinatura_gerente")
    private Boolean semAssinaturaGerente;

    // Mapeamento para tipo PostGIS geometry(geometry, 31982) como String WKT
    // Se for necessário manipular a geometria, um UserType/biblioteca espacial seria necessário.
    @Column(name = "fcetd_geometria_wkt")
    private String fcetdGeometriaWkt;

    @Column(name = "monitor_relatorio_codigo")
    private Integer monitorRelatorioCodigo;

    @Tolerate
    public FceTpdoc() {
        // Method default for hibernate
    }

    @Builder
    public FceTpdoc(Integer fcetdNumero, String fcetdObservacao, Integer fcetdQtdePaginas, Integer fcetdSequencia, Double fcetdVersaoUtilizada, Fce fce, TipoDocumento tipoDocumento, Tramite tramite, Boolean obrigatorio, Boolean digital, Boolean fcetdJuntadaStatus, Boolean fcetdOutroDocumentoStatus, String status, String statusAuditoria, String justificativaAuditoria, Boolean semAssinaturaGerente, String fcetdGeometriaWkt, Integer monitorRelatorioCodigo) {
        this.fcetdNumero = fcetdNumero;
        this.fcetdObservacao = fcetdObservacao;
        this.fcetdQtdePaginas = fcetdQtdePaginas;
        this.fcetdSequencia = fcetdSequencia;
        this.fcetdVersaoUtilizada = fcetdVersaoUtilizada;
        this.fce = fce;
        this.tipoDocumento = tipoDocumento;
        this.tramite = tramite;
        this.obrigatorio = obrigatorio;
        this.digital = digital;
        this.fcetdJuntadaStatus = fcetdJuntadaStatus;
        this.fcetdOutroDocumentoStatus = fcetdOutroDocumentoStatus;
        this.status = status;
        this.statusAuditoria = statusAuditoria;
        this.justificativaAuditoria = justificativaAuditoria;
        this.semAssinaturaGerente = semAssinaturaGerente;
        this.fcetdGeometriaWkt = fcetdGeometriaWkt;
        this.monitorRelatorioCodigo = monitorRelatorioCodigo;
    }
}
