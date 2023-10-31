package com.GerenciamentoTributario.views.services;


import com.GerenciamentoTributario.models.dto.ContribuinteDTO;
import com.GerenciamentoTributario.models.dto.ImovelDTO;
import com.GerenciamentoTributario.models.dto.IptuDTO;
import com.GerenciamentoTributario.models.entity.ContribuinteEntity;
import com.GerenciamentoTributario.models.entity.ImovelEntity;
import com.GerenciamentoTributario.models.entity.IptuEntity;
import com.GerenciamentoTributario.views.repository.ImovelRepository;
import com.GerenciamentoTributario.views.repository.IptuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class IptuService {

    @Autowired
    private IptuRepository iptuRepository;
    @Autowired
    private ImovelRepository imovelRepository;

    public void cadastrarIptu(IptuDTO iptuDTO) {
        ImovelEntity imovel = imovelRepository.findByCodigoImovel(iptuDTO.getImovel().getCodigoImovel());
        IptuEntity tributoIptu = IptuEntity.builder()
                .anoCompetencia(iptuDTO.getAnoCompetencia())
                .valor(iptuDTO.getValor())
                .dataLancamento(iptuDTO.getDataLancamento())
                .imovel(imovel)
                .build();
        iptuRepository.save(tributoIptu);
    }

    public List<IptuDTO> buscaIptu() {
        return iptuRepository.findAll().stream().map(cE -> {

            IptuDTO imDto = new IptuDTO();
            log.info("não pegou as informações no banco");
            imDto.setDataLancamento(cE.getDataLancamento());
            imDto.setAnoCompetencia(cE.getAnoCompetencia());
            imDto.setValor(cE.getValor());

            ImovelEntity imovel = cE.getImovel();
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

            imovelDTO.setProprietario(contribuinteDTO);
            imDto.setImovel(imovelDTO);

            return imDto;
        }).collect(Collectors.toList());
    }
}








