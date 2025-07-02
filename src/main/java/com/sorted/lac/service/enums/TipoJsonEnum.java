package com.sorted.lac.service.enums;

public enum TipoJsonEnum {

    LAC_AVICULTURA(TipoDocumentoEnum.LAC_AVICULTURA),
    LAC_TRANSPORTE(TipoDocumentoEnum.LAC_TPP),
    LAO_TPP(null),
    LAC_ANTENA (null),
    LAC_SUINOCULTURA(TipoDocumentoEnum.LAC_SUINOCULTURA),
    LAC_SUINO(TipoDocumentoEnum.LAC_SUINO),
    RENLAO_AUTO_LINHAS_TRANS(TipoDocumentoEnum.RENLAO_AUTO_LINHAS_TRANS),
    CERTIDAO(null),
    CERTIDAO_RIOS(null),
    QUEIMA_CONTROLADA_AUA_AUTO(TipoDocumentoEnum.AUA_QUEIMADA),
    AAF_LEVANTAMENTO(TipoDocumentoEnum.LAC_FAUNA),
    AAF_MONITORAMENTO(TipoDocumentoEnum.LAC_FAUNA),
    AAF_SALVAMENTO(TipoDocumentoEnum.LAC_FAUNA),
    AAF_MANEJO(TipoDocumentoEnum.LAC_FAUNA),
    CONF_LAO(TipoDocumentoEnum.LICENCA_AMBIENTAL_OPERACAO_AUTOMATICA),
    CONF_AUA_AUT(TipoDocumentoEnum.AUA_AUTOMATICA),
    PISCICULTURA(TipoDocumentoEnum.RCE),
    LICENCA_AMBIENTAL_OPERACAO_AUTOMATICA(TipoDocumentoEnum.LICENCA_AMBIENTAL_OPERACAO_AUTOMATICA),
    CAD(null),
    CURSOS_DAGUA(null),
    ;

    TipoDocumentoEnum tipoDocEnum;

    TipoJsonEnum(TipoDocumentoEnum tipoDocEnum){
        this.tipoDocEnum = tipoDocEnum;
    }

    public TipoDocumentoEnum getTipoDocEnum() {
        return tipoDocEnum;
    }


}
