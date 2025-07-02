package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Entity
@Table(name = "ATIVIDADE_TPDOC")
@SequenceGenerator(name = "SEQ_ATIVIDADE_TPDOC", sequenceName = "SEQ_ATIVIDADE_TPDOC", allocationSize=1)
public class AtividadeTpdoc implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attpd_codigo")
    private Integer attpdCodigo;

    @Column(name = "attpd_sequencia")
    private Integer attpdSequencia;

    @ManyToOne
    @JoinColumn(name = "ativ_codigo", referencedColumnName = "ativ_codigo")
    private Atividade atividade;

    @ManyToOne
    @JoinColumn(name = "tpdoc_codigo", referencedColumnName = "tpdoc_codigo")
    private TipoDocumento tipoDocumento;

    @ManyToOne
    @JoinColumn(name = "tplic_codigo", referencedColumnName = "tplic_codigo")
    private TipoLicenca tipoLicenca;

    @Column(name = "obrigatorio")
    private Boolean obrigatorio;

    @Column(name = "tac")
    private Boolean tac;

    @Tolerate
    public AtividadeTpdoc() {
        // Method default for hibernate
    }

    @Builder
    public AtividadeTpdoc(Integer attpdCodigo, Integer attpdSequencia, Atividade atividade, TipoDocumento tipoDocumento, TipoLicenca tipoLicenca, Boolean obrigatorio, Boolean tac) {
        this.attpdCodigo = attpdCodigo;
        this.attpdSequencia = attpdSequencia;
        this.atividade = atividade;
        this.tipoDocumento = tipoDocumento;
        this.tipoLicenca = tipoLicenca;
        this.obrigatorio = obrigatorio;
        this.tac = tac;
    }
}
