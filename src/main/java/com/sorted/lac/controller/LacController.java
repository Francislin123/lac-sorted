package com.sorted.lac.controller;

import com.sorted.lac.controller.response.LacResponseDTO;
import com.sorted.lac.service.LacService;
import com.sorted.lac.service.enums.TipoLicencaLacEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(LacController.URI_LAC)
public class LacController implements ILacController {

    public static final String URI_LAC = "/lac/sorted";

    @Autowired
    private LacService lacService;

    @Override
    public ResponseEntity<List<LacResponseDTO>> listarComprasOrdenadas(
            @RequestParam("checkBoxes") final List<Boolean> listaCheckBoxes,
            @RequestParam("tipoLicenca") final TipoLicencaLacEnum tipoLicencaEnum) {
        Optional<List<LacResponseDTO>> response =
                Optional.ofNullable(lacService.lacSorteioTodasRegionais(listaCheckBoxes, tipoLicencaEnum));
        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<LacResponseDTO>> lacSorteioTodosTipoLicenca(
            @RequestParam("listaCheckBoxes") final List<Boolean> listaCheckBoxes) {
        Optional<List<LacResponseDTO>> response =
                Optional.ofNullable(lacService.lacSorteioTodosTipoLicenca(listaCheckBoxes));
        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
