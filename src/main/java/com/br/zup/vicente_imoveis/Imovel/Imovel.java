package com.br.zup.vicente_imoveis.Imovel;

import com.br.zup.vicente_imoveis.Endereco.Endereco;
import com.br.zup.vicente_imoveis.Imovel.Enums.TipoDeContrato;
import com.br.zup.vicente_imoveis.Morador.Morador;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "imoveis")
@RequiredArgsConstructor
@Setter
@Getter
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double valor;
    private String tipoDeImovel;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Morador> moradores;
    private int qtdBanheiros;
    @OneToOne
    private Endereco endereco;
    private double metragem;
    private TipoDeContrato tipoDeContrato;
    private boolean ocupado;

}
