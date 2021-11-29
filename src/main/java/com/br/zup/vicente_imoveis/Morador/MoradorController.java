package com.br.zup.vicente_imoveis.Morador;

import com.br.zup.vicente_imoveis.Imovel.Imovel;
import com.br.zup.vicente_imoveis.Imovel.ImovelSaidaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/moradores")
public class MoradorController {

    @Autowired
    MoradorService moradorService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MoradorDTO cadastrarMorador(@RequestBody MoradorDTO moradorDTO) {
        Morador morador = modelMapper.map(moradorDTO, Morador.class);
        moradorService.salvarMorador(morador);
        return moradorDTO;
    }

    @GetMapping
    public List<MoradorDTO> exibirMoradores() {

        List<MoradorDTO> moradoresDTO = new ArrayList<>();

        for (Morador morador : moradorService.exibirMoradoresCadastrados()) {
            MoradorDTO moradorDTO = new MoradorDTO(morador.getCpf(), morador.getNome(),
                    morador.getTelefone(), morador.getDataDeEntradaNoImovel());
            moradoresDTO.add(moradorDTO);
        }
        return moradoresDTO;
    }

    @GetMapping(path = {("/{cpf}")})
    public MoradorDTO exibirMorador (@PathVariable String cpf){
        Morador morador= moradorService.buscarMoradorPorID(cpf);
        return modelMapper.map(morador,MoradorDTO.class);
    }

}
