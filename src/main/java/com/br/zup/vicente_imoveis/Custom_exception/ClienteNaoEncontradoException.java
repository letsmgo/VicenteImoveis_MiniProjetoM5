package com.br.zup.vicente_imoveis.Custom_exception;

public class ClienteNaoEncontradoException extends RuntimeException{

    public ClienteNaoEncontradoException(String message) {
        super(message);
    }

}
