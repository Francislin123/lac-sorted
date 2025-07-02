package com.sorted.lac.service.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
@EqualsAndHashCode
class AnaliseEtapaTplicPk implements Serializable {

    @Column(name = "anset_codigo")
    private Integer ansetCodigo;

    @Column(name = "tplic_codigo")
    private Integer tplicCodigo;
}
