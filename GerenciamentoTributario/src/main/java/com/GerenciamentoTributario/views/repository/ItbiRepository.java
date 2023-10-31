package com.GerenciamentoTributario.views.repository;

import com.GerenciamentoTributario.models.entity.ItbiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItbiRepository extends JpaRepository<ItbiEntity, Integer> {
}
