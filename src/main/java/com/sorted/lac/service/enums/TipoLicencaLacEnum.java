package com.sorted.lac.service.enums;


public enum TipoLicencaLacEnum {

    NAO_DEFINIDO_AINDA(0, "NAO DEFINIDO AINDA", "NAO DEFINIDO AINDA"),
    LAC_AVICULTURA(1477, "LAC - Avicultura", "LAC_AVICULTURA"),
    LAC_SUINO(1901, "LAC - Suinocultura", "LAC_SUINO"),
    LAC_TRANSPORTE(1622, "LAC - Transporte", "LAC_TRANSPORTE"),
    RENLAO_AUTO_LINHAS_TRANS(1623, "RENLAO - Autorização para Linhas de Transmissão (Automática)", "RENLAO_AUTO_LINHAS_TRANS"),
    CONF_LAO(1902, "Licença Ambiental de Operação Automática", "CONF_LAO"),
    CONF_AUA_AUT(1925, "CONF AUA", "CONF_AUA_AUT");

    Integer valor;
    String nome;
    String nomeDaLicencaItemValue;

    TipoLicencaLacEnum(Integer valor, String nome, String nomeDaLicencaItemValue) {
        this.valor = valor;
        this.nome = nome;
        this.nomeDaLicencaItemValue = nomeDaLicencaItemValue;
    }

    public Integer getValor() {
        return valor;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeDaLicencaItemValue() {
        return nomeDaLicencaItemValue;
    }

    TipoLicencaLacEnum licencaLacEnum;

    TipoLicencaLacEnum(TipoLicencaLacEnum licencaLacEnum){
        this.licencaLacEnum = licencaLacEnum;
    }

    public TipoLicencaLacEnum getTipoDocEnum() {
        return licencaLacEnum;
    }

    public static TipoLicencaLacEnum valueOf(Integer valor) {
        for (TipoLicencaLacEnum tpDoc : TipoLicencaLacEnum.values()) {
            if (tpDoc.getValor().equals(valor)) {
                return tpDoc;
            }
        }
        return NAO_DEFINIDO_AINDA;
    }
}
