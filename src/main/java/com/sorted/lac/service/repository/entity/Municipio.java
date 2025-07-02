package com.sorted.lac.service.repository.entity;

import com.sorted.lac.service.repository.regional.Regional;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Entity
@Table(name = "MUNICIPIO")
public class Municipio implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "MUNIC_CODIGO", unique = true, nullable = false, precision = 22, scale = 0)
    private Integer municCodigo;

    @Column(name = "munic_cep", nullable = false)
    private Integer municCep;

    @Column(name = "munic_codigo_ibge")
    private Integer municCodigoIbge;

    @Column(name = "munic_descricao", nullable = false, length = 100)
    private String municDescricao;

    @Column(name = "municipio_codigo_sgpe")
    private Integer municipioCodigoSgpe;

    @ManyToOne
    @JoinColumn(name = "estad_uf", referencedColumnName = "estad_uf", nullable = false)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "reg_codigo", referencedColumnName = "reg_codigo")
    private Regional regional;

    @Tolerate
    public Municipio() {
        // Method default for hibernate
    }

    @Builder
    public Municipio(Integer municCep, Integer municCodigoIbge, String municDescricao, Integer municipioCodigoSgpe,
                     Estado estado, Regional regional) {
        this.municCep = municCep;
        this.municCodigoIbge = municCodigoIbge;
        this.municDescricao = municDescricao;
        this.municipioCodigoSgpe = municipioCodigoSgpe;
        this.estado = estado;
        this.regional = regional;
    }
}
