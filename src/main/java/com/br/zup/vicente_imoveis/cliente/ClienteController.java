package com.br.zup.vicente_imoveis.cliente;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO cadastrarCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        clienteService.salvarCliente(cliente);
        return clienteDTO;
    }

    @GetMapping
    public List<ClienteDTO> exibirClientes() {

        List<ClienteDTO> clientesDTO = new ArrayList<>();

        for (Cliente cliente : clienteService.exibirClientesCadastrados()) {
            ClienteDTO clienteDTO = new ClienteDTO(cliente.getCpf(), cliente.getNome(),
                    cliente.getTelefone());
            clientesDTO.add(clienteDTO);
        }
        return clientesDTO;
    }
  
    @GetMapping(path = {("/{id}")})
    public ClienteSaidaDTO exibirCliente (@PathVariable String id){
        Cliente cliente = clienteService.buscarClientePorID(id);
        return modelMapper.map(cliente, ClienteSaidaDTO.class);
    }

   @DeleteMapping(path = {"/{cpf}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCliente(@PathVariable String cpf){
        clienteService.deletarCliente(cpf);
    }

    @PutMapping(path = {"/{cpf}"})
    public ClienteSaidaDTO atualizarCliente(@PathVariable String cpf, @RequestBody ClienteAtualizarDTO clienteAtualizarDTO){
        Cliente cliente = clienteService.atualizarCliente(cpf, clienteAtualizarDTO);

        return modelMapper.map(cliente, ClienteSaidaDTO.class);
    }

}
