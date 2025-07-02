package com.sorted.lac.service.repository.entity;

import com.sorted.lac.service.repository.fce.Fce;
import com.sorted.lac.service.repository.fce.FceTpdoc;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.experimental.Tolerate;

import java.util.List;

@Entity
@Table(name = "TRAMITE")
@SequenceGenerator(name = "SEQ_TRAMITE", sequenceName = "SEQ_TRAMITE")
public class Tramite implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer trmteCodigo;
    private TipoTramite tipoTramite;
    private Usuario usuario;
    private TramiteSituacao tramiteSituacao;
    private List<Processo> processos;
    private List<Fce> fces;
    private List<TramiteHistorico> tramiteHistoricos;
    private List<FceTpdoc> fceTpdocs;
    private List<TramiteGuia> tramiteGuias;
    private List<TramiteGuiaItem> tramiteGuiaItens;

    @Id
    @SequenceGenerator(name = "SEQ_FCE", sequenceName = "SEQ_FCE", allocationSize = 1)
    @Column(name = "TRMTE_CODIGO", unique = true, precision = 10)
    public Integer getTrmteCodigo() {
        return this.trmteCodigo;
    }

    public void setTrmteCodigo(Integer trmteCodigo) {
        this.trmteCodigo = trmteCodigo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TPTMT_CODIGO")
    public TipoTramite getTipoTramite() {
        return this.tipoTramite;
    }

    public void setTipoTramite(TipoTramite tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ATUAL")
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TMTSI_CODIGO")
    public TramiteSituacao getTramiteSituacao() {
        return this.tramiteSituacao;
    }

    public void setTramiteSituacao(TramiteSituacao tramiteSituacao) {
        this.tramiteSituacao = tramiteSituacao;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tramite")
    public List<Processo> getProcessos() {
        return this.processos;
    }

    public void setProcessos(List<Processo> processos) {
        this.processos = processos;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tramites")
    public List<TramiteGuia> getTramiteGuias() {
        return this.tramiteGuias;
    }

    public void setTramiteGuias(List<TramiteGuia> tramiteGuias) {
        this.tramiteGuias = tramiteGuias;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tramite")
    public List<Fce> getFces() {
        return this.fces;
    }

    public void setFces(List<Fce> fces) {
        this.fces = fces;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tramite")
    public List<TramiteHistorico> getTramiteHistoricos() {
        return this.tramiteHistoricos;
    }

    public void setTramiteHistoricos(List<TramiteHistorico> tramiteHistoricos) {
        this.tramiteHistoricos = tramiteHistoricos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tramite")
    public List<FceTpdoc> getFceTpdocs() {
        return this.fceTpdocs;
    }

    public void setFceTpdocs(List<FceTpdoc> fceTpdocs) {
        this.fceTpdocs = fceTpdocs;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tramite")
    public List<TramiteGuiaItem> getTramiteGuiaItens() {
        return tramiteGuiaItens;
    }

    public void setTramiteGuiaItens(List<TramiteGuiaItem> tramiteGuiaItens) {
        this.tramiteGuiaItens = tramiteGuiaItens;
    }

    @Tolerate
    public Tramite() {
    }

    @Builder
    public Tramite(Integer trmteCodigo, TipoTramite tipoTramite, Usuario usuario, TramiteSituacao tramiteSituacao, List<Processo> processos, List<Fce> fces, List<TramiteHistorico> tramiteHistoricos, List<FceTpdoc> fceTpdocs, List<TramiteGuia> tramiteGuias, List<TramiteGuiaItem> tramiteGuiaItens) {
        this.trmteCodigo = trmteCodigo;
        this.tipoTramite = tipoTramite;
        this.usuario = usuario;
        this.tramiteSituacao = tramiteSituacao;
        this.processos = processos;
        this.fces = fces;
        this.tramiteHistoricos = tramiteHistoricos;
        this.fceTpdocs = fceTpdocs;
        this.tramiteGuias = tramiteGuias;
        this.tramiteGuiaItens = tramiteGuiaItens;
    }
}
