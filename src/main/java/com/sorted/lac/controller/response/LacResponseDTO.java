package com.sorted.lac.controller.response;

import com.sorted.lac.service.enums.FaseEnum;
import com.sorted.lac.service.enums.StatusFceEnum;
import com.sorted.lac.service.enums.TipoJsonEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class LacResponseDTO {

    private Integer fceCodigo;
    private Integer tramiteId;
    private Integer objetoRequerimentoId;
    private FaseEnum fase;
    private Integer empreendimentoId;
    private Integer usuarioId;
    private Integer tipoFceId;
    private Integer processoId;
    private Integer legislacao;
    private StatusFceEnum statusFce;
    private LocalDateTime fceDataCadastro;
    private Boolean fceJuntadaStatus;
    private Boolean digital = Boolean.TRUE;
    private String fceObs;
    private TipoJsonEnum tipoJsonEnum;
    private String json;
    private Integer codRegionalDestino;

    // Listas podem ser IDs ou DTOs aninhados, conforme necessidade:
    private List<Integer> licencaIds;
    private List<Integer> analiseIds;
}