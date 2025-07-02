package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Entity
@Table(name = "UNIDADE")
public class Unidade implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assumindo sequence ou auto-incremento para 'unidd_codigo'
    @Column(name = "unidd_codigo", nullable = false)
    private Integer uniddCodigo;

    @Column(name = "unidd_descricao", nullable = false, length = 15)
    private String uniddDescricao;

    @Tolerate
    public Unidade() {
        // Default method
    }

    @Builder
    public Unidade(Integer uniddCodigo, String uniddDescricao) {
        this.uniddCodigo = uniddCodigo;
        this.uniddDescricao = uniddDescricao;
    }
}
