package com.GerenciamentoTributario.models.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ItbiDTO extends TributoDTO {
    private ContribuinteDTO proprietarioAtual;
    private ContribuinteDTO novoProprietario;
    private LocalDateTime dataTransferencia;
}
