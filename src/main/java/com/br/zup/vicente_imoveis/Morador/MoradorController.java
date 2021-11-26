package com.br.zup.vicente_imoveis.Morador;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/moradores")
public class MoradorController {

    @Autowired
    MoradorService moradorService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MoradorDTO cadastrarMorador(@RequestBody MoradorDTO moradorDTO){
        Morador morador = modelMapper.map(moradorDTO, Morador.class);
        moradorService.salvarMorador(morador);
        return moradorDTO;
    }
}
