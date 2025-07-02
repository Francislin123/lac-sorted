package com.sorted.lac.service.repository.entity;

import com.sorted.lac.service.repository.fce.Fce;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "OBJETO_REQUERIMENTO")
public class ObjetoRequerimento implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer objreCodigo;
    private String objreDescricao;
    private List<Fce> fces = new ArrayList<Fce>();

    public ObjetoRequerimento() {
    }

    public ObjetoRequerimento(Integer objreCodigo, String objreDescricao) {
        this.objreCodigo = objreCodigo;
        this.objreDescricao = objreDescricao;
    }

    public ObjetoRequerimento(Integer objreCodigo, String objreDescricao, List<Fce> fces) {
        this.objreCodigo = objreCodigo;
        this.objreDescricao = objreDescricao;
        this.fces = fces;
    }

    @Id
    @Column(name = "OBJRE_CODIGO", unique = true, precision = 10)
    public Integer getObjreCodigo() {
        return this.objreCodigo;
    }

    public void setObjreCodigo(Integer objreCodigo) {
        this.objreCodigo = objreCodigo;
    }

    @Column(name = "OBJRE_DESCRICAO", length = 100)
    public String getObjreDescricao() {
        return this.objreDescricao;
    }

    public void setObjreDescricao(String objreDescricao) {
        this.objreDescricao = objreDescricao;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "objetoRequerimento")
    public List<Fce> getFces() {
        return this.fces;
    }

    public void setFces(List<Fce> fces) {
        this.fces = fces;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((objreCodigo == null) ? 0 : objreCodigo.hashCode());
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
        ObjetoRequerimento other = (ObjetoRequerimento) obj;
        if (objreCodigo == null) {
            if (other.objreCodigo != null) {
                return false;
            }
        } else if (!objreCodigo.equals(other.objreCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ObjetoRequerimento [objreCodigo=" + objreCodigo + ", objreDescricao=" + objreDescricao + "]";
    }
}
