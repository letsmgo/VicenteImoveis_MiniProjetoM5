package com.br.zup.vicente_imoveis.Cliente.Dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@RequiredArgsConstructor
@Getter
@Setter
public class ClienteDTO {
    @CPF(message ="CPF inválido")
    @NotNull(message = "O campo CPF deve ser preenchido")
    private String cpf;
    @NotBlank
    @Size(min = 2,message = "O nome não pode ter menos de 2 caracteres")
    private String nome;
    @NotNull(message = "O campo telefone precisa ser preenchido")
    private String telefone;

    public ClienteDTO(String cpf, String nome, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
    }

}
