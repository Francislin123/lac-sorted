package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;

/**
 * @author BRASIL Direct - Softwares, Soluções e Serviços
 * @version 2.0
 * @since 2008
 */

@Entity
@Table(name = "ENDERECO")
@SequenceGenerator(name = "SEQ_ENDERECO", sequenceName = "SEQ_ENDERECO", allocationSize = 1)
public class Endereco implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer endCodigo;
    private Municipio municipio;
    private String endLogradouro;
    private String endNumero;
    private String endBairro;
    private String endComplemento;
    private String endCaixaPostal;
    private String endCep;

    public Endereco() {
        municipio = new Municipio();
    }

    public Endereco(Integer endCodigo, Municipio municipio, String endLogradouro, String endNumero, String endBairro, String endCep) {
        this.endCodigo = endCodigo;
        this.municipio = municipio;
        this.endLogradouro = endLogradouro;
        this.endNumero = endNumero;
        this.endBairro = endBairro;
        this.endCep = endCep;
    }

    @Id
    @GeneratedValue(generator = "SEQ_ENDERECO")
    @Column(name = "END_CODIGO", unique = true, precision = 22)
    public Integer getEndCodigo() {
        return this.endCodigo;
    }

    public void setEndCodigo(Integer endCodigo) {
        this.endCodigo = endCodigo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MUNIC_CODIGO")
    public Municipio getMunicipio() {
        return this.municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Column(name = "END_LOGRADOURO", length = 100)
    public String getEndLogradouro() {
        return this.endLogradouro;
    }

    public void setEndLogradouro(String endLogradouro) {
        this.endLogradouro = endLogradouro;
    }

    @Column(name = "END_NUMERO", length = 20)
    public String getEndNumero() {
        return this.endNumero;
    }

    public void setEndNumero(String endNumero) {
        this.endNumero = endNumero;
    }

    @Column(name = "END_BAIRRO", nullable = true, length = 50)
    public String getEndBairro() {
        return this.endBairro;
    }

    public void setEndBairro(String endBairro) {
        this.endBairro = endBairro;
    }

    @Column(name = "END_COMPLEMENTO", length = 200)
    public String getEndComplemento() {
        return this.endComplemento;
    }

    public void setEndComplemento(String endComplemento) {
        this.endComplemento = endComplemento;
    }

    @Column(name = "END_CAIXA_POSTAL", length = 20)
    public String getEndCaixaPostal() {
        return this.endCaixaPostal;
    }

    public void setEndCaixaPostal(String endCaixaPostal) {
        this.endCaixaPostal = endCaixaPostal;
    }

    @Column(name = "END_CEP", length = 8)
    public String getEndCep() {
        return this.endCep;
    }

    public void setEndCep(String endCep) {
        this.endCep = endCep;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((endBairro == null) ? 0 : endBairro.hashCode());
        result = prime * result + ((endCaixaPostal == null) ? 0 : endCaixaPostal.hashCode());
        result = prime * result + ((endCep == null) ? 0 : endCep.hashCode());
        result = prime * result + ((endComplemento == null) ? 0 : endComplemento.hashCode());
        result = prime * result + ((endLogradouro == null) ? 0 : endLogradouro.hashCode());
        result = prime * result + ((endNumero == null) ? 0 : endNumero.hashCode());
        result = prime * result + ((municipio == null) ? 0 : municipio.hashCode());
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
        Endereco other = (Endereco) obj;
        if (endBairro == null) {
            if (other.endBairro != null) {
                return false;
            }
        } else if (!endBairro.equals(other.endBairro)) {
            return false;
        }
        if (endCaixaPostal == null) {
            if (other.endCaixaPostal != null) {
                return false;
            }
        } else if (!endCaixaPostal.equals(other.endCaixaPostal)) {
            return false;
        }
        if (endCep == null) {
            if (other.endCep != null) {
                return false;
            }
        } else if (!endCep.equals(other.endCep)) {
            return false;
        }
        if (endComplemento == null) {
            if (other.endComplemento != null) {
                return false;
            }
        } else if (!endComplemento.equals(other.endComplemento)) {
            return false;
        }
        if (endLogradouro == null) {
            if (other.endLogradouro != null) {
                return false;
            }
        } else if (!endLogradouro.equals(other.endLogradouro)) {
            return false;
        }
        if (endNumero == null) {
            if (other.endNumero != null) {
                return false;
            }
        } else if (!endNumero.equals(other.endNumero)) {
            return false;
        }
        if (municipio == null) {
            if (other.municipio != null) {
                return false;
            }
        } else if (!municipio.equals(other.municipio)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Endereco [endCep=" + endCep + ", endCodigo=" + endCodigo + "]";
    }

}