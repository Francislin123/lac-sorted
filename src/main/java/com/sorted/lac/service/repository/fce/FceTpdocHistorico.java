package com.sorted.lac.service.repository.fce;

import com.sorted.lac.service.repository.entity.Motivo;
import com.sorted.lac.service.repository.entity.Usuario;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Entity
@Table(name = "FCE_TPDOC_HISTORICO")
public class FceTpdocHistorico implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private FceTpdocHistoricoPk id;

    @ManyToOne
    @JoinColumn(name = "mtivo_codigo", referencedColumnName = "motiv_codigo", nullable = false)
    private Motivo motivo; // Assumindo que a entidade Motivo existe

    @ManyToOne
    @JoinColumn(name = "user_codigo", referencedColumnName = "user_codigo", nullable = false)
    private Usuario usuario; // Assumindo que a entidade Usuario existe

    @ManyToOne
    @MapsId("fcetdNumero") // Mapeia fcetd_numero da chave composta
    @JoinColumn(name = "fcetd_numero", referencedColumnName = "fcetd_numero", nullable = false)
    private FceTpdoc fceTpdoc; // Assumindo que a entidade FceTpdoc existe

    @Column(name = "status", length = 200)
    private String status;

    @Tolerate
    public FceTpdocHistorico() {
    }

    @Builder
    public FceTpdocHistorico(FceTpdocHistoricoPk id, Motivo motivo, Usuario usuario, FceTpdoc fceTpdoc, String status) {
        this.id = id;
        this.motivo = motivo;
        this.usuario = usuario;
        this.fceTpdoc = fceTpdoc;
        this.status = status;
    }
}
