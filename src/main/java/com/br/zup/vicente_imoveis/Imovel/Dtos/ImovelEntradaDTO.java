package com.br.zup.vicente_imoveis.Imovel.Dtos;

import com.br.zup.vicente_imoveis.Endereco.Endereco;
import com.br.zup.vicente_imoveis.Imovel.Enums.TipoDeContrato;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;

@RequiredArgsConstructor
@Getter
@Setter
public class ImovelEntradaDTO {

    @DecimalMin(value = "50.0", inclusive = false, message = "Valor abaixo do permitido")
    @Digits(integer = 10, fraction = 2, message = "Valor inválido")
    private double valor;
    @NotNull(message = "Adicione o tipo do imovel")
    private String tipoDeImovel;
    @NotNull(message = "A quantidade de banheiros deve ser informada")
    @Min(value = 1, message = "Por favor corrija os dados da quantidade de banheiros")
    private Integer qtdBanheiros;
    @Valid
    private Endereco endereco;
    @DecimalMin(value = "0.0", inclusive = false, message = "Tamanho abaixo do permitido")
    private double metragem;
    @NotNull(message = "Informe o tipo de contrato")
    private TipoDeContrato tipoDeContrato;


}
