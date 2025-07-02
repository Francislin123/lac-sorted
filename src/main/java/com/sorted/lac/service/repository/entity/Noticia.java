package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "NOTICIA")
public class Noticia implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer notCodigo;
    private TipoNoticia tipoNoticia;
    private Usuario usuario;
    private String notDescricao;
    private LocalDateTime notData;
    private Boolean noticiaAtiva;

    public Noticia() {
        tipoNoticia = new TipoNoticia();
        usuario = new Usuario();
    }

    public Noticia(Integer notCodigo, TipoNoticia tipoNoticia, Usuario usuario, String notDescricao, LocalDateTime notData) {
        this.notCodigo = notCodigo;
        this.tipoNoticia = tipoNoticia;
        this.usuario = usuario;
        this.notDescricao = notDescricao;
        this.notData = notData;
    }

    @Id
    @Column(name = "NOT_CODIGO", unique = true, precision = 22)
    public Integer getNotCodigo() {
        return this.notCodigo;
    }

    public void setNotCodigo(Integer notCodigo) {
        this.notCodigo = notCodigo;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TPNOT_CODIGO")
    public TipoNoticia getTipoNoticia() {
        return this.tipoNoticia;
    }

    public void setTipoNoticia(TipoNoticia tipoNoticia) {
        this.tipoNoticia = tipoNoticia;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_CODIGO")
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Column(name = "NOT_DESCRICAO", length = 500)
    public String getNotDescricao() {
        return this.notDescricao;
    }

    public void setNotDescricao(String notDescricao) {
        this.notDescricao = notDescricao;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "NOT_DATA", length = 7)
    public LocalDateTime getNotData() {
        return this.notData;
    }

    public void setNotData(LocalDateTime notData) {
        this.notData = notData;
    }

    @Column(name = "NOTICIA_ATIVA")
    public Boolean getNoticiaAtiva() {
        return noticiaAtiva;
    }

    public void setNoticiaAtiva(Boolean noticiaAtiva) {
        this.noticiaAtiva = noticiaAtiva;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((notCodigo == null) ? 0 : notCodigo.hashCode());
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
        Noticia other = (Noticia) obj;
        if (notCodigo == null) {
            if (other.notCodigo != null) {
                return false;
            }
        } else if (!notCodigo.equals(other.notCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Noticia [notCodigo=" + notCodigo + ", notDescricao=" + notDescricao + "]";
    }

}
