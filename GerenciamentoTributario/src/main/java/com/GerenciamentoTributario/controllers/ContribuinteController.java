package com.GerenciamentoTributario.controllers;

import com.GerenciamentoTributario.models.dto.ContribuinteDTO;
import com.GerenciamentoTributario.view.service.ContribuinteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/contribuinte")
public class ContribuinteController {

    @PostMapping("/")
    public void addContribuinte(@RequestBody ContribuinteDTO contribuinteDTO) {
        ContribuinteService.addContribuicao(contribuinteDTO);
    }
}
