package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "analise_etapa_prazo")
@SequenceGenerator(name = "SEQ_ANALISE_ETAPA_PRAZO", sequenceName = "SEQ_ANALISE_ETAPA_PRAZO", allocationSize = 1)
public class AnaliseEtapaPrazo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assuming sequence or auto-increment for ansep_codigo
    @Column(name = "ansep_codigo")
    private Integer ansepCodigo;

    @Column(name = "ansep_data_fim")
    private LocalDateTime ansepDataFim;

    @Column(name = "ansep_data_inicio")
    private LocalDateTime ansepDataInicio;

    @Column(name = "ansep_prazo")
    private Integer ansepPrazo;

    @ManyToOne
    @JoinColumn(name = "anlse_codigo", referencedColumnName = "anlse_codigo")
    private Analise analise;

    @ManyToOne
    @JoinColumn(name = "anset_codigo", referencedColumnName = "anset_codigo")
    private AnaliseEtapa analiseEtapa;

    @ManyToOne
    @JoinColumn(name = "user_codigo", referencedColumnName = "user_codigo") // user_codigo is NULLABLE
    private Usuario usuario;

    @Column(name = "anlsep_obs")
    private String anlsepObs; // text type

    @Column(name = "status", length = 255)
    private String status;

    @Column(name = "ansep_data_inicio_automatico")
    private LocalDateTime ansepDataInicioAutomatico;

    @Column(name = "ansep_data_fim_automatico")
    private LocalDateTime ansepDataFimAutomatico;

    @Tolerate
    public AnaliseEtapaPrazo() {
        // Method default for hibernate
    }

    @Builder
    public AnaliseEtapaPrazo(Integer ansepCodigo, LocalDateTime ansepDataFim, LocalDateTime ansepDataInicio,
                             Integer ansepPrazo, Analise analise, AnaliseEtapa analiseEtapa, Usuario usuario,
                             String anlsepObs, String status, LocalDateTime ansepDataInicioAutomatico, LocalDateTime ansepDataFimAutomatico) {
        this.ansepCodigo = ansepCodigo;
        this.ansepDataFim = ansepDataFim;
        this.ansepDataInicio = ansepDataInicio;
        this.ansepPrazo = ansepPrazo;
        this.analise = analise;
        this.analiseEtapa = analiseEtapa;
        this.usuario = usuario;
        this.anlsepObs = anlsepObs;
        this.status = status;
        this.ansepDataInicioAutomatico = ansepDataInicioAutomatico;
        this.ansepDataFimAutomatico = ansepDataFimAutomatico;
    }
}