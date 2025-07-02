package com.sorted.lac.service.repository.entity;

import com.sorted.lac.service.repository.fce.Fce;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "analise")
@SequenceGenerator (name = "SEQ_ANALISE", sequenceName= "SEQ_ANALISE", allocationSize = 1)
public class Analise implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anlse_codigo")
    private Integer anlseCodigo;

    @Column(name = "anlse_data_cadastro")
    private LocalDateTime anlseDataCadastro;

    @Column(name = "anlse_data_finalizacao")
    private LocalDateTime anlseDataFinalizacao;

    @Column(name = "anlse_data_inicio")
    private LocalDateTime anlseDataInicio;

    @Column(name = "anlse_descricao", length = 255)
    private String anlseDescricao;

    @Column(name = "anlse_numero_processo", length = 100)
    private String anlseNumeroProcesso;

    @Column(name = "anlse_observacao")
    private String anlseObservacao;

    @Column(name = "anlse_situacao")
    private Boolean anlseSituacao;

    @Column(name = "anset_codigo")
    private Integer ansetCodigo; // FK, but not mapped to AnaliseEtapa directly

    @Column(name = "user_codigo_analista")
    private Integer userCodigoAnalista; // FK, but User entity not defined yet

    @Column(name = "user_codigo_cadastrador")
    private Integer userCodigoCadastrador; // FK, but User entity not defined yet

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FCE_CODIGO")
    private Fce fce;

    @Tolerate
    public Analise() {
        // Method default for hibernate
    }

    @Builder
    public Analise(Integer anlseCodigo, LocalDateTime anlseDataCadastro, LocalDateTime anlseDataFinalizacao,
                   LocalDateTime anlseDataInicio, String anlseDescricao, String anlseNumeroProcesso,
                   String anlseObservacao, Boolean anlseSituacao, Integer ansetCodigo,
                   Integer userCodigoAnalista, Integer userCodigoCadastrador) {
        this.anlseCodigo = anlseCodigo;
        this.anlseDataCadastro = anlseDataCadastro;
        this.anlseDataFinalizacao = anlseDataFinalizacao;
        this.anlseDataInicio = anlseDataInicio;
        this.anlseDescricao = anlseDescricao;
        this.anlseNumeroProcesso = anlseNumeroProcesso;
        this.anlseObservacao = anlseObservacao;
        this.anlseSituacao = anlseSituacao;
        this.ansetCodigo = ansetCodigo;
        this.userCodigoAnalista = userCodigoAnalista;
        this.userCodigoCadastrador = userCodigoCadastrador;
    }
}