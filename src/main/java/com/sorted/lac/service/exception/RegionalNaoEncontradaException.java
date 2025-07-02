package com.sorted.lac.service.exception;

public class RegionalNaoEncontradaException extends RuntimeException {
    public RegionalNaoEncontradaException(Integer id) {
        super("Nenhuma reginao encontrada para o id " + id);
    }
}
