package com.br.zup.vicente_imoveis.Contrato.Dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Getter
@Setter
public class ContratoEntradaDTO {
    @NotNull
    private int id_imovel;
    @NotNull
    private String id_morador;
}
