package com.br.zup.vicente_imoveis.Contrato;

import com.br.zup.vicente_imoveis.Cliente.Cliente;
import com.br.zup.vicente_imoveis.Contrato.Enums.StatusDoContrato;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContratoRepository extends CrudRepository<Contrato, Integer> {
    List<Contrato> findAllByClienteCpf(String cpf);

    List<Contrato> findAllByStatusDoContrato(StatusDoContrato statusDoContrato);

    List<Contrato> findAllByImovelId(Integer id_imovel);

    @Query(value = "SELECT * FROM contratos WHERE " +
            "status_do_contrato =:statusDoContrato AND cliente_cpf = :cpf AND imovel_id = :idImovel",
            nativeQuery = true)
    List<Contrato> findAllByStatusDoContratoEClienteCpfEImovelId(String statusDoContrato,
                                                                 String cpf, Integer idImovel);

    @Query(value = "SELECT * FROM contratos WHERE cliente_cpf = :cpf AND imovel_id = :idImovel", nativeQuery = true)
    List<Contrato> findAllByClienteCpfEImovelId(String cpf, Integer idImovel);

    @Query(value = "SELECT * FROM contratos WHERE status_do_contrato =:statusDoContrato AND cliente_cpf = :cpf",
            nativeQuery = true)
    List<Contrato> findAllByStatusDoContratoEClienteCpf(StatusDoContrato statusDoContrato,
                                                        String cpf);

    @Query(value = "SELECT * FROM contratos WHERE " +
            "status_do_contrato =:statusDoContrato AND imovel_id = :idImovel",
            nativeQuery = true)
    List<Contrato> findAllByStatusDoContratoEImovelId(StatusDoContrato statusDoContrato, Integer idImovel);

}
