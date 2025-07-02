package com.sorted.lac.service.repository.fce;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

@Embeddable
public class FceFaseId implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer fceCodigo;
    private LocalDateTime fcefaData;

    public FceFaseId() {
    }

    public FceFaseId(Integer fceCodigo, LocalDateTime fcefaData) {
        this.fceCodigo = fceCodigo;
        this.fcefaData = fcefaData;
    }

    @Column(name = "FCE_CODIGO", precision = 10)
    public Integer getFceCodigo() {
        return this.fceCodigo;
    }

    public void setFceCodigo(Integer fceCodigo) {
        this.fceCodigo = fceCodigo;
    }

    @Column(name = "FCEFA_DATA", length = 7)
    public LocalDateTime getFcefaData() {
        return this.fcefaData;
    }

    public void setFcefaData(LocalDateTime fcefaData) {
        this.fcefaData = fcefaData;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fceCodigo == null) ? 0 : fceCodigo.hashCode());
        result = prime * result + ((fcefaData == null) ? 0 : fcefaData.hashCode());
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
        FceFaseId other = (FceFaseId) obj;
        if (fceCodigo == null) {
            if (other.fceCodigo != null) {
                return false;
            }
        } else if (!fceCodigo.equals(other.fceCodigo)) {
            return false;
        }
        if (fcefaData == null) {
            if (other.fcefaData != null) {
                return false;
            }
        } else if (!fcefaData.equals(other.fcefaData)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FceFaseId [fceCodigo=" + fceCodigo + ", fcefaData=" + fcefaData + "]";
    }
}
