package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

import java.util.List;

@Entity
@Immutable
@Table(name = "CARGO")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class Cargo implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer cargoCodigo;
    private String cargoDescricao;
    private List<Colaborador> colaboradors;
    private List<Menu> menuList;
    private List<SubMenu> subMenuList;

    public Cargo() {
    }

    public Cargo(Integer cargoCodigo, String cargoDescricao) {
        this.cargoCodigo = cargoCodigo;
        this.cargoDescricao = cargoDescricao;
    }

    public Cargo(Integer cargoCodigo, String cargoDescricao, List<Colaborador> colaboradors) {
        this.cargoCodigo = cargoCodigo;
        this.cargoDescricao = cargoDescricao;
        this.colaboradors = colaboradors;
    }

    @Id
    @Column(name = "CARGO_CODIGO", unique = true, precision = 22)
    public Integer getCargoCodigo() {
        return this.cargoCodigo;
    }

    public void setCargoCodigo(Integer cargoCodigo) {
        this.cargoCodigo = cargoCodigo;
    }

    @Column(name = "CARGO_DESCRICAO", length = 30)
    public String getCargoDescricao() {
        return this.cargoDescricao;
    }

    public void setCargoDescricao(String cargoDescricao) {
        this.cargoDescricao = cargoDescricao;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cargo")
    public List<Colaborador> getColaboradors() {
        return this.colaboradors;
    }

    public void setColaboradors(List<Colaborador> colaboradors) {
        this.colaboradors = colaboradors;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "CARGO_MENU", joinColumns = {@JoinColumn(name = "CARGO_CODIGO")}, inverseJoinColumns = {@JoinColumn(name = "MENU_CODIGO")})
    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "CARGO_SUB_MENU", // Nome da tabela de junção (exemplo)
            joinColumns = {@JoinColumn(name = "CARGO_CODIGO")}, // <--- CORREÇÃO AQUI: Remova 'insertable = false, updatable = false'
            inverseJoinColumns = {@JoinColumn(name = "SMENU_CODIGO")})
    public List<SubMenu> getSubMenuList() {
        return subMenuList;
    }

    public void setSubMenuList(List<SubMenu> subMenuList) {
        this.subMenuList = subMenuList;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cargoCodigo == null) ? 0 : cargoCodigo.hashCode());
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
        Cargo other = (Cargo) obj;
        if (cargoCodigo == null) {
            if (other.cargoCodigo != null) {
                return false;
            }
        } else if (!cargoCodigo.equals(other.cargoCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cargo [cargoCodigo=" + cargoCodigo + ", cargoDescricao=" + cargoDescricao + "]";
    }

}
