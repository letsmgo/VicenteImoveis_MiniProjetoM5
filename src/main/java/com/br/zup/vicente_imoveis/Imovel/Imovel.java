package com.br.zup.vicente_imoveis.Imovel;

import com.br.zup.vicente_imoveis.Endereco.Endereco;
import com.br.zup.vicente_imoveis.Imovel.Enums.TipoDeContrato;
import com.br.zup.vicente_imoveis.Morador.Morador;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Setter
@Getter
public class Imovel {

    private double valor;
    private String tipoDeImovel;
    private List<Morador> moradores;
    private int qtdBanheiros;
    private Endereco endereco;
    private double metragem;
    private TipoDeContrato tipoDeContrato;
    private boolean ocupado;

}
