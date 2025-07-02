package com.sorted.lac.service;

import com.sorted.lac.controller.response.LacResponseDTO;
import com.sorted.lac.service.component.GetFceSorteados;
import com.sorted.lac.service.enums.TipoLicencaLacEnum;
import com.sorted.lac.service.mapper.FceToLacResponseDTOMapper;
import com.sorted.lac.service.repository.fce.Fce;
import com.sorted.lac.service.repository.licenca.LicencaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.sorted.lac.service.auxiliar.GetFilteredRegionaisMap.getFilteredRegionaisMap;
import static com.sorted.lac.service.util.GetListaTiposLicencasUtil.getListaTiposLicencas;

@Slf4j
@Service
public class LacServiceImp implements LacService {

    @Autowired
    private LicencaRepository licencaRepository;

    @Autowired
    private GetFceSorteados sorteados;

    @Override
    public List<LacResponseDTO> lacSorteioTodasRegionais(final List<Boolean> listaCheckBoxes, final TipoLicencaLacEnum tipoLicencaEnum) {

        final Map<String, Integer> filteredRegionaisMap = getFilteredRegionaisMap(listaCheckBoxes);

        List<Fce> fceSorteados = this.sorteados.getFceSorteados(filteredRegionaisMap, tipoLicencaEnum);

        return FceToLacResponseDTOMapper.mapFceListToLacResponseDTOList(fceSorteados);
    }

    @Override
    public List<LacResponseDTO> lacSorteioTodosTipoLicenca(List<Boolean> listaCheckBoxes) {

        List<Fce> fceSorteados = new ArrayList<>();

        List<TipoLicencaLacEnum> listaTiposLicencas = getListaTiposLicencas();

        final Map<String, Integer> filteredRegionaisMap = getFilteredRegionaisMap(listaCheckBoxes);

        for (TipoLicencaLacEnum licencaTipo : listaTiposLicencas) {
            fceSorteados = this.sorteados.getFceSorteados(filteredRegionaisMap, licencaTipo);
        }

        return FceToLacResponseDTOMapper.mapFceListToLacResponseDTOList(fceSorteados);
    }
}
