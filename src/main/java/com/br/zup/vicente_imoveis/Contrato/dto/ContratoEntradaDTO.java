package com.br.zup.vicente_imoveis.Contrato.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ContratoEntradaDTO {
    private int id_imovel;
    private String id_morador;
}
