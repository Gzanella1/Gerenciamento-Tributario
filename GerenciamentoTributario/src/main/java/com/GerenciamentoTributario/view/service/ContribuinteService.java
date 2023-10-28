package com.GerenciamentoTributario.view.service;

import com.GerenciamentoTributario.models.dto.ContribuinteDTO;
import com.GerenciamentoTributario.models.entity.ContribuinteEntity;
import com.GerenciamentoTributario.view.repository.ContribuinteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContribuinteService {
    @Autowired
    private static ContribuinteRepository contribuinteRepository;

    public static void addContribuicao(ContribuinteDTO contribuinteDTO) {
        ContribuinteEntity cE= new ContribuinteEntity();
        cE.setCpf(contribuinteDTO.getCpf());
        cE.setNome(contribuinteDTO.getNome());
        cE.setEmail(contribuinteDTO.getEmail());
        cE.setTelefone(contribuinteDTO.getTelefone());
        contribuinteRepository.save(cE);
    }
}
