package com.sorted.lac.service.enums;

public enum TipoContatoEnum {
    SEM_CONTATO("Sem contatos"),
    TELEFONE("Telefone"),
    FAX("Fax"),
    CELULAR("Celular"),
    EMAIL("e-mail"),
    SITE("site");

    private String descricao;

    TipoContatoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoContatoEnum valueOf(TipoContatoEnum tipoContato) {
        for (TipoContatoEnum tipo : TipoContatoEnum.values()) {
            if (tipo.equals(tipoContato)) {
                return tipo;
            }
        }

        return SEM_CONTATO;
    }

    public boolean isEmail(){
        return this.equals(EMAIL);
    }

    public String getName(){
        return this.name();
    }
}
