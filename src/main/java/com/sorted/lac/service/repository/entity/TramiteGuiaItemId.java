package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;

@Embeddable
public class TramiteGuiaItemId implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer tmtguCodigo;
    private Integer trmteCodigo;

    public TramiteGuiaItemId() {
    }

    public TramiteGuiaItemId(Integer tmtguCodigo, Integer trmteCodigo) {
        this.tmtguCodigo = tmtguCodigo;
        this.trmteCodigo = trmteCodigo;
    }

    @Column(name = "TMTGU_CODIGO", precision = 10)
    public Integer getTmtguCodigo() {
        return tmtguCodigo;
    }

    public void setTmtguCodigo(Integer tmtguCodigo) {
        this.tmtguCodigo = tmtguCodigo;
    }

    @Column(name = "TRMTE_CODIGO", precision = 10)
    public Integer getTrmteCodigo() {
        return trmteCodigo;
    }

    public void setTrmteCodigo(Integer trmteCodigo) {
        this.trmteCodigo = trmteCodigo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tmtguCodigo == null) ? 0 : tmtguCodigo.hashCode());
        result = prime * result + ((trmteCodigo == null) ? 0 : trmteCodigo.hashCode());
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
        TramiteGuiaItemId other = (TramiteGuiaItemId) obj;
        if (tmtguCodigo == null) {
            if (other.tmtguCodigo != null) {
                return false;
            }
        } else if (!tmtguCodigo.equals(other.tmtguCodigo)) {
            return false;
        }
        if (trmteCodigo == null) {
            if (other.trmteCodigo != null) {
                return false;
            }
        } else if (!trmteCodigo.equals(other.trmteCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TramiteGuiaItemId [tmtguCodigo=" + tmtguCodigo + ", trmteCodigo=" + trmteCodigo + "]";
    }

}
