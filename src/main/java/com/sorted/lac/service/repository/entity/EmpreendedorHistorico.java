package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "EMPREENDEDOR_HISTORICO")
public class EmpreendedorHistorico implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private EmpreendedorHistoricoId id;
    private Usuario usuarioByUserCodigo;
    private Usuario usuarioByUserCodigoAtualizou;
    private String emphiDescricao;
    private String emphiRazaoAntiga;
    private String emphiCnpjAntigo;
    private Endereco endereco;

    public EmpreendedorHistorico() {
        usuarioByUserCodigo = new Usuario();
        usuarioByUserCodigoAtualizou = new Usuario();
        id = new EmpreendedorHistoricoId();
        endereco = new Endereco();
    }

    public EmpreendedorHistorico(EmpreendedorHistoricoId id, Usuario usuarioByUserCodigo, Usuario usuarioByUserCodigoAtualizou, String emphiDescricao) {
        this.id = id;
        this.usuarioByUserCodigo = usuarioByUserCodigo;
        this.usuarioByUserCodigoAtualizou = usuarioByUserCodigoAtualizou;
        this.emphiDescricao = emphiDescricao;
    }

    public EmpreendedorHistorico(EmpreendedorHistoricoId id, Usuario usuarioByUserCodigo, Usuario usuarioByUserCodigoAtualizou, String emphiDescricao, String emphiRazaoAntiga, String emphiCnpjAntigo) {
        this.id = id;
        this.usuarioByUserCodigo = usuarioByUserCodigo;
        this.usuarioByUserCodigoAtualizou = usuarioByUserCodigoAtualizou;
        this.emphiDescricao = emphiDescricao;
        this.emphiRazaoAntiga = emphiRazaoAntiga;
        this.emphiCnpjAntigo = emphiCnpjAntigo;
    }

    @EmbeddedId
    @AttributeOverrides({@AttributeOverride(name = "userCodigo", column = @Column(name = "USER_CODIGO", precision = 22)), @AttributeOverride(name = "emphiDataAtualizacao", column = @Column(name = "EMPHI_DATA_ATUALIZACAO", length = 7))})
    public EmpreendedorHistoricoId getId() {
        return this.id;
    }

    public void setId(EmpreendedorHistoricoId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_CODIGO", insertable = false, updatable = false)
    public Usuario getUsuarioByUserCodigo() {
        return this.usuarioByUserCodigo;
    }

    public void setUsuarioByUserCodigo(Usuario usuarioByUserCodigo) {
        this.usuarioByUserCodigo = usuarioByUserCodigo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_CODIGO_ATUALIZOU")
    public Usuario getUsuarioByUserCodigoAtualizou() {
        return this.usuarioByUserCodigoAtualizou;
    }

    public void setUsuarioByUserCodigoAtualizou(Usuario usuarioByUserCodigoAtualizou) {
        this.usuarioByUserCodigoAtualizou = usuarioByUserCodigoAtualizou;
    }

    @Column(name = "EMPHI_DESCRICAO", length = 500)
    public String getEmphiDescricao() {
        return this.emphiDescricao;
    }

    public void setEmphiDescricao(String emphiDescricao) {
        this.emphiDescricao = emphiDescricao;
    }

    @Column(name = "EMPHI_RAZAO_ANTIGA", length = 100)
    public String getEmphiRazaoAntiga() {
        return this.emphiRazaoAntiga;
    }

    public void setEmphiRazaoAntiga(String emphiRazaoAntiga) {
        this.emphiRazaoAntiga = emphiRazaoAntiga;
    }

    @Column(name = "EMPHI_CNPJ_ANTIGO", length = 14)
    public String getEmphiCnpjAntigo() {
        return this.emphiCnpjAntigo;
    }

    public void setEmphiCnpjAntigo(String emphiCnpjAntigo) {
        this.emphiCnpjAntigo = emphiCnpjAntigo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "END_CODIGO", nullable = true)
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
        EmpreendedorHistorico other = (EmpreendedorHistorico) obj;
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
        return "EmpreendedorHistorico [emphiCnpjAntigo=" + emphiCnpjAntigo + ", emphiDescricao=" + emphiDescricao + ", emphiRazaoAntiga=" + emphiRazaoAntiga + ", id=" + id + ", usuarioByUserCodigo=" + usuarioByUserCodigo.getUserCodigo() + ", usuarioByUserCodigoAtualizou=" + usuarioByUserCodigoAtualizou.getUserCodigo() + "]";
    }

}
