package com.GerenciamentoTributario.controllers;

import com.GerenciamentoTributario.models.dto.IptuDTO;
import com.GerenciamentoTributario.models.dto.ItbiDTO;
import com.GerenciamentoTributario.views.services.IptuService;
import com.GerenciamentoTributario.views.services.ItbiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TributosController {


    @Autowired
    private IptuService iptuService;
    @Autowired
    private ItbiService itbiService;

    @PostMapping("/iptu")
    public void cadastrarIptu(@RequestBody IptuDTO iptuDTO ) {
        iptuService.cadastrarIptu(iptuDTO);
    }

    @PostMapping("/itbi")
    public void cadastrarItbi(@RequestBody ItbiDTO iptuDTO) {
        itbiService.cadastrarItbi(iptuDTO);
    }
}
