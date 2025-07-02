package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TRAMITE_GUIA_ITEM")
public class TramiteGuiaItem implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private TramiteGuiaItemId id;
    private TramiteGuia tramiteGuia;
    private Tramite tramite;

    public TramiteGuiaItem() {
        tramiteGuia = new TramiteGuia();
        tramite = new Tramite();
    }

    @EmbeddedId
    @AttributeOverrides({@AttributeOverride(name = "tmtguCodigo", column = @Column(name = "TMTGU_CODIGO", precision = 10)), @AttributeOverride(name = "trmteCodigo", column = @Column(name = "TRMTE_CODIGO", precision = 10))})
    public TramiteGuiaItemId getId() {
        return this.id;
    }

    public void setId(TramiteGuiaItemId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TMTGU_CODIGO", insertable = false, updatable = false)
    public TramiteGuia getTramiteGuia() {
        return tramiteGuia;
    }

    public void setTramiteGuia(TramiteGuia tramiteGuia) {
        this.tramiteGuia = tramiteGuia;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TRMTE_CODIGO", insertable = false, updatable = false)
    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        TramiteGuiaItem other = (TramiteGuiaItem) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TramiteGuiaItem [id=" + id + ", tramite=" + tramite.getTrmteCodigo() + ", tramiteGuia=" + tramiteGuia.getTmtguCodigo() + "]";
    }

}
