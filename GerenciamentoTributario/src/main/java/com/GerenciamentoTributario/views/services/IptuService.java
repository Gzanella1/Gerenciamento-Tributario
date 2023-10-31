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

import java.time.LocalDateTime;
import java.util.List;
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


//    public List<IptuDTO> retornaIptu() {
//        return iptuRepository.findAll().stream().map(iptuE ->{
//            IptuDTO iptuDTO = new IptuDTO();
//            iptuDTO.setAnoCompetencia(iptuE.getAnoCompetencia());
//            iptuDTO.setValor(iptuE.getValor());
//            iptuDTO.setDataLancamento(iptuE.getDataLancamento());
//        }).collect(Collectors.toList());
//    }


}








