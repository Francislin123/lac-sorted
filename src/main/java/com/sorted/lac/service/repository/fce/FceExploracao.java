package com.sorted.lac.service.repository.fce;

import java.math.BigDecimal;

import com.sorted.lac.service.repository.entity.Exploracao;
import com.sorted.lac.service.repository.licenca.LicencaValidade;
import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author BRASIL Direct - Softwares, Soluções e Serviços
 * @since 2008
 * @version 2.0
 */

@Entity
@Table(name = "FCE_EXPLORACAO", uniqueConstraints = @UniqueConstraint(columnNames = { "FCE_CODIGO", "EXPLO_CODIGO" }))
public class FceExploracao implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer fceCodigo;
    private LicencaValidade licencaValidade;
    private Exploracao exploracao;
    private Fce fce;
    private BigDecimal fceexValor;
    private String numeroCar;
    private String invIndividuosJSON;
//	private byte[] planilhaInventario;


    public FceExploracao() {
        exploracao = new Exploracao();
        licencaValidade = new LicencaValidade();
    }

    public FceExploracao(LicencaValidade licencaValidade, Exploracao exploracao, Fce fce, BigDecimal fceexValor) {
        this.licencaValidade = licencaValidade;
        this.exploracao = exploracao;
        this.fce = fce;
        this.fceexValor = fceexValor;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LICVA_CODIGO")
    public LicencaValidade getLicencaValidade() {
        return this.licencaValidade;
    }

    public void setLicencaValidade(LicencaValidade licencaValidade) {
        this.licencaValidade = licencaValidade;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EXPLO_CODIGO")
    public Exploracao getExploracao() {
        return this.exploracao;
    }

    public void setExploracao(Exploracao exploracao) {
        this.exploracao = exploracao;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    public Fce getFce() {
        return this.fce;
    }

    public void setFce(Fce fce) {
        this.fce = fce;
    }

    @Column(name = "FCEEX_VALOR", precision = 10)
    public BigDecimal getFceexValor() {
        return this.fceexValor;
    }

    public void setFceexValor(BigDecimal fceexValor) {
        this.fceexValor = fceexValor;
    }

    //Sinaflor
    @Column(name = "NUMERO_CAR", nullable = true)
    public String getNumeroCar() {
        return numeroCar;
    }

    public void setNumeroCar(String numeroCar) {
        this.numeroCar = numeroCar;
    }

    @Column(name = "INV_INDIVIDUOS", nullable = true)
    public String getInvIndividuosJSON() {
        return invIndividuosJSON;
    }

    public void setInvIndividuosJSON(String invIndividuosJSON) {
        this.invIndividuosJSON = invIndividuosJSON;
    }

//	@Column(name = "INV_PLANILHA", nullable = true)
//	public byte[] getPlanilhaInventario() {
//		return planilhaInventario;
//	}
//
//	public void setPlanilhaInventario(byte[] planilhaInventario) {
//		this.planilhaInventario = planilhaInventario;
//	}

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
        FceExploracao other = (FceExploracao) obj;
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
        return "FceExploracao [exploracao=" + exploracao.getExploCodigo() + ", fceCodigo=" + fceCodigo + ", fceexValor="
                + fceexValor + "]";
    }

}
