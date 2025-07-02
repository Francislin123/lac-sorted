package com.sorted.lac.service.mapper;

import com.sorted.lac.controller.response.LacResponseDTO;
import com.sorted.lac.service.repository.entity.Analise;
import com.sorted.lac.service.repository.fce.Fce;
import com.sorted.lac.service.repository.licenca.Licenca;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FceToLacResponseDTOMapper {

    public static LacResponseDTO mapFceToLacResponseDTO(Fce fce) {
        if (fce == null) {
            return null;
        }

        LacResponseDTO dto = new LacResponseDTO();
        dto.setFceCodigo(fce.getFceCodigo());

        dto.setTramiteId(fce.getTramite() != null ? fce.getTramite().getTrmteCodigo() : null);
        dto.setObjetoRequerimentoId(fce.getObjetoRequerimento() != null ? fce.getObjetoRequerimento().getObjreCodigo() : null);
        dto.setUsuarioId(fce.getUsuario() != null ? fce.getUsuario().getUserCodigo() : null);
        dto.setTipoFceId(fce.getTipoFce() != null ? fce.getTipoFce().getTpfceCodigo() : null);
        dto.setProcessoId(fce.getProcesso() != null ? fce.getProcesso().getProcCodigo() : null);

        dto.setFase(fce.getFase());
        dto.setLegislacao(fce.getLegislacao());
        dto.setStatusFce(fce.getStatusFce());

        dto.setFceDataCadastro(convertToLocalDateTimeViaInstant(fce.getFceDataCadastro()));

        dto.setFceJuntadaStatus(fce.getFceJuntadaStatus());
        dto.setDigital(fce.getDigital());
        dto.setFceObs(fce.getFceObs());
        dto.setTipoJsonEnum(fce.getTipoJsonEnum());
        dto.setJson(fce.getJson());
        dto.setCodRegionalDestino(fce.getCodRegionalDestino());

        dto.setLicencaIds(fce.getLicencas() != null ? fce.getLicencas().stream().map(Licenca::getLicenCodigo).collect(Collectors.toList()) : Collections.emptyList());

        dto.setAnaliseIds(fce.getAnalises() != null ? fce.getAnalises().stream().map(Analise::getAnlseCodigo).collect(Collectors.toList()) : Collections.emptyList());

        return dto;
    }

    public static List<LacResponseDTO> mapFceListToLacResponseDTOList(List<Fce> fces) {
        if (fces == null || fces.isEmpty()) {
            return Collections.emptyList();
        }
        return fces.stream().map(FceToLacResponseDTOMapper::mapFceToLacResponseDTO).collect(Collectors.toList());
    }

    private static LocalDateTime convertToLocalDateTimeViaInstant(LocalDateTime LocalDateTimeToConvert) {
        if (LocalDateTimeToConvert == null) {
            return null;
        }
        return LocalDateTimeToConvert.atZone(ZoneId.systemDefault()).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
