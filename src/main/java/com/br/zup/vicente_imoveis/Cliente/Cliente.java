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
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String telefone;

}
