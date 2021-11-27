package com.br.zup.vicente_imoveis.Imovel;

import com.br.zup.vicente_imoveis.Endereco.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImovelService {

    @Autowired
    ImovelRepository imovelRepository;
    @Autowired
    EnderecoRepository enderecoRepository;

    public Imovel salvarImovel(Imovel imovel){
        enderecoRepository.save(imovel.getEndereco());
        return imovelRepository.save(imovel);
    }

    public List<Imovel> exibirImoveisCadastrados(){
        Iterable<Imovel> imoveis = imovelRepository.findAll();
        return (List<Imovel>) imoveis;
    }

}
