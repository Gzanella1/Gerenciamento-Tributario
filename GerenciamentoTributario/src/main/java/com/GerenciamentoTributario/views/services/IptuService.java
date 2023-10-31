package com.GerenciamentoTributario.views.services;


import com.GerenciamentoTributario.models.dto.ContribuinteDTO;
import com.GerenciamentoTributario.models.dto.ImovelDTO;
import com.GerenciamentoTributario.models.dto.IptuDTO;
import com.GerenciamentoTributario.models.entity.ContribuinteEntity;
import com.GerenciamentoTributario.models.entity.ImovelEntity;
import com.GerenciamentoTributario.models.entity.IptuEntity;
import com.GerenciamentoTributario.views.repository.ImovelRepository;
import com.GerenciamentoTributario.views.repository.IptuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
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

//    public List<IptuDTO> buscaIptu() {
//        return iptuRepository.findAll().stream().map(cE -> {
//           //NÃO PEGOU AS INFORMAÇÕES
//            ContribuinteEntity contribuinte = new ContribuinteEntity();
//            ContribuinteDTO contribuinteDTO = ContribuinteDTO.builder()
//                    .codigoContribuinte(contribuinte.getCodigoContribuinte())
//                    .cpf(contribuinte.getCodigoContribuinte())
//                    .email(contribuinte.getEmail())
//                    .nome(contribuinte.getNome())
//                    .telefone(contribuinte.getTelefone())
//                    .build();
//
//            //PEGOU AS INFORMAÇÕES QUE EU PRECISO
//            ImovelDTO imovelDTO = new ImovelDTO();
//            imovelDTO.setCodigoImovel(cE.getImovel().getCodigoImovel());
//            imovelDTO.setDataInscricao(cE.getImovel().getDataInscricao());
//            imovelDTO.setArea(cE.getImovel().getArea());
//            imovelDTO.setValorVenal(cE.getImovel().getValorVenal());
//            imovelDTO.setTipoImovel(cE.getImovel().getTipoImovel());
//            imovelDTO.setProprietario(contribuinteDTO);
//
//            //NÃO PEGOU AS INFORMAÇÕES
//            IptuDTO imDto = new IptuDTO();
//            imDto.setDataLancamento(cE.getDataLancamento());
//            imDto.setAnoCompetencia(cE.getAnoCompetencia());
//            imDto.setValor(cE.getValor());
//            imDto.setImovel(imovelDTO);
//
//            return imDto;
//        }).collect(Collectors.toList());
//    }



    public List<IptuDTO> buscaIptu() {
        return iptuRepository.findAll().stream().map(cE -> {
            ContribuinteEntity contribuinte = cE.getImovel().getProprietario(); // Obter o proprietário diretamente

            ImovelEntity imovel = cE.getImovel(); // Obter o imóvel diretamente

            IptuDTO imDto = new IptuDTO();
            imDto.setDataLancamento(cE.getDataLancamento());
            imDto.setAnoCompetencia(cE.getAnoCompetencia());
            imDto.setValor(cE.getValor());

            ImovelDTO imovelDTO = new ImovelDTO();
            imovelDTO.setCodigoImovel(imovel.getCodigoImovel());
            imovelDTO.setDataInscricao(imovel.getDataInscricao());
            imovelDTO.setArea(imovel.getArea());
            imovelDTO.setValorVenal(imovel.getValorVenal());
            imovelDTO.setTipoImovel(imovel.getTipoImovel());
            imovelDTO.setProprietario(ContribuinteDTO.builder()
                    .codigoContribuinte(contribuinte.getCodigoContribuinte())
                    .cpf(contribuinte.getCodigoContribuinte())
                    .email(contribuinte.getEmail())
                    .nome(contribuinte.getNome())
                    .telefone(contribuinte.getTelefone())
                    .build());

            imDto.setImovel(imovelDTO);

            return imDto;
        }).collect(Collectors.toList());
    }


}








