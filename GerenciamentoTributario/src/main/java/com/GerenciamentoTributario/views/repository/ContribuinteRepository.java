package com.GerenciamentoTributario.views.repository;

import com.GerenciamentoTributario.models.entity.ContribuinteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContribuinteRepository extends JpaRepository<ContribuinteEntity, String> {

    ContribuinteEntity findByCodigoContribuinte(String id);
}

