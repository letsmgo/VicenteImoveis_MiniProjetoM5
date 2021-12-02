package com.br.zup.vicente_imoveis.Custom_exception;

public class ImovelNaoCadastradoException extends RuntimeException{

    public ImovelNaoCadastradoException(String message) {
        super(message);
    }

}
