package com.br.zup.vicente_imoveis.Endereco;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "enderecos")
@RequiredArgsConstructor
@Getter
@Setter
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    @NotBlank(message = "O cep não pode ser vazio")
    private String cep;
    @Column(nullable = false)
    @NotBlank(message = "Informe o logradouro com o nome")
    private String logradouro;
    @Column(nullable = false)
    @NotNull(message = "Informe o número do endereço")
    @Min(value = 1)
    private int numero;
    @Column(columnDefinition = "VARCHAR(50) default 'NT'")
    private String complemento;
    @Column(nullable = false)
    @NotBlank(message = "Informe o nome do bairro")
    private String bairro;
    @Column(nullable = false)
    @NotBlank(message = "Informe o nome da cidade")
    private String cidade;
    @Column(nullable = false)
    @NotBlank(message = "Informe o Nome do Estado")
    private String estado;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return numero == endereco.numero && Objects.equals(cep, endereco.cep) && Objects.equals(logradouro, endereco.logradouro) && Objects.equals(complemento, endereco.complemento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cep, logradouro, numero, complemento);
    }
}
