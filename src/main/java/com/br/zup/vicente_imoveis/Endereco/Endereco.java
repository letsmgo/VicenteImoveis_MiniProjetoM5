package com.br.zup.vicente_imoveis.Endereco;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "enderecos")
@RequiredArgsConstructor
@Getter
@Setter
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String cep;
    @Column(nullable = false)
    private String logradouro;
    @Column(nullable = false)
    private int numero;
    @Column(columnDefinition = "VARCHAR(50) default 'NT'")
    private String complemento;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String estado;

}
