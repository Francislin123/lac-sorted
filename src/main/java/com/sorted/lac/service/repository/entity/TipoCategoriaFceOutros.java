package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "TIPO_CATEGORIA_FCE_OUTROS")
@SequenceGenerator(name = "SEQ_TIPO_CATEGORIA_OUTROS", sequenceName = "SEQ_TIPO_CATEGORIA_OUTROS", allocationSize = 1)
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class TipoCategoriaFceOutros implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer tpcfoCodigo;
    private String tpcfoDescricao;

    public TipoCategoriaFceOutros() {
    }

    @Id
    @GeneratedValue(generator = "SEQ_TIPO_CATEGORIA_OUTROS")
    @Column(name = "TPCFO_CODIGO", unique = true, precision = 22)
    public Integer getTpcfoCodigo() {
        return tpcfoCodigo;
    }

    public void setTpcfoCodigo(Integer tpcfoCodigo) {
        this.tpcfoCodigo = tpcfoCodigo;
    }

    @Column(name = "TPCFO_DESCRICAO", length = 200)
    public String getTpcfoDescricao() {
        return tpcfoDescricao;
    }

    public void setTpcfoDescricao(String tpcfoDescricao) {
        this.tpcfoDescricao = tpcfoDescricao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tpcfoCodigo == null) ? 0 : tpcfoCodigo.hashCode());
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
        TipoCategoriaFceOutros other = (TipoCategoriaFceOutros) obj;
        if (tpcfoCodigo == null) {
            if (other.tpcfoCodigo != null) {
                return false;
            }
        } else if (!tpcfoCodigo.equals(other.tpcfoCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoCategoriaFceOutros [tpcfoCodigo=" + tpcfoCodigo + ", tpcfoDescricao=" + tpcfoDescricao + "]";
    }
}
