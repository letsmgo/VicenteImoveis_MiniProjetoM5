package com.br.zup.vicente_imoveis.Imovel;

import com.br.zup.vicente_imoveis.Imovel.Dtos.ImovelAtualizarDTO;
import com.br.zup.vicente_imoveis.Imovel.Dtos.ImovelEntradaDTO;
import com.br.zup.vicente_imoveis.Imovel.Dtos.ImovelSaidaDTO;
import com.br.zup.vicente_imoveis.Imovel.Enums.StatusImovel;
import com.br.zup.vicente_imoveis.Imovel.Enums.TipoDeContrato;
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
    public List<ImovelSaidaDTO> exibirImoveis(@RequestParam(required = false)TipoDeContrato tipoDeContrato,
                                              @RequestParam(required = false)String tipoDeImovel,
                                              @RequestParam(required = false)StatusImovel statusImovel,
                                              @RequestParam(required = false) Double valor){
        List<ImovelSaidaDTO> imovelSaidaDTOS = new ArrayList<>();
        for (Imovel imovel : imovelService.aplicarFiltroParaBusca(tipoDeContrato, tipoDeImovel, statusImovel,valor)){
            ImovelSaidaDTO exibirImoveisDaBusca = modelMapper.map(imovel, ImovelSaidaDTO.class);
            imovelSaidaDTOS.add(exibirImoveisDaBusca);

        }
        return imovelSaidaDTOS;
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
    public ImovelSaidaDTO atualizarImovel(@PathVariable int id, @RequestBody ImovelAtualizarDTO imovelAtualizarDTO){
        Imovel imovel = imovelService.atualizarImovel(id,imovelAtualizarDTO);

        return modelMapper.map(imovel, ImovelSaidaDTO.class);

    }

}
