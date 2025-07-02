package com.sorted.lac.service.repository.entity;

import java.util.HashSet;
import java.util.Set;

import com.sorted.lac.service.repository.fce.FceCertidao;
import jakarta.persistence.*;

@Entity
@Table(name = "CERTIDAO")
public class Certidao implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer certiCodigo;
    private ModeloIn modeloIn;
    private SatClasse satClasse;
    private Variavel variavel;
    private String certiDescricao;
    private Set<FceCertidao> fceCertidaos = new HashSet<FceCertidao>(0);
    private Set<CertidaoTpdoc> certidaoTpdocs = new HashSet<CertidaoTpdoc>(0);

    public Certidao() {
    }

    public Certidao(Integer certiCodigo, ModeloIn modeloIn, Variavel variavel, String certiDescricao) {
        this.certiCodigo = certiCodigo;
        this.modeloIn = modeloIn;
        this.variavel = variavel;
        this.certiDescricao = certiDescricao;
    }

    public Certidao(Integer certiCodigo, ModeloIn modeloIn, Variavel variavel, String certiDescricao,
                    Set<FceCertidao> fceCertidaos, Set<CertidaoTpdoc> certidaoTpdocs) {
        this.certiCodigo = certiCodigo;
        this.modeloIn = modeloIn;
        this.variavel = variavel;
        this.certiDescricao = certiDescricao;
        this.fceCertidaos = fceCertidaos;
        this.certidaoTpdocs = certidaoTpdocs;
    }

    @Id
    @Column(name = "CERTI_CODIGO", unique = true, precision = 22)
    public Integer getCertiCodigo() {
        return this.certiCodigo;
    }

    public void setCertiCodigo(Integer certiCodigo) {
        this.certiCodigo = certiCodigo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MODIN_CODIGO")
    public ModeloIn getModeloIn() {
        return this.modeloIn;
    }

    public void setModeloIn(ModeloIn modeloIn) {
        this.modeloIn = modeloIn;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SATCL_CODIGO")
    public SatClasse getSatClasse() {
        return this.satClasse;
    }

    public void setSatClasse(SatClasse satClasse) {
        this.satClasse = satClasse;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "VAR_CODIGO")
    public Variavel getVariavel() {
        return this.variavel;
    }

    public void setVariavel(Variavel variavel) {
        this.variavel = variavel;
    }

    @Column(name = "CERTI_DESCRICAO", length = 100)
    public String getCertiDescricao() {
        return this.certiDescricao;
    }

    public void setCertiDescricao(String certiDescricao) {
        this.certiDescricao = certiDescricao;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "certidao")
    public Set<FceCertidao> getFceCertidaos() {
        return this.fceCertidaos;
    }

    public void setFceCertidaos(Set<FceCertidao> fceCertidaos) {
        this.fceCertidaos = fceCertidaos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "certidao")
    public Set<CertidaoTpdoc> getCertidaoTpdocs() {
        return this.certidaoTpdocs;
    }

    public void setCertidaoTpdocs(Set<CertidaoTpdoc> certidaoTpdocs) {
        this.certidaoTpdocs = certidaoTpdocs;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((certiCodigo == null) ? 0 : certiCodigo.hashCode());
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
        Certidao other = (Certidao) obj;
        if (certiCodigo == null) {
            if (other.certiCodigo != null) {
                return false;
            }
        } else if (!certiCodigo.equals(other.certiCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Certidao [certiCodigo=" + certiCodigo + ", certiDescricao=" + certiDescricao + "]";
    }

}
