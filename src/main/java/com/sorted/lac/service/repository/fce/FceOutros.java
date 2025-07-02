package com.sorted.lac.service.repository.fce;

import com.sorted.lac.service.repository.entity.CategoriaFceOutros;
import com.sorted.lac.service.repository.licenca.LicencaValidade;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "FCE_OUTROS", uniqueConstraints = @UniqueConstraint(columnNames = {"FCE_CODIGO", "CATFO_CODIGO"}))
public class FceOutros implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assuming sequence or auto-increment for fce_codigo
    @Column(name = "fce_codigo")
    private Integer fceCodigo;

    @Column(name = "fceot_valor", precision = 19, scale = 2)
    private BigDecimal fceotValor;

    @ManyToOne
    @JoinColumn(name = "catfo_codigo", referencedColumnName = "catfo_codigo")
    private CategoriaFceOutros categoriaFceOutros;

    @ManyToOne
    @JoinColumn(name = "licva_codigo", referencedColumnName = "licva_codigo")
    private LicencaValidade licencaValidade;

    @Tolerate
    public FceOutros() {
        // Method default for hibernate
    }

    @Builder
    public FceOutros(Integer fceCodigo, BigDecimal fceotValor, CategoriaFceOutros categoriaFceOutros, LicencaValidade licencaValidade) {
        this.fceCodigo = fceCodigo;
        this.fceotValor = fceotValor;
        this.categoriaFceOutros = categoriaFceOutros;
        this.licencaValidade = licencaValidade;
    }
}
