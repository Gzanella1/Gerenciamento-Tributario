package com.GerenciamentoTributario.views.services;

import com.GerenciamentoTributario.models.dto.ItbiDTO;
import com.GerenciamentoTributario.models.entity.ContribuinteEntity;
import com.GerenciamentoTributario.models.entity.ItbiEntity;
import com.GerenciamentoTributario.models.entity.TributoEntity;
import com.GerenciamentoTributario.views.repository.TributoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ItbiService extends TributoService{

    @Autowired
    private TributoRepository tributoRepository;
    public void addTributoItbi(ItbiDTO iptuDTO) {
        ItbiEntity tributo_Itbi=new ItbiEntity();
        tributo_Itbi.setDataTransferencia(iptuDTO.getDataTransferencia());
        tributo_Itbi.setProprietarioAtual(tributo_Itbi.getProprietarioAtual());
        tributo_Itbi.setNovoProprietario(iptuDTO.getNovoProprietario());
        tributo_Itbi.setValor(tributo_Itbi.getValor());
        tributo_Itbi.setDataLancamento(tributo_Itbi.getDataLancamento());
        tributoRepository.save(tributo_Itbi);


    }
}
