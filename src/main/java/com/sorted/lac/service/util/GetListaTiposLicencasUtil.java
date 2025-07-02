package com.sorted.lac.service.util;

import com.sorted.lac.service.enums.TipoLicencaLacEnum;

import java.util.Arrays;
import java.util.List;

public class GetListaTiposLicencasUtil {

    public static List<TipoLicencaLacEnum> getListaTiposLicencas() {
        return Arrays.asList(TipoLicencaLacEnum.LAC_AVICULTURA, TipoLicencaLacEnum.LAC_SUINO,
                TipoLicencaLacEnum.LAC_TRANSPORTE, TipoLicencaLacEnum.RENLAO_AUTO_LINHAS_TRANS,
                TipoLicencaLacEnum.CONF_LAO, TipoLicencaLacEnum.CONF_AUA_AUT);
    }
}
