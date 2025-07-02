package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "NIVEL_ATIVIDADE")
public class NivelAtividade implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private NivelAtividadeId id;
    private Atividade atividade;
    private Nivel nivel;

    public NivelAtividade() {
    }

    public NivelAtividade(NivelAtividadeId id, Atividade atividade, Nivel nivel) {
        this.id = id;
        this.atividade = atividade;
        this.nivel = nivel;
    }

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "nivelCodigo", column = @Column(name = "NIVEL_CODIGO", precision = 22)),
            @AttributeOverride(name = "ativiCodigo", column = @Column(name = "ATIVI_CODIGO", precision = 22)),
            @AttributeOverride(name = "niatiPorte", column = @Column(name = "NIATI_PORTE", length = 1)) })
    public NivelAtividadeId getId() {
        return this.id;
    }

    public void setId(NivelAtividadeId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ATIVI_CODIGO", insertable = false, updatable = false)
    public Atividade getAtividade() {
        return this.atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NIVEL_CODIGO", insertable = false, updatable = false)
    public Nivel getNivel() {
        return this.nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
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
        NivelAtividade other = (NivelAtividade) obj;
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
        return "NivelAtividade [atividade=" + atividade.getAtivCodigo() + ", id=" + id.getNiatiPorte() + ", nivel="
                + nivel.getNivelCodigo() + "]";
    }

}
