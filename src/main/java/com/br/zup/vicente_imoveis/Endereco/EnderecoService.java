package com.br.zup.vicente_imoveis.Endereco;

import org.springframework.beans.factory.annotation.Autowired;

public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;

    public Endereco salvarEndereco(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

}
