package com.br.zup.vicente_imoveis.Custom_exception;

public class ContratoNaoEncontradoException extends RuntimeException{

    public ContratoNaoEncontradoException(String message) {
        super(message);
    }

}
