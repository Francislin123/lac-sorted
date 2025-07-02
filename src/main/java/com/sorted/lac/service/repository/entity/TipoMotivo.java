package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "TIPO_MOTIVO")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class TipoMotivo implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer tpmtvCodigo;
    private String tpmtvDescricao;

    public TipoMotivo() {
    }

    public TipoMotivo(Integer tpmtvCodigo, String tpmtvDescricao) {
        this.tpmtvCodigo = tpmtvCodigo;
        this.tpmtvDescricao = tpmtvDescricao;
    }

    @Id
    @Column(name = "TPMTV_CODIGO", unique = true, precision = 22)
    public Integer getTpmtvCodigo() {
        return this.tpmtvCodigo;
    }

    public void setTpmtvCodigo(Integer tpmtvCodigo) {
        this.tpmtvCodigo = tpmtvCodigo;
    }

    @Column(name = "TPMTV_DESCRICAO", length = 1000)
    public String getTpmtvDescricao() {
        return this.tpmtvDescricao;
    }

    public void setTpmtvDescricao(String tpmtvDescricao) {
        this.tpmtvDescricao = tpmtvDescricao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tpmtvCodigo == null) ? 0 : tpmtvCodigo.hashCode());
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
        TipoMotivo other = (TipoMotivo) obj;
        if (tpmtvCodigo == null) {
            if (other.tpmtvCodigo != null) {
                return false;
            }
        } else if (!tpmtvCodigo.equals(other.tpmtvCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoMotivo [tpmtvCodigo=" + tpmtvCodigo + ", tpmtvDescricao=" + tpmtvDescricao + "]";
    }

}
