package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.experimental.Tolerate;

import java.time.LocalDateTime;

@EqualsAndHashCode
@Embeddable
public class EmpreendedorHistoricoPk implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "emphi_data_atualizacao", nullable = false)
    private LocalDateTime emphiDataAtualizacao;

    @Column(name = "user_codigo", nullable = false)
    private Integer userCodigo;

    @Tolerate
    public EmpreendedorHistoricoPk() {
        // Method default for hibernate
    }

    @Builder
    public EmpreendedorHistoricoPk(LocalDateTime emphiDataAtualizacao, Integer userCodigo) {
        this.emphiDataAtualizacao = emphiDataAtualizacao;
        this.userCodigo = userCodigo;
    }
}
