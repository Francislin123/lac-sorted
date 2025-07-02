package com.sorted.lac.service.repository.auditoria;

import com.sorted.lac.service.repository.entity.Usuario;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "AUDITORIA_EQUIPE")
@SequenceGenerator(name = "SEQ_AUDITORIA_EQUIPE", sequenceName = "SEQ_AUDITORIA_EQUIPE", allocationSize = 1)
public class AuditoriaEquipe implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "SEQ_AUDITORIA_EQUIPE")
    @Column(name = "auditoria_equipe_codigo", nullable = false)
    private Integer auditoriaEquipeCodigo;

    @ManyToOne
    @JoinColumn(name = "audit_codigo", referencedColumnName = "audit_codigo", nullable = false)
    private Auditoria auditoria; // Entidade Auditoria deve existir

    @ManyToOne
    @JoinColumn(name = "user_codigo", referencedColumnName = "user_codigo", nullable = false)
    private Usuario usuario; // Entidade Usuario deve existir

    @Column(name = "dt_validacao")
    private LocalDateTime dtValidacao; // Mapeado de timestamp(6) para LocalDateTime

    @Column(name = "dt_assinatura")
    private LocalDateTime dtAssinatura; // Mapeado de timestamp(6) para LocalDateTime

    @Column(name = "dt_solicitacao")
    private LocalDateTime dtSolicitacao; // Mapeado de timestamp(6) para LocalDateTime

    @Column(name = "dt_autorizacao")
    private LocalDateTime dtAutorizacao; // Mapeado de timestamp(6) para LocalDateTime

    @Column(name = "sha_arquivo", length = 100)
    private String shaArquivo;

    @Column(name = "tipo_equipe", length = 30)
    private String tipoEquipe;

    @Column(name = "motivo_solicitacao", length = 200)
    private String motivoSolicitacao;

    @Column(name = "status_solicitacao", length = 30)
    private String statusSolicitacao;

    @Column(name = "dt_valrel_final")
    private LocalDateTime dtValrelFinal;

    @Tolerate
    public AuditoriaEquipe() {
        // Method default for hibernate
    }

    @Builder
    public AuditoriaEquipe(Integer auditoriaEquipeCodigo, Auditoria auditoria, Usuario usuario,
                           LocalDateTime dtValidacao, LocalDateTime dtAssinatura, LocalDateTime dtSolicitacao,
                           LocalDateTime dtAutorizacao, String shaArquivo, String tipoEquipe, String motivoSolicitacao,
                           String statusSolicitacao, LocalDateTime dtValrelFinal) {
        this.auditoriaEquipeCodigo = auditoriaEquipeCodigo;
        this.auditoria = auditoria;
        this.usuario = usuario;
        this.dtValidacao = dtValidacao;
        this.dtAssinatura = dtAssinatura;
        this.dtSolicitacao = dtSolicitacao;
        this.dtAutorizacao = dtAutorizacao;
        this.shaArquivo = shaArquivo;
        this.tipoEquipe = tipoEquipe;
        this.motivoSolicitacao = motivoSolicitacao;
        this.statusSolicitacao = statusSolicitacao;
        this.dtValrelFinal = dtValrelFinal;
    }
}
