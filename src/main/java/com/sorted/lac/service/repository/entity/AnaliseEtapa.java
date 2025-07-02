package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Entity
@Table(name = "analise_etapa")
public class AnaliseEtapa implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anset_codigo")
    private Integer ansetCodigo;

    @Column(name = "anset_descricao", length = 100)
    private String ansetDescricao;

    @Tolerate
    public AnaliseEtapa() {
        // Method default for hibernate
    }

    @Builder
    public AnaliseEtapa(Integer ansetCodigo, String ansetDescricao) {
        this.ansetCodigo = ansetCodigo;
        this.ansetDescricao = ansetDescricao;
    }
}
