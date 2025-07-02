package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Embeddable
@EqualsAndHashCode
public class CertidaoTpdocPk implements java.io.Serializable {

    @Column(name = "certi_codigo")
    private Integer certiCodigo;

    @Column(name = "tpdoc_codigo")
    private Integer tpdocCodigo;

    @Tolerate
    public CertidaoTpdocPk() {
        // Method default for hibernate
    }

    @Builder
    public CertidaoTpdocPk(Integer certiCodigo, Integer tpdocCodigo) {
        this.certiCodigo = certiCodigo;
        this.tpdocCodigo = tpdocCodigo;
    }
}
