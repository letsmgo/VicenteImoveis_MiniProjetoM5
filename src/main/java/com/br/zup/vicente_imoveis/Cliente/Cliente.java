package com.br.zup.vicente_imoveis.Cliente;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
@RequiredArgsConstructor
@Getter
@Setter

public class Cliente {

    @Id
    private String cpf;
    private String nome;
    private String telefone;

}
