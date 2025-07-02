package com.sorted.lac.service;

import com.sorted.lac.controller.response.LacResponseDTO;
import com.sorted.lac.service.enums.TipoLicencaLacEnum;

import java.util.List;

public interface LacService {
    List<LacResponseDTO> lacSorteioTodasRegionais(final List<Boolean> listaCheckBoxes, final TipoLicencaLacEnum tipoLicencaEnum);
    List<LacResponseDTO> lacSorteioTodosTipoLicenca(final List<Boolean> listaCheckBoxes);
}
