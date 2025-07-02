package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "BASE_CALCULO")
public class BaseCalculo implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private BaseCalculoId id;
    private TabelaCalculo tabelaCalculo;
    private TipoLicenca tipoLicenca;
    private BigDecimal basecValor;

    public BaseCalculo() {
        tipoLicenca = new TipoLicenca();
        tabelaCalculo = new TabelaCalculo();
    }

    public BaseCalculo(BaseCalculoId id, TabelaCalculo tabelaCalculo, TipoLicenca tipoLicenca, BigDecimal basecValor) {
        this.id = id;
        this.tabelaCalculo = tabelaCalculo;
        this.tipoLicenca = tipoLicenca;
        this.basecValor = basecValor;
    }

    @EmbeddedId
    @AttributeOverrides({@AttributeOverride(name = "tplicCodigo", column = @Column(name = "TPLIC_CODIGO", precision = 10)), @AttributeOverride(name = "basecPorte", column = @Column(name = "BASEC_PORTE", length = 1)), @AttributeOverride(name = "basecPotencialPoluidor", column = @Column(name = "BASEC_POTENCIAL_POLUIDOR", length = 1)), @AttributeOverride(name = "tabcaCodigo", column = @Column(name = "TABCA_CODIGO", precision = 10))})
    public BaseCalculoId getId() {
        return this.id;
    }

    public void setId(BaseCalculoId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TABCA_CODIGO", insertable = false, updatable = false)
    public TabelaCalculo getTabelaCalculo() {
        return this.tabelaCalculo;
    }

    public void setTabelaCalculo(TabelaCalculo tabelaCalculo) {
        this.tabelaCalculo = tabelaCalculo;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TPLIC_CODIGO", insertable = false, updatable = false)
    public TipoLicenca getTipoLicenca() {
        return this.tipoLicenca;
    }

    public void setTipoLicenca(TipoLicenca tipoLicenca) {
        this.tipoLicenca = tipoLicenca;
    }

    @Column(name = "BASEC_VALOR", precision = 10)
    public BigDecimal getBasecValor() {
        return this.basecValor;
    }

    public void setBasecValor(BigDecimal basecValor) {
        this.basecValor = basecValor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        BaseCalculo other = (BaseCalculo) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BaseCalculo [basecValor=" + basecValor + ", id=" + id + ", tabelaCalculo=" + tabelaCalculo.getTabcaCodigo() + ", tipoLicenca=" + tipoLicenca.getTplicCodigo() + "]";
    }

}
