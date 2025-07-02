package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Entity
@Table(name = "EMPREENDIMENTO_CORRESPONDENCIA", uniqueConstraints = @UniqueConstraint(columnNames = {"EMPTO_CODIGO", "END_CODIGO"}))
public class EmpreendimentoCorrespondencia implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "empto_codigo", nullable = false)
    private Integer emptoCodigo; // Este campo será mapeado pela PK de Empreendimento

    @OneToOne
    @MapsId // Indica que emptoCodigo é também a PK e mapeia para a PK de Empreendimento
    @JoinColumn(name = "empto_codigo", referencedColumnName = "empto_codigo", nullable = false)
    private Empreendimento empreendimento; // Assumindo que a entidade Empreendimento existe

    @Column(name = "empco_cpf", length = 255)
    private String empcoCpf;

    @Column(name = "empco_nome", nullable = false, length = 100)
    private String empcoNome;

    @Column(name = "empco_orgao_expedidor", length = 15)
    private String empcoOrgaoExpedidor;

    @Column(name = "empco_rg", length = 20)
    private String empcoRg;

    @Column(name = "empco_uf", length = 2)
    private String empcoUf;

    @ManyToOne
    @JoinColumn(name = "end_codigo", referencedColumnName = "end_codigo", nullable = false)
    private Endereco endereco;

    @Tolerate
    public EmpreendimentoCorrespondencia() {
        // Method default for hibernate
    }

    @Builder
    public EmpreendimentoCorrespondencia(Integer emptoCodigo, Empreendimento empreendimento, String empcoCpf,
                                         String empcoNome, String empcoOrgaoExpedidor, String empcoRg,
                                         String empcoUf, Endereco endereco) {
        this.emptoCodigo = emptoCodigo;
        this.empreendimento = empreendimento;
        this.empcoCpf = empcoCpf;
        this.empcoNome = empcoNome;
        this.empcoOrgaoExpedidor = empcoOrgaoExpedidor;
        this.empcoRg = empcoRg;
        this.empcoUf = empcoUf;
        this.endereco = endereco;
    }
}
