package com.br.zup.vicente_imoveis.Imovel;

import com.br.zup.vicente_imoveis.Endereco.Endereco;
import com.br.zup.vicente_imoveis.Imovel.Enums.TipoDeContrato;
import com.br.zup.vicente_imoveis.Morador.Morador;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class ImovelEntradaDTO {

    private double valor;
    private String tipoDeImovel;
    private List<Morador> moradores;
    private int qtdBanheiros;
    private Endereco endereco;
    private double metragem;
    private TipoDeContrato tipoDeContrato;
    private boolean ocupado;

    public ImovelEntradaDTO(double valor, String tipoDeImovel, int qtdBanheiros,
                            Endereco endereco, double metragem, TipoDeContrato tipoDeContrato, boolean ocupado) {
        this.valor = valor;
        this.tipoDeImovel = tipoDeImovel;
        this.qtdBanheiros = qtdBanheiros;
        this.endereco = endereco;
        this.metragem = metragem;
        this.tipoDeContrato = tipoDeContrato;
        this.ocupado = ocupado;
    }
}
