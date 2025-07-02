package com.sorted.lac.service.repository.entity;

import java.util.List;

import com.sorted.lac.service.repository.regional.Regional;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CAIXA")
@SequenceGenerator(name = "SEQ_CAIXA", sequenceName = "SEQ_CAIXA", allocationSize = 1)
public class Caixa implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "SEQ_CAIXA")
    @Column(name = "CAIXA_CODIGO", unique = true, precision = 22)
    private Integer caixaCodigo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REG_CODIGO")
    private Regional regional;

    @Column(name = "CAIXA_NUMERO", precision = 22)
    private Integer caixaNumero;

    @Column(name = "CAIXA_CHEIA", length = 1)
    private Character caixaCheia;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "caixa")
    @OrderBy("prccxPosicao")
    private List<ProcessoCaixa> processoCaixas;

    @Transient
    private boolean caixaCheiaBool;

    public Caixa() {
        regional = new Regional();
    }

    public Caixa(Integer caixaCodigo, Regional regional, Integer caixaNumero) {
        this.caixaCodigo = caixaCodigo;
        this.regional = regional;
        this.caixaNumero = caixaNumero;
    }

    public Caixa(Integer caixaCodigo, Regional regional, Integer caixaNumero, Character caixaCheia, List<ProcessoCaixa> processoCaixas) {
        this.caixaCodigo = caixaCodigo;
        this.regional = regional;
        this.caixaNumero = caixaNumero;
        this.caixaCheia = caixaCheia;
        this.processoCaixas = processoCaixas;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((caixaCodigo == null) ? 0 : caixaCodigo.hashCode());
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
        Caixa other = (Caixa) obj;
        if (caixaCodigo == null) {
            if (other.caixaCodigo != null) {
                return false;
            }
        } else if (!caixaCodigo.equals(other.caixaCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Caixa [caixaCodigo=" + caixaCodigo + ", caixaNumero=" + caixaNumero + ", regional=" + regional.getRegCodigo() + "]";
    }

}
