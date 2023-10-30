package com.GerenciamentoTributario.views.services;

import com.GerenciamentoTributario.models.dto.ItbiDTO;
import com.GerenciamentoTributario.models.entity.ItbiEntity;
import com.GerenciamentoTributario.views.repository.ItbiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItbiService {
    @Autowired
    private ItbiRepository itbiRepository;

    public void cadastrarItbi(ItbiDTO itbiDTO) {
        ItbiEntity tributoItbi = ItbiEntity.builder()
                .novoProprietario(itbiDTO.getNovoProprietario())
                .proprietarioAtual(itbiDTO.getProprietarioAtual())
                .dataTransferencia(itbiDTO.getDataTransferencia())
                .valor(itbiDTO.getValor())
                .dataLancamento(itbiDTO.getDataLancamento())
                .build();


        itbiRepository.save(tributoItbi);
    }

}
