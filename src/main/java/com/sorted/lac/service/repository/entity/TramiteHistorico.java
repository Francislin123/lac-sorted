package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TRAMITE_HISTORICO")
@SequenceGenerator(name = "SEQ_TRAMITE_HISTORICO", sequenceName = "SEQ_TRAMITE_HISTORICO", allocationSize = 1)
public class TramiteHistorico implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "SEQ_TRAMITE_HISTORICO")
    @Column(name = "tmthi_codigo", nullable = false)
    private Integer tmthiCodigo;

    @Column(name = "tmthi_data_destino")
    private LocalDateTime tmthiDataDestino; // Mapeado de timestamp para LocalDateTime

    @Column(name = "tmthi_data_origem", nullable = false)
    private LocalDateTime tmthiDataOrigem; // Mapeado de timestamp para LocalDateTime

    @Column(name = "tmthi_objeto", length = 70)
    private String tmthiObjeto;

    @ManyToOne
    @JoinColumn(name = "trmte_codigo", referencedColumnName = "trmte_codigo", nullable = false)
    private Tramite tramite; // Entidade Tramite deve existir

    @ManyToOne
    @JoinColumn(name = "tmtgu_codigo", referencedColumnName = "tmtac_codigo", nullable = false) // FK aponta para tmtac_codigo
    private TramiteAcao tramiteAcao; // Entidade TramiteAcao deve existir (tmtac_codigo)

    @ManyToOne
    @JoinColumn(name = "tmtsi_codigo", referencedColumnName = "tmtsi_codigo", nullable = false)
    private TramiteSituacao tramiteSituacao; // Entidade TramiteSituacao deve existir

    @ManyToOne
    @JoinColumn(name = "user_destino", referencedColumnName = "user_codigo", nullable = false)
    private Usuario userDestino; // Entidade Usuario (para o usuário destino) deve existir

    @ManyToOne
    @JoinColumn(name = "user_origem", referencedColumnName = "user_codigo", nullable = false)
    private Usuario userOrigem;


    @Tolerate
    public TramiteHistorico() {
      // Default method by hibernate
    }

    @Builder
    public TramiteHistorico(Integer tmthiCodigo, LocalDateTime tmthiDataDestino, LocalDateTime tmthiDataOrigem,
                            String tmthiObjeto, Tramite tramite, TramiteAcao tramiteAcao, TramiteSituacao tramiteSituacao,
                            Usuario userDestino, Usuario userOrigem) {
        this.tmthiCodigo = tmthiCodigo;
        this.tmthiDataDestino = tmthiDataDestino;
        this.tmthiDataOrigem = tmthiDataOrigem;
        this.tmthiObjeto = tmthiObjeto;
        this.tramite = tramite;
        this.tramiteAcao = tramiteAcao;
        this.tramiteSituacao = tramiteSituacao;
        this.userDestino = userDestino;
        this.userOrigem = userOrigem;
    }
}
