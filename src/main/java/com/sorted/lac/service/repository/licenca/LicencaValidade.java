package com.sorted.lac.service.repository.licenca;

import com.sorted.lac.service.repository.fce.FceAtividade;
import com.sorted.lac.service.repository.fce.FceCertidao;
import com.sorted.lac.service.repository.fce.FceExploracao;
import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;

@Entity
@Table(name = "LICENCA_VALIDADE")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class LicencaValidade implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer licvaCodigo;
    private String licvaDescricao;
    private List<FceExploracao> fceExploracaos;
    private List<FceCertidao> fceCertidaos;
    private List<FceAtividade> fceAtividades;

    public LicencaValidade() {
    }

    public LicencaValidade(Integer licvaCodigo, String licvaDescricao) {
        this.licvaCodigo = licvaCodigo;
        this.licvaDescricao = licvaDescricao;
    }

    public LicencaValidade(Integer licvaCodigo, String licvaDescricao, List<FceExploracao> fceExploracaos, List<FceCertidao> fceCertidaos, List<FceAtividade> fceAtividades) {
        this.licvaCodigo = licvaCodigo;
        this.licvaDescricao = licvaDescricao;
        this.fceExploracaos = fceExploracaos;
        this.fceCertidaos = fceCertidaos;
        this.fceAtividades = fceAtividades;
    }

    @Id
    @Column(name = "LICVA_CODIGO", unique = true, precision = 22)
    public Integer getLicvaCodigo() {
        return this.licvaCodigo;
    }

    public void setLicvaCodigo(Integer licvaCodigo) {
        this.licvaCodigo = licvaCodigo;
    }

    @Column(name = "LICVA_DESCRICAO", length = 10)
    public String getLicvaDescricao() {
        return this.licvaDescricao;
    }

    public void setLicvaDescricao(String licvaDescricao) {
        this.licvaDescricao = licvaDescricao;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "licencaValidade")
    public List<FceExploracao> getFceExploracaos() {
        return this.fceExploracaos;
    }

    public void setFceExploracaos(List<FceExploracao> fceExploracaos) {
        this.fceExploracaos = fceExploracaos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "licencaValidade")
    public List<FceCertidao> getFceCertidaos() {
        return this.fceCertidaos;
    }

    public void setFceCertidaos(List<FceCertidao> fceCertidaos) {
        this.fceCertidaos = fceCertidaos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "licencaValidade")
    public List<FceAtividade> getFceAtividades() {
        return this.fceAtividades;
    }

    public void setFceAtividades(List<FceAtividade> fceAtividades) {
        this.fceAtividades = fceAtividades;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((licvaCodigo == null) ? 0 : licvaCodigo.hashCode());
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
        LicencaValidade other = (LicencaValidade) obj;
        if (licvaCodigo == null) {
            if (other.licvaCodigo != null) {
                return false;
            }
        } else if (!licvaCodigo.equals(other.licvaCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LicencaValidade [licvaCodigo=" + licvaCodigo + ", licvaDescricao=" + licvaDescricao + "]";
    }

}
