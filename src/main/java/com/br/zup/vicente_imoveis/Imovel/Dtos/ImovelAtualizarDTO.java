package com.br.zup.vicente_imoveis.Imovel.Dtos;

import com.br.zup.vicente_imoveis.Imovel.Enums.TipoDeContrato;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ImovelAtualizarDTO {

    private double valor;
    private String tipoDeImovel;
    private int qtdBanheiros;
    private double metragem;
    private TipoDeContrato tipoDeContrato;

}
