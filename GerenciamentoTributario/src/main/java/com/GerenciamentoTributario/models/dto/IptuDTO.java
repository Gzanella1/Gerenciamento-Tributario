package com.GerenciamentoTributario.models.dto;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class IptuDTO extends TributoDTO {
    private String anoCompetencia;

    public IptuDTO(String anoCompetencia) {
        this.anoCompetencia = anoCompetencia;
    }
}
