package com.br.zup.vicente_imoveis.Morador;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import java.util.Date;

@RequiredArgsConstructor
@Getter
@Setter
public class MoradorDTO {
    private String cpf;
    private String nome;
    private String telefone;
    private Date dataDeEntradaNoImovel;


    public MoradorDTO(String cpf, String nome, String telefone, Date dataDeEntradaNoImovel) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.dataDeEntradaNoImovel = dataDeEntradaNoImovel;
    }
}
