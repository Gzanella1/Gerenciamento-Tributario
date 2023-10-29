package com.GerenciamentoTributario.controllers;

import com.GerenciamentoTributario.models.dto.IptuDTO;
import com.GerenciamentoTributario.models.dto.ItbiDTO;
import com.GerenciamentoTributario.views.services.IptuService;
import com.GerenciamentoTributario.views.services.ItbiService;
import com.GerenciamentoTributario.views.services.TributoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TributosController {

    private final TributoService tributoService;

    @Autowired
    private IptuService iptuService;

    @Autowired
    private ItbiService itbiService;

    public TributosController(TributoService tributoService) {
        this.tributoService = tributoService;
    }

    @PostMapping("/iptu")
    public void cadastrarIptu(@RequestBody IptuDTO iptu) {
        iptuService.addTributoIptu(iptu);
    }

    @PostMapping("/itbi")
    public void cadastrarItbi(@RequestBody ItbiDTO iptuDTO) {
        itbiService.addTributoItbi(iptuDTO);
    }
}
