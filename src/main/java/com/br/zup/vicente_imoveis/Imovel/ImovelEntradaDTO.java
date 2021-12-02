package com.br.zup.vicente_imoveis.Imovel;

import com.br.zup.vicente_imoveis.Endereco.Endereco;
import com.br.zup.vicente_imoveis.Imovel.Enums.TipoDeContrato;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Getter
@Setter
public class ImovelEntradaDTO {

    @DecimalMin(value = "0.0", inclusive = false, message = "Valor abaixo do permitido")
    @Digits(integer = 10, fraction = 2, message = "Valor inválido")
    private double valor;
    @NotNull(message = "Adicione o tipo do imovel")
    private String tipoDeImovel;
    @DecimalMin(value = "0", inclusive = false, message = "Valor abaixo do permitido")
    private int qtdBanheiros;
    private Endereco endereco;
    @DecimalMin(value = "0.0", inclusive = false, message = "Valor abaixo do permitido")
    private double metragem;
    private TipoDeContrato tipoDeContrato;


}
