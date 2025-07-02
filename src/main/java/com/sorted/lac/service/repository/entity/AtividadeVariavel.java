package com.sorted.lac.service.repository.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Entity
@Table(name = "ATIVIDADE_VARIAVEL")
public class AtividadeVariavel implements java.io.Serializable {

    private static final long serialVersionUID = 6115030395504056590L;

    @EmbeddedId
    private AtividadeVariavelPk id;

    @ManyToOne
    @MapsId("ativCodigo") // Mapeia ativ_codigo da chave composta
    @JoinColumn(name = "ativ_codigo", referencedColumnName = "ativ_codigo")
    private Atividade atividade;

    @ManyToOne
    @MapsId("varCodigo") // Mapeia var_codigo da chave composta
    @JoinColumn(name = "var_codigo", referencedColumnName = "var_codigo")
    // Assumindo que a entidade Variavel existe
    private Variavel variavel;

    @Column(name = "atvar_valor_maximo", precision = 10, scale = 0) // Numeric(10)
    private BigDecimal atvarValorMaximo;

    @Column(name = "atvar_valor_medio", precision = 10, scale = 0) // Numeric(10)
    private BigDecimal atvarValorMedio;

    @Column(name = "atvar_valor_minimo", precision = 10, scale = 0) // Numeric(10)
    private BigDecimal atvarValorMinimo;

    @Tolerate
    public AtividadeVariavel() {
        // Method default for hibernate
    }

    @Builder
    public AtividadeVariavel(AtividadeVariavelPk id, Atividade atividade, Variavel variavel,
                             BigDecimal atvarValorMaximo, BigDecimal atvarValorMedio, BigDecimal atvarValorMinimo) {
        this.id = id;
        this.atividade = atividade;
        this.variavel = variavel;
        this.atvarValorMaximo = atvarValorMaximo;
        this.atvarValorMedio = atvarValorMedio;
        this.atvarValorMinimo = atvarValorMinimo;
    }
}
