package com.GerenciamentoTributario.views.repository;

import com.GerenciamentoTributario.models.entity.IptuEntity;
import com.GerenciamentoTributario.models.entity.TributoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IptuRepository extends JpaRepository<IptuEntity, Integer> {
    List<IptuEntity>findAll();
}
