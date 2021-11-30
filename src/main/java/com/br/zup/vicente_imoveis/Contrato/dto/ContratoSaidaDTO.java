package com.br.zup.vicente_imoveis.Contrato.dto;

import com.br.zup.vicente_imoveis.Contrato.enun.StatusDoContrato;
import com.br.zup.vicente_imoveis.Imovel.Imovel;
import com.br.zup.vicente_imoveis.cliente.Cliente;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@Setter
public class ContratoSaidaDTO {
    private int id;
    private Imovel imovel;
    private Cliente cliente;
    private StatusDoContrato statusDoContrato;
    private LocalDate dataDoContrato;

}
