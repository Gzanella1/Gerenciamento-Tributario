package com.GerenciamentoTributario.controllers;

import com.GerenciamentoTributario.models.dto.ContribuinteDTO;
import com.GerenciamentoTributario.views.services.ContribuinteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/contribuinte")
public class ContribuinteController {

    @Autowired
    private final ContribuinteService contribuinteService;

    public ContribuinteController(ContribuinteService contribuinteService) {
        this.contribuinteService = contribuinteService;
    }

    @PostMapping
    public void addContribuinte(@RequestBody ContribuinteDTO contribuinteDTO) {
        contribuinteService.addContribuinte(contribuinteDTO);
    }
}
