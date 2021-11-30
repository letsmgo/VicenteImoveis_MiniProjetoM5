package com.br.zup.vicente_imoveis.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> exibirClientesCadastrados() {
        Iterable<Cliente> clientes = clienteRepository.findAll();
        return (List<Cliente>) clientes;
    }

    public Cliente buscarClientePorID(String id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()) {
            throw new RuntimeException("Cliente não encontrado");
        }
        return cliente.get();
    }

    public void deletarCliente(String cpf) {
        clienteRepository.deleteById(cpf);
    }

    public Cliente atualizarCliente(String cpf, ClienteAtualizarDTO clienteAtualizarDTO){
        Optional<Cliente> cliente = clienteRepository.findById(cpf);
        if (cliente.isEmpty()){
            throw new RuntimeException("Cliente não cadastrado, por gentileza efetue o cadastro primeiro.");

        }
        Cliente clienteParaAtualizar = cliente.get();
        clienteParaAtualizar.setTelefone(clienteAtualizarDTO.getTelefone());

        clienteRepository.save(clienteParaAtualizar);

        return clienteParaAtualizar;

    }

}
