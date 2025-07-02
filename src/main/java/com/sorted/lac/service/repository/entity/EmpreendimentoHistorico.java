package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.experimental.Tolerate;

@Entity
@Table(name = "EMPREENDIMENTO_HISTORICO")
public class EmpreendimentoHistorico implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private EmpreendedorHistoricoPk id;

    @ManyToOne
    @MapsId("userCodigo") // Mapeia user_codigo da chave composta
    @JoinColumn(name = "user_codigo", referencedColumnName = "user_codigo", nullable = false)
    private Usuario usuario; // Assumindo que a entidade Usuario existe

    @Column(name = "emphi_cnpj_antigo", length = 14)
    private String emphiCnpjAntigo;

    @Column(name = "emphi_descricao", nullable = false, length = 500)
    private String emphiDescricao;

    @Column(name = "emphi_razao_antiga", length = 100)
    private String emphiRazaoAntiga;

    @ManyToOne
    @JoinColumn(name = "end_codigo", referencedColumnName = "end_codigo") // end_codigo é NULLABLE
    private Endereco endereco; // Assumindo que a entidade Endereco existe

    @ManyToOne
    @JoinColumn(name = "user_codigo_atualizou", referencedColumnName = "user_codigo", nullable = false)
    private Usuario usuarioAtualizou; // Relacionamento para o usuário que fez a atualização

    @Tolerate
    public EmpreendimentoHistorico() {
        // Method default for hibernate
    }

    @Builder
    public EmpreendimentoHistorico(EmpreendedorHistoricoPk id, Usuario usuario, String emphiCnpjAntigo, String emphiDescricao, String emphiRazaoAntiga, Endereco endereco, Usuario usuarioAtualizou) {
        this.id = id;
        this.usuario = usuario;
        this.emphiCnpjAntigo = emphiCnpjAntigo;
        this.emphiDescricao = emphiDescricao;
        this.emphiRazaoAntiga = emphiRazaoAntiga;
        this.endereco = endereco;
        this.usuarioAtualizou = usuarioAtualizou;
    }
}
