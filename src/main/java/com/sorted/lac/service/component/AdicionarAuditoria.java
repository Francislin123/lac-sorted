package com.sorted.lac.service.component;

import com.sorted.lac.service.enums.EtapaAuditoriaEnum;
import com.sorted.lac.service.enums.StatusAuditoriaEnum;
import com.sorted.lac.service.enums.StatusGeralEnum;
import com.sorted.lac.service.repository.auditoria.Auditoria;
import com.sorted.lac.service.repository.auditoria.AuditoriaEtapaPrazo;
import com.sorted.lac.service.repository.auditoria.AuditoriaEtapaPrazoRepository;
import com.sorted.lac.service.repository.auditoria.AuditoriaRepository;
import com.sorted.lac.service.repository.fce.Fce;
import com.sorted.lac.service.repository.regional.Regional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
class AdicionarAuditoria {

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Autowired
    private AuditoriaEtapaPrazoRepository auditoriaEtapaPrazoRepository;

    public void adicionarAuditoria(Fce fce, Regional regional) {

        Auditoria auditoria = new Auditoria();
        auditoria.setEtapa(EtapaAuditoriaEnum.NOMEACAO_EQUIPE);
        auditoria.setDataSorteio(LocalDateTime.now());
        auditoria.setFce(fce);
        auditoria.setRegional(regional);
        auditoria.setStatus(StatusAuditoriaEnum.NAO_INICIADA);

        AuditoriaEtapaPrazo auditoriaEtapaPrazo = new AuditoriaEtapaPrazo();
        auditoriaEtapaPrazo.setAuditoria(auditoria);
        auditoriaEtapaPrazo.setDataInicio(LocalDateTime.now());
        auditoriaEtapaPrazo.setEtapa(EtapaAuditoriaEnum.NOMEACAO_EQUIPE);
        auditoriaEtapaPrazo.setPrazo(5);
        auditoriaEtapaPrazo.setStatus(StatusGeralEnum.CADASTRADO);

        auditoriaRepository.save(auditoria);
        auditoriaEtapaPrazoRepository.save(auditoriaEtapaPrazo);
    }
}
