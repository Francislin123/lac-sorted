package com.sorted.lac.service.repository.entity;

import java.util.List;

import jakarta.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * @author BRASIL Direct - Softwares, Soluções e Serviços
 * @since 2008
 * @version 2.0
 */

@Entity
@Table(name = "TABELA_CALCULO")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class TabelaCalculo implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer tabcaCodigo;
    private String tabcaDescricao;
    private List<BaseCalculo> baseCalculos;
    private List<Atividade> atividades;

    public TabelaCalculo() {
    }

    public TabelaCalculo(Integer tabcaCodigo, String tabcaDescricao) {
        this.tabcaCodigo = tabcaCodigo;
        this.tabcaDescricao = tabcaDescricao;
    }

    public TabelaCalculo(Integer tabcaCodigo, String tabcaDescricao, List<BaseCalculo> baseCalculos,
                         List<Atividade> atividades) {
        this.tabcaCodigo = tabcaCodigo;
        this.tabcaDescricao = tabcaDescricao;
        this.baseCalculos = baseCalculos;
        this.atividades = atividades;
    }

    @Id
    @Column(name = "TABCA_CODIGO", unique = true, precision = 22)
    public Integer getTabcaCodigo() {
        return this.tabcaCodigo;
    }

    public void setTabcaCodigo(Integer tabcaCodigo) {
        this.tabcaCodigo = tabcaCodigo;
    }

    @Column(name = "TABCA_DESCRICAO", length = 50)
    public String getTabcaDescricao() {
        return this.tabcaDescricao;
    }

    public void setTabcaDescricao(String tabcaDescricao) {
        this.tabcaDescricao = tabcaDescricao;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tabelaCalculo")
    public List<BaseCalculo> getBaseCalculos() {
        return this.baseCalculos;
    }

    public void setBaseCalculos(List<BaseCalculo> baseCalculos) {
        this.baseCalculos = baseCalculos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tabelaCalculo")
    public List<Atividade> getAtividades() {
        return this.atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    @Override
    public String toString() {
        return "TabelaCalculo [tabcaCodigo=" + tabcaCodigo + ", tabcaDescricao=" + tabcaDescricao + "]";
    }

}
