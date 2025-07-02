package com.sorted.lac.service.repository.entity;

import com.sorted.lac.service.enums.TipoEstudoEnum;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Entity
@Table(name = "ATIVIDADE_TIPO_ESTUDO")
@SequenceGenerator(name = "seq_atividade_tipo_estudo", sequenceName = "seq_atividade_tipo_estudo", allocationSize = 1)
public class AtividadeTipoEstudo implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "seq_atividade_tipo_estudo")
    @Column(name = "ativ_tp_estudo_seq")
    private Integer ativ_tp_estudo_seq;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ATIV_CODIGO")
    private Atividade atividade;

    @Column(name = "TIPO_ESTUDO")
    @Enumerated(EnumType.STRING)
    private TipoEstudoEnum tipoEstudo;

    @Column(name = "ATTPE_PORTE")
    private Character attpe_porte;

    @Tolerate
    public AtividadeTipoEstudo() {
        // Method default for hibernate
    }

    @Builder
    public AtividadeTipoEstudo(Integer ativ_tp_estudo_seq, Atividade atividade, TipoEstudoEnum tipoEstudo, Character attpe_porte) {
        this.ativ_tp_estudo_seq = ativ_tp_estudo_seq;
        this.atividade = atividade;
        this.tipoEstudo = tipoEstudo;
        this.attpe_porte = attpe_porte;
    }
}
