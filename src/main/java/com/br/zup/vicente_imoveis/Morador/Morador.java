package com.br.zup.vicente_imoveis.Morador;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "moradores")
@RequiredArgsConstructor
@Getter
@Setter

public class Morador {

    @Id
    private String cpf;
    private String nome;
    private String telefone;
    private Date dataDeEntradaNoImovel;

}
