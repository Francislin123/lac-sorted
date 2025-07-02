package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
class UsuarioContatoPk implements Serializable {

    @Column(name = "user_codigo", nullable = false)
    private Integer userCodigo;

    @Column(name = "userc_contato", nullable = false, length = 100)
    private String usercContato;

    @Tolerate
    public UsuarioContatoPk() {
        // Default method for hibernate
    }

    @Builder
    public UsuarioContatoPk(Integer userCodigo, String usercContato) {
        this.userCodigo = userCodigo;
        this.usercContato = usercContato;
    }
}
