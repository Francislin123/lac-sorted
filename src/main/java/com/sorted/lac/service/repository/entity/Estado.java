package com.sorted.lac.service.repository.entity;

import java.util.List;

import jakarta.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

/**
 * @author BRASIL Direct - Softwares, Soluções e Serviços
 * @since 2008
 * @version 2.0
 */

@Entity
@Immutable
@Table(name = "ESTADO")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class Estado implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private String estadUf;
    private String estadDescricao;
    private List<Municipio> municipios;

    public Estado() {
    }

    public Estado(String estadUf) {
        this.estadUf = estadUf;
    }

    public Estado(String estadUf, String estadDescricao, List<Municipio> municipios) {
        this.estadUf = estadUf;
        this.estadDescricao = estadDescricao;
        this.municipios = municipios;
    }

    @Id
    @Column(name = "ESTAD_UF", unique = true, length = 2)
    public String getEstadUf() {
        return this.estadUf;
    }

    public void setEstadUf(String estadUf) {
        this.estadUf = estadUf;
    }

    @Column(name = "ESTAD_DESCRICAO", length = 30)
    public String getEstadDescricao() {
        return this.estadDescricao;
    }

    public void setEstadDescricao(String estadDescricao) {
        this.estadDescricao = estadDescricao;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
    public List<Municipio> getMunicipios() {
        return this.municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((estadUf == null) ? 0 : estadUf.hashCode());
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
        Estado other = (Estado) obj;
        if (estadUf == null) {
            if (other.estadUf != null) {
                return false;
            }
        } else if (!estadUf.equals(other.estadUf)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estado [estadDescricao=" + estadDescricao + ", estadUf=" + estadUf + "]";
    }

}
