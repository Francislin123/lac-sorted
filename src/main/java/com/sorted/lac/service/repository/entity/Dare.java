package com.sorted.lac.service.repository.entity;

import com.sorted.lac.service.enums.StatusDareEnum;
import com.sorted.lac.service.repository.fce.FceTpdoc;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "DARE")
public class Dare implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "dare_numero", nullable = false, precision = 22, scale = 0)
    private BigDecimal dareNumero; // numeric(22) como PK, assumindo que não é auto-gerado IDENTITY

    @Column(name = "dare_classe_servico", length = 15)
    private String dareClasseServico;

    @Column(name = "dare_codigo_barra", length = 100)
    private String dareCodigoBarra;

    @Column(name = "dare_codigo_barra_verif", length = 100)
    private String dareCodigoBarraVerif;

    @Column(name = "dare_codigo_receita")
    private Integer dareCodigoReceita;

    @Column(name = "dare_data_arrecadacao")
    private LocalDateTime dareDataArrecadacao;

    @Column(name = "dare_data_cadastro")
    private LocalDateTime dareDataCadastro;

    @Column(name = "dare_mensagem", length = 50)
    private String dareMensagem;

    @Column(name = "dare_obs", length = 500)
    private String dareObs;

    @Column(name = "dare_tipo_doc_arrecadacao")
    private Integer dareTipoDocArrecadacao;

    @Column(name = "dare_valor_pago", precision = 22, scale = 0) // numeric(22)
    private BigDecimal dareValorPago;

    @ManyToOne
    @JoinColumn(name = "fcetd_numero", referencedColumnName = "fcetd_numero") // nullable no DDL
    private FceTpdoc fceTpdoc; // Assumindo que a entidade FceTpdoc existe

    @ManyToOne
    @JoinColumn(name = "tpdar_codigo", referencedColumnName = "tpdar_codigo", nullable = false)
    private TipoDare tipoDare; // Assumindo que a entidade TipoDare existe

    @Column(name = "STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusDareEnum statusDare; // Assumindo que a entidade StatusDare existe e tem 'enum' como PK

    @Column(name = "dare_valor", precision = 22, scale = 0) // numeric(22)
    private BigDecimal dareValor;

    @Column(name = "dare_data_vencimento")
    private LocalDateTime dareDataVencimento;

    @Tolerate
    public Dare() {
        // Method default for hibernate
    }

    @Builder
    public Dare(BigDecimal dareNumero, String dareClasseServico, String dareCodigoBarra, String dareCodigoBarraVerif, Integer dareCodigoReceita, LocalDateTime dareDataArrecadacao, LocalDateTime dareDataCadastro, String dareMensagem, String dareObs, Integer dareTipoDocArrecadacao, BigDecimal dareValorPago, FceTpdoc fceTpdoc, TipoDare tipoDare, StatusDareEnum statusDare, BigDecimal dareValor, LocalDateTime dareDataVencimento) {
        this.dareNumero = dareNumero;
        this.dareClasseServico = dareClasseServico;
        this.dareCodigoBarra = dareCodigoBarra;
        this.dareCodigoBarraVerif = dareCodigoBarraVerif;
        this.dareCodigoReceita = dareCodigoReceita;
        this.dareDataArrecadacao = dareDataArrecadacao;
        this.dareDataCadastro = dareDataCadastro;
        this.dareMensagem = dareMensagem;
        this.dareObs = dareObs;
        this.dareTipoDocArrecadacao = dareTipoDocArrecadacao;
        this.dareValorPago = dareValorPago;
        this.fceTpdoc = fceTpdoc;
        this.tipoDare = tipoDare;
        this.statusDare = statusDare;
        this.dareValor = dareValor;
        this.dareDataVencimento = dareDataVencimento;
    }
}
