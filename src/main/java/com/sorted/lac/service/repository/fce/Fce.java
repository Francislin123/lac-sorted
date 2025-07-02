package com.sorted.lac.service.repository.fce;

import com.sorted.lac.service.enums.FaseEnum;
import com.sorted.lac.service.enums.StatusFceEnum;
import com.sorted.lac.service.enums.TipoJsonEnum;
import com.sorted.lac.service.repository.entity.*;
import com.sorted.lac.service.repository.licenca.Licenca;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Getter
@Setter
@Entity
@Table(name = "FCE")
@SequenceGenerator(name = "SEQ_FCE", sequenceName = "SEQ_FCE", allocationSize = 1)
public class Fce {

    @Id
    @GeneratedValue(generator = "SEQ_FCE")
    @Column(name = "FCE_CODIGO", unique = true, precision = 10)
    private Integer fceCodigo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TRMTE_CODIGO")
    private Tramite tramite;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "OBJRE_CODIGO")
    private ObjetoRequerimento objetoRequerimento;

    @Column(name = "FASE")
    @Enumerated(EnumType.STRING)
    private FaseEnum fase;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EMPTO_CODIGO")
    private Empreendimento empreendimento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_CODIGO")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TPFCE_CODIGO")
    private TipoFce tipoFce;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROC_CODIGO")
    private Processo processo;

    @Column(name = "LEGIS_CODIGO", nullable = true)
    private Integer legislacao;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private StatusFceEnum statusFce;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FCE_DATA_CADASTRO", length = 7)
    private LocalDateTime fceDataCadastro;

    @Column(name = "FCE_JUNTADA_STATUS")
    private Boolean fceJuntadaStatus;

    @Column(name = "DIGITAL", length = 1)
    private Boolean digital = Boolean.TRUE;

    @Column(name = "FCE_OBS", nullable = true, length = 500)
    private String fceObs;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fce")
    private List<FceTpdoc> fceTpdocs;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fce")
    private List<FceFase> fceFases;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "fce")
    private FceAtividade fceAtividade;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "fce")
    private FceCertidao fceCertidao;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "fce")
    private FceExploracao fceExploracao;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "fce")
    private FceLaboratorio fceLaboratorio;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fce")
    private List<Licenca> licencas;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fce")
    private List<FceVariavel> fceVariavels;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fce")
    private List<FceVariavelExtra> fceVariavelExtras;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fce")
    private List<Analise> analises;

    @Column(name = "TIPO_JSON")
    @Enumerated(EnumType.STRING)
    private TipoJsonEnum tipoJsonEnum;

    @Column(name = "JSON")
    private String json;

    @Column(name = "COD_REGIONAL_DESTINO", nullable = true, precision = 22)
    private Integer codRegionalDestino;

    @Tolerate
    public Fce() {
        // Method default for hibernate
    }

    @Builder
    public Fce(Integer fceCodigo, Tramite tramite, ObjetoRequerimento objetoRequerimento, FaseEnum fase, Empreendimento empreendimento, Usuario usuario, TipoFce tipoFce, Processo processo, Integer legislacao, StatusFceEnum statusFce, LocalDateTime fceDataCadastro, Boolean fceJuntadaStatus, Boolean digital, String fceObs, List<FceTpdoc> fceTpdocs, List<FceFase> fceFases, FceAtividade fceAtividade, FceCertidao fceCertidao, FceExploracao fceExploracao, FceLaboratorio fceLaboratorio, List<Licenca> licencas, List<FceVariavel> fceVariavels, List<FceVariavelExtra> fceVariavelExtras, List<Analise> analises, TipoJsonEnum tipoJsonEnum, String json, Integer codRegionalDestino) {
        this.fceCodigo = fceCodigo;
        this.tramite = tramite;
        this.objetoRequerimento = objetoRequerimento;
        this.fase = fase;
        this.empreendimento = empreendimento;
        this.usuario = usuario;
        this.tipoFce = tipoFce;
        this.processo = processo;
        this.legislacao = legislacao;
        this.statusFce = statusFce;
        this.fceDataCadastro = fceDataCadastro;
        this.fceJuntadaStatus = fceJuntadaStatus;
        this.digital = digital;
        this.fceObs = fceObs;
        this.fceTpdocs = fceTpdocs;
        this.fceFases = fceFases;
        this.fceAtividade = fceAtividade;
        this.fceCertidao = fceCertidao;
        this.fceExploracao = fceExploracao;
        this.fceLaboratorio = fceLaboratorio;
        this.licencas = licencas;
        this.fceVariavels = fceVariavels;
        this.fceVariavelExtras = fceVariavelExtras;
        this.analises = analises;
        this.tipoJsonEnum = tipoJsonEnum;
        this.json = json;
        this.codRegionalDestino = codRegionalDestino;
    }
}