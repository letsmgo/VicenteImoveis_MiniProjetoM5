package com.br.zup.vicente_imoveis.Imovel;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping
    public List<ImovelSaidaDTO> exibirImoveis(){
        List<ImovelSaidaDTO> imoveisDTO = new ArrayList<>();

        for (Imovel imovel: imovelService.exibirImoveisCadastrados()){
            ImovelSaidaDTO imovelDTO = new ImovelSaidaDTO(imovel.getValor(), imovel.getTipoDeImovel(),
                    imovel.getMoradores(), imovel.getQtdBanheiros(), imovel.getEndereco(), imovel.getMetragem(),
                    imovel.getTipoDeContrato(), imovel.isOcupado());
            imoveisDTO.add(imovelDTO);
        }
        return imoveisDTO;
    }

}
