package com.br.zup.vicente_imoveis.Contrato;

import com.br.zup.vicente_imoveis.Contrato.Enums.StatusDoContrato;
import com.br.zup.vicente_imoveis.Custom_exception.ContratoNaoEncontradoException;
import com.br.zup.vicente_imoveis.Custom_exception.TipoDeContratoIndelevelException;
import com.br.zup.vicente_imoveis.Imovel.Enums.StatusImovel;
import com.br.zup.vicente_imoveis.Imovel.Enums.TipoDeContrato;
import com.br.zup.vicente_imoveis.Imovel.Imovel;
import com.br.zup.vicente_imoveis.Imovel.ImovelService;
import com.br.zup.vicente_imoveis.Cliente.Cliente;
import com.br.zup.vicente_imoveis.Cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;


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

    public List<Contrato> exibirContratosCadastrados(){
        Iterable<Contrato> contratos = contratoRepository.findAll();
        return (List<Contrato>) contratos;
    }

    public Contrato localizarContratoPorId(int id){
        Optional<Contrato> contratoOptional = contratoRepository.findById(id);
        if (contratoOptional.isEmpty()){
            throw new ContratoNaoEncontradoException("Contrato não encontrado");
        }
        return contratoOptional.get();
    }

    public Contrato atualizarContrato(int id){
        Contrato contrato = localizarContratoPorId(id);
        if (contrato.getImovel().getTipoDeContrato().equals(TipoDeContrato.ALUGUEL)){
            contrato.setStatusDoContrato(StatusDoContrato.INATIVO);
            contrato.getImovel().setStatusImovel(StatusImovel.DISPONIVEL);
            contrato.setDataTerminoContrato(LocalDate.now());
            contratoRepository.save(contrato);
        }else if (contrato.getImovel().getTipoDeContrato().equals(TipoDeContrato.VENDA)){
            throw new TipoDeContratoIndelevelException("Não é possível encerrar um contrato de venda");
        }
        return contrato;

    }

}
