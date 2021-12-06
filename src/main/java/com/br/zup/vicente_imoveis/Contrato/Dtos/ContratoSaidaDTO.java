package com.br.zup.vicente_imoveis.Contrato.Dtos;

import com.br.zup.vicente_imoveis.Contrato.Enums.StatusDoContrato;
import com.br.zup.vicente_imoveis.Imovel.Imovel;
import com.br.zup.vicente_imoveis.Cliente.Cliente;
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
    private LocalDate dataTerminoContrato;

    public ContratoSaidaDTO(int id, Imovel imovel, Cliente cliente, StatusDoContrato statusDoContrato,
                            LocalDate dataDoContrato, LocalDate dataTerminoContrato) {
        this.id = id;
        this.imovel = imovel;
        this.cliente = cliente;
        this.statusDoContrato = statusDoContrato;
        this.dataDoContrato = dataDoContrato;
        this.dataTerminoContrato = dataTerminoContrato;
    }
}
