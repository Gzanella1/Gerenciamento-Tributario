package com.GerenciamentoTributario.controllers;

import com.GerenciamentoTributario.models.dto.IptuDTO;
import com.GerenciamentoTributario.models.dto.ItbiDTO;
import com.GerenciamentoTributario.models.entity.ImovelEntity;
import com.GerenciamentoTributario.views.services.IptuService;
import com.GerenciamentoTributario.views.services.ItbiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// A anotação @RestController indica que esta classe é um controlador Spring que lida com solicitações HTTP.
@RestController
@RequestMapping("/tributos")
public class TributosController {

    @Autowired
    private IptuService iptuService;
    @Autowired
    private ItbiService itbiService;

    @PostMapping("/iptu")
    public void cadastrarIptu(@RequestBody IptuDTO iptuDTO) {
        // Chama o método cadastrarIptu no serviço IptuService com os dados recebidos no corpo da solicitação.
        iptuService.cadastrarIptu(iptuDTO);
    }

    @PostMapping("/itbi")
    public void cadastrarItbi(@RequestBody ItbiDTO iptuDTO) {
        // Chama o método cadastrarItbi no serviço ItbiService com os dados recebidos no corpo da solicitação.
        itbiService.cadastrarItbi(iptuDTO);
    }

    @GetMapping("/iptu")
    public List<IptuDTO> retornaTributoIPTU() {
        return iptuService.buscaIptu();
    }

    @GetMapping("/itbi")
    public List<ItbiDTO> retornaTributoITBI() {
        return itbiService.buscaItbi();
    }
}