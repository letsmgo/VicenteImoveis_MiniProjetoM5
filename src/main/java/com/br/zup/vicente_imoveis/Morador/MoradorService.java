package com.br.zup.vicente_imoveis.Morador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoradorService {
    @Autowired
    MoradorRepository moradorRepository;

    public Morador salvarMorador(Morador morador){
        return moradorRepository.save(morador);
    }
}
