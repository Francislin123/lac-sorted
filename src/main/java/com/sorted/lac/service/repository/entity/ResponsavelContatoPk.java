package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@EqualsAndHashCode
@Getter
@Setter
@Embeddable
public class ResponsavelContatoPk implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "respt_codigo", nullable = false)
    private Integer resptCodigo;

    @Column(name = "respc_contato", nullable = false, length = 100)
    private String respcContato;

    @Tolerate
    public ResponsavelContatoPk() {
        // Method default for hibernate
    }

    @Builder
    public ResponsavelContatoPk(Integer resptCodigo, String respcContato) {
        this.resptCodigo = resptCodigo;
        this.respcContato = respcContato;
    }
}
