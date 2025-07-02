package com.sorted.lac.service.enums;

public enum StatusDareEnum {

    ABERTO(1,"Aberto"),
    PAGAMENTO_ONLINE_PROVISORIO(2,"Pago, mas não confirmado"),
    PAGAMENTO_CONSOLIDADO_PERMANENTE(3,"Pago"),
    CANCELADA_NAO_PAGA(4,"Cancelado sem pagamento"),
    CANCELADA_PAGA_PROVISORIA(5,"Cancelado com pagamento não confirmado"),
    CANCELADA_PAGA_PERMANENTE(6,"Cancelado"),
    PAGAMENTO_TRANSFERENCIA(7,"Pago com transferencia"),
    PAGAMENTO_DEPOSITO_ONLINE(8,"Pago com depósito online"),
    CANCELADA_DISPONIVEL_PARA_RESSARCIMENTO(9,"Cancelado, disponível para ressarcimento"),
    DARE_PAGA_SOLICITADA_DARE_COMPLEMENTAR(10,"Pago, solicitada DARE complementar"),
    DARE_NAO_GERADA(11,"DARE não gerada"),
    DARE_RESSARCIDA(12,"DARE ressarcida");

    Integer valor;
    String descricao;

    StatusDareEnum(Integer valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public Integer getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusDareEnum valueOf(Integer valor) {
        for(StatusDareEnum sd : StatusDareEnum.values()){
            if(sd.getValor().equals(valor)){
                return sd;
            }
        }
        return null;
    }
}
