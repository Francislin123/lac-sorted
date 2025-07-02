package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MODELO_IN_TPDOC")
@SequenceGenerator(name = "SEQ_MODELO_IN_TPDOC", sequenceName = "SEQ_MODELO_IN_TPDOC", allocationSize = 1)
public class ModeloInTpdoc implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "SEQ_MODELO_IN_TPDOC")
    @Column(name = "MITPD_CODIGO", unique = true, precision = 10)
    private Integer mitpdCodigo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MODIN_CODIGO")
    private ModeloIn modeloIn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TPLIC_CODIGO")
    private TipoLicenca tipoLicenca;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TPDOC_CODIGO")
    private TipoDocumento tipoDocumento;

    @Column(name = "MITPD_SEQUENCIA", precision = 22)
    private Integer mitpdSequencia;

    @Column(name = "OBRIGATORIO", length = 1)
    private boolean obrigatorio;

    public ModeloInTpdoc() {
        modeloIn = new ModeloIn();
        tipoDocumento = new TipoDocumento();
        tipoLicenca = new TipoLicenca();
        obrigatorio = true;
    }

    public ModeloInTpdoc(Integer mitpdCodigo, ModeloIn modeloIn, TipoLicenca tipoLicenca, TipoDocumento tipoDocumento, Integer mitpdSequencia, boolean obrigatorio) {
        this.mitpdCodigo = mitpdCodigo;
        this.modeloIn = modeloIn;
        this.tipoLicenca = tipoLicenca;
        this.tipoDocumento = tipoDocumento;
        this.mitpdSequencia = mitpdSequencia;
        this.obrigatorio = obrigatorio;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mitpdCodigo == null) ? 0 : mitpdCodigo.hashCode());
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
        ModeloInTpdoc other = (ModeloInTpdoc) obj;
        if (mitpdCodigo == null) {
            if (other.mitpdCodigo != null) {
                return false;
            }
        } else if (!mitpdCodigo.equals(other.mitpdCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModeloInTpdoc [mitpdCodigo=" + mitpdCodigo + "]";
    }

}
