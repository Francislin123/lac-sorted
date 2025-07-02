package com.sorted.lac.service.repository.entity;

import java.util.List;

import jakarta.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "TIPO_DARE")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class TipoDare implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer tpdarCodigo;
    private String tpdarDescricao;
    private List<Dare> dares;

    public TipoDare() {
    }

    public TipoDare(Integer tpdarCodigo) {
        this.tpdarCodigo = tpdarCodigo;
    }

    public TipoDare(Integer tpdarCodigo, String tpdarDescricao,
                    List<Dare> dares) {
        this.tpdarCodigo = tpdarCodigo;
        this.tpdarDescricao = tpdarDescricao;
        this.dares = dares;
    }

    @Id
    @Column(name = "TPDAR_CODIGO", unique = true, precision = 22)
    public Integer getTpdarCodigo() {
        return this.tpdarCodigo;
    }

    public void setTpdarCodigo(Integer tpdarCodigo) {
        this.tpdarCodigo = tpdarCodigo;
    }

    @Column(name = "TPDAR_DESCRICAO", length = 30)
    public String getTpdarDescricao() {
        return this.tpdarDescricao;
    }

    public void setTpdarDescricao(String tpdarDescricao) {
        this.tpdarDescricao = tpdarDescricao;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoDare")
    public List<Dare> getDares() {
        return this.dares;
    }

    public void setDares(List<Dare> dares) {
        this.dares = dares;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((tpdarCodigo == null) ? 0 : tpdarCodigo.hashCode());
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
        TipoDare other = (TipoDare) obj;
        if (tpdarCodigo == null) {
            if (other.tpdarCodigo != null) {
                return false;
            }
        } else if (!tpdarCodigo.equals(other.tpdarCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoDare [tpdarCodigo=" + tpdarCodigo + ", tpdarDescricao="
                + tpdarDescricao + "]";
    }

}
