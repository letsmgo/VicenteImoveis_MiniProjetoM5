package com.br.zup.vicente_imoveis.Imovel;

import com.br.zup.vicente_imoveis.Endereco.Endereco;
import com.br.zup.vicente_imoveis.Imovel.Enums.TipoDeContrato;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
@Getter
@Setter
public class ImovelSaidaDTO {
    private int id;
    private double valor;
    private String tipoDeImovel;
    private int qtdBanheiros;
    private Endereco endereco;
    private double metragem;
    private TipoDeContrato tipoDeContrato;

    public ImovelSaidaDTO(int id, double valor, String tipoDeImovel, int qtdBanheiros,
                          Endereco endereco, double metragem, TipoDeContrato tipoDeContrato) {
        this.id = id;
        this.valor = valor;
        this.tipoDeImovel = tipoDeImovel;
        this.qtdBanheiros = qtdBanheiros;
        this.endereco = endereco;
        this.metragem = metragem;
        this.tipoDeContrato = tipoDeContrato;
    }

}
