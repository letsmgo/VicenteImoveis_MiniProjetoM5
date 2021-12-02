package com.br.zup.vicente_imoveis.Contrato;

import com.br.zup.vicente_imoveis.Contrato.Enums.StatusDoContrato;
import com.br.zup.vicente_imoveis.Imovel.Imovel;
import com.br.zup.vicente_imoveis.Cliente.Cliente;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "contratos")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Imovel imovel;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Cliente cliente;
    @Enumerated(EnumType.STRING)
    private StatusDoContrato statusDoContrato;
    private LocalDate dataDoContrato;
    private LocalDate dataTerminoContrato;

}
