package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "TIPO_EMPREENDEDOR")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class TipoEmpreendedor implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer tpempCodigo;
    private String tpempDescricao;

    @Id
    @Column(name = "TPEMP_CODIGO", unique = true, precision = 10)
    public Integer getTpempCodigo() {
        return tpempCodigo;
    }

    public void setTpempCodigo(Integer tpempCodigo) {
        this.tpempCodigo = tpempCodigo;
    }

    @Column(name = "TPEMP_DESCRICAO", length = 30)
    public String getTpempDescricao() {
        return tpempDescricao;
    }

    public void setTpempDescricao(String tpempDescricao) {
        this.tpempDescricao = tpempDescricao;
    }
}
