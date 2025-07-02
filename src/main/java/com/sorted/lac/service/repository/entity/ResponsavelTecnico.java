package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Entity
@Table(name = "RESPONSAVEL_TECNICO")
@SequenceGenerator(name = "SEQ_RESPONSAVEL_TECNICO", sequenceName = "SEQ_RESPONSAVEL_TECNICO", allocationSize = 1)
public class ResponsavelTecnico implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assumindo sequence ou auto-incremento para 'respt_codigo'
    @Column(name = "respt_codigo", nullable = false)
    private Integer resptCodigo;

    @Column(name = "respt_nome", nullable = false, length = 100)
    private String resptNome;

    @Column(name = "respt_reg_crea", nullable = false, length = 20)
    private String resptRegCrea;

    @ManyToOne
    @JoinColumn(name = "end_codigo", referencedColumnName = "end_codigo", nullable = false)
    private Endereco endereco; // Assumindo que a entidade Endereco existe

    @ManyToOne
    @JoinColumn(name = "rtcar_codigo", referencedColumnName = "rtcar_codigo", nullable = false)
    // Assumindo que a entidade ResponsavelTecnicoCargo existe
    private ResponsavelTecnicoCargo responsavelTecnicoCargo;

    @Tolerate
    public ResponsavelTecnico() {
        // Method default for hibernate
    }

    @Tolerate
    public ResponsavelTecnico(Integer resptCodigo, String resptNome, String resptRegCrea, Endereco endereco, ResponsavelTecnicoCargo responsavelTecnicoCargo) {
        this.resptCodigo = resptCodigo;
        this.resptNome = resptNome;
        this.resptRegCrea = resptRegCrea;
        this.endereco = endereco;
        this.responsavelTecnicoCargo = responsavelTecnicoCargo;
    }
}
