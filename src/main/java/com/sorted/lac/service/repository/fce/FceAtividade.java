package com.sorted.lac.service.repository.fce;

import java.io.Serializable;
import java.math.BigDecimal;

import com.sorted.lac.service.enums.TipoEstudoEnum;
import com.sorted.lac.service.repository.entity.Atividade;
import com.sorted.lac.service.repository.licenca.LicencaValidade;
import com.sorted.lac.service.repository.entity.TipoLicenca;
import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "FCE_ATIVIDADE", uniqueConstraints = @UniqueConstraint(columnNames = { "FCE_CODIGO", "ATIV_CODIGO" }))
public class FceAtividade implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer fceCodigo;
    private LicencaValidade licencaValidade;
    private Atividade atividade;
    private TipoEstudoEnum tipoEstudo;
    private Fce fce;
    private TipoLicenca tipoLicenca;
    private boolean tac;
    private char fceatPorte;
    private BigDecimal fceatValor;
    private String fceatTipoProducao;
    private String fceatDnpm;
    private char potencialGeral; //O potencial geral está sendo salvo para garantir que não haverá mudança quando troca de CONSEMA

    public FceAtividade() {
        atividade = new Atividade();
        tipoLicenca = new TipoLicenca();
        licencaValidade = new LicencaValidade();
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
    @JoinColumn(name = "ATIV_CODIGO")
    public Atividade getAtividade() {
        return this.atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    @Column(name = "TIPO_ESTUDO")
    @Enumerated(EnumType.STRING)
    public TipoEstudoEnum getTipoEstudo() {
        return this.tipoEstudo;
    }

    public void setTipoEstudo(TipoEstudoEnum tipoEstudo) {
        this.tipoEstudo = tipoEstudo;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    public Fce getFce() {
        return this.fce;
    }

    public void setFce(Fce fce) {
        this.fce = fce;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TPLIC_CODIGO")
    public TipoLicenca getTipoLicenca() {
        return this.tipoLicenca;
    }

    public void setTipoLicenca(TipoLicenca tipoLicenca) {
        this.tipoLicenca = tipoLicenca;
    }

    @Column(name = "TAC", length = 1)
    public boolean getTac() {
        return this.tac;
    }

    public void setTac(boolean tac) {
        this.tac = tac;
    }

    @Column(name = "FCEAT_PORTE", length = 1)
    public char getFceatPorte() {
        return this.fceatPorte;
    }

    public void setFceatPorte(char fceatPorte) {
        this.fceatPorte = fceatPorte;
    }

    @Column(name = "FCEAT_VALOR", precision = 10)
    public BigDecimal getFceatValor() {
        return this.fceatValor;
    }

    public void setFceatValor(BigDecimal fceatValor) {
        this.fceatValor = fceatValor;
    }

    @Column(name = "FCEAT_TIPO_PRODUCAO", nullable = true, length = 50)
    public String getFceatTipoProducao() {
        return fceatTipoProducao;
    }

    public void setFceatTipoProducao(String fceatTipoProducao) {
        this.fceatTipoProducao = fceatTipoProducao;
    }

    @Column(name = "FCEAT_DNPM", nullable = true, length = 50)
    public String getFceatDnpm() {
        return fceatDnpm;
    }

    public void setFceatDnpm(String fceatDnpm) {
        this.fceatDnpm = fceatDnpm;
    }

    @Column(name = "POTENCIAL_GERAL", length = 1)
    public char getPotencialGeral() {
        return potencialGeral;
    }

    public void setPotencialGeral(char potencialGeral) {
        this.potencialGeral = potencialGeral;
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
        FceAtividade other = (FceAtividade) obj;
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
        return "FceAtividade [atividade=" + atividade.getAtivCodigo() + ", fceCodigo=" + fceCodigo + ", fceatValor="
                + fceatValor + "]";
    }

}
