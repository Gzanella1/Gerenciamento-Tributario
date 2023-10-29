package com.GerenciamentoTributario.views.services;

import com.GerenciamentoTributario.models.dto.TributoDTO;
import com.GerenciamentoTributario.models.entity.TributoEntity;
import com.GerenciamentoTributario.views.repository.TributoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TributoService{

    @Autowired
    private TributoRepository tributoRepository;

//    public List<TributoDTO> consultaTributos(){
//        return tributoRepository.findAll().stream().map(tributos->{
//            TributoDTO tdto=new TributoDTO();
//            tdto.setDataLancamento(tributos.getDataLancamento());
//            tdto.setValor(tributos.getValor());
//        })
//    }
}
