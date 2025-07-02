package com.sorted.lac.service.repository.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "TIPO_PROCESSO")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class TipoProcesso implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer tpprcCodigo;
    private String tpprcDescricao;
    private Set<Processo> processos = new HashSet<Processo>(0);

    public TipoProcesso() {
    }

    public TipoProcesso(Integer tpprcCodigo, String tpprcDescricao) {
        this.tpprcCodigo = tpprcCodigo;
        this.tpprcDescricao = tpprcDescricao;
    }

    public TipoProcesso(Integer tpprcCodigo, String tpprcDescricao, Set<Processo> processos) {
        this.tpprcCodigo = tpprcCodigo;
        this.tpprcDescricao = tpprcDescricao;
        this.processos = processos;
    }

    @Id
    @Column(name = "TPPRC_CODIGO", unique = true, precision = 10)
    public Integer getTpprcCodigo() {
        return this.tpprcCodigo;
    }

    public void setTpprcCodigo(Integer tpprcCodigo) {
        this.tpprcCodigo = tpprcCodigo;
    }

    @Column(name = "TPPRC_DESCRICAO", length = 50)
    public String getTpprcDescricao() {
        return this.tpprcDescricao;
    }

    public void setTpprcDescricao(String tpprcDescricao) {
        this.tpprcDescricao = tpprcDescricao;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoProcesso")
    public Set<Processo> getProcessos() {
        return this.processos;
    }

    public void setProcessos(Set<Processo> processos) {
        this.processos = processos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tpprcCodigo == null) ? 0 : tpprcCodigo.hashCode());
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
        TipoProcesso other = (TipoProcesso) obj;
        if (tpprcCodigo == null) {
            if (other.tpprcCodigo != null) {
                return false;
            }
        } else if (!tpprcCodigo.equals(other.tpprcCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoProcesso [tpprcCodigo=" + tpprcCodigo + ", tpprcDescricao=" + tpprcDescricao + "]";
    }

}
