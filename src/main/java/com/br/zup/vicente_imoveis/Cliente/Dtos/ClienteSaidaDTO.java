package com.br.zup.vicente_imoveis.Cliente.Dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import java.util.Date;

@RequiredArgsConstructor
@Getter
@Setter
public class ClienteSaidaDTO {

    @Id
    private String cpf;
    private String nome;
    private String telefone;
    private Date dataDeEntradaNoImovel;

}
