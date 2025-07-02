package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "EMPREENDEDOR")
public class Empreendedor implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer userCodigo;
    private Usuario usuario;
    private String empdrRazao;
    private String empdrNomeFantasia;
    private String empdrIe;
    private String empdrIm;
    private char empdrJuridica;
    private TipoEmpreendedor tipoEmpreendedor;

    private String isentoPorLei;

    public Empreendedor() {
        usuario = new Usuario();
    }

    public Empreendedor(Usuario usuario, String empdrRazao, char empdrJuridica) {
        this.empdrRazao = empdrRazao;
        this.empdrJuridica = empdrJuridica;
        if (usuario == null) {
            this.usuario = new Usuario();
        } else {
            this.usuario = usuario;
        }
    }

    public Empreendedor(Usuario usuario, String empdrRazao, String empdrNomeFantasia, String empdrIe, String empdrIm, char empdrJuridica) {
        this.usuario = usuario;
        this.empdrRazao = empdrRazao;
        this.empdrNomeFantasia = empdrNomeFantasia;
        this.empdrIe = empdrIe;
        this.empdrIm = empdrIm;
        this.empdrJuridica = empdrJuridica;
        this.usuario = usuario;
    }

    @GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "usuario"))
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "USER_CODIGO", unique = true, precision = 22)
    public Integer getUserCodigo() {
        return this.userCodigo;
    }

    public void setUserCodigo(Integer userCodigo) {
        this.userCodigo = userCodigo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TPEMP_CODIGO")
    public TipoEmpreendedor getTipoEmpreendedor() {
        return this.tipoEmpreendedor;
    }

    public void setTipoEmpreendedor(TipoEmpreendedor tipoEmpreendedor) {
        this.tipoEmpreendedor = tipoEmpreendedor;
    }

    @Column(name = "EMPDR_RAZAO", length = 100)
    public String getEmpdrRazao() {
        return this.empdrRazao;
    }

    public void setEmpdrRazao(String empdrRazao) {
        this.empdrRazao = empdrRazao;
    }

    @Column(name = "EMPDR_NOME_FANTASIA", length = 100)
    public String getEmpdrNomeFantasia() {
        return this.empdrNomeFantasia;
    }

    public void setEmpdrNomeFantasia(String empdrNomeFantasia) {
        this.empdrNomeFantasia = empdrNomeFantasia;
    }

    @Column(name = "EMPDR_IE", length = 13)
    public String getEmpdrIe() {
        return this.empdrIe;
    }

    public void setEmpdrIe(String empdrIe) {
        this.empdrIe = empdrIe;
    }

    @Column(name = "EMPDR_IM", length = 13)
    public String getEmpdrIm() {
        return this.empdrIm;
    }

    public void setEmpdrIm(String empdrIm) {
        this.empdrIm = empdrIm;
    }

    @Column(name = "EMPDR_JURIDICA", length = 1)
    public char getEmpdrJuridica() {
        return this.empdrJuridica;
    }

    public void setEmpdrJuridica(char empdrJuridica) {
        this.empdrJuridica = empdrJuridica;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Empreendedor [empdrIe=" + empdrIe + ", empdrIm=" + empdrIm + ", empdrJuridica=" + empdrJuridica + ", empdrNomeFantasia=" + empdrNomeFantasia + ", empdrRazao=" + empdrRazao + ", userCodigo=" + userCodigo + ", usuario=" + usuario.getUserCodigo() + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((userCodigo == null) ? 0 : userCodigo.hashCode());
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
        Empreendedor other = (Empreendedor) obj;
        if (userCodigo == null) {
            if (other.userCodigo != null) {
                return false;
            }
        } else if (!userCodigo.equals(other.userCodigo)) {
            return false;
        }
        return true;
    }

    @Column(name = "isento_lei", length = 100)
    public String getIsentoPorLei() {
        return isentoPorLei;
    }

    public void setIsentoPorLei(String isentoPorLei) {
        this.isentoPorLei = isentoPorLei;
    }

}
