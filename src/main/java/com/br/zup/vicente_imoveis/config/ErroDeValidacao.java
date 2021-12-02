package com.br.zup.vicente_imoveis.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ErroDeValidacao {
    private String mensagem;

    public ErroDeValidacao( String mensagem) {
        this.mensagem = mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
