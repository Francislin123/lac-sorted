package com.sorted.lac.service.repository.entity;

import com.sorted.lac.service.enums.StatusProcessoCaixaEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "PROCESSO_CAIXA")
@SequenceGenerator(name = "SEQ_PROCESSO_CAIXA", sequenceName = "SEQ_PROCESSO_CAIXA", allocationSize = 1)
public class ProcessoCaixa implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer prccxCodigo;
    private Processo processo;
    private Caixa caixa;
    private StatusProcessoCaixaEnum statusProcessoCaixa;
    private String prccxObservacao;
    private Integer prccxPosicao;

    public ProcessoCaixa() {
        processo = new Processo();
        caixa = new Caixa();
    }

    public ProcessoCaixa(Integer prccxCodigo, Processo processo, Caixa caixa) {
        this.prccxCodigo = prccxCodigo;
        this.processo = processo;
        this.caixa = caixa;
    }

    @Id
    @GeneratedValue(generator = "SEQ_PROCESSO_CAIXA")
    @Column(name = "PRCCX_CODIGO", unique = true, precision = 10)
    public Integer getPrccxCodigo() {
        return prccxCodigo;
    }

    public void setPrccxCodigo(Integer prccxCodigo) {
        this.prccxCodigo = prccxCodigo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROC_CODIGO")
    public Processo getProcesso() {
        return this.processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CAIXA_CODIGO")
    public Caixa getCaixa() {
        return this.caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    public StatusProcessoCaixaEnum getStatusProcessoCaixa() {
        return this.statusProcessoCaixa;
    }

    public void setStatusProcessoCaixa(StatusProcessoCaixaEnum statusProcessoCaixa) {
        this.statusProcessoCaixa = statusProcessoCaixa;
    }

    @Column(name = "PRCCX_OBSERVACAO", length = 1000)
    public String getPrccxObservacao() {
        return this.prccxObservacao;
    }

    public void setPrccxObservacao(String prccxObservacao) {
        this.prccxObservacao = prccxObservacao;
    }

    @Column(name = "PRCCX_POSICAO", precision = 10)
    public Integer getPrccxPosicao() {
        return prccxPosicao;
    }

    public void setPrccxPosicao(Integer prccxPosicao) {
        this.prccxPosicao = prccxPosicao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((prccxCodigo == null) ? 0 : prccxCodigo.hashCode());
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
        ProcessoCaixa other = (ProcessoCaixa) obj;
        if (prccxCodigo == null) {
            if (other.prccxCodigo != null) {
                return false;
            }
        } else if (!prccxCodigo.equals(other.prccxCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProcessoCaixa [prccxCodigo=" + prccxCodigo + ", processo=" + processo.getProcCodigo() + ", caixa="
                + caixa.getCaixaCodigo() + ", statusProcessoCaixa=" + statusProcessoCaixa
                + ", prccxObservacao=" + prccxObservacao + ", prccxPosicao=" + prccxPosicao + "]";
    }

}
