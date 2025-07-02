package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Entity
@Table(name = "CATEGORIA_FCE_OUTROS")
@SequenceGenerator(name = "SEQ_CATEGORIA_OUTROS", sequenceName = "SEQ_CATEGORIA_OUTROS", allocationSize = 1)
public class CategoriaFceOutros implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "SEQ_CATEGORIA_OUTROS")// Assuming sequence or auto-increment for catfo_codigo
    @Column(name = "catfo_codigo")
    private Integer catfoCodigo;

    @Column(name = "catfo_descricao", length = 200)
    private String catfoDescricao;

    @Column(name = "catfo_sigla", length = 1)
    private String catfoSigla; // bpchar(1)

    @ManyToOne
    @JoinColumn(name = "modin_codigo", referencedColumnName = "modin_codigo") // Can be NULL
    private ModeloIn modeloIn;

    @ManyToOne
    @JoinColumn(name = "satcl_codigo", referencedColumnName = "satcl_codigo") // Can be NULL
    // Assumindo que a entidade SatClasse existe
    private SatClasse satClasse;

    @ManyToOne
    @JoinColumn(name = "tpcfo_codigo", referencedColumnName = "tpcfo_codigo")
    // Assumindo que a entidade TipoCategoriaFceOutros existe
    private TipoCategoriaFceOutros tipoCategoriaFceOutros;

    @ManyToOne
    @JoinColumn(name = "var_codigo", referencedColumnName = "var_codigo") // Can be NULL
    private Variavel variavel;

    @Column(name = "tpdoc_diferenciado")
    private Boolean tpdocDiferenciado;

    @Tolerate
    public CategoriaFceOutros() {
        // Method default for hibernate
    }

    @Builder
    public CategoriaFceOutros(Integer catfoCodigo, String catfoDescricao, String catfoSigla, ModeloIn modeloIn,
                              SatClasse satClasse, TipoCategoriaFceOutros tipoCategoriaFceOutros, Variavel variavel,
                              Boolean tpdocDiferenciado) {
        this.catfoCodigo = catfoCodigo;
        this.catfoDescricao = catfoDescricao;
        this.catfoSigla = catfoSigla;
        this.modeloIn = modeloIn;
        this.satClasse = satClasse;
        this.tipoCategoriaFceOutros = tipoCategoriaFceOutros;
        this.variavel = variavel;
        this.tpdocDiferenciado = tpdocDiferenciado;
    }
}
