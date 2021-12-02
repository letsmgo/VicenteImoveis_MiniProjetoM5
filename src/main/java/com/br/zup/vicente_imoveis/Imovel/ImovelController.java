package com.br.zup.vicente_imoveis.Imovel;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ImovelEntradaDTO cadastrarImovel(@RequestBody @Valid ImovelEntradaDTO imovelEntradaDTO){
        Imovel imovel = modelMapper.map(imovelEntradaDTO, Imovel.class);
        imovelService.salvarImovel(imovel);
        return imovelEntradaDTO;
    }

    @GetMapping
    public List<ImovelSaidaDTO> exibirImoveis(){
        List<ImovelSaidaDTO> imoveisDTO = new ArrayList<>();

        for (Imovel imovel: imovelService.exibirImoveisCadastrados()){
            ImovelSaidaDTO imovelDTO = new ImovelSaidaDTO(imovel.getId(), imovel.getValor(), imovel.getTipoDeImovel(), imovel.getQtdBanheiros(), imovel.getEndereco(), imovel.getMetragem(),
                    imovel.getTipoDeContrato());
            imoveisDTO.add(imovelDTO);
        }
        return imoveisDTO;
    }

    @GetMapping(path = {("/{id}")})
    public ImovelSaidaDTO exibirImovel (@PathVariable int id){
        Imovel imovel= imovelService.buscarImovelPorID(id);
        return modelMapper.map(imovel,ImovelSaidaDTO.class);
    }

    @DeleteMapping(path = {"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarImovel(@PathVariable int id){
        imovelService.deletarImovel(id);
    }

    @PutMapping(path = {"/{id}"})
    public ImovelSaidaDTO atualizarImovel(@PathVariable int id, @RequestBody @Valid ImovelAtualizarDTO imovelAtualizarDTO){
        Imovel imovel = imovelService.atualizarImovel(id,imovelAtualizarDTO);

        return modelMapper.map(imovel, ImovelSaidaDTO.class);

    }

}
