package com.sorted.lac.service.repository.auditoria;

import com.sorted.lac.service.enums.EtapaAuditoriaEnum;
import com.sorted.lac.service.enums.StatusGeralEnum;
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
@Table(name = "AUDITORIA_ETAPA_PRAZO")
@SequenceGenerator(name = "SEQ_AUDITORIA_ETAPA_PRAZO", sequenceName = "SEQ_AUDITORIA_ETAPA_PRAZO", allocationSize = 1)
public class AuditoriaEtapaPrazo implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "SEQ_AUDITORIA_ETAPA_PRAZO")
    @Column(name = "codigo", nullable = false)
    private Integer codigo;

    @Column(name = "data_fim")
    private LocalDateTime dataFim;

    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "prazo")
    private Integer prazo;

    @ManyToOne
    @JoinColumn(name = "auditoria_codigo", referencedColumnName = "audit_codigo", nullable = false)
    private Auditoria auditoria;

    @Column(name = "ETAPA", nullable = false)
    @Enumerated(EnumType.STRING)
    private EtapaAuditoriaEnum etapa;

    @ManyToOne
    @JoinColumn(name = "user_codigo", referencedColumnName = "user_codigo") // user_codigo é NULLABLE
    private Usuario usuario;

    @Column(name = "observacao", length = 200)
    private String observacao;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private StatusGeralEnum status;

    @Tolerate
    public AuditoriaEtapaPrazo() {
        // Method default for hibernate
    }

    @Builder
    public AuditoriaEtapaPrazo(Integer codigo, LocalDateTime dataFim, LocalDateTime dataInicio, Integer prazo,
                               Auditoria auditoria, EtapaAuditoriaEnum etapa, Usuario usuario, String observacao, StatusGeralEnum status) {
        this.codigo = codigo;
        this.dataFim = dataFim;
        this.dataInicio = dataInicio;
        this.prazo = prazo;
        this.auditoria = auditoria;
        this.etapa = etapa;
        this.usuario = usuario;
        this.observacao = observacao;
        this.status = status;
    }
}
