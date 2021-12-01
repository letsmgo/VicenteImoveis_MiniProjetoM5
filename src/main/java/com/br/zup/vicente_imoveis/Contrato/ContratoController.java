package com.br.zup.vicente_imoveis.Contrato;

import com.br.zup.vicente_imoveis.Contrato.Dtos.ContratoEntradaDTO;
import com.br.zup.vicente_imoveis.Contrato.Dtos.ContratoSaidaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contratos")
public class ContratoController {
    @Autowired
    ContratoService contratoService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContratoSaidaDTO salvarContrato(@RequestBody ContratoEntradaDTO contratoEntradaDTO) {
        Contrato contrato = contratoService.salvarContrato(contratoEntradaDTO.getId_imovel(),
                contratoEntradaDTO.getId_morador());
        return modelMapper.map(contrato, ContratoSaidaDTO.class);
    }

 @GetMapping
    public List<ContratoSaidaDTO> exibirContratos() {
        List<ContratoSaidaDTO> contratosDTO = new ArrayList<>();
        for (Contrato contrato : contratoService.exibirContratosCadastrados()) {
            ContratoSaidaDTO contratoDTO = modelMapper.map(contrato, ContratoSaidaDTO.class);
            contratosDTO.add(contratoDTO);
        }
        return contratosDTO;
    }

    @PutMapping(path = {("/{id}")})
    public ContratoSaidaDTO encerrarContrato(@PathVariable int id) {
        return modelMapper.map((contratoService.atualizarContrato(id)), ContratoSaidaDTO.class);
    }

}



