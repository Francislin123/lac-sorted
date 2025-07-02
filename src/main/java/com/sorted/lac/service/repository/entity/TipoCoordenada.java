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
@Table(name = "TIPO_COORDENADA")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class TipoCoordenada implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer tpcooCodigo;
    private String tpcooDescricao;
    private Set<Empreendimento> empreendimentos = new HashSet<Empreendimento>(0);

    public TipoCoordenada() {
    }

    public TipoCoordenada(Integer tpcooCodigo, String tpcooDescricao) {
        this.tpcooCodigo = tpcooCodigo;
        this.tpcooDescricao = tpcooDescricao;
    }

    public TipoCoordenada(Integer tpcooCodigo, String tpcooDescricao,
                          Set<Empreendimento> empreendimentos) {
        this.tpcooCodigo = tpcooCodigo;
        this.tpcooDescricao = tpcooDescricao;
        this.empreendimentos = empreendimentos;
    }

    @Id
    @Column(name = "TPCOO_CODIGO", unique = true, precision = 10)
    public Integer getTpcooCodigo() {
        return this.tpcooCodigo;
    }

    public void setTpcooCodigo(Integer tpcooCodigo) {
        this.tpcooCodigo = tpcooCodigo;
    }

    @Column(name = "TPCOO_DESCRICAO", length = 50)
    public String getTpcooDescricao() {
        return this.tpcooDescricao;
    }

    public void setTpcooDescricao(String tpcooDescricao) {
        this.tpcooDescricao = tpcooDescricao;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoCoordenada")
    public Set<Empreendimento> getEmpreendimentos() {
        return this.empreendimentos;
    }

    public void setEmpreendimentos(Set<Empreendimento> empreendimentos) {
        this.empreendimentos = empreendimentos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((tpcooCodigo == null) ? 0 : tpcooCodigo.hashCode());
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
        TipoCoordenada other = (TipoCoordenada) obj;
        if (tpcooCodigo == null) {
            if (other.tpcooCodigo != null) {
                return false;
            }
        } else if (!tpcooCodigo.equals(other.tpcooCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoCoordenada [tpcooCodigo=" + tpcooCodigo
                + ", tpcooDescricao=" + tpcooDescricao + "]";
    }

}
