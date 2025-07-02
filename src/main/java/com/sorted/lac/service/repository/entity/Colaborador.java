package com.sorted.lac.service.repository.entity;

import com.sorted.lac.service.repository.regional.Regional;
import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "COLABORADOR")
public class Colaborador implements java.io.Serializable, Comparable<Colaborador> {

    private static final long serialVersionUID = 1L;
    private Integer userCodigo;
    private Regional regional;
    private Usuario usuario;
    private Setor setor;
    private String colabNome;
    private String colabFoto;
    private Cargo cargo;
    private String colabMatricula;
    private String tokenNumero;

    public Colaborador() {
        setor = new Setor();
        regional = new Regional();
        cargo = new Cargo();
    }

    public Colaborador(Regional regional, Usuario usuario, Setor setor, String colabNome, Cargo cargo) {
        this.regional = regional;
        this.usuario = usuario;
        this.setor = setor;
        this.colabNome = colabNome;
        this.cargo = cargo;
    }

    public Colaborador(Regional regional, Usuario usuario, Setor setor, String colabNome, String colabFoto,
                       Cargo cargo) {
        this.regional = regional;
        this.usuario = usuario;
        this.setor = setor;
        this.colabNome = colabNome;
        this.colabFoto = colabFoto;
        this.cargo = cargo;
    }

    @GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "usuario"))
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "USER_CODIGO", unique = true, precision = 10)
    public Integer getUserCodigo() {
        return this.userCodigo;
    }

    public void setUserCodigo(Integer userCodigo) {
        this.userCodigo = userCodigo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "REG_CODIGO")
    public Regional getRegional() {
        return this.regional;
    }

    public void setRegional(Regional regional) {
        this.regional = regional;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SETOR_CODIGO")
    public Setor getSetor() {
        return this.setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    @Column(name = "COLAB_NOME", length = 100)
    public String getColabNome() {
        return this.colabNome;
    }

    public void setColabNome(String colabNome) {
        this.colabNome = colabNome;
    }

    @Column(name = "COLAB_FOTO", length = 20)
    public String getColabFoto() {
        return this.colabFoto;
    }

    public void setColabFoto(String colabFoto) {
        this.colabFoto = colabFoto;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CARGO_CODIGO")
    public Cargo getCargo() {
        return this.cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Column(name = "COLAB_MATRICULA", length = 10)
    public String getColabMatricula() {
        return colabMatricula;
    }

    public void setColabMatricula(String colabMatricula) {
        this.colabMatricula = colabMatricula;
    }

    public void setTokenNumero(String tokenNumero) {
        this.tokenNumero = tokenNumero;
    }

    @Override
    public String toString() {
        return "Colaborador [userCodigo=" + userCodigo + ", regional=" + regional.getRegCodigo() + ", setor="
                + setor.getSetorCodigo() + ", colabNome=" + colabNome + ", cargo=" + cargo.getCargoCodigo() + "]";
    }

    @Override
    public int compareTo(Colaborador o) {
        return this.colabNome.toLowerCase().compareTo(o.colabNome.toLowerCase());
    }

}
