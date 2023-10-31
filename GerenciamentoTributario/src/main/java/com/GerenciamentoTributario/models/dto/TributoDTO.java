package com.GerenciamentoTributario.models.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TributoDTO {
    private LocalDateTime dataLancamento;
    private String valor;
    private ImovelDTO imovel;
}
