package com.sorted.lac.service.repository.regional;

import jakarta.persistence.*;

@Embeddable
public class RegionalContatoId implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private long regCodigo;
    private String regctContato;

    public RegionalContatoId() {
    }

    public RegionalContatoId(long regCodigo, String regctContato) {
        this.regCodigo = regCodigo;
        this.regctContato = regctContato;
    }

    @Column(name = "REG_CODIGO", precision = 10)
    public long getRegCodigo() {
        return this.regCodigo;
    }

    public void setRegCodigo(long regCodigo) {
        this.regCodigo = regCodigo;
    }

    @Column(name = "REGCT_CONTATO", length = 100)
    public String getRegctContato() {
        return this.regctContato;
    }

    public void setRegctContato(String regctContato) {
        this.regctContato = regctContato;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof RegionalContatoId)) {
            return false;
        }
        RegionalContatoId castOther = (RegionalContatoId) other;

        return (this.getRegCodigo() == castOther.getRegCodigo())
                && ((this.getRegctContato() == castOther.getRegctContato())
                || (this.getRegctContato() != null && castOther.getRegctContato() != null
                && this.getRegctContato().equals(castOther.getRegctContato())));
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 37 * result + (int) this.getRegCodigo();
        result = 37 * result + (getRegctContato() == null ? 0 : this.getRegctContato().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RegionalContatoId [regCodigo=" + regCodigo + ", regctContato=" + regctContato + "]";
    }
}
