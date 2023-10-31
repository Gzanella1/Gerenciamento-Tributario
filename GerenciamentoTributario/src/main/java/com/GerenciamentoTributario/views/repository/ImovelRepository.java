package com.GerenciamentoTributario.views.repository;

import com.GerenciamentoTributario.models.entity.ContribuinteEntity;
import com.GerenciamentoTributario.models.entity.ImovelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImovelRepository extends JpaRepository<ImovelEntity, String> {

    ImovelEntity findByCodigoImovel(String id);
    List<ImovelEntity> findByOrderByCodigoImovelAsc();
    List<ImovelEntity> findByProprietario(ContribuinteEntity contribuinte);
}
