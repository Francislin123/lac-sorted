package com.sorted.lac.service.repository.entity;

import com.sorted.lac.service.repository.fce.Fce;
import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TIPO_FCE")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class TipoFce implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer tpfceCodigo;
    private String tpfceDescricao;
    private Set<Fce> fces = new HashSet<Fce>(0);

    public TipoFce() {
    }

    public TipoFce(Integer tpfceCodigo) {
        this.tpfceCodigo = tpfceCodigo;
    }

    public TipoFce(Integer tpfceCodigo, String tpfceDescricao, Set<Fce> fces) {
        this.tpfceCodigo = tpfceCodigo;
        this.tpfceDescricao = tpfceDescricao;
        this.fces = fces;
    }

    @Id
    @Column(name = "TPFCE_CODIGO", unique = true, precision = 22)
    public Integer getTpfceCodigo() {
        return this.tpfceCodigo;
    }

    public void setTpfceCodigo(Integer tpfceCodigo) {
        this.tpfceCodigo = tpfceCodigo;
    }

    @Column(name = "TPFCE_DESCRICAO", length = 50)
    public String getTpfceDescricao() {
        return this.tpfceDescricao;
    }

    public void setTpfceDescricao(String tpfceDescricao) {
        this.tpfceDescricao = tpfceDescricao;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoFce")
    public Set<Fce> getFces() {
        return this.fces;
    }

    public void setFces(Set<Fce> fces) {
        this.fces = fces;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tpfceCodigo == null) ? 0 : tpfceCodigo.hashCode());
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
        TipoFce other = (TipoFce) obj;
        if (tpfceCodigo == null) {
            if (other.tpfceCodigo != null) {
                return false;
            }
        } else if (!tpfceCodigo.equals(other.tpfceCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoFce [tpfceCodigo=" + tpfceCodigo + ", tpfceDescricao=" + tpfceDescricao + "]";
    }

}
