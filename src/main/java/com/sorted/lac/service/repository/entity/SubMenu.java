package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;

import lombok.experimental.Tolerate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "SUB_MENU")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class SubMenu implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer smenuCodigo;
    private Menu menu;
    private String smenuDescricao;
    private String smenuLink;
    private String smenuImagem;

    @Tolerate
    public SubMenu() {
        // Method default for hibernate
    }

    @Id
    @Column(name = "SMENU_CODIGO", unique = true, precision = 22)
    public Integer getSmenuCodigo() {
        return this.smenuCodigo;
    }

    public void setSmenuCodigo(Integer smenuCodigo) {
        this.smenuCodigo = smenuCodigo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MENU_CODIGO")
    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Column(name = "SMENU_DESCRICAO", length = 200)
    public String getSmenuDescricao() {
        return this.smenuDescricao;
    }

    public void setSmenuDescricao(String smenuDescricao) {
        this.smenuDescricao = smenuDescricao;
    }

    @Column(name = "SMENU_LINK", length = 200)
    public String getSmenuLink() {
        return this.smenuLink;
    }

    public void setSmenuLink(String smenuLink) {
        this.smenuLink = smenuLink;
    }

    @Column(name = "SMENU_IMAGEM", nullable = true, length = 100)
    public String getSmenuImagem() {
        return smenuImagem;
    }

    public void setSmenuImagem(String smenuImagem) {
        this.smenuImagem = smenuImagem;
    }
}
