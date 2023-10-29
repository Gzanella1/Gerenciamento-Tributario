package com.GerenciamentoTributario.views.repository;


import com.GerenciamentoTributario.models.entity.TributoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Renomeie TibutoRepository para TributoRepository
@Repository
public interface TributoRepository extends JpaRepository<TributoEntity, String> {
}
