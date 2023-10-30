package com.GerenciamentoTributario.models.dto;

import com.GerenciamentoTributario.enums.MenuTipoImovel;
import com.GerenciamentoTributario.models.entity.ContribuinteEntity;
import lombok.Data;


import java.time.LocalDateTime;

@Data
public class ImovelDTO {

    private String codigoImovel ;
    private LocalDateTime dataInscricao;
    private ContribuinteEntity proprietario;
    private double area;
    private double valorVenal;
    private MenuTipoImovel tipoImovel;

}
