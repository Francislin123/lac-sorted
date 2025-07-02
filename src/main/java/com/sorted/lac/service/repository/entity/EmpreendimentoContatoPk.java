package com.sorted.lac.service.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.experimental.Tolerate;

@EqualsAndHashCode
@Embeddable
public class EmpreendimentoContatoPk implements java.io.Serializable {

    @Column(name = "emptc_contato", nullable = false, length = 100)
    private String emptcContato;

    @Column(name = "empto_codigo", nullable = false)
    private Integer emptoCodigo;

    @Tolerate
    public EmpreendimentoContatoPk() {
        // Method default for hibernate
    }

    @Builder
    public EmpreendimentoContatoPk(String emptcContato, Integer emptoCodigo) {
        this.emptcContato = emptcContato;
        this.emptoCodigo = emptoCodigo;
    }

}
