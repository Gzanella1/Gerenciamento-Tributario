package com.GerenciamentoTributario.models.dto;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class TributoDTO {
    protected  LocalDateTime dataLancamento;
    protected  double valor;

}
