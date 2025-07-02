package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.experimental.Tolerate;

@Entity
@Table(name = "RESPONSAVEL_CONTATO")
public class ResponsavelContato implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ResponsavelContatoPk id;

    @ManyToOne
    @MapsId("resptCodigo") // Mapeia respt_codigo da chave composta
    @JoinColumn(name = "respt_codigo", referencedColumnName = "respt_codigo", nullable = false)
    private ResponsavelTecnico responsavelTecnico; // Assumindo que a entidade ResponsavelTecnico existe

    @Column(name = "respc_principal", nullable = false, length = 1)
    private String respcPrincipal; // bpchar(1)

    @Column(name = "tipo_contato", nullable = false, length = 20)
    private String tipoContato;

    @Tolerate
    public ResponsavelContato() {
        // Method default for hibernate
    }

    @Builder
    public ResponsavelContato(ResponsavelContatoPk id, ResponsavelTecnico responsavelTecnico, String respcPrincipal, String tipoContato) {
        this.id = id;
        this.responsavelTecnico = responsavelTecnico;
        this.respcPrincipal = respcPrincipal;
        this.tipoContato = tipoContato;
    }
}
