package com.br.zup.vicente_imoveis.Imovel;

import com.br.zup.vicente_imoveis.Imovel.Enums.StatusImovel;
import com.br.zup.vicente_imoveis.Imovel.Enums.TipoDeContrato;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ImovelRepository extends CrudRepository<Imovel, Integer> {

    List<Imovel> findAllByTipoDeContrato(TipoDeContrato tipoDeContrato);

    List<Imovel> findAllByTipoDeImovel(String tipoDeImovel);

    List<Imovel> findAllByStatusImovel(StatusImovel statusImovel);

    @Query(value = "SELECT * FROM imoveis WHERE valor BETWEEN :valor*0.7 AND :valor*1.3", nativeQuery = true)
    List<Imovel> findAllByValor(Double valor);

}
