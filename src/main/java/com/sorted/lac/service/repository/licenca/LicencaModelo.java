package com.sorted.lac.service.repository.licenca;

import java.io.Serializable;

import com.sorted.lac.service.repository.entity.TipoLicenca;
import jakarta.persistence.*;

@Entity
@Table(name = "LICENCA_MODELO")
@SequenceGenerator(name = "SEQ_LICENCA_MODELO", sequenceName = "SEQ_LICENCA_MODELO", allocationSize = 1)
public class LicencaModelo implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer licmoCodigo;
    private String licmoCondicoesGerais;
    private String licmoViabilidadeInstalacao;
    private String licmoCondicoesValidade;
    private String licmoDescricao;
    private String licmoSigla;
    private TipoLicenca tipoLicenca;

    public LicencaModelo() {
        tipoLicenca = new TipoLicenca();
    }

    @Id
    @GeneratedValue(generator = "SEQ_LICENCA_MODELO")
    @Column(name = "LICMO_CODIGO", unique = true, precision = 22)
    public Integer getLicmoCodigo() {
        return licmoCodigo;
    }

    public void setLicmoCodigo(Integer licmoCodigo) {
        this.licmoCodigo = licmoCodigo;
    }

    @Column(name = "LICMO_CONDICOES_GERAIS", length = 2000)
    public String getLicmoCondicoesGerais() {
        return licmoCondicoesGerais;
    }

    public void setLicmoCondicoesGerais(String licmoCondicoesGerais) {
        this.licmoCondicoesGerais = licmoCondicoesGerais;
    }

    @Column(name = "LICMO_VIABILIDADE_INSTALACAO", length = 2000)
    public String getLicmoViabilidadeInstalacao() {
        return licmoViabilidadeInstalacao;
    }

    public void setLicmoViabilidadeInstalacao(String licmoViabilidadeInstalacao) {
        this.licmoViabilidadeInstalacao = licmoViabilidadeInstalacao;
    }

    @Column(name = "LICMO_CONDICOES_VALIDADE", length = 3000)
    public String getLicmoCondicoesValidade() {
        return licmoCondicoesValidade;
    }

    public void setLicmoCondicoesValidade(String licmoCondicoesValidade) {
        this.licmoCondicoesValidade = licmoCondicoesValidade;
    }

    @Column(name = "LICMO_DESCRICAO", length = 200)
    public String getLicmoDescricao() {
        return licmoDescricao;
    }

    public void setLicmoDescricao(String licmoDescricao) {
        this.licmoDescricao = licmoDescricao;
    }

    @Column(name = "LICMO_SIGLA", length = 10)
    public String getLicmoSigla() {
        return licmoSigla;
    }

    public void setLicmoSigla(String licmoSigla) {
        this.licmoSigla = licmoSigla;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TPLIC_CODIGO")
    public TipoLicenca getTipoLicenca() {
        return tipoLicenca;
    }

    public void setTipoLicenca(TipoLicenca tipoLicenca) {
        this.tipoLicenca = tipoLicenca;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((licmoCodigo == null) ? 0 : licmoCodigo.hashCode());
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
        LicencaModelo other = (LicencaModelo) obj;
        if (licmoCodigo == null) {
            if (other.licmoCodigo != null) {
                return false;
            }
        } else if (!licmoCodigo.equals(other.licmoCodigo)) {
            return false;
        }
        return true;
    }
}
