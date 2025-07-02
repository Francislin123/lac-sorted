package com.sorted.lac.service.repository.regional;

import com.sorted.lac.service.enums.TipoContatoEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "REGIONAL_CONTATO")
public class RegionalContato implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private RegionalContatoId id;
    private TipoContatoEnum tipoContato;
    private Regional regional;
    private char regctPrincipal;

    public RegionalContato() {
        regional = new Regional();
    }

    public RegionalContato(RegionalContatoId id, TipoContatoEnum tipoContato, Regional regional, char regctPrincipal) {
        this.id = id;
        this.tipoContato = tipoContato;
        this.regional = regional;
        this.regctPrincipal = regctPrincipal;
    }

    @EmbeddedId
    @AttributeOverrides({@AttributeOverride(name = "regCodigo", column = @Column(name = "REG_CODIGO",
            nullable = false, precision = 10)), @AttributeOverride(name = "regctContato",
            column = @Column(name = "REGCT_CONTATO", length = 100))})
    public RegionalContatoId getId() {
        return this.id;
    }

    public void setId(RegionalContatoId id) {
        this.id = id;
    }

    @Column(name = "TIPO_CONTATO")
    @Enumerated(EnumType.STRING)
    public TipoContatoEnum getTipoContato() {
        return this.tipoContato;
    }

    public void setTipoContato(TipoContatoEnum tipoContato) {
        this.tipoContato = tipoContato;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REG_CODIGO", insertable = false, updatable = false)
    public Regional getRegional() {
        return this.regional;
    }

    public void setRegional(Regional regional) {
        this.regional = regional;
    }

    @Column(name = "REGCT_PRINCIPAL", length = 1)
    public char getRegctPrincipal() {
        return this.regctPrincipal;
    }

    public void setRegctPrincipal(char regctPrincipal) {
        this.regctPrincipal = regctPrincipal;
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
        RegionalContato other = (RegionalContato) obj;
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
        return "RegionalContato [id=" + id.getRegCodigo() + ", regional=" + regional.getRegCodigo() + ", tipoContato=" + tipoContato + "]";
    }

}
