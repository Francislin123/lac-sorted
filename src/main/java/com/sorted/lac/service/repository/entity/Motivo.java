package com.sorted.lac.service.repository.entity;


import jakarta.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDateTime;

@Entity
@Table(name = "MOTIVO")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class Motivo implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer motivCodigo;
    private TipoMotivo tipoMotivo;
    private String motivDescricao;
    private LocalDateTime motivData;

    public Motivo() {
    }

    @Id
    @Column(name = "MOTIV_CODIGO", unique = true, precision = 22)
    public Integer getMotivCodigo() {
        return this.motivCodigo;
    }

    public void setMotivCodigo(Integer motivCodigo) {
        this.motivCodigo = motivCodigo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TPMTV_CODIGO")
    @Fetch(FetchMode.JOIN)
    public TipoMotivo getTipoMotivo() {
        return this.tipoMotivo;
    }

    public void setTipoMotivo(TipoMotivo tipoMotivo) {
        this.tipoMotivo = tipoMotivo;
    }

    @Column(name = "MOTIV_DESCRICAO", length = 500)
    public String getMotivDescricao() {
        return this.motivDescricao;
    }

    public void setMotivDescricao(String motivDescricao) {
        this.motivDescricao = motivDescricao;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MOTIV_DATA", length = 7)
    public LocalDateTime getMotivData() {
        return this.motivData;
    }

    public void setMotivData(LocalDateTime motivData) {
        this.motivData = motivData;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((motivCodigo == null) ? 0 : motivCodigo.hashCode());
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
        Motivo other = (Motivo) obj;
        if (motivCodigo == null) {
            if (other.motivCodigo != null) {
                return false;
            }
        } else if (!motivCodigo.equals(other.motivCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Motivo [motivCodigo=" + motivCodigo + ", motivDescricao=" + motivDescricao + "]";
    }

}
