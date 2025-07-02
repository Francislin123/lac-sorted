package com.sorted.lac.service.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "USUARIO", uniqueConstraints = @UniqueConstraint(columnNames = "USER_CPF_CNPJ"))
@SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1)
public class Usuario implements java.io.Serializable {

    @Id
    @GeneratedValue(generator = "SEQ_USUARIO") // Assuming sequence or auto-increment for user_codigo
    @Column(name = "user_codigo", nullable = false)
    private Integer userCodigo;

    @Column(name = "user_atualizacao_perfil", length = 1)
    private String userAtualizacaoPerfil; // bpchar(1)

    @Column(name = "user_cpf_cnpj", nullable = false, length = 14)
    private String userCpfCnpj;

    @Column(name = "user_data_cadastro", nullable = false)
    private LocalDateTime userDataCadastro;

    @Column(name = "user_data_exclusao")
    private LocalDateTime userDataExclusao;

    @Column(name = "user_exclusor")
    private Integer userExclusor; // FK self-referencing or to another User, but no FK constraint for this specific column in the provided DDL.

    @Column(name = "user_login", nullable = false, length = 50, unique = true)
    private String userLogin;

    @Column(name = "user_senha", nullable = false, length = 170)
    private String userSenha;

    @ManyToOne
    @JoinColumn(name = "end_codigo", referencedColumnName = "end_codigo", nullable = false)
    // Assumindo que a entidade Endereco existe (End) e tem end_codigo como PK
    private Endereco endereco; // Ou End, dependendo do nome da sua entidade Endereço

    @Column(name = "senha_assinatura", length = 12)
    private String senhaAssinatura;

    @Lob // Usado para mapear dados grandes como bytea
    @Column(name = "arquivo_assinatura")
    private byte[] arquivoAssinatura; // bytea

    @Column(name = "perfil_atualizado")
    private Boolean perfilAtualizado;

    @Column(name = "ultimo_login")
    private LocalDateTime ultimoLogin;

    @Column(name = "atualizou_email")
    private Boolean atualizouEmail;

    @Tolerate
    public Usuario() {
        // Method default for hibernate
    }

    @Builder
    public Usuario(Integer userCodigo, String userAtualizacaoPerfil, String userCpfCnpj, LocalDateTime userDataCadastro,
                   LocalDateTime userDataExclusao, Integer userExclusor, String userLogin, String userSenha,
                   Endereco endereco, String senhaAssinatura, byte[] arquivoAssinatura, Boolean perfilAtualizado,
                   LocalDateTime ultimoLogin, Boolean atualizouEmail) {
        this.userCodigo = userCodigo;
        this.userAtualizacaoPerfil = userAtualizacaoPerfil;
        this.userCpfCnpj = userCpfCnpj;
        this.userDataCadastro = userDataCadastro;
        this.userDataExclusao = userDataExclusao;
        this.userExclusor = userExclusor;
        this.userLogin = userLogin;
        this.userSenha = userSenha;
        this.endereco = endereco;
        this.senhaAssinatura = senhaAssinatura;
        this.arquivoAssinatura = arquivoAssinatura;
        this.perfilAtualizado = perfilAtualizado;
        this.ultimoLogin = ultimoLogin;
        this.atualizouEmail = atualizouEmail;
    }
}
