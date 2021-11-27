package com.br.zup.vicente_imoveis.Morador;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@RequiredArgsConstructor
@Getter
@Setter
public class MoradorDTO {
    private String cpf;
    private String nome;
    private String telefone;
    private Date dataDeEntradaNoImovel;
}
