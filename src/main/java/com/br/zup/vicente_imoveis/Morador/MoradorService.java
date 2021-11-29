package com.br.zup.vicente_imoveis.Morador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoradorService {
    @Autowired
    MoradorRepository moradorRepository;

    public Morador salvarMorador(Morador morador){
        return moradorRepository.save(morador);
    }

    public List<Morador> exibirMoradoresCadastrados(){
        Iterable<Morador> moradores = moradorRepository.findAll();
        return (List<Morador>) moradores;
    }

    public void deletarMorador(String cpf){
        moradorRepository.deleteById(cpf);
    }
}
