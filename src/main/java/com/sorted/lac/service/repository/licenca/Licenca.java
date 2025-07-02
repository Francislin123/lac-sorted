package com.sorted.lac.service.repository.licenca;

import com.sorted.lac.service.enums.StatusLicencaEnum;
import com.sorted.lac.service.repository.entity.TipoLicenca;
import com.sorted.lac.service.repository.entity.Usuario;
import com.sorted.lac.service.repository.fce.Fce;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "LICENCA")
@SequenceGenerator(name = "SEQ_LICENCA", sequenceName = "SEQ_LICENCA", allocationSize = 1)
public class Licenca implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "SEQ_LICENCA")
    @Column(name = "LICEN_CODIGO", unique = true, precision = 10)
    private Integer licenCodigo;

    @Column(name = "LICEN_NUMERO", length = 50)
    private String licenNumero;

    @Column(name = "LICEN_DOCUMENTO_ANEXO", length = 500)
    private String licenDocumentoAnexo;

    @Column(name = "LICEN_CONDICOES_VALIDADE", length = 1000)
    private String licenCondicoesValidade;

    @Column(name = "LICEN_VALIDADE", precision = 22)
    private Integer licenValidade;

    @Column(name = "LICEN_CARACTERISTICA", nullable = true, length = 1000)
    private String licenCaracteristica;

    @Column(name = "LICEN_PARECER", nullable = true, length = 20)
    private String licenParecer;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LICEN_DATA_ASSINATURA", length = 7)
    private LocalDateTime licenDataAssinatura;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LICEN_DATA_VALIDADE", length = 7)
    private LocalDateTime licenDataValidade;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LICEN_DATA_ENTREGA", length = 7)
    private LocalDateTime licenDataEntrega;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LICEN_DATA_EMISSAO", length = 7)
    private LocalDateTime licenDataEmissao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FCE_CODIGO")
    private Fce fce;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_CODIGO")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TPLIC_CODIGO")
    private TipoLicenca tipoLicenca;

    @Column(name = "LICEN_OBSERVACAO", nullable = true, length = 1000)
    private String licenObservacao;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private StatusLicencaEnum statusLicenca;

    @Column(name = "LICEN_ATIV_SECUNDARIA", nullable = true, length = 200)
    private String licenAtivSecundaria;

    @Column(name = "LICEN_MONITORAMENTO", nullable = true)
    private Integer licenMonitoramento;

    @Transient
    private LocalDateTime trLicenDataValidade;

    @Transient
    private LocalDateTime trLicenPrazoRenovacao;

    @Transient
    private int trDiasRestantes;

    @Column(name = "ID_FCE_TPDOC", nullable = true)
    private Integer idFceTpdoc;

    @Column(name = "RECURSO", nullable = true)
    private Boolean recurso;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LICEN_DATA_ACEITE_INDEF", length = 7)
    private LocalDateTime licenDataAceiteIndef;

    @Column(name = "RECURSO_AUDITORIA", nullable = true)
    private Boolean recursoAuditoria;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LICEN_DATA_ACEITE_REC_AUDIT", length = 7)
    private LocalDateTime licenDataAceiteRecAudit;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LICEN_DATA_ACE_INICIO_AUDIT", length = 7)
    private LocalDateTime licenDataAceiteInicioAudit;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LICEN_DATA_ACE_SUSP_AUDIT", length = 7)
    private LocalDateTime licenDataAceiteSuspAudit;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USUARIO_RESP_ANALISE", nullable = true)
    private Usuario usuarioRespAnalise;

    @Tolerate
    public Licenca() {
        // Method default for hibernate
    }

    @Builder
    public Licenca(Integer licenCodigo, String licenNumero, String licenDocumentoAnexo, String licenCondicoesValidade, Integer licenValidade, String licenCaracteristica, String licenParecer, LocalDateTime licenDataAssinatura, LocalDateTime licenDataValidade, LocalDateTime licenDataEntrega, LocalDateTime licenDataEmissao, Fce fce, Usuario usuario, TipoLicenca tipoLicenca, String licenObservacao, StatusLicencaEnum statusLicenca, String licenAtivSecundaria, Integer licenMonitoramento, LocalDateTime trLicenDataValidade, LocalDateTime trLicenPrazoRenovacao, int trDiasRestantes, Integer idFceTpdoc, Boolean recurso, LocalDateTime licenDataAceiteIndef, Boolean recursoAuditoria, LocalDateTime licenDataAceiteRecAudit, LocalDateTime licenDataAceiteInicioAudit, LocalDateTime licenDataAceiteSuspAudit, Usuario usuarioRespAnalise) {
        this.licenCodigo = licenCodigo;
        this.licenNumero = licenNumero;
        this.licenDocumentoAnexo = licenDocumentoAnexo;
        this.licenCondicoesValidade = licenCondicoesValidade;
        this.licenValidade = licenValidade;
        this.licenCaracteristica = licenCaracteristica;
        this.licenParecer = licenParecer;
        this.licenDataAssinatura = licenDataAssinatura;
        this.licenDataValidade = licenDataValidade;
        this.licenDataEntrega = licenDataEntrega;
        this.licenDataEmissao = licenDataEmissao;
        this.fce = fce;
        this.usuario = usuario;
        this.tipoLicenca = tipoLicenca;
        this.licenObservacao = licenObservacao;
        this.statusLicenca = statusLicenca;
        this.licenAtivSecundaria = licenAtivSecundaria;
        this.licenMonitoramento = licenMonitoramento;
        this.trLicenDataValidade = trLicenDataValidade;
        this.trLicenPrazoRenovacao = trLicenPrazoRenovacao;
        this.trDiasRestantes = trDiasRestantes;
        this.idFceTpdoc = idFceTpdoc;
        this.recurso = recurso;
        this.licenDataAceiteIndef = licenDataAceiteIndef;
        this.recursoAuditoria = recursoAuditoria;
        this.licenDataAceiteRecAudit = licenDataAceiteRecAudit;
        this.licenDataAceiteInicioAudit = licenDataAceiteInicioAudit;
        this.licenDataAceiteSuspAudit = licenDataAceiteSuspAudit;
        this.usuarioRespAnalise = usuarioRespAnalise;
    }
}
