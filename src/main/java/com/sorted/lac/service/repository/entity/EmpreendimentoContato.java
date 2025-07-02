package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.experimental.Tolerate;

@Entity
@Table(name = "EMPREENDIMENTO_CONTATO")
public class EmpreendimentoContato implements java.io.Serializable {

    @EmbeddedId
    private EmpreendimentoContatoPk id;

    @ManyToOne
    @MapsId("emptoCodigo") // Mapeia empto_codigo da chave composta
    @JoinColumn(name = "empto_codigo", referencedColumnName = "empto_codigo", nullable = false)
    private Empreendimento empreendimento; // Assumindo que a entidade Empreendimento existe

    @Column(name = "emptc_principal", nullable = false, length = 1)
    private String emptcPrincipal; // bpchar(1)

    @Column(name = "tipo_contato", nullable = false, length = 255)
    private String tipoContato;

    @Tolerate
    public EmpreendimentoContato() {
        // Method default for hibernate
    }

    @Builder
    public EmpreendimentoContato(EmpreendimentoContatoPk id, Empreendimento empreendimento,
                                 String emptcPrincipal, String tipoContato) {
        this.id = id;
        this.empreendimento = empreendimento;
        this.emptcPrincipal = emptcPrincipal;
        this.tipoContato = tipoContato;
    }
}
