package com.GerenciamentoTributario.controllers;

import com.GerenciamentoTributario.models.dto.ContribuinteDTO;
import com.GerenciamentoTributario.models.dto.ImovelDTO;
import com.GerenciamentoTributario.views.services.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/imovel")
public class ImovelController {
    @Autowired
    private ImovelService imovelService;

    @PostMapping
    public void cadastroContribuinte(@RequestBody ImovelDTO imovelDTO) {
        imovelService.cadastroImovel(imovelDTO);
    }

}
