package com.GerenciamentoTributario.views.repository;

import com.GerenciamentoTributario.models.entity.IptuEntity;
import com.GerenciamentoTributario.models.entity.ItbiEntity;
import com.GerenciamentoTributario.models.entity.TributoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItbiRepository extends JpaRepository<ItbiEntity,String> {
}
