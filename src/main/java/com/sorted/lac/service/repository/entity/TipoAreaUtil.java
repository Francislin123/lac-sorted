package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

/**
 * @author BRASIL Direct - Softwares, Soluções e Serviços
 * @since 2008
 * @version 2.0
 */

@Entity
@Immutable
@Table(name = "TIPO_AREA_UTIL")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class TipoAreaUtil implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer tpautCodigo;
    private Unidade unidade;
    private String tpautDescricao;

    public TipoAreaUtil() {
    }

    public TipoAreaUtil(Integer tpautCodigo, Unidade unidade, String tpautDescricao) {
        this.tpautCodigo = tpautCodigo;
        this.unidade = unidade;
        this.tpautDescricao = tpautDescricao;
    }

    @Id
    @Column(name = "TPAUT_CODIGO", unique = true, precision = 22)
    public Integer getTpautCodigo() {
        return this.tpautCodigo;
    }

    public void setTpautCodigo(Integer tpautCodigo) {
        this.tpautCodigo = tpautCodigo;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UNIDD_CODIGO")
    public Unidade getUnidade() {
        return this.unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    @Column(name = "TPAUT_DESCRICAO", length = 30)
    public String getTpautDescricao() {
        return this.tpautDescricao;
    }

    public void setTpautDescricao(String tpautDescricao) {
        this.tpautDescricao = tpautDescricao;
    }

    @Override
    public String toString() {
        return "TipoAreaUtil [tpautCodigo=" + tpautCodigo + ", tpautDescricao=" + tpautDescricao + ", unidade="
                + unidade.getUniddCodigo() + "]";
    }

}
