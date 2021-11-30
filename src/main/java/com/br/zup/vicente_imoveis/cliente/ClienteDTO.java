package com.br.zup.vicente_imoveis.cliente;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
@Getter
@Setter
public class ClienteDTO {
    private String cpf;
    private String nome;
    private String telefone;

    public ClienteDTO(String cpf, String nome, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
    }

}
