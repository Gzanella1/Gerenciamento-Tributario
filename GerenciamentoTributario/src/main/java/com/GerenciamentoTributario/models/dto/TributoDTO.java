package com.GerenciamentoTributario.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class TributoDTO {

    private LocalDateTime dataLancamento;
    private String valor;
    private ImovelDTO imovel;

}
