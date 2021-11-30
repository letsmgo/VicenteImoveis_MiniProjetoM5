package com.br.zup.vicente_imoveis.Imovel;

import com.br.zup.vicente_imoveis.Endereco.EnderecoRepository;
import com.br.zup.vicente_imoveis.Imovel.Enums.StatusImovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImovelService {

    @Autowired
    ImovelRepository imovelRepository;
    @Autowired
    EnderecoRepository enderecoRepository;

    public Imovel salvarImovel(Imovel imovel){
        enderecoRepository.save(imovel.getEndereco());
        imovel.setStatusImovel(StatusImovel.DISPONIVEL);
        return imovelRepository.save(imovel);
    }

    public List<Imovel> exibirImoveisCadastrados(){
        Iterable<Imovel> imoveis = imovelRepository.findAll();
        return (List<Imovel>) imoveis;
    }

    public Imovel buscarImovelPorID(int id){
        Optional<Imovel> imovel=imovelRepository.findById(id);
        if (imovel.isEmpty()){
            throw new RuntimeException("Imovel não encontrado");
        }
        return imovel.get();
    }

    public void deletarImovel(int id){
        imovelRepository.deleteById(id);
    }

    public Imovel atualizarImovel(int id, ImovelAtualizarDTO imovelEntrada){
        Optional<Imovel> imovel = imovelRepository.findById(id);
        if (imovel.isEmpty()){
            throw new RuntimeException("Imóvel não cadastrado, por gentileza efetue o cadastro primeiro.");
        }

        Imovel imovelParaAtualizar = imovel.get();
        imovelParaAtualizar.setValor(imovelEntrada.getValor());
        imovelParaAtualizar.setTipoDeImovel(imovelEntrada.getTipoDeImovel());
        imovelParaAtualizar.setQtdBanheiros(imovelEntrada.getQtdBanheiros());
        imovelParaAtualizar.setMetragem(imovelEntrada.getMetragem());
        imovelParaAtualizar.setTipoDeContrato(imovelEntrada.getTipoDeContrato());

        imovelRepository.save(imovelParaAtualizar);
        return imovelParaAtualizar;

    }

}
