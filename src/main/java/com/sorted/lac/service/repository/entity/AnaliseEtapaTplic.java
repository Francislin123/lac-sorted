package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "analise_etapa_tplic")
public class AnaliseEtapaTplic implements Serializable {

    @EmbeddedId
    private AnaliseEtapaTplicPk id;

    @ManyToOne
    @MapsId("ansetCodigo") // Mapeia anset_codigo da chave composta
    @JoinColumn(name = "anset_codigo", referencedColumnName = "anset_codigo")
    private AnaliseEtapa analiseEtapa;

    @ManyToOne
    @MapsId("tplicCodigo") // Mapeia tplic_codigo da chave composta
    @JoinColumn(name = "tplic_codigo", referencedColumnName = "tplic_codigo")
    // Assumindo que a entidade TipoLicenca existe
    private TipoLicenca tipoLicenca;

    @Column(name = "anset_prazo")
    private Integer ansetPrazo;

    @Tolerate
    public AnaliseEtapaTplic() {
        // Method default for hibernate
    }

    @Builder
    public AnaliseEtapaTplic(AnaliseEtapaTplicPk id, AnaliseEtapa analiseEtapa, TipoLicenca tipoLicenca, Integer ansetPrazo) {
        this.id = id;
        this.analiseEtapa = analiseEtapa;
        this.tipoLicenca = tipoLicenca;
        this.ansetPrazo = ansetPrazo;
    }
}