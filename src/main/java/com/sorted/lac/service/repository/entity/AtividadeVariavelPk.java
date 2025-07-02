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
public class AtividadeVariavelPk implements java.io.Serializable {

    @Column(name = "ativ_codigo")
    private Integer ativCodigo;

    @Column(name = "atvar_ordem")
    private Integer atvarOrdem;

    @Column(name = "var_codigo")
    private Integer varCodigo;

    @Tolerate
    public AtividadeVariavelPk() {
        // Method default for hibernate
    }

    @Builder
    public AtividadeVariavelPk(Integer ativCodigo, Integer atvarOrdem, Integer varCodigo) {
        this.ativCodigo = ativCodigo;
        this.atvarOrdem = atvarOrdem;
        this.varCodigo = varCodigo;
    }
}
