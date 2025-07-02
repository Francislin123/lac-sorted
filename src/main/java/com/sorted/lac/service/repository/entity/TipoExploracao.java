package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TIPO_EXPLORACAO")
@SequenceGenerator(name = "SEQ_TIPO_EXPLORACAO", sequenceName = "SEQ_TIPO_EXPLORACAO", allocationSize = 1)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Cacheable
public class TipoExploracao implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer tpexpCodigo;
    private String tpexpDescricao;
    private boolean valido = true;
    private Set<Exploracao> exploracaos = new HashSet<Exploracao>(0);

    public TipoExploracao() {
    }

    public TipoExploracao(Integer tpexpCodigo, String tpexpDescricao) {
        this.tpexpCodigo = tpexpCodigo;
        this.tpexpDescricao = tpexpDescricao;
    }

    public TipoExploracao(Integer tpexpCodigo, String tpexpDescricao, Set<Exploracao> exploracaos) {
        this.tpexpCodigo = tpexpCodigo;
        this.tpexpDescricao = tpexpDescricao;
        this.exploracaos = exploracaos;
    }

    @Id
    @GeneratedValue(generator = "SEQ_TIPO_EXPLORACAO")
    @Column(name = "TPEXP_CODIGO", unique = true, precision = 10)
    public Integer getTpexpCodigo() {
        return this.tpexpCodigo;
    }

    public void setTpexpCodigo(Integer tpexpCodigo) {
        this.tpexpCodigo = tpexpCodigo;
    }

    @Column(name = "TPEXP_DESCRICAO", length = 100)
    public String getTpexpDescricao() {
        return this.tpexpDescricao;
    }

    public void setTpexpDescricao(String tpexpDescricao) {
        this.tpexpDescricao = tpexpDescricao;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoExploracao")
    public Set<Exploracao> getExploracaos() {
        return this.exploracaos;
    }

    public void setExploracaos(Set<Exploracao> exploracaos) {
        this.exploracaos = exploracaos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tpexpCodigo == null) ? 0 : tpexpCodigo.hashCode());
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
        TipoExploracao other = (TipoExploracao) obj;
        if (tpexpCodigo == null) {
            if (other.tpexpCodigo != null) {
                return false;
            }
        } else if (!tpexpCodigo.equals(other.tpexpCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoExploracao [tpexpCodigo=" + tpexpCodigo + ", tpexpDescricao=" + tpexpDescricao + "]";
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

}
