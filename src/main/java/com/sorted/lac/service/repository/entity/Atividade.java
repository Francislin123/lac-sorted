package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Entity
@Table(name = "ATIVIDADE", uniqueConstraints = @UniqueConstraint(columnNames = "ATIV_CODIGO_CONSEMA"))
@SequenceGenerator(name = "seq_atividade", sequenceName = "seq_atividade", allocationSize = 1)
public class Atividade implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ativ_codigo")
    @GeneratedValue(generator = "seq_atividade")
    private Integer ativCodigo;

    @Column(name = "ativ_codigo_consema", length = 10, unique = true)
    private String ativCodigoConseMa;

    @Column(name = "ativ_descricao", length = 1000)
    private String ativDescricao;

    @Column(name = "ativ_enquadra")
    private Integer ativEnquadra;

    @Column(name = "ativ_potencial_geral", length = 1)
    private String ativPotencialGeral; // bpchar(1)

    @Column(name = "ativ_resumo", length = 1000)
    private String ativResumo;

    @ManyToOne
    @JoinColumn(name = "modin_codigo", referencedColumnName = "modin_codigo")
    // Assumindo que a entidade ModeloIn existe
    private ModeloIn modeloIn;

    @ManyToOne
    @JoinColumn(name = "modin_codigo_tac", referencedColumnName = "modin_codigo") // Can be NULL
    // Assumindo que a entidade ModeloIn existe
    private ModeloIn modeloInTac;

    @ManyToOne
    @JoinColumn(name = "tabca_codigo", referencedColumnName = "tabca_codigo")
    // Assumindo que a entidade TabelaCalculo existe
    private TabelaCalculo tabelaCalculo;

    @Column(name = "tpdoc_diferenciado")
    private Boolean tpdocDiferenciado;

    @Column(name = "tpdoc_tfasc")
    private Boolean tpdocTfasc;

    @Column(name = "atividade_ativa")
    private Boolean atividadeAtiva;

    @Column(name = "tipologia", length = 255)
    private String tipologia;

    @Tolerate
    public Atividade() {
        // Method default for hibernate
    }

    @Builder
    public Atividade(Integer ativCodigo, String ativCodigoConseMa, String ativDescricao, Integer ativEnquadra,
                     String ativPotencialGeral, String ativResumo, ModeloIn modeloIn, ModeloIn modeloInTac,
                     TabelaCalculo tabelaCalculo, Boolean tpdocDiferenciado, Boolean tpdocTfasc, Boolean atividadeAtiva, String tipologia) {
        this.ativCodigo = ativCodigo;
        this.ativCodigoConseMa = ativCodigoConseMa;
        this.ativDescricao = ativDescricao;
        this.ativEnquadra = ativEnquadra;
        this.ativPotencialGeral = ativPotencialGeral;
        this.ativResumo = ativResumo;
        this.modeloIn = modeloIn;
        this.modeloInTac = modeloInTac;
        this.tabelaCalculo = tabelaCalculo;
        this.tpdocDiferenciado = tpdocDiferenciado;
        this.tpdocTfasc = tpdocTfasc;
        this.atividadeAtiva = atividadeAtiva;
        this.tipologia = tipologia;
    }
}
