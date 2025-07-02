package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "analise_equipe")
@SequenceGenerator(name = "SEQ_ANALISE_EQUIPE", sequenceName = "SEQ_ANALISE_EQUIPE", allocationSize = 1)
public class AnaliseEquipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "analise_equipe_codigo")
    private Integer analiseEquipeCodigo;

    @ManyToOne
    @JoinColumn(name = "anlse_codigo", referencedColumnName = "anlse_codigo")
    private Analise analise;

    @ManyToOne
    @JoinColumn(name = "user_codigo", referencedColumnName = "user_codigo")
    private Usuario usuario;

    @Column(name = "anseq_coordenador", length = 1)
    private String anseqCoordenador; // bpchar(1)

    @Column(name = "dt_validacao")
    private LocalDateTime dtValidacao;

    @Column(name = "dt_assinatura")
    private LocalDateTime dtAssinatura;

    @Column(name = "sha_arquivo", length = 100)
    private String shaArquivo;

    @Column(name = "tipo_equipe", length = 30)
    private String tipoEquipe;

    @Column(name = "status_solicitacao", length = 30)
    private String statusSolicitacao;

    @Column(name = "motivo_solicitacao", length = 1000)
    private String motivoSolicitacao;

    @Column(name = "dt_solicitacao")
    private LocalDateTime dtSolicitacao;

    @Column(name = "dt_autorizacao")
    private LocalDateTime dtAutorizacao;

    @Tolerate
    public AnaliseEquipe() {
        // Method default for hibernate
    }

    @Builder
    public AnaliseEquipe(Integer analiseEquipeCodigo, Analise analise, Usuario usuario, String anseqCoordenador, LocalDateTime dtValidacao, LocalDateTime dtAssinatura, String shaArquivo, String tipoEquipe, String statusSolicitacao, String motivoSolicitacao, LocalDateTime dtSolicitacao, LocalDateTime dtAutorizacao) {
        this.analiseEquipeCodigo = analiseEquipeCodigo;
        this.analise = analise;
        this.usuario = usuario;
        this.anseqCoordenador = anseqCoordenador;
        this.dtValidacao = dtValidacao;
        this.dtAssinatura = dtAssinatura;
        this.shaArquivo = shaArquivo;
        this.tipoEquipe = tipoEquipe;
        this.statusSolicitacao = statusSolicitacao;
        this.motivoSolicitacao = motivoSolicitacao;
        this.dtSolicitacao = dtSolicitacao;
        this.dtAutorizacao = dtAutorizacao;
    }
}
