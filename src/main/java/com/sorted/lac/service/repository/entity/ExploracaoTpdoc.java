package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Entity
@Table(name = "EXPLORACAO_TPDOC")
@SequenceGenerator(name = "SEQ_EXPLORACAO_TPDOC", sequenceName = "SEQ_EXPLORACAO_TPDOC", allocationSize = 1)
public class ExploracaoTpdoc implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "SEQ_EXPLORACAO_TPDOC")// Assuming sequence or auto-increment for extpd_codigo
    @Column(name = "extpd_codigo")
    private Integer extpdCodigo;

    @Column(name = "extpd_obrigatorio", length = 1)
    private String extpdObrigatorio; // bpchar(1)

    @Column(name = "extpd_sequencia")
    private Integer extpdSequencia;

    @ManyToOne
    @JoinColumn(name = "explo_codigo", referencedColumnName = "explo_codigo")
    // Assumindo que a entidade Exploracao existe
    private Exploracao exploracao;

    @ManyToOne
    @JoinColumn(name = "tpdoc_codigo", referencedColumnName = "tpdoc_codigo")
    private TipoDocumento tipoDocumento;


    @Tolerate
    public ExploracaoTpdoc() {
        // Method default for hibernate
    }

    @Builder
    public ExploracaoTpdoc(Integer extpdCodigo, String extpdObrigatorio, Integer extpdSequencia,
                           Exploracao exploracao, TipoDocumento tipoDocumento) {
        this.extpdCodigo = extpdCodigo;
        this.extpdObrigatorio = extpdObrigatorio;
        this.extpdSequencia = extpdSequencia;
        this.exploracao = exploracao;
        this.tipoDocumento = tipoDocumento;
    }
}
