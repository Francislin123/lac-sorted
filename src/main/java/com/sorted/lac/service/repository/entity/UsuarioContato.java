package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Entity
@Table(name = "USUARIO_CONTATO")
public class UsuarioContato implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private UsuarioContatoPk id;

    @ManyToOne
    @MapsId("userCodigo") // Mapeia user_codigo da chave composta
    @JoinColumn(name = "user_codigo", referencedColumnName = "user_codigo", nullable = false)
    private Usuario usuario; // Entidade Usuario deve existir

    @Column(name = "userc_principal_status")
    private Boolean usercPrincipalStatus; // bool mapeado para Boolean

    @Column(name = "tipo_contato", length = 20)
    private String tipoContato;

    @Tolerate
    public UsuarioContato() {
        // Default method for hibernate
    }

    @Builder
    public UsuarioContato(UsuarioContatoPk id, Usuario usuario, Boolean usercPrincipalStatus, String tipoContato) {
        this.id = id;
        this.usuario = usuario;
        this.usercPrincipalStatus = usercPrincipalStatus;
        this.tipoContato = tipoContato;
    }
}
