package com.GerenciamentoTributario.views.services;

import com.GerenciamentoTributario.models.dto.ContribuinteDTO;
import com.GerenciamentoTributario.models.dto.IptuDTO;
import com.GerenciamentoTributario.models.entity.ContribuinteEntity;
import com.GerenciamentoTributario.models.entity.IptuEntity;
import com.GerenciamentoTributario.views.repository.IptuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class IptuService {

    @Autowired
    private IptuRepository iptuRepository;
    public void cadastrarIptu(IptuDTO iptuDTO) {
        IptuEntity tributoIptu=new IptuEntity();
        tributoIptu.setAnoCompetencia(iptuDTO.getAnoCompetencia());
        tributoIptu.setDataLancamento(iptuDTO.getDataLancamento());
        tributoIptu.setValor(iptuDTO.getValor());
        //ta faltando o Imovel
        iptuRepository.save(tributoIptu);
    }


}
