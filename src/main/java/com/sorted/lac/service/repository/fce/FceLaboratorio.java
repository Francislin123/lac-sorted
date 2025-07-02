package com.sorted.lac.service.repository.fce;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.math.BigDecimal;

@Entity
@Table(name = "FCE_LABORATORIO", uniqueConstraints = @UniqueConstraint(columnNames = {"FCE_CODIGO"}))
public class FceLaboratorio implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer fceCodigo;
    private BigDecimal fcelaValor;
    private BigDecimal fcelaValorServicos;
    private Fce fce;

    public FceLaboratorio() {
    }

    @GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "fce"))
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "FCE_CODIGO", unique = true, precision = 10)
    public Integer getFceCodigo() {
        return this.fceCodigo;
    }

    public void setFceCodigo(Integer fceCodigo) {
        this.fceCodigo = fceCodigo;
    }

    @Column(name = "FCELA_VALOR", precision = 10)
    public BigDecimal getFcelaValor() {
        return this.fcelaValor;
    }

    public void setFcelaValor(BigDecimal fcelaValor) {
        this.fcelaValor = fcelaValor;
    }

    @Column(name = "FCELA_VALOR_SERVICOS", precision = 10)
    public BigDecimal getFcelaValorServicos() {
        return this.fcelaValorServicos;
    }

    public void setFcelaValorServicos(BigDecimal fcelaValorServicos) {
        this.fcelaValorServicos = fcelaValorServicos;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    public Fce getFce() {
        return this.fce;
    }

    public void setFce(Fce fce) {
        this.fce = fce;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fceCodigo == null) ? 0 : fceCodigo.hashCode());
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
        FceLaboratorio other = (FceLaboratorio) obj;
        if (fceCodigo == null) {
            if (other.fceCodigo != null) {
                return false;
            }
        } else if (!fceCodigo.equals(other.fceCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FceLaboratorio [fceCodigo=" + fceCodigo + ", fcelaValor=" + fcelaValor + "]";
    }
}
