package com.GerenciamentoTributario.controllers;

import com.GerenciamentoTributario.models.dto.ImovelDTO;
import com.GerenciamentoTributario.models.entity.ImovelEntity;
import com.GerenciamentoTributario.views.services.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/imovel")
public class ImovelController {
    @Autowired
    private ImovelService imovelService;

    @PostMapping
    public void cadastroImovel(@RequestBody ImovelDTO imovelDTO) {
        imovelService.cadastroImovel(imovelDTO);
    }

    @GetMapping("/todos")
    public List<ImovelEntity> buscarImoveisOrdenadosPorCodigo() {
        return imovelService.buscarImoveisOrdenadosPorCodigo();
    }

    @GetMapping("/busca")
    public List<ImovelDTO> buscarImoveisPorContribuinte(@RequestParam(name = "codigoContribuinte") String codigoContribuinte) {
        return imovelService.buscarImoveisPorContribuinte(codigoContribuinte);
    }
}
