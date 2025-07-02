package com.sorted.lac.service.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Entity
@Table(name = "ATIVIDADE_VALOR_DIFERENCIADO")
public class AtividadeValorDiferenciado implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ativ_codigo")
    private Integer ativCodigo;

    @Column(name = "ativd_custo_inicial")
    private Float ativdCustoInicial;

    @Column(name = "ativd_valor_multiplicativo")
    private Float ativdValorMultiplicativo;

    @Tolerate
    public AtividadeValorDiferenciado() {
        // Method default for hibernate
    }

    @Builder
    public AtividadeValorDiferenciado(Integer ativCodigo, Float ativdCustoInicial, Float ativdValorMultiplicativo) {
        this.ativCodigo = ativCodigo;
        this.ativdCustoInicial = ativdCustoInicial;
        this.ativdValorMultiplicativo = ativdValorMultiplicativo;
    }
}
