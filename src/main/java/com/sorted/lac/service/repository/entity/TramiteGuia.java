package com.sorted.lac.service.repository.entity;

import com.sorted.lac.service.enums.StatusTramiteGuiaEnum;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TRAMITE_GUIA")
@SequenceGenerator(name = "SEQ_TRAMITE_GUIA", sequenceName = "SEQ_TRAMITE_GUIA", allocationSize = 1)
public class TramiteGuia implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer tmtguCodigo;
    private Usuario usuarioByUserDestino;
    private Usuario usuarioByUserOrigem;
    private StatusTramiteGuiaEnum statusTramiteGuia;
    private LocalDateTime tmtguDataEnvio;
    private LocalDateTime tmtguDataRecebimento;
    private List<Tramite> tramites;
    private List<TramiteGuiaItem> tramiteGuiaItens;

    public TramiteGuia() {
        usuarioByUserDestino = new Usuario();
        usuarioByUserOrigem = new Usuario();
    }

    public TramiteGuia(Integer tmtguCodigo, Usuario usuarioByUserDestino, Usuario usuarioByUserOrigem, StatusTramiteGuiaEnum statusTramiteGuia, LocalDateTime tmtguDataEnvio) {
        this.tmtguCodigo = tmtguCodigo;
        this.usuarioByUserDestino = usuarioByUserDestino;
        this.usuarioByUserOrigem = usuarioByUserOrigem;
        this.statusTramiteGuia = statusTramiteGuia;
        this.tmtguDataEnvio = tmtguDataEnvio;
    }

    public TramiteGuia(Integer tmtguCodigo, Usuario usuarioByUserDestino, Usuario usuarioByUserOrigem, StatusTramiteGuiaEnum statusTramiteGuia, LocalDateTime tmtguDataEnvio, LocalDateTime tmtguDataRecebimento, List<Tramite> tramites) {
        this.tmtguCodigo = tmtguCodigo;
        this.usuarioByUserDestino = usuarioByUserDestino;
        this.usuarioByUserOrigem = usuarioByUserOrigem;
        this.statusTramiteGuia = statusTramiteGuia;
        this.tmtguDataEnvio = tmtguDataEnvio;
        this.tmtguDataRecebimento = tmtguDataRecebimento;
        this.tramites = tramites;
    }

    @Id
    @GeneratedValue(generator = "SEQ_TRAMITE_GUIA")
    @Column(name = "TMTGU_CODIGO", unique = true, precision = 22)
    public Integer getTmtguCodigo() {
        return this.tmtguCodigo;
    }

    public void setTmtguCodigo(Integer tmtguCodigo) {
        this.tmtguCodigo = tmtguCodigo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_DESTINO")
    public Usuario getUsuarioByUserDestino() {
        return this.usuarioByUserDestino;
    }

    public void setUsuarioByUserDestino(Usuario usuarioByUserDestino) {
        this.usuarioByUserDestino = usuarioByUserDestino;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ORIGEM")
    public Usuario getUsuarioByUserOrigem() {
        return this.usuarioByUserOrigem;
    }

    public void setUsuarioByUserOrigem(Usuario usuarioByUserOrigem) {
        this.usuarioByUserOrigem = usuarioByUserOrigem;
    }

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    public StatusTramiteGuiaEnum getStatusTramiteGuia() {
        return this.statusTramiteGuia;
    }

    public void setStatusTramiteGuia(StatusTramiteGuiaEnum statusTramiteGuia) {
        this.statusTramiteGuia = statusTramiteGuia;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TMTGU_DATA_ENVIO", length = 7)
    public LocalDateTime getTmtguDataEnvio() {
        return this.tmtguDataEnvio;
    }

    public void setTmtguDataEnvio(LocalDateTime tmtguDataEnvio) {
        this.tmtguDataEnvio = tmtguDataEnvio;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TMTGU_DATA_RECEBIMENTO", length = 7)
    public LocalDateTime getTmtguDataRecebimento() {
        return this.tmtguDataRecebimento;
    }

    public void setTmtguDataRecebimento(LocalDateTime tmtguDataRecebimento) {
        this.tmtguDataRecebimento = tmtguDataRecebimento;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TRAMITE_GUIA_TRAMITE", // Nome da tabela de junção
            joinColumns = {@JoinColumn(name = "TMTGU_CODIGO")}, // Remova 'insertable=false, updatable=false'
            inverseJoinColumns = {@JoinColumn(name = "TRAMITE_CODIGO")})
    public List<Tramite> getTramites() {
        return this.tramites;
    }

    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tramiteGuia")
    public List<TramiteGuiaItem> getTramiteGuiaItens() {
        return tramiteGuiaItens;
    }

    public void setTramiteGuiaItens(List<TramiteGuiaItem> tramiteGuiaItens) {
        this.tramiteGuiaItens = tramiteGuiaItens;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tmtguCodigo == null) ? 0 : tmtguCodigo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        TramiteGuia other = (TramiteGuia) obj;
        if (tmtguCodigo == null) {
            if (other.tmtguCodigo != null) {
                return false;
            }
        } else if (!tmtguCodigo.equals(other.tmtguCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TramiteGuia [statusTramiteGuia=" + statusTramiteGuia + ", tmtguCodigo=" + tmtguCodigo + ", tmtguDataEnvio=" + tmtguDataEnvio + ", tmtguDataRecebimento=" + tmtguDataRecebimento + ", usuarioByUserDestino=" + usuarioByUserDestino.getUserCodigo() + ", usuarioByUserOrigem=" + usuarioByUserOrigem.getUserCodigo() + "]";
    }

}
