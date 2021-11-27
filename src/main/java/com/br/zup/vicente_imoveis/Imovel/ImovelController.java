package com.br.zup.vicente_imoveis.Imovel;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/imoveis")
public class ImovelController {

    @Autowired
    ImovelService imovelService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ImovelEntradaDTO cadastrarImovel(@RequestBody ImovelEntradaDTO imovelEntradaDTO){
        Imovel imovel = modelMapper.map(imovelEntradaDTO, Imovel.class);
        imovelService.salvarImovel(imovel);
        return imovelEntradaDTO;
    }

}
