package com.sorted.lac.service.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

@Embeddable
public class EmpreendedorHistoricoId implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer userCodigo;
    private LocalDateTime emphiDataAtualizacao;

    public EmpreendedorHistoricoId() {
    }

    public EmpreendedorHistoricoId(Integer userCodigo, LocalDateTime emphiDataAtualizacao) {
        this.userCodigo = userCodigo;
        this.emphiDataAtualizacao = emphiDataAtualizacao;
    }

    @Column(name = "USER_CODIGO", precision = 22)
    public Integer getUserCodigo() {
        return this.userCodigo;
    }

    public void setUserCodigo(Integer userCodigo) {
        this.userCodigo = userCodigo;
    }

    @Column(name = "EMPHI_DATA_ATUALIZACAO", length = 7)
    public LocalDateTime getEmphiDataAtualizacao() {
        return this.emphiDataAtualizacao;
    }

    public void setEmphiDataAtualizacao(LocalDateTime emphiDataAtualizacao) {
        this.emphiDataAtualizacao = emphiDataAtualizacao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((emphiDataAtualizacao == null) ? 0 : emphiDataAtualizacao.hashCode());
        result = prime * result + ((userCodigo == null) ? 0 : userCodigo.hashCode());
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
        EmpreendedorHistoricoId other = (EmpreendedorHistoricoId) obj;
        if (emphiDataAtualizacao == null) {
            if (other.emphiDataAtualizacao != null) {
                return false;
            }
        } else if (!emphiDataAtualizacao.equals(other.emphiDataAtualizacao)) {
            return false;
        }
        if (userCodigo == null) {
            if (other.userCodigo != null) {
                return false;
            }
        } else if (!userCodigo.equals(other.userCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EmpreendedorHistoricoId [emphiDataAtualizacao=" + emphiDataAtualizacao + ", userCodigo=" + userCodigo + "]";
    }
}
