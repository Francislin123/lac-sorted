package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "TRAMITE_ACAO")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class TramiteAcao implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer tmtacCodigo;
    private String tmtacDescricao;
    private Set<TramiteHistorico> tramiteHistoricos = new HashSet<TramiteHistorico>(0);

    public TramiteAcao() {
    }

    public TramiteAcao(Integer tmtacCodigo, String tmtacDescricao) {
        this.tmtacCodigo = tmtacCodigo;
        this.tmtacDescricao = tmtacDescricao;
    }

    public TramiteAcao(Integer tmtacCodigo, String tmtacDescricao, Set<TramiteHistorico> tramiteHistoricos) {
        this.tmtacCodigo = tmtacCodigo;
        this.tmtacDescricao = tmtacDescricao;
        this.tramiteHistoricos = tramiteHistoricos;
    }

    @Id
    @Column(name = "TMTAC_CODIGO", unique = true, precision = 10)
    public Integer getTmtacCodigo() {
        return this.tmtacCodigo;
    }

    public void setTmtacCodigo(Integer tmtacCodigo) {
        this.tmtacCodigo = tmtacCodigo;
    }

    @Column(name = "TMTAC_DESCRICAO", length = 50)
    public String getTmtacDescricao() {
        return this.tmtacDescricao;
    }

    public void setTmtacDescricao(String tmtacDescricao) {
        this.tmtacDescricao = tmtacDescricao;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tramiteAcao")
    public Set<TramiteHistorico> getTramiteHistoricos() {
        return this.tramiteHistoricos;
    }

    public void setTramiteHistoricos(Set<TramiteHistorico> tramiteHistoricos) {
        this.tramiteHistoricos = tramiteHistoricos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tmtacCodigo == null) ? 0 : tmtacCodigo.hashCode());
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
        TramiteAcao other = (TramiteAcao) obj;
        if (tmtacCodigo == null) {
            if (other.tmtacCodigo != null) {
                return false;
            }
        } else if (!tmtacCodigo.equals(other.tmtacCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TramiteAcao [tmtacCodigo=" + tmtacCodigo + ", tmtacDescricao=" + tmtacDescricao + "]";
    }
}
