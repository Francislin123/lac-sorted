package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;

@Embeddable
public class NivelAtividadeId implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer nivelCodigo;
    private Integer ativiCodigo;
    private char niatiPorte;

    public NivelAtividadeId() {
    }

    public NivelAtividadeId(Integer nivelCodigo, Integer ativiCodigo, char niatiPorte) {
        this.nivelCodigo = nivelCodigo;
        this.ativiCodigo = ativiCodigo;
        this.niatiPorte = niatiPorte;
    }

    @Column(name = "NIVEL_CODIGO", precision = 22)
    public Integer getNivelCodigo() {
        return this.nivelCodigo;
    }

    public void setNivelCodigo(Integer nivelCodigo) {
        this.nivelCodigo = nivelCodigo;
    }

    @Column(name = "ATIVI_CODIGO", precision = 22)
    public Integer getAtiviCodigo() {
        return this.ativiCodigo;
    }

    public void setAtiviCodigo(Integer ativiCodigo) {
        this.ativiCodigo = ativiCodigo;
    }

    @Column(name = "NIATI_PORTE", length = 1)
    public char getNiatiPorte() {
        return this.niatiPorte;
    }

    public void setNiatiPorte(char niatiPorte) {
        this.niatiPorte = niatiPorte;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ativiCodigo == null) ? 0 : ativiCodigo.hashCode());
        result = prime * result + niatiPorte;
        result = prime * result + ((nivelCodigo == null) ? 0 : nivelCodigo.hashCode());
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
        NivelAtividadeId other = (NivelAtividadeId) obj;
        if (ativiCodigo == null) {
            if (other.ativiCodigo != null) {
                return false;
            }
        } else if (!ativiCodigo.equals(other.ativiCodigo)) {
            return false;
        }
        if (niatiPorte != other.niatiPorte) {
            return false;
        }
        if (nivelCodigo == null) {
            if (other.nivelCodigo != null) {
                return false;
            }
        } else if (!nivelCodigo.equals(other.nivelCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NivelAtividadeId [ativiCodigo=" + ativiCodigo + ", niatiPorte=" + niatiPorte + ", nivelCodigo="
                + nivelCodigo + "]";
    }

}
