package com.GerenciamentoTributario.controllers;

import com.GerenciamentoTributario.models.dto.ImovelDTO;
import com.GerenciamentoTributario.views.services.ImovelService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/imovel")
public class ImovelController {
    @PostMapping("")
    public void addImovel(@RequestBody ImovelDTO imovelDTO) {
        ImovelService.addImovel(imovelDTO);
    }

}
