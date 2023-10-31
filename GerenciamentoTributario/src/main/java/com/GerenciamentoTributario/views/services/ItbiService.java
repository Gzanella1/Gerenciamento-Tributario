package com.GerenciamentoTributario.views.services;

import com.GerenciamentoTributario.models.dto.ItbiDTO;
import com.GerenciamentoTributario.models.entity.ContribuinteEntity;
import com.GerenciamentoTributario.models.entity.ImovelEntity;
import com.GerenciamentoTributario.models.entity.ItbiEntity;
import com.GerenciamentoTributario.views.repository.ContribuinteRepository;
import com.GerenciamentoTributario.views.repository.ImovelRepository;
import com.GerenciamentoTributario.views.repository.ItbiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItbiService {
    @Autowired
    private ItbiRepository itbiRepository;
    @Autowired
    private ImovelRepository imovelRepository;
    @Autowired
    private ContribuinteRepository contribuinteRepository;

    public void cadastrarItbi(ItbiDTO itbiDTO) {
        ImovelEntity imovel = imovelRepository.findByCodigoImovel(itbiDTO.getImovel().getCodigoImovel());
        ContribuinteEntity proprietarioAtual = contribuinteRepository
                .findByCodigoContribuinte(itbiDTO.getProprietarioAtual().getCodigoContribuinte());
        ContribuinteEntity novoProprietario = contribuinteRepository
                .findByCodigoContribuinte(itbiDTO.getNovoProprietario().getCodigoContribuinte());
        ItbiEntity tributoItbi = ItbiEntity.builder()
                .novoProprietario(novoProprietario)
                .proprietarioAtual(proprietarioAtual)
                .dataTransferencia(itbiDTO.getDataTransferencia())
                .valor(itbiDTO.getValor())
                .dataLancamento(itbiDTO.getDataLancamento())
                .imovel(imovel)
                .build();
        itbiRepository.save(tributoItbi);
    }


}
