package com.sorted.lac.service.repository.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * @author BRASIL Direct - Softwares, Soluções e Serviços
 * @since 2008
 * @version 2.0
 */

@Entity
@Table(name = "SAT_CLASSE")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class SatClasse implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer satclCodigo;
    private SatReceita satReceita;
    private String satclDescricao;
    private String satclCodigoClasse;
    private Set<Exploracao> exploracaos = new HashSet<Exploracao>(0);
    private Set<TipoLicenca> tipoLicencas = new HashSet<TipoLicenca>(0);
    private Set<Certidao> certidaos = new HashSet<Certidao>(0);

    public SatClasse() {
    }

    public SatClasse(Integer satclCodigo, SatReceita satReceita,
                     String satclDescricao) {
        this.satclCodigo = satclCodigo;
        this.satReceita = satReceita;
        this.satclDescricao = satclDescricao;
    }

    public SatClasse(Integer satclCodigo, SatReceita satReceita,
                     String satclDescricao, String satclCodigoClasse,
                     Set<Exploracao> exploracaos, Set<TipoLicenca> tipoLicencas,
                     Set<Certidao> certidaos) {
        this.satclCodigo = satclCodigo;
        this.satReceita = satReceita;
        this.satclDescricao = satclDescricao;
        this.satclCodigoClasse = satclCodigoClasse;
        this.exploracaos = exploracaos;
        this.tipoLicencas = tipoLicencas;
        this.certidaos = certidaos;
    }

    @Id
    @Column(name = "SATCL_CODIGO", unique = true, precision = 22)
    public Integer getSatclCodigo() {
        return this.satclCodigo;
    }

    public void setSatclCodigo(Integer satclCodigo) {
        this.satclCodigo = satclCodigo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SATRE_CODIGO")
    public SatReceita getSatReceita() {
        return this.satReceita;
    }

    public void setSatReceita(SatReceita satReceita) {
        this.satReceita = satReceita;
    }

    @Column(name = "SATCL_DESCRICAO", length = 30)
    public String getSatclDescricao() {
        return this.satclDescricao;
    }

    public void setSatclDescricao(String satclDescricao) {
        this.satclDescricao = satclDescricao;
    }

    @Column(name = "SATCL_CODIGO_CLASSE", length = 10)
    public String getSatclCodigoClasse() {
        return this.satclCodigoClasse;
    }

    public void setSatclCodigoClasse(String satclCodigoClasse) {
        this.satclCodigoClasse = satclCodigoClasse;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "satClasse")
    public Set<Exploracao> getExploracaos() {
        return this.exploracaos;
    }

    public void setExploracaos(Set<Exploracao> exploracaos) {
        this.exploracaos = exploracaos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "satClasse")
    public Set<TipoLicenca> getTipoLicencas() {
        return this.tipoLicencas;
    }

    public void setTipoLicencas(Set<TipoLicenca> tipoLicencas) {
        this.tipoLicencas = tipoLicencas;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "satClasse")
    public Set<Certidao> getCertidaos() {
        return this.certidaos;
    }

    public void setCertidaos(Set<Certidao> certidaos) {
        this.certidaos = certidaos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((satclCodigo == null) ? 0 : satclCodigo.hashCode());
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
        SatClasse other = (SatClasse) obj;
        if (satclCodigo == null) {
            if (other.satclCodigo != null) {
                return false;
            }
        } else if (!satclCodigo.equals(other.satclCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SatClasse [satReceita=" + satReceita.getSatreCodigo() + ", satclCodigo="
                + satclCodigo + ", satclDescricao=" + satclDescricao + "]";
    }

}
