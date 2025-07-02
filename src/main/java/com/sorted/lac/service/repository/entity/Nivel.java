package com.sorted.lac.service.repository.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "NIVEL")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class Nivel implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer nivelCodigo;
    private String nivelDescricao;
    private Set<NivelAtividade> nivelAtividades = new HashSet<NivelAtividade>(0);
    private Set<Municipalizacao> municipalizacaos = new HashSet<Municipalizacao>(0);

    public Nivel() {
    }

    public Nivel(Integer nivelCodigo, String nivelDescricao) {
        this.nivelCodigo = nivelCodigo;
        this.nivelDescricao = nivelDescricao;
    }

    public Nivel(Integer nivelCodigo, String nivelDescricao, Set<NivelAtividade> nivelAtividades,
                 Set<Municipalizacao> municipalizacaos) {
        this.nivelCodigo = nivelCodigo;
        this.nivelDescricao = nivelDescricao;
        this.nivelAtividades = nivelAtividades;
        this.municipalizacaos = municipalizacaos;
    }

    @Id
    @Column(name = "NIVEL_CODIGO", unique = true, precision = 22)
    public Integer getNivelCodigo() {
        return this.nivelCodigo;
    }

    public void setNivelCodigo(Integer nivelCodigo) {
        this.nivelCodigo = nivelCodigo;
    }

    @Column(name = "NIVEL_DESCRICAO", length = 5)
    public String getNivelDescricao() {
        return this.nivelDescricao;
    }

    public void setNivelDescricao(String nivelDescricao) {
        this.nivelDescricao = nivelDescricao;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nivel")
    public Set<NivelAtividade> getNivelAtividades() {
        return this.nivelAtividades;
    }

    public void setNivelAtividades(Set<NivelAtividade> nivelAtividades) {
        this.nivelAtividades = nivelAtividades;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nivel")
    public Set<Municipalizacao> getMunicipalizacaos() {
        return this.municipalizacaos;
    }

    public void setMunicipalizacaos(Set<Municipalizacao> municipalizacaos) {
        this.municipalizacaos = municipalizacaos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nivelCodigo == null) ? 0 : nivelCodigo.hashCode());
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
        Nivel other = (Nivel) obj;
        if (nivelCodigo == null) {
            if (other.nivelCodigo != null) {
                return false;
            }
        } else if (!nivelCodigo.equals(other.nivelCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nivel [nivelCodigo=" + nivelCodigo + ", nivelDescricao=" + nivelDescricao + "]";
    }

}
