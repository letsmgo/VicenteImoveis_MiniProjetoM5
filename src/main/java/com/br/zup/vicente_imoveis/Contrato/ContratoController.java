package com.br.zup.vicente_imoveis.Contrato;

import com.br.zup.vicente_imoveis.Contrato.dto.ContratoEntradaDTO;
import com.br.zup.vicente_imoveis.Contrato.dto.ContratoSaidaDTO;
import com.br.zup.vicente_imoveis.Imovel.ImovelService;
import com.br.zup.vicente_imoveis.cliente.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contratos")
public class ContratoController {
    @Autowired
    ContratoService contratoService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContratoSaidaDTO salvarContrato(@RequestBody ContratoEntradaDTO contratoEntradaDTO){
        Contrato contrato = contratoService.salvarContrato(contratoEntradaDTO.getId_imovel(),
                contratoEntradaDTO.getId_morador());
        return modelMapper.map(contrato, ContratoSaidaDTO.class);
    }

}