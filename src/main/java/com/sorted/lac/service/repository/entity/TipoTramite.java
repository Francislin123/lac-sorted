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
@Table(name = "TIPO_TRAMITE")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class TipoTramite implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer tptmtCodigo;
    private String tptmtDescricao;
    private Set<Tramite> tramites = new HashSet<Tramite>(0);

    public TipoTramite() {
    }

    public TipoTramite(Integer tptmtCodigo) {
        this.tptmtCodigo = tptmtCodigo;
    }

    public TipoTramite(Integer tptmtCodigo, String tptmtDescricao, Set<Tramite> tramites) {
        this.tptmtCodigo = tptmtCodigo;
        this.tptmtDescricao = tptmtDescricao;
        this.tramites = tramites;
    }

    @Id
    @Column(name = "TPTMT_CODIGO", unique = true, precision = 22)
    public Integer getTptmtCodigo() {
        return this.tptmtCodigo;
    }

    public void setTptmtCodigo(Integer tptmtCodigo) {
        this.tptmtCodigo = tptmtCodigo;
    }

    @Column(name = "TPTMT_DESCRICAO", length = 100)
    public String getTptmtDescricao() {
        return this.tptmtDescricao;
    }

    public void setTptmtDescricao(String tptmtDescricao) {
        this.tptmtDescricao = tptmtDescricao;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoTramite")
    public Set<Tramite> getTramites() {
        return this.tramites;
    }

    public void setTramites(Set<Tramite> tramites) {
        this.tramites = tramites;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tptmtCodigo == null) ? 0 : tptmtCodigo.hashCode());
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
        TipoTramite other = (TipoTramite) obj;
        if (tptmtCodigo == null) {
            if (other.tptmtCodigo != null) {
                return false;
            }
        } else if (!tptmtCodigo.equals(other.tptmtCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoTramite [tptmtCodigo=" + tptmtCodigo + ", tptmtDescricao=" + tptmtDescricao + "]";
    }

}
