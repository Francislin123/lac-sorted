package com.sorted.lac.service.repository.fce;

import jakarta.persistence.*;

@Embeddable
public class FceVariavelId implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer fceCodigo;
    private Integer varCodigo;

    public FceVariavelId() {
    }

    public FceVariavelId(Integer fceCodigo, Integer varCodigo) {
        this.fceCodigo = fceCodigo;
        this.varCodigo = varCodigo;
    }

    @Column(name = "FCE_CODIGO", precision = 10)
    public Integer getFceCodigo() {
        return this.fceCodigo;
    }

    public void setFceCodigo(Integer fceCodigo) {
        this.fceCodigo = fceCodigo;
    }

    @Column(name = "VAR_CODIGO", precision = 10)
    public Integer getVarCodigo() {
        return this.varCodigo;
    }

    public void setVarCodigo(Integer varCodigo) {
        this.varCodigo = varCodigo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fceCodigo == null) ? 0 : fceCodigo.hashCode());
        result = prime * result + ((varCodigo == null) ? 0 : varCodigo.hashCode());
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
        FceVariavelId other = (FceVariavelId) obj;
        if (fceCodigo == null) {
            if (other.fceCodigo != null) {
                return false;
            }
        } else if (!fceCodigo.equals(other.fceCodigo)) {
            return false;
        }
        if (varCodigo == null) {
            if (other.varCodigo != null) {
                return false;
            }
        } else if (!varCodigo.equals(other.varCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FceVariavelId [fceCodigo=" + fceCodigo + ", varCodigo=" + varCodigo + "]";
    }

}
