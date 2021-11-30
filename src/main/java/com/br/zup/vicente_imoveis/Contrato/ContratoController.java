package com.br.zup.vicente_imoveis.Contrato;

import com.br.zup.vicente_imoveis.Imovel.ImovelService;
import com.br.zup.vicente_imoveis.cliente.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contratos")
public class ContratoController {
    @Autowired
    ContratoService contratoService;
    @Autowired
    ModelMapper modelMapper;

}
