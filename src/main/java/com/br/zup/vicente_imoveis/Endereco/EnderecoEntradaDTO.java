package com.br.zup.vicente_imoveis.Endereco;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

@RequiredArgsConstructor
@Getter
@Setter
public class EnderecoEntradaDTO {

    @NotBlank(message = "O cep não pode ser vazio")
    private String cep;
    @NotBlank(message = "Informe o logradouro com o nome")
    private String logradouro;
    @NotBlank(message = "Informe o número do endereço")
    @DecimalMin(value = "0.0", inclusive = false, message = "Valor abaixo do permitido")
    private int numero;
    private String complemento;
    @NotBlank(message = "Informe o nome do bairro")
    private String bairro;
    @NotBlank(message = "Informe o nome da cidade")
    private String cidade;
    @NotBlank(message = "Informe o Nome do Estado")
    private String estado;
}
