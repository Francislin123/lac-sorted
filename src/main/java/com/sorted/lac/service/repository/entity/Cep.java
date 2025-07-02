package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "cep")
public class Cep implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assumindo sequence ou auto-incremento para 'cep_codigo'
    @Column(name = "cep_codigo", nullable = false)
    private Integer cepCodigo;

    @Column(name = "cep_bairro", length = 100)
    private String cepBairro;

    @Column(name = "cep_logradouro", length = 100)
    private String cepLogradouro;

    @ManyToOne
    @JoinColumn(name = "munic_codigo", referencedColumnName = "munic_codigo", nullable = false)
    private Municipio municipio; // Assumindo que a entidade Municipio existe

    @Tolerate
    public Cep() {
        // Method default for hibernate
    }

    @Builder
    public Cep(Integer cepCodigo, String cepBairro, String cepLogradouro, Municipio municipio) {
        this.cepCodigo = cepCodigo;
        this.cepBairro = cepBairro;
        this.cepLogradouro = cepLogradouro;
        this.municipio = municipio;
    }
}