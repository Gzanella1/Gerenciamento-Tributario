package com.GerenciamentoTributario.models.dto;

import com.GerenciamentoTributario.models.entity.ContribuinteEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ItbiDTO extends TributoDTO{
    private String proprietarioAtual;
    private String novoProprietario;
    private LocalDateTime dataTransferencia;
}
