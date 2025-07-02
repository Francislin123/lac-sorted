package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.experimental.Tolerate;

import java.time.LocalDate;

/**
 * @author BRASIL Direct - Softwares, Soluções e Serviços
 * @version 2.0
 * @since 2008
 */

@Entity
@Table(name = "MUNICIPALIZACAO")
public class Municipalizacao implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "munic_codigo", nullable = false)
    private Integer municCodigo;

    @Column(name = "muniz_data_fim")
    private LocalDate munizDataFim;

    @Column(name = "muniz_data_inicio", nullable = false)
    private LocalDate munizDataInicio;

    @Column(name = "muniz_nivel_ativ_diferenciado", nullable = false, length = 1)
    private String munizNivelAtivDiferenciado; // bpchar(1)

    @Column(name = "muniz_numero", nullable = false, length = 80)
    private String munizNumero;

    @Column(name = "muniz_orgao", length = 100)
    private String munizOrgao;

    @ManyToOne
    @JoinColumn(name = "end_codigo", referencedColumnName = "end_codigo", nullable = false)
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "nivel_codigo", referencedColumnName = "nivel_codigo", nullable = false)
    // Assumindo que a entidade Nivel existe
    private Nivel nivel;

    @Tolerate
    public Municipalizacao() {
        // Method default for hibernate
    }

    @Builder
    public Municipalizacao(Integer municCodigo, LocalDate munizDataFim, LocalDate munizDataInicio,
                           String munizNivelAtivDiferenciado, String munizNumero, String munizOrgao,
                           Endereco endereco, Nivel nivel) {
        this.municCodigo = municCodigo;
        this.munizDataFim = munizDataFim;
        this.munizDataInicio = munizDataInicio;
        this.munizNivelAtivDiferenciado = munizNivelAtivDiferenciado;
        this.munizNumero = munizNumero;
        this.munizOrgao = munizOrgao;
        this.endereco = endereco;
        this.nivel = nivel;
    }
}
