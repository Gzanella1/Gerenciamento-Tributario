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

    public void cadastrarItbi(ItbiDTO itbiDTO){
        ItbiEntity tributoItbi=new ItbiEntity();
        tributoItbi.setDataTransferencia(itbiDTO.getDataTransferencia());
        tributoItbi.setValor(itbiDTO.getValor());
        tributoItbi.setDataLancamento(itbiDTO.getDataLancamento());
        tributoItbi.setProprietarioAtual(itbiDTO.getProprietarioAtual());
        tributoItbi.setNovoProprietario(itbiDTO.getNovoProprietario());
        //ta faltando o imovel
        itbiRepository.save(tributoItbi);
    }

}
