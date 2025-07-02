package com.sorted.lac.service.repository.fce;

import com.sorted.lac.service.repository.entity.Atividade;
import com.sorted.lac.service.repository.entity.Certidao;
import com.sorted.lac.service.repository.licenca.LicencaValidade;
import com.sorted.lac.service.repository.entity.Usuario;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.experimental.Tolerate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "FCE_CERTIDAO")
public class FceCertidao implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "fce_codigo", nullable = false)
    private Integer fceCodigo; // Este campo será mapeado pela PK de Fce

    @OneToOne
    @MapsId // Indica que fceCodigo é também a PK e mapeia para a PK de Fce
    @JoinColumn(name = "fce_codigo", referencedColumnName = "fce_codigo", nullable = false)
    private Fce fce; // Assumindo que a entidade Fce existe

    @Column(name = "fcece_data_declaracao")
    private LocalDateTime fceceDataDeclaracao;

    @Column(name = "fcece_data_validade")
    private LocalDateTime fceceDataValidade;

    @Column(name = "fcece_valor", nullable = false, precision = 19, scale = 2)
    private BigDecimal fceceValor;

    @ManyToOne
    @JoinColumn(name = "ativ_codigo", referencedColumnName = "ativ_codigo", nullable = false)
    private Atividade atividade; // Assumindo que a entidade Atividade existe

    @ManyToOne
    @JoinColumn(name = "certi_codigo", referencedColumnName = "certi_codigo", nullable = false)
    private Certidao certidao; // Assumindo que a entidade Certidao existe

    @ManyToOne
    @JoinColumn(name = "licva_codigo", referencedColumnName = "licva_codigo", nullable = false)
    private LicencaValidade licencaValidade; // Assumindo que a entidade LicencaValidade existe

    @Column(name = "fcece_descritivo")
    private String fceceDescritivo; // varchar sem limite definido

    @Column(name = "fcece_observacao")
    private String fceceObservacao; // varchar sem limite definido

    @ManyToOne
    @JoinColumn(name = "user_codigo", referencedColumnName = "user_codigo") // user_codigo é NULLABLE
    private Usuario usuario; // Assumindo que a entidade Usuario existe

    @Column(name = "cnae", length = 10)
    private String cnae;

    @Column(name = "cnae_baixo_impacto")
    private Boolean cnaeBaixoImpacto; // bool mapeia para Boolean

    @Column(name = "motivo_alteracao")
    private String motivoAlteracao;

    @Tolerate
    public FceCertidao() {
        // Method default for hibernate
    }

    @Builder
    public FceCertidao(Integer fceCodigo, Fce fce, LocalDateTime fceceDataDeclaracao, LocalDateTime fceceDataValidade, BigDecimal fceceValor, Atividade atividade, Certidao certidao, LicencaValidade licencaValidade, String fceceDescritivo, String fceceObservacao, Usuario usuario, String cnae, Boolean cnaeBaixoImpacto, String motivoAlteracao) {
        this.fceCodigo = fceCodigo;
        this.fce = fce;
        this.fceceDataDeclaracao = fceceDataDeclaracao;
        this.fceceDataValidade = fceceDataValidade;
        this.fceceValor = fceceValor;
        this.atividade = atividade;
        this.certidao = certidao;
        this.licencaValidade = licencaValidade;
        this.fceceDescritivo = fceceDescritivo;
        this.fceceObservacao = fceceObservacao;
        this.usuario = usuario;
        this.cnae = cnae;
        this.cnaeBaixoImpacto = cnaeBaixoImpacto;
        this.motivoAlteracao = motivoAlteracao;
    }
}
