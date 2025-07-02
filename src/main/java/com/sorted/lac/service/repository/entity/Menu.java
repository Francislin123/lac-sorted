package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * @author BRASIL Direct - Softwares, Soluções e Serviços
 * @version 2.0
 * @since 2008
 */

@Entity
@Table(name = "MENU")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class Menu implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Integer menuCodigo;
    private String menuDescricao;
    private String menuLink;

    public Menu() {
    }

    public Menu(Integer menuCodigo, String menuDescricao, String menuLink) {
        this.menuCodigo = menuCodigo;
        this.menuDescricao = menuDescricao;
        this.menuLink = menuLink;
    }

    @Id
    @Column(name = "MENU_CODIGO", unique = true, precision = 22)
    public Integer getMenuCodigo() {
        return this.menuCodigo;
    }

    public void setMenuCodigo(Integer menuCodigo) {
        this.menuCodigo = menuCodigo;
    }

    @Column(name = "MENU_DESCRICAO", length = 20)
    public String getMenuDescricao() {
        return this.menuDescricao;
    }

    public void setMenuDescricao(String menuDescricao) {
        this.menuDescricao = menuDescricao;
    }

    @Column(name = "MENU_LINK", length = 50)
    public String getMenuLink() {
        return this.menuLink;
    }

    public void setMenuLink(String menuLink) {
        this.menuLink = menuLink;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((menuCodigo == null) ? 0 : menuCodigo.hashCode());
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
        Menu other = (Menu) obj;
        if (menuCodigo == null) {
            if (other.menuCodigo != null) {
                return false;
            }
        } else if (!menuCodigo.equals(other.menuCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Menu [menuCodigo=" + menuCodigo + ", menuDescricao=" + menuDescricao + "]";
    }

}
