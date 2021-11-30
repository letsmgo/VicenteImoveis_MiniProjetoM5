package com.br.zup.vicente_imoveis.Contrato;

import com.br.zup.vicente_imoveis.Imovel.ImovelService;
import com.br.zup.vicente_imoveis.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContratoService {
    @Autowired
    ContratoRepository contratoRepository;
    @Autowired
    ImovelService imovelService;
    @Autowired
    ClienteService clienteService;

}
