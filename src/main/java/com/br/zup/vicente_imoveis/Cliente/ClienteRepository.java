package com.br.zup.vicente_imoveis.Cliente;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteRepository extends CrudRepository<Cliente, String> {
    List<Cliente> findAllByCpf (String cpf);
}
