package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Entity
@Table(name = "MODELO_IN")
public class ModeloIn implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assuming sequence or auto-increment for modin_codigo
    @Column(name = "modin_codigo")
    private Integer modinCodigo;

    @Column(name = "modin_arquivo", length = 300)
    private String modinArquivo;

    @Column(name = "modin_descricao", length = 500)
    private String modinDescricao;

    @Column(name = "sha", length = 255)
    private String sha;

    @Tolerate
    public ModeloIn() {
        // Method default for hibernate
    }

    @Builder
    public ModeloIn(Integer modinCodigo, String modinArquivo, String modinDescricao, String sha) {
        this.modinCodigo = modinCodigo;
        this.modinArquivo = modinArquivo;
        this.modinDescricao = modinDescricao;
        this.sha = sha;
    }
}
