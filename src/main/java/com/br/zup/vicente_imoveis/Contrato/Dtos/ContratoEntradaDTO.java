package com.br.zup.vicente_imoveis.Contrato.Dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Getter
@Setter
public class ContratoEntradaDTO {
    @NotNull(message = "Por favor informar ID do imovel")
    private Integer id_imovel;
    @NotNull(message = "Por favor informar CPF do novo morador")
    private String id_morador;
}
