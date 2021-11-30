package com.br.zup.vicente_imoveis.Imovel;

import com.br.zup.vicente_imoveis.Endereco.Endereco;
import com.br.zup.vicente_imoveis.Imovel.Enums.StatusImovel;
import com.br.zup.vicente_imoveis.Imovel.Enums.TipoDeContrato;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "imoveis")
@RequiredArgsConstructor
@Setter
@Getter
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double valor;
    private String tipoDeImovel;
    private int qtdBanheiros;
    @OneToOne
    private Endereco endereco;
    private double metragem;
    private TipoDeContrato tipoDeContrato;
    private StatusImovel statusImovel;

}
