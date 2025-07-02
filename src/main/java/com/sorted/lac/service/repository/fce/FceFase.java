package com.sorted.lac.service.repository.fce;

import com.sorted.lac.service.enums.FaseEnum;
import com.sorted.lac.service.repository.entity.Usuario;
import jakarta.persistence.*;

@Entity
@Table(name = "FCE_FASE")
public class FceFase implements Comparable<FceFase>, java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private FceFaseId id;
    private Fce fce;
    private Usuario usuario;
    private FaseEnum fase;

    public FceFase() {
        fce = new Fce();
        usuario = new Usuario();
        id = new FceFaseId();
    }

    public FceFase(FceFaseId id, Fce fce, Usuario usuario, FaseEnum fase) {
        this.id = id;
        this.fce = fce;
        this.usuario = usuario;
        this.fase = fase;
    }

    @EmbeddedId
    @AttributeOverrides({@AttributeOverride(name = "fceCodigo", column = @Column(name = "FCE_CODIGO", precision = 10)), @AttributeOverride(name = "fcefaData", column = @Column(name = "FCEFA_DATA", length = 7))})
    public FceFaseId getId() {
        return this.id;
    }

    public void setId(FceFaseId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FCE_CODIGO", insertable = false, updatable = false)
    public Fce getFce() {
        if (this.fce == null) {
            this.fce = new Fce();
        }
        return this.fce;
    }

    public void setFce(Fce fce) {
        if (this.fce == null) {
            this.fce = new Fce();
        }
        this.fce = fce;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_CODIGO")
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Column(name = "FASE")
    @Enumerated(EnumType.STRING)
    public FaseEnum getFase() {
        return this.fase;
    }

    public void setFase(FaseEnum fase) {
        this.fase = fase;
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
        FceFase other = (FceFase) obj;
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
    public int compareTo(FceFase o) {
        return this.getId().getFcefaData().compareTo(o.getId().getFcefaData());
    }
}
