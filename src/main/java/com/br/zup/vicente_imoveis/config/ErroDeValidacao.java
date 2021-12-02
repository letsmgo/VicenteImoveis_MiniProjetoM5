package com.br.zup.vicente_imoveis.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ErroDeValidacao {
    private String campo;
    private String mensagem;

    public ErroDeValidacao(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;

    }

    public ErroDeValidacao(String defautMessage){

    }
}
