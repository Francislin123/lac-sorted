package com.sorted.lac.service.repository.fce;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
class FceTpdocHistoricoPk implements Serializable {

    @Column(name = "fcetd_numero", nullable = false)
    private Integer fcetdNumero;

    @Column(name = "fctdh_data", nullable = false)
    private LocalDateTime fctdhData;

    @Tolerate
    public FceTpdocHistoricoPk() {
        // Method default for hibernate
    }

    @Builder
    public FceTpdocHistoricoPk(Integer fcetdNumero, LocalDateTime fctdhData) {
        this.fcetdNumero = fcetdNumero;
        this.fctdhData = fctdhData;
    }
}