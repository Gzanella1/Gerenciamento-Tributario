package com.GerenciamentoTributario.models.dto;

import lombok.Data;


import java.time.LocalDateTime;

@Data
public class ImovelDTO {

    private String codigoImovel ;
    private LocalDateTime dataInscricao;
    private double area;
    private double valorVenal;
    //VER COM A JESSICA SOBRE O ENUM
    //private MenuTipoImovel tipoImovel;

}
