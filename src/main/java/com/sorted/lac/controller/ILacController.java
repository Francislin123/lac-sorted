package com.sorted.lac.controller;

import com.sorted.lac.controller.response.LacResponseDTO;
import com.sorted.lac.service.enums.TipoLicencaLacEnum;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface ILacController {

    @GetMapping(value = "/regionals", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<LacResponseDTO>> listarComprasOrdenadas(@RequestParam("checkBoxes") final List<Boolean> listaCheckBoxes, @RequestParam("tipoLicenca") final TipoLicencaLacEnum tipoLicencaEnum);

    @GetMapping(value = "/all-type-license", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<LacResponseDTO>> lacSorteioTodosTipoLicenca(@RequestParam("listaCheckBoxes") final List<Boolean> listaCheckBoxes);
}
