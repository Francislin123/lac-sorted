package com.sorted.lac.service.repository.regional;

import com.sorted.lac.service.repository.entity.Endereco;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Entity
@Table(name = "REGIONAL")
public class Regional implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reg_codigo", nullable = false)
    private Integer regCodigo;

    @ManyToOne
    @JoinColumn(name = "end_codigo", referencedColumnName = "end_codigo", nullable = false)
    private Endereco endereco; // Ou End, dependendo do nome da sua entidade Endereço

    @Column(name = "reg_descricao", nullable = false, length = 100)
    private String regDescricao;

    @Column(name = "reg_resumo", nullable = false, length = 50)
    private String regResumo;

    @Column(name = "reg_sigla", nullable = false, length = 10)
    private String regSigla;

    @Tolerate
    public Regional() {
        // Method default for hibernate
    }

    @Builder
    public Regional(Integer regCodigo, Endereco endereco, String regDescricao, String regResumo, String regSigla) {
        this.regCodigo = regCodigo;
        this.endereco = endereco;
        this.regDescricao = regDescricao;
        this.regResumo = regResumo;
        this.regSigla = regSigla;
    }
}
