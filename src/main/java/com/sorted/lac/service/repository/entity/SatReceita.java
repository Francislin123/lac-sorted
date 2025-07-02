package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SAT_RECEITA")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class SatReceita implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer satreCodigo;
    private String satreDescricao;
    private Set<SatClasse> satClasses = new HashSet<SatClasse>(0);

    public SatReceita() {
    }

    public SatReceita(Integer satreCodigo) {
        this.satreCodigo = satreCodigo;
    }

    public SatReceita(Integer satreCodigo, String satreDescricao, Set<SatClasse> satClasses) {
        this.satreCodigo = satreCodigo;
        this.satreDescricao = satreDescricao;
        this.satClasses = satClasses;
    }

    @Id
    @Column(name = "SATRE_CODIGO", unique = true, precision = 22)
    public Integer getSatreCodigo() {
        return this.satreCodigo;
    }

    public void setSatreCodigo(Integer satreCodigo) {
        this.satreCodigo = satreCodigo;
    }

    @Column(name = "SATRE_DESCRICAO", length = 30)
    public String getSatreDescricao() {
        return this.satreDescricao;
    }

    public void setSatreDescricao(String satreDescricao) {
        this.satreDescricao = satreDescricao;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "satReceita")
    public Set<SatClasse> getSatClasses() {
        return this.satClasses;
    }

    public void setSatClasses(Set<SatClasse> satClasses) {
        this.satClasses = satClasses;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((satreCodigo == null) ? 0 : satreCodigo.hashCode());
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
        SatReceita other = (SatReceita) obj;
        if (satreCodigo == null) {
            if (other.satreCodigo != null) {
                return false;
            }
        } else if (!satreCodigo.equals(other.satreCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SatReceita [satreCodigo=" + satreCodigo + ", satreDescricao=" + satreDescricao + "]";
    }

}
