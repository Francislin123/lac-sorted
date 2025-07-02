package com.sorted.lac.service.repository.auditoria;

import com.sorted.lac.service.enums.EtapaAuditoriaEnum;
import com.sorted.lac.service.enums.StatusAuditoriaEnum;
import com.sorted.lac.service.repository.fce.Fce;
import com.sorted.lac.service.repository.regional.Regional;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "AUDITORIA")
@SequenceGenerator(name = "SEQ_AUDITORIA", sequenceName = "SEQ_AUDITORIA", allocationSize = 1)
public class Auditoria implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "SEQ_AUDITORIA")
    @Column(name = "AUDIT_CODIGO", unique = true, precision = 22)
    private Integer auditCodigo;

    @ManyToOne
    @JoinColumn(name = "fce", referencedColumnName = "fce_codigo", nullable = false)
    private Fce fce;

    @ManyToOne
    @JoinColumn(name = "reg_codigo", referencedColumnName = "reg_codigo", nullable = false)
    private Regional regional;

    @Column(name = "ETAPA", nullable = false)
    @Enumerated(EnumType.STRING)
    private EtapaAuditoriaEnum etapa;

    @Column(name = "data_sorteio", nullable = false)
    private LocalDateTime dataSorteio; // Mapeado de timestamp(6) para LocalDateTime

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private StatusAuditoriaEnum status;

    @Column(name = "sha_arquivo", length = 100)
    private String shaArquivo;

    @Column(name = "recurso")
    private Boolean recurso;

    @Tolerate
    public Auditoria() {
        // Method default for hibernate
    }

    @Builder
    public Auditoria(Integer auditCodigo, Fce fce, Regional regional, EtapaAuditoriaEnum etapa,
                     LocalDateTime dataSorteio, StatusAuditoriaEnum status, String shaArquivo, Boolean recurso) {
        this.auditCodigo = auditCodigo;
        this.fce = fce;
        this.regional = regional;
        this.etapa = etapa;
        this.dataSorteio = dataSorteio;
        this.status = status;
        this.shaArquivo = shaArquivo;
        this.recurso = recurso;
    }
}
