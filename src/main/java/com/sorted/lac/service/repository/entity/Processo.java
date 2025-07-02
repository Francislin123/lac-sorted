package com.sorted.lac.service.repository.entity;

import com.sorted.lac.service.enums.StatusProcessoEnum;
import com.sorted.lac.service.repository.fce.Fce;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PROCESSO")
@SequenceGenerator(name = "SEQ_PROCESSO", sequenceName = "SEQ_PROCESSO", allocationSize = 1)
public class Processo implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer procCodigo;
    private Tramite tramite;
    private TipoProcesso tipoProcesso;
    private StatusProcessoEnum statusProcesso;
    private String procNumero;
    private LocalDateTime procDataFormalizacao;
    private List<Fce> fces;
    private Set<ProcessoCaixa> processoCaixas = new HashSet<ProcessoCaixa>(0);
    private Empreendimento empreendimento;

    public Processo() {
        tramite = new Tramite();
        tipoProcesso = new TipoProcesso();
        empreendimento = new Empreendimento();
    }

    public Processo(int procCodigo) {
        this.procCodigo = procCodigo;
    }

    public Processo(Integer procCodigo, TipoProcesso tipoProcesso, StatusProcessoEnum statusProcesso, String procNumero, Empreendimento empreendimento, LocalDateTime procDataFormalizacao) {
        this.procCodigo = procCodigo;
        this.tipoProcesso = tipoProcesso;
        this.statusProcesso = statusProcesso;
        this.procNumero = procNumero;
        this.empreendimento = empreendimento;
        this.procDataFormalizacao = procDataFormalizacao;
    }

    public Processo(Integer procCodigo, Tramite tramite, TipoProcesso tipoProcesso, StatusProcessoEnum statusProcesso, String procNumero, LocalDateTime procDataFormalizacao, List<Fce> fces, Set<ProcessoCaixa> processoCaixas, Empreendimento empreendimento) {
        this.procCodigo = procCodigo;
        this.tramite = tramite;
        this.tipoProcesso = tipoProcesso;
        this.statusProcesso = statusProcesso;
        this.procNumero = procNumero;
        this.procDataFormalizacao = procDataFormalizacao;
        this.fces = fces;
        this.processoCaixas = processoCaixas;
        this.empreendimento = empreendimento;
    }

    @Id
    @GeneratedValue(generator = "SEQ_PROCESSO")
    @Column(name = "PROC_CODIGO", unique = true, precision = 10)
    public Integer getProcCodigo() {
        return this.procCodigo;
    }

    public void setProcCodigo(Integer procCodigo) {
        this.procCodigo = procCodigo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TRMTE_CODIGO")
    public Tramite getTramite() {
        return this.tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TPPRC_CODIGO")
    public TipoProcesso getTipoProcesso() {
        return this.tipoProcesso;
    }

    public void setTipoProcesso(TipoProcesso tipoProcesso) {
        this.tipoProcesso = tipoProcesso;
    }

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    public StatusProcessoEnum getStatusProcesso() {
        return this.statusProcesso;
    }

    public void setStatusProcesso(StatusProcessoEnum statusProcesso) {
        this.statusProcesso = statusProcesso;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EMPTO_CODIGO")
    public Empreendimento getEmpreendimento() {
        return empreendimento;
    }

    public void setEmpreendimento(Empreendimento empreendimento) {
        this.empreendimento = empreendimento;
    }

    @Column(name = "PROC_NUMERO", length = 15)
    public String getProcNumero() {
        return this.procNumero;
    }

    public void setProcNumero(String procNumero) {
        this.procNumero = procNumero;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PROC_DATA_FORMALIZACAO", length = 7)
    public LocalDateTime getProcDataFormalizacao() {
        return this.procDataFormalizacao;
    }

    public void setProcDataFormalizacao(LocalDateTime procDataFormalizacao) {
        this.procDataFormalizacao = procDataFormalizacao;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "processo")
    public List<Fce> getFces() {
        return this.fces;
    }

    public void setFces(List<Fce> fces) {
        this.fces = fces;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "processo")
    public Set<ProcessoCaixa> getProcessoCaixas() {
        return this.processoCaixas;
    }

    public void setProcessoCaixas(Set<ProcessoCaixa> processoCaixas) {
        this.processoCaixas = processoCaixas;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((procCodigo == null) ? 0 : procCodigo.hashCode());
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
        Processo other = (Processo) obj;
        if (procCodigo == null) {
            if (other.procCodigo != null) {
                return false;
            }
        } else if (!procCodigo.equals(other.procCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Processo [procCodigo=" + procCodigo + ", procDataFormalizacao=" + procDataFormalizacao + ", procNumero=" + procNumero + ", statusProcesso=" + statusProcesso + ", tipoProcesso=" + tipoProcesso.getTpprcCodigo() + ", tramite=" + tramite.getTrmteCodigo() + "]";
    }

}
