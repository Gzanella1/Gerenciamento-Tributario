package com.GerenciamentoTributario.views.services;

import com.GerenciamentoTributario.models.dto.ContribuinteDTO;
import com.GerenciamentoTributario.models.dto.ImovelDTO;
import com.GerenciamentoTributario.models.dto.IptuDTO;
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
import java.util.stream.Collectors;

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

    public List<ItbiDTO> buscaItbi() {
    return itbiRepository.findAll().stream().map(itbiEntity -> {
        ItbiDTO dto=new ItbiDTO();
        dto.setDataLancamento(itbiEntity.getDataLancamento());
        dto.setValor(itbiEntity.getValor());
        dto.setDataTransferencia(itbiEntity.getDataTransferencia());

        ImovelEntity imovel = itbiEntity.getImovel();
        ImovelDTO imovelDTO = new ImovelDTO();
        imovelDTO.setCodigoImovel(imovel.getCodigoImovel());
        imovelDTO.setDataInscricao(imovel.getDataInscricao());
        imovelDTO.setArea(imovel.getArea());
        imovelDTO.setValorVenal(imovel.getValorVenal());
        imovelDTO.setTipoImovel(imovel.getTipoImovel());

        ContribuinteEntity contribuinte = imovel.getProprietario();
        ContribuinteDTO contribuinteDTO = new ContribuinteDTO();
        contribuinteDTO.setCodigoContribuinte(contribuinte.getCodigoContribuinte());
        contribuinteDTO.setCpf(contribuinte.getCodigoContribuinte());
        contribuinteDTO.setEmail(contribuinte.getEmail());
        contribuinteDTO.setNome(contribuinte.getNome());
        contribuinteDTO.setTelefone(contribuinte.getTelefone());

        dto.setImovel(imovelDTO);
        dto.setProprietarioAtual(contribuinteDTO);
        dto.setNovoProprietario(contribuinteDTO);

        return dto;
    }).collect(Collectors.toList());
    }

}


