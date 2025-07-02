package com.sorted.lac.service.repository.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sorted.lac.service.repository.fce.FceAtividade;
import com.sorted.lac.service.repository.licenca.Licenca;
import com.sorted.lac.service.repository.licenca.LicencaModelo;
import jakarta.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "TIPO_LICENCA")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class TipoLicenca implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer tplicCodigo;
    private SatClasse satClasse;
    private String tplicDescricao;
    private String tplicSigla;
    private Integer tplicSomatorio;
    private Integer codigoAssuntoSgpe;
    private Set<AtividadeTpdoc> atividadeTpdocs = new HashSet<AtividadeTpdoc>(0);
    private Set<FceAtividade> fceAtividades = new HashSet<FceAtividade>(0);
    private Set<BaseCalculo> baseCalculos = new HashSet<BaseCalculo>(0);
    private Set<Licenca> licencas = new HashSet<Licenca>(0);
    private Set<ModeloInTpdoc> modeloInTpdocs = new HashSet<ModeloInTpdoc>(0);
    private List<LicencaModelo> licencaModelos;
    private List<AnaliseEtapaTplic> analiseEtapaTplics;

    public TipoLicenca() {
    }

    public TipoLicenca(TipoLicenca tl) {
        this.tplicCodigo = tl.tplicCodigo;
        this.tplicDescricao = tl.tplicDescricao;
        this.tplicSigla = tl.tplicSigla;
        this.atividadeTpdocs = tl.atividadeTpdocs;
        this.fceAtividades = tl.fceAtividades;
        this.baseCalculos = tl.baseCalculos;
        this.licencas = tl.licencas;
        this.modeloInTpdocs = tl.modeloInTpdocs;
    }

    public TipoLicenca(Integer tplicCodigo, String tplicDescricao, String tplicSigla) {
        this.tplicCodigo = tplicCodigo;
        this.tplicDescricao = tplicDescricao;
        this.tplicSigla = tplicSigla;
    }

    public TipoLicenca(Integer tplicCodigo, String tplicDescricao, String tplicSigla,
                       Set<AtividadeTpdoc> atividadeTpdocs, Set<Licenca> licencas, Set<ModeloInTpdoc> modeloInTpdocs,
                       Set<FceAtividade> fceAtividades, Set<BaseCalculo> baseCalculos) {
        this.tplicCodigo = tplicCodigo;
        this.tplicDescricao = tplicDescricao;
        this.tplicSigla = tplicSigla;
        this.atividadeTpdocs = atividadeTpdocs;
        this.fceAtividades = fceAtividades;
        this.baseCalculos = baseCalculos;
        this.licencas = licencas;
        this.modeloInTpdocs = modeloInTpdocs;
    }

    @Id
    @Column(name = "TPLIC_CODIGO", unique = true, precision = 10)
    public Integer getTplicCodigo() {
        return this.tplicCodigo;
    }

    public void setTplicCodigo(Integer tplicCodigo) {
        this.tplicCodigo = tplicCodigo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SATCL_CODIGO")
    public SatClasse getSatClasse() {
        return this.satClasse;
    }

    public void setSatClasse(SatClasse satClasse) {
        this.satClasse = satClasse;
    }

    @Column(name = "TPLIC_DESCRICAO", length = 50)
    public String getTplicDescricao() {
        return this.tplicDescricao;
    }

    public void setTplicDescricao(String tplicDescricao) {
        this.tplicDescricao = tplicDescricao;
    }

    @Column(name = "TPLIC_SIGLA", length = 30)
    public String getTplicSigla() {
        return this.tplicSigla;
    }

    public void setTplicSigla(String tplicSigla) {
        this.tplicSigla = tplicSigla;
    }

    @Column(name = "TPLIC_SOMATORIO", nullable = true)
    public Integer getTplicSomatorio() {
        return this.tplicCodigo;
    }

    public void setTplicSomatorio(Integer tplicSomatorio) {
        this.tplicSomatorio = tplicSomatorio;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoLicenca")
    public Set<AtividadeTpdoc> getAtividadeTpdocs() {
        return this.atividadeTpdocs;
    }

    public void setAtividadeTpdocs(Set<AtividadeTpdoc> atividadeTpdocs) {
        this.atividadeTpdocs = atividadeTpdocs;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoLicenca")
    public Set<FceAtividade> getFceAtividades() {
        return this.fceAtividades;
    }

    public void setFceAtividades(Set<FceAtividade> fceAtividades) {
        this.fceAtividades = fceAtividades;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoLicenca")
    public Set<BaseCalculo> getBaseCalculos() {
        return this.baseCalculos;
    }

    public void setBaseCalculos(Set<BaseCalculo> baseCalculos) {
        this.baseCalculos = baseCalculos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoLicenca")
    public Set<ModeloInTpdoc> getModeloInTpdocs() {
        return this.modeloInTpdocs;
    }

    public void setModeloInTpdocs(Set<ModeloInTpdoc> modeloInTpdocs) {
        this.modeloInTpdocs = modeloInTpdocs;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoLicenca")
    public Set<Licenca> getLicencas() {
        return this.licencas;
    }

    public void setLicencas(Set<Licenca> licencas) {
        this.licencas = licencas;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoLicenca")
    public List<LicencaModelo> getLicencaModelos() {
        return licencaModelos;
    }

    public void setLicencaModelos(List<LicencaModelo> licencaModelos) {
        this.licencaModelos = licencaModelos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoLicenca")
    public List<AnaliseEtapaTplic> getAnaliseEtapaTplics() {
        return analiseEtapaTplics;
    }

    public void setAnaliseEtapaTplics(List<AnaliseEtapaTplic> analiseEtapaTplics) {
        this.analiseEtapaTplics = analiseEtapaTplics;
    }

    @Column(name = "CODIGO_ASSUNTO_SGPE")
    public Integer getCodigoAssuntoSgpe() {
        return codigoAssuntoSgpe;
    }

    public void setCodigoAssuntoSgpe(Integer codigoAssuntoSgpe) {
        this.codigoAssuntoSgpe = codigoAssuntoSgpe;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tplicCodigo == null) ? 0 : tplicCodigo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        TipoLicenca other = (TipoLicenca) obj;
        if (tplicCodigo == null) {
            if (other.tplicCodigo != null) {
                return false;
            }
        } else if (!tplicCodigo.equals(other.tplicCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoLicenca [satClasse=" + satClasse.getSatclCodigo() + ", tplicCodigo=" + tplicCodigo
                + ", tplicDescricao=" + tplicDescricao + ", tplicSomatorio=" + tplicSomatorio + "]";
    }

}
