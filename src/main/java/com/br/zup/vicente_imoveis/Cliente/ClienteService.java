package com.br.zup.vicente_imoveis.Cliente;

import com.br.zup.vicente_imoveis.Contrato.Contrato;
import com.br.zup.vicente_imoveis.Contrato.ContratoService;
import com.br.zup.vicente_imoveis.Custom_exception.ClienteNaoEncontradoException;
import com.br.zup.vicente_imoveis.Cliente.Dtos.ClienteAtualizarDTO;
import com.br.zup.vicente_imoveis.Custom_exception.CpfJaCadastradoException;
import com.br.zup.vicente_imoveis.Custom_exception.VinculoContratualClienteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ContratoService contratoService;

    public Cliente salvarCliente(Cliente cliente) {
        if (cpfJaExiste(cliente)){
            throw new CpfJaCadastradoException("CPF já consta no banco de dados, tente acessar as informações do mesmo.");
        }
        return clienteRepository.save(cliente);

    }

    public List<Cliente> exibirClientesCadastrados() {
        Iterable<Cliente> clientes = clienteRepository.findAll();
        return (List<Cliente>) clientes;
    }

    public Cliente buscarClientePorID(String id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()) {
            throw new ClienteNaoEncontradoException("Cliente não encontrado");
        }
        return cliente.get();
    }

    public void deletarCliente(String cpf) {
        Cliente cliente = buscarClientePorID(cpf);
        List<Contrato> contrato = contratoService.localizarContratosPorCpf(cpf);
        if (contrato.isEmpty()) {
            clienteRepository.deleteById(cpf);
        } else {
            throw new VinculoContratualClienteException("Cliente não pode ser deletado pois possui vínculo contratual.");

        }

    }

    public Cliente atualizarCliente(String cpf, ClienteAtualizarDTO clienteAtualizarDTO){
        Optional<Cliente> cliente = clienteRepository.findById(cpf);
        if (cliente.isEmpty()){
            throw new ClienteNaoEncontradoException("Cliente não cadastrado, por gentileza efetue o cadastro primeiro.");

        }
        Cliente clienteParaAtualizar = cliente.get();
        clienteParaAtualizar.setTelefone(clienteAtualizarDTO.getTelefone());

        clienteRepository.save(clienteParaAtualizar);

        return clienteParaAtualizar;

    }


    public boolean cpfJaExiste(Cliente clienteEntrada){
        boolean cpfExiste = false;
        for (Cliente cliente: exibirClientesCadastrados()) {
            if (cliente.getCpf().equalsIgnoreCase(clienteEntrada.getCpf())
                    && cliente.getNome().equalsIgnoreCase(clienteEntrada.getNome())
                        && Objects.equals(cliente.getTelefone(), clienteEntrada.getTelefone())){
                    cpfExiste = true;
                }
            }
        return cpfExiste;
        }

}
