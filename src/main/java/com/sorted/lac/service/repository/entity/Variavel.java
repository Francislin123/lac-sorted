package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Entity
@Table(name = "VARIAVEL")
public class Variavel implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assumindo sequence ou auto-incremento para 'var_codigo'
    @Column(name = "var_codigo", nullable = false)
    private Integer varCodigo;

    @Column(name = "var_descricao", nullable = false, length = 200)
    private String varDescricao;

    @Column(name = "var_sigla", nullable = false, length = 50)
    private String varSigla;

    @ManyToOne
    @JoinColumn(name = "unidd_codigo", referencedColumnName = "unidd_codigo", nullable = false)
    private Unidade unidade;

    @Tolerate
    public Variavel() {
        // Default method for hibernate
    }

    @Builder
    public Variavel(Integer varCodigo, String varDescricao, String varSigla, Unidade unidade) {
        this.varCodigo = varCodigo;
        this.varDescricao = varDescricao;
        this.varSigla = varSigla;
        this.unidade = unidade;
    }
}
