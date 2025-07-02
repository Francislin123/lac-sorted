package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;

/**
 * @author BRASIL Direct - Softwares, Soluções e Serviços
 * @since 2008
 * @version 2.0
 */

@Embeddable
public class BaseCalculoId implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer tplicCodigo;
    private char basecPorte;
    private char basecPotencialPoluidor;
    private Integer tabcaCodigo;

    public BaseCalculoId() {
    }

    public BaseCalculoId(Integer tplicCodigo, char basecPorte, char basecPotencialPoluidor, Integer tabcaCodigo) {
        this.tplicCodigo = tplicCodigo;
        this.basecPorte = basecPorte;
        this.basecPotencialPoluidor = basecPotencialPoluidor;
        this.tabcaCodigo = tabcaCodigo;
    }

    @Column(name = "TPLIC_CODIGO", precision = 10)
    public Integer getTplicCodigo() {
        return this.tplicCodigo;
    }

    public void setTplicCodigo(Integer tplicCodigo) {
        this.tplicCodigo = tplicCodigo;
    }

    @Column(name = "BASEC_PORTE", length = 1)
    public char getBasecPorte() {
        return this.basecPorte;
    }

    public void setBasecPorte(char basecPorte) {
        this.basecPorte = basecPorte;
    }

    @Column(name = "BASEC_POTENCIAL_POLUIDOR", length = 1)
    public char getBasecPotencialPoluidor() {
        return this.basecPotencialPoluidor;
    }

    public void setBasecPotencialPoluidor(char basecPotencialPoluidor) {
        this.basecPotencialPoluidor = basecPotencialPoluidor;
    }

    @Column(name = "TABCA_CODIGO", precision = 10)
    public Integer getTabcaCodigo() {
        return this.tabcaCodigo;
    }

    public void setTabcaCodigo(Integer tabcaCodigo) {
        this.tabcaCodigo = tabcaCodigo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + basecPorte;
        result = prime * result + basecPotencialPoluidor;
        result = prime * result + ((tabcaCodigo == null) ? 0 : tabcaCodigo.hashCode());
        result = prime * result + ((tplicCodigo == null) ? 0 : tplicCodigo.hashCode());
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
        BaseCalculoId other = (BaseCalculoId) obj;
        if (basecPorte != other.basecPorte) {
            return false;
        }
        if (basecPotencialPoluidor != other.basecPotencialPoluidor) {
            return false;
        }
        if (tabcaCodigo == null) {
            if (other.tabcaCodigo != null) {
                return false;
            }
        } else if (!tabcaCodigo.equals(other.tabcaCodigo)) {
            return false;
        }
        if (tplicCodigo == null) {
            if (other.tplicCodigo != null) {
                return false;
            }
        } else if (!tplicCodigo.equals(other.tplicCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BaseCalculoId [basecPorte=" + basecPorte + ", basecPotencialPoluidor=" + basecPotencialPoluidor
                + ", tabcaCodigo=" + tabcaCodigo + ", tplicCodigo=" + tplicCodigo + "]";
    }

}
