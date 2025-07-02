package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;

import lombok.Builder;
import lombok.experimental.Tolerate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "TRAMITE_SITUACAO")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class TramiteSituacao implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assumindo sequence ou auto-incremento para 'tmtsi_codigo'
    @Column(name = "tmtsi_codigo", nullable = false)
    private Integer tmtsiCodigo;

    @Column(name = "tmtsi_descricao", nullable = false, length = 100)
    private String tmtsiDescricao;

    @Tolerate
    public TramiteSituacao() {
        // Default method by hibernate
    }

    @Builder
    public TramiteSituacao(Integer tmtsiCodigo, String tmtsiDescricao) {
        this.tmtsiCodigo = tmtsiCodigo;
        this.tmtsiDescricao = tmtsiDescricao;
    }
}
