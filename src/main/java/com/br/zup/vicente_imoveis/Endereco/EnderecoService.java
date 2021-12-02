package com.br.zup.vicente_imoveis.Endereco;

import com.br.zup.vicente_imoveis.Imovel.Imovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;

    public Endereco salvarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> exibirEnderecosCadastrados() {
        Iterable<Endereco> endereco = enderecoRepository.findAll();
        return (List<Endereco>) endereco;
    }

    public boolean enderecoExiste(Endereco enderecoEntrada) {
        boolean enderecoexiste = false;
        for (Endereco endereco : exibirEnderecosCadastrados()) {
            if (enderecoEntrada.equals(endereco)){
                enderecoexiste = true;
            }
        }
        return enderecoexiste;
    }


}
