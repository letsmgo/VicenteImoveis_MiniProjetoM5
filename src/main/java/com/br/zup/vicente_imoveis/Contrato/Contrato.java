package com.br.zup.vicente_imoveis.Contrato;

import com.br.zup.vicente_imoveis.Contrato.enun.StatusDoContrato;
import com.br.zup.vicente_imoveis.Imovel.Imovel;
import com.br.zup.vicente_imoveis.cliente.Cliente;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

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
    private StatusDoContrato statusDoContrato;
    private LocalDate dataDoContrato;

}
