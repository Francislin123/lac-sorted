package com.sorted.lac.service.repository.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

import java.util.HashSet;
import java.util.Set;

@Entity
@Immutable
@Table(name = "TIPO_NOTICIA")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class TipoNoticia implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer tpnotCodigo;
    private String tpnotDescricao;
    private Set<Noticia> noticias = new HashSet<Noticia>(0);

    public TipoNoticia() {
    }

    public TipoNoticia(Integer tpnotCodigo, String tpnotDescricao) {
        this.tpnotCodigo = tpnotCodigo;
        this.tpnotDescricao = tpnotDescricao;
    }

    public TipoNoticia(Integer tpnotCodigo, String tpnotDescricao, Set<Noticia> noticias) {
        this.tpnotCodigo = tpnotCodigo;
        this.tpnotDescricao = tpnotDescricao;
        this.noticias = noticias;
    }

    @Id
    @Column(name = "TPNOT_CODIGO", unique = true, precision = 22)
    public Integer getTpnotCodigo() {
        return this.tpnotCodigo;
    }

    public void setTpnotCodigo(Integer tpnotCodigo) {
        this.tpnotCodigo = tpnotCodigo;
    }

    @Column(name = "TPNOT_DESCRICAO", length = 500)
    public String getTpnotDescricao() {
        return this.tpnotDescricao;
    }

    public void setTpnotDescricao(String tpnotDescricao) {
        this.tpnotDescricao = tpnotDescricao;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoNoticia")
    public Set<Noticia> getNoticias() {
        return this.noticias;
    }

    public void setNoticias(Set<Noticia> noticias) {
        this.noticias = noticias;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tpnotCodigo == null) ? 0 : tpnotCodigo.hashCode());
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
        TipoNoticia other = (TipoNoticia) obj;
        if (tpnotCodigo == null) {
            if (other.tpnotCodigo != null) {
                return false;
            }
        } else if (!tpnotCodigo.equals(other.tpnotCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoNoticia [tpnotCodigo=" + tpnotCodigo + ", tpnotDescricao=" + tpnotDescricao + "]";
    }
}
