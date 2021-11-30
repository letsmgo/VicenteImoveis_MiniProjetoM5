package com.br.zup.vicente_imoveis.Contrato;

import com.br.zup.vicente_imoveis.Imovel.Imovel;
import com.br.zup.vicente_imoveis.Morador.Morador;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    @OneToOne
    private Imovel imovel;
    @OneToOne
    private Morador morador;
    private StatusDoContrato statusDoContrato;
    private Date dataDoContrato;

}
