package com.GerenciamentoTributario.views.services;

import com.GerenciamentoTributario.models.dto.ContribuinteDTO;
import com.GerenciamentoTributario.models.entity.ContribuinteEntity;
import com.GerenciamentoTributario.views.repository.ContribuinteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContribuinteService {

    @Autowired
    private ContribuinteRepository contribuinteRepository;

    public void addContribuinte(ContribuinteDTO contribuinteDTO) {
        ContribuinteEntity contribuinte = ContribuinteEntity.builder()
                .codigoContribuinte(contribuinteDTO.getCodigoContribuinte())
                .nome(contribuinteDTO.getNome())
                .cpf(contribuinteDTO.getCpf())
                .email(contribuinteDTO.getEmail())
                .telefone(contribuinteDTO.getTelefone())
                .build();
        contribuinteRepository.save(contribuinte);
    }
}
