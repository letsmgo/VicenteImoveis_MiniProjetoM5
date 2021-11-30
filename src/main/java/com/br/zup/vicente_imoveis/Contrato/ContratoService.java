package com.br.zup.vicente_imoveis.Contrato;

import com.br.zup.vicente_imoveis.Contrato.enun.StatusDoContrato;
import com.br.zup.vicente_imoveis.Imovel.Enums.StatusImovel;
import com.br.zup.vicente_imoveis.Imovel.Enums.TipoDeContrato;
import com.br.zup.vicente_imoveis.Imovel.Imovel;
import com.br.zup.vicente_imoveis.Imovel.ImovelService;
import com.br.zup.vicente_imoveis.cliente.Cliente;
import com.br.zup.vicente_imoveis.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ContratoService {
    @Autowired
    ContratoRepository contratoRepository;
    @Autowired
    ImovelService imovelService;
    @Autowired
    ClienteService clienteService;

    public Contrato salvarContrato(int id_imovel, String id_Cliente) {
        Imovel imovel = imovelService.buscarImovelPorID(id_imovel);
        Cliente cliente = clienteService.buscarClientePorID(id_Cliente);
        Contrato contrato = new Contrato();
        contrato.setImovel(imovel);
        contrato.setCliente(cliente);
        contrato.setDataDoContrato(LocalDate.now());

        if (imovel.getTipoDeContrato().equals(TipoDeContrato.ALUGUEL)) {
            imovel.setStatusImovel(StatusImovel.ALUGADO);
        } else if (imovel.getTipoDeContrato().equals(TipoDeContrato.VENDA)) {
            imovel.setStatusImovel(StatusImovel.VENDIDO);
        }

        contrato.setStatusDoContrato(StatusDoContrato.ATIVO);
        return contratoRepository.save(contrato);
    }


}
