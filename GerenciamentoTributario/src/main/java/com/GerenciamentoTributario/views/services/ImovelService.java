package com.GerenciamentoTributario.views.services;

import com.GerenciamentoTributario.models.dto.ImovelDTO;
import com.GerenciamentoTributario.models.entity.ImovelEntity;
import com.GerenciamentoTributario.views.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImovelService {

    @Autowired
    private static ImovelRepository imovelRepository;

    public static void addImovel(ImovelDTO imovelDTO) {

    }
}
