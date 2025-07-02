package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "EMPREENDIMENTO")
@SequenceGenerator(name = "SEQ_EMPREENDIMENTO", sequenceName = "SEQ_EMPREENDIMENTO", allocationSize = 1)
public class Empreendimento implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "SEQ_EMPREENDIMENTO")
    @Column(name = "EMPTO_CODIGO", unique = true, nullable = false, precision = 10, scale = 0)
    private Integer emptoCodigo;

    @Column(name = "empto_cnpj", length = 14)
    private String emptoCnpj;

    @Column(name = "empto_data_cadastro", nullable = false)
    private LocalDate emptoDataCadastro;

    @Column(name = "empto_escritura", length = 20)
    private String emptoEscritura;

    @Column(name = "empto_ie", length = 13)
    private String emptoIe;

    @Column(name = "empto_im", length = 13)
    private String emptoIm;

    @Column(name = "empto_juridico", nullable = false, length = 1)
    private String emptoJuridico; // bpchar(1)

    @Column(name = "empto_nome_fantasia", length = 200)
    private String emptoNomeFantasia;

    @Column(name = "empto_razao", nullable = false, length = 150)
    private String emptoRazao;

    @Column(name = "empto_x", length = 20)
    private String emptoX;

    @Column(name = "empto_y", length = 20)
    private String emptoY;

    @ManyToOne
    @JoinColumn(name = "end_codigo", referencedColumnName = "end_codigo", nullable = false)
    private Endereco endereco; // Assumindo que a entidade Endereco existe

    @ManyToOne
    @JoinColumn(name = "tpcoo_codigo", referencedColumnName = "tpcoo_codigo", nullable = false)
    private TipoCoordenada tipoCoordenada; // Assumindo que a entidade TipoCoordenada existe

    @ManyToOne
    @JoinColumn(name = "user_codigo", referencedColumnName = "user_codigo", nullable = false)
    private Usuario usuario; // Assumindo que a entidade Usuario existe

    @Column(name = "tpcoo_codigo_back")
    private Integer tpcooCodigoBack;

    @Column(name = "empto_x_back", length = 20)
    private String emptoXBack;

    @Column(name = "empto_y_back", length = 20)
    private String emptoYBack;

    @Column(name = "empto_codigo_sinaflor")
    private Integer emptoCodigoSinaflor;

    @Column(name = "status")
    private String status;

    @Column(name = "descricao")
    private String descricao; // TEXT ou VARCHAR sem limite definido mapeia para String

    @Column(name = "valor_estimado", precision = 38, scale = 2)
    private BigDecimal valorEstimado;

    @Column(name = "empregos_diretos")
    private Integer empregosDiretos;

    @Column(name = "empregos_indiretos")
    private Integer empregosIndiretos;

    @Column(name = "retificar_coordenada")
    private Boolean retificarCoordenada;

    @Tolerate
    public Empreendimento() {
        // Method default for hibernate
    }

    @Builder
    public Empreendimento(Integer emptoCodigo, String emptoCnpj, LocalDate emptoDataCadastro, String emptoEscritura,
                          String emptoIe, String emptoIm, String emptoJuridico, String emptoNomeFantasia,
                          String emptoRazao, String emptoX, String emptoY, Endereco endereco,
                          TipoCoordenada tipoCoordenada, Usuario usuario, Integer tpcooCodigoBack, String emptoXBack,
                          String emptoYBack, Integer emptoCodigoSinaflor, String status, String descricao,
                          BigDecimal valorEstimado, Integer empregosDiretos, Integer empregosIndiretos,
                          Boolean retificarCoordenada) {
        this.emptoCodigo = emptoCodigo;
        this.emptoCnpj = emptoCnpj;
        this.emptoDataCadastro = emptoDataCadastro;
        this.emptoEscritura = emptoEscritura;
        this.emptoIe = emptoIe;
        this.emptoIm = emptoIm;
        this.emptoJuridico = emptoJuridico;
        this.emptoNomeFantasia = emptoNomeFantasia;
        this.emptoRazao = emptoRazao;
        this.emptoX = emptoX;
        this.emptoY = emptoY;
        this.endereco = endereco;
        this.tipoCoordenada = tipoCoordenada;
        this.usuario = usuario;
        this.tpcooCodigoBack = tpcooCodigoBack;
        this.emptoXBack = emptoXBack;
        this.emptoYBack = emptoYBack;
        this.emptoCodigoSinaflor = emptoCodigoSinaflor;
        this.status = status;
        this.descricao = descricao;
        this.valorEstimado = valorEstimado;
        this.empregosDiretos = empregosDiretos;
        this.empregosIndiretos = empregosIndiretos;
        this.retificarCoordenada = retificarCoordenada;
    }
}