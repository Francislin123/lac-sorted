package com.sorted.lac.service.repository.entity;

import java.util.List;

import com.sorted.lac.service.repository.fce.FceExploracao;
import jakarta.persistence.*;

@Entity
@Table(name = "EXPLORACAO")
@SequenceGenerator(name = "seq_exploracao", sequenceName = "seq_exploracao", allocationSize=1)
public class Exploracao implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer exploCodigo;
    private ModeloIn modeloIn;
    private TipoExploracao tipoExploracao;
    private SatClasse satClasse;
    private Variavel variavel;
    private String exploDescricao;
    private boolean tpdocDiferenciado;
    private Integer exploEnquadra;
    private List<FceExploracao> fceExploracaos;
    private List<ExploracaoTpdoc> exploracaoTpdocs;

    public Exploracao() {
        modeloIn = new ModeloIn();
        tipoExploracao = new TipoExploracao();
        variavel = new Variavel();
    }

    public Exploracao(Integer exploCodigo, ModeloIn modeloIn, TipoExploracao tipoExploracao, Variavel variavel,
                      String exploDescricao) {
        this.exploCodigo = exploCodigo;
        this.modeloIn = modeloIn;
        this.tipoExploracao = tipoExploracao;
        this.variavel = variavel;
        this.exploDescricao = exploDescricao;
    }

    public Exploracao(Integer exploCodigo, ModeloIn modeloIn, TipoExploracao tipoExploracao, Variavel variavel,
                      String exploDescricao, List<FceExploracao> fceExploracaos, List<ExploracaoTpdoc> exploracaoTpdocs) {
        this.exploCodigo = exploCodigo;
        this.modeloIn = modeloIn;
        this.tipoExploracao = tipoExploracao;
        this.variavel = variavel;
        this.exploDescricao = exploDescricao;
        this.fceExploracaos = fceExploracaos;
        this.exploracaoTpdocs = exploracaoTpdocs;
    }

    @Id
    @GeneratedValue(generator = "seq_exploracao")
    @Column(name = "EXPLO_CODIGO", unique = true, precision = 10)
    public Integer getExploCodigo() {
        return this.exploCodigo;
    }

    public void setExploCodigo(Integer exploCodigo) {
        this.exploCodigo = exploCodigo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MODIN_CODIGO")
    public ModeloIn getModeloIn() {
        return this.modeloIn;
    }

    public void setModeloIn(ModeloIn modeloIn) {
        this.modeloIn = modeloIn;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TPEXP_CODIGO")
    public TipoExploracao getTipoExploracao() {
        return this.tipoExploracao;
    }

    public void setTipoExploracao(TipoExploracao tipoExploracao) {
        this.tipoExploracao = tipoExploracao;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "VAR_CODIGO")
    public Variavel getVariavel() {
        return this.variavel;
    }

    public void setVariavel(Variavel variavel) {
        this.variavel = variavel;
    }

    @Column(name = "EXPLO_DESCRICAO", length = 100)
    public String getExploDescricao() {
        return this.exploDescricao;
    }

    public void setExploDescricao(String exploDescricao) {
        this.exploDescricao = exploDescricao;
    }

    @Column(name = "TPDOC_DIFERENCIADO", length = 1)
    public boolean getTpdocDiferenciado() {
        return tpdocDiferenciado;
    }

    public void setTpdocDiferenciado(boolean tpdocDiferenciado) {
        this.tpdocDiferenciado = tpdocDiferenciado;
    }

    @Column(name = "EXPLO_ENQUADRA", precision = 10)
    public Integer getExploEnquadra() {
        return exploEnquadra;
    }

    public void setExploEnquadra(Integer exploEnquadra) {
        this.exploEnquadra = exploEnquadra;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SATCL_CODIGO")
    public SatClasse getSatClasse() {
        return this.satClasse;
    }

    public void setSatClasse(SatClasse satClasse) {
        this.satClasse = satClasse;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "exploracao")
    public List<FceExploracao> getFceExploracaos() {
        return this.fceExploracaos;
    }

    public void setFceExploracaos(List<FceExploracao> fceExploracaos) {
        this.fceExploracaos = fceExploracaos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "exploracao")
    public List<ExploracaoTpdoc> getExploracaoTpdocs() {
        return this.exploracaoTpdocs;
    }

    public void setExploracaoTpdocs(List<ExploracaoTpdoc> exploracaoTpdocs) {
        this.exploracaoTpdocs = exploracaoTpdocs;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((exploCodigo == null) ? 0 : exploCodigo.hashCode());
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
        Exploracao other = (Exploracao) obj;
        if (exploCodigo == null) {
            if (other.exploCodigo != null) {
                return false;
            }
        } else if (!exploCodigo.equals(other.exploCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Exploracao [exploCodigo=" + exploCodigo + ", exploDescricao=" + exploDescricao + "]";
    }

}
