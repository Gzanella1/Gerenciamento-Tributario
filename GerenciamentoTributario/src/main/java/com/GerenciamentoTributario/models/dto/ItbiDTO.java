package com.GerenciamentoTributario.models.dto;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class ItbiDTO {
    private ContribuinteDTO proprietarioAtual;
    private ContribuinteDTO novoProprietario;
    private LocalDateTime dataTransferencia;

    public ItbiDTO(ContribuinteDTO proprietarioAtual, ContribuinteDTO novoProprietario, LocalDateTime dataTransferencia) {
        this.proprietarioAtual = proprietarioAtual;
        this.novoProprietario = novoProprietario;
        this.dataTransferencia = dataTransferencia;
    }
}