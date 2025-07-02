package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SETOR")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class Setor implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer setorCodigo;
    private String setorDescricao;
    private String setorSigla;
    private Set<Colaborador> colaboradors = new HashSet<Colaborador>(0);

    public Setor() {
    }

    public Setor(Integer setorCodigo) {
        this.setorCodigo = setorCodigo;
    }

    public Setor(Integer setorCodigo, String setorDescricao, String setorSigla, Set<Colaborador> colaboradors) {
        this.setorCodigo = setorCodigo;
        this.setorDescricao = setorDescricao;
        this.setorSigla = setorSigla;
        this.colaboradors = colaboradors;
    }

    @Id
    @Column(name = "SETOR_CODIGO", unique = true, precision = 22)
    public Integer getSetorCodigo() {
        return this.setorCodigo;
    }

    public void setSetorCodigo(Integer setorCodigo) {
        this.setorCodigo = setorCodigo;
    }

    @Column(name = "SETOR_DESCRICAO", length = 100)
    public String getSetorDescricao() {
        return this.setorDescricao;
    }

    public void setSetorDescricao(String setorDescricao) {
        this.setorDescricao = setorDescricao;
    }

    @Column(name = "SETOR_SIGLA", length = 10)
    public String getSetorSigla() {
        return this.setorSigla;
    }

    public void setSetorSigla(String setorSigla) {
        this.setorSigla = setorSigla;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "setor")
    public Set<Colaborador> getColaboradors() {
        return this.colaboradors;
    }

    public void setColaboradors(Set<Colaborador> colaboradors) {
        this.colaboradors = colaboradors;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((setorCodigo == null) ? 0 : setorCodigo.hashCode());
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
        Setor other = (Setor) obj;
        if (setorCodigo == null) {
            if (other.setorCodigo != null) {
                return false;
            }
        } else if (!setorCodigo.equals(other.setorCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Setor [setorCodigo=" + setorCodigo + ", setorDescricao=" + setorDescricao + "]";
    }

}
