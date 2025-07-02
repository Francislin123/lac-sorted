package com.sorted.lac.service.enums;

public enum StatusAnaliseEnum {
    EM_DIA(1, "Em dia"),
    ATRASADO(2, "Atrasado"),
    CONCLUIDO(3, "Concluído"),
    SUSPENSO(4, "Suspenso"),
    CANCELADO(5, "Cancelado"),
    VENCIDO(6, "Vencido"),
    INDEFERIDA(7, "Indeferida"),
    ARQUIVADA(8, "Arquivado");

    private Integer valor;
    private String descricao;
    private StatusAnaliseCoresEnum stansStyle;

    StatusAnaliseEnum(Integer valor, String descricao) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public Integer getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public StatusAnaliseCoresEnum getStansStyle() {
        return stansStyle;
    }

    public void setStansStyle(StatusAnaliseCoresEnum stansStyle) {
        this.stansStyle = stansStyle;
    }

    public static StatusAnaliseEnum valueOf(int id) {
        for (StatusAnaliseEnum e : StatusAnaliseEnum.values()) {
            if (e.getValor().equals(id)) {
                return e;
            }
        }
        return EM_DIA;
    }

}
