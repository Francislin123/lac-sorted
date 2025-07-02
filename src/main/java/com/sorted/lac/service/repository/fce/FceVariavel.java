package com.sorted.lac.service.repository.fce;

import com.sorted.lac.service.repository.entity.Variavel;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "FCE_VARIAVEL")
public class FceVariavel implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private FceVariavelId id;
    private Fce fce;
    private Variavel variavel;
    private BigDecimal fcevaValor;

    public FceVariavel() {
        fce = new Fce();
        variavel = new Variavel();
    }

    public FceVariavel(FceVariavelId id, Fce fce, Variavel variavel, BigDecimal fcevaValor) {
        this.id = id;
        this.fce = fce;
        this.variavel = variavel;
        this.fcevaValor = fcevaValor;
    }

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "fceCodigo", column = @Column(name = "FCE_CODIGO", precision = 10)),
            @AttributeOverride(name = "varCodigo", column = @Column(name = "VAR_CODIGO", precision = 10)),
            @AttributeOverride(name = "fcevaExploracao", column = @Column(name = "FCEVA_EXPLORACAO", length = 1)) })
    public FceVariavelId getId() {
        return this.id;
    }

    public void setId(FceVariavelId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FCE_CODIGO", insertable = false, updatable = false)
    public Fce getFce() {
        return this.fce;
    }

    public void setFce(Fce fce) {
        this.fce = fce;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "VAR_CODIGO", insertable = false, updatable = false)
    public Variavel getVariavel() {
        return this.variavel;
    }

    public void setVariavel(Variavel variavel) {
        this.variavel = variavel;
    }

    @Column(name = "FCEVA_VALOR", precision = 10)
    public BigDecimal getFcevaValor() {
        return this.fcevaValor;
    }

    public void setFcevaValor(BigDecimal fcevaValor) {
        this.fcevaValor = fcevaValor;
    }

    @Override
    public String toString() {
        return "FceVariavel [fce=" + fce.getFceCodigo() + ", variavel=" + variavel.getVarCodigo() + ", fcevaValor="
                + fcevaValor + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fcevaValor == null) ? 0 : fcevaValor.hashCode());
        result = prime * result + ((variavel == null) ? 0 : variavel.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        FceVariavel other = (FceVariavel) obj;

        if (fcevaValor == null) {
            if (other.fcevaValor != null) {
                return false;
            }
        } else if (!fcevaValor.equals(other.fcevaValor)) {
            return false;
        }
        if (variavel == null) {
            if (other.variavel != null) {
                return false;
            }
        } else if (!variavel.equals(other.variavel)) {
            return false;
        }
        return true;
    }

}
