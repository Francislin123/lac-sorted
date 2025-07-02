package com.sorted.lac.service.repository.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "RESPONSAVEL_TECNICO_CARGO")
public class ResponsavelTecnicoCargo implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer rtcarCodigo;
    private String rtcarDescricao;
    private Set<ResponsavelTecnico> responsavelTecnicos = new HashSet<ResponsavelTecnico>(
            0);

    public ResponsavelTecnicoCargo() {
    }

    public ResponsavelTecnicoCargo(Integer rtcarCodigo, String rtcarDescricao) {
        this.rtcarCodigo = rtcarCodigo;
        this.rtcarDescricao = rtcarDescricao;
    }

    public ResponsavelTecnicoCargo(Integer rtcarCodigo, String rtcarDescricao,
                                   Set<ResponsavelTecnico> responsavelTecnicos) {
        this.rtcarCodigo = rtcarCodigo;
        this.rtcarDescricao = rtcarDescricao;
        this.responsavelTecnicos = responsavelTecnicos;
    }

    @Id
    @Column(name = "RTCAR_CODIGO", unique = true, precision = 10)
    public Integer getRtcarCodigo() {
        return this.rtcarCodigo;
    }

    public void setRtcarCodigo(Integer rtcarCodigo) {
        this.rtcarCodigo = rtcarCodigo;
    }

    @Column(name = "RTCAR_DESCRICAO", length = 50)
    public String getRtcarDescricao() {
        return this.rtcarDescricao;
    }

    public void setRtcarDescricao(String rtcarDescricao) {
        this.rtcarDescricao = rtcarDescricao;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "responsavelTecnicoCargo")
    public Set<ResponsavelTecnico> getResponsavelTecnicos() {
        return this.responsavelTecnicos;
    }

    public void setResponsavelTecnicos(
            Set<ResponsavelTecnico> responsavelTecnicos) {
        this.responsavelTecnicos = responsavelTecnicos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((rtcarCodigo == null) ? 0 : rtcarCodigo.hashCode());
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
        ResponsavelTecnicoCargo other = (ResponsavelTecnicoCargo) obj;
        if (rtcarCodigo == null) {
            if (other.rtcarCodigo != null) {
                return false;
            }
        } else if (!rtcarCodigo.equals(other.rtcarCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ResponsavelTecnicoCargo [rtcarCodigo=" + rtcarCodigo
                + ", rtcarDescricao=" + rtcarDescricao + "]";
    }

}
