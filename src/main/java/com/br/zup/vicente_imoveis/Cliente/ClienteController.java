package com.br.zup.vicente_imoveis.Cliente;

import com.br.zup.vicente_imoveis.Cliente.Dtos.ClienteAtualizarDTO;
import com.br.zup.vicente_imoveis.Cliente.Dtos.ClienteDTO;
import com.br.zup.vicente_imoveis.Cliente.Dtos.ClienteSaidaDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
@Api(value = "Gerenciador de clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    ClienteService clienteService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    @ApiOperation(value = "Cadastrar cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO cadastrarCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        clienteService.salvarCliente(cliente);
        return clienteDTO;
    }

    @GetMapping
    @ApiOperation(value = "Exibir clientes")
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
    @ApiOperation(value = "Exibir cliente por CPF")
    public ClienteSaidaDTO exibirCliente (@PathVariable String id){
        Cliente cliente = clienteService.buscarClientePorID(id);
        return modelMapper.map(cliente, ClienteSaidaDTO.class);
    }

   @DeleteMapping(path = {"/{cpf}"})
   @ApiOperation(value = "Deletar cadastro cliente")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCliente(@PathVariable String cpf){
        clienteService.deletarCliente(cpf);
    }

    @PutMapping(path = {"/{cpf}"})
    @ApiOperation(value = "Atualizar dados cliente")
    public ClienteSaidaDTO atualizarCliente(@PathVariable String cpf, @RequestBody ClienteAtualizarDTO clienteAtualizarDTO){
        Cliente cliente = clienteService.atualizarCliente(cpf, clienteAtualizarDTO);

        return modelMapper.map(cliente, ClienteSaidaDTO.class);
    }

}
