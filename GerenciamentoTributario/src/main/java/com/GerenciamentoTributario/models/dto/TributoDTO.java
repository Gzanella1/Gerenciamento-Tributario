package com.GerenciamentoTributario.models.dto;

import com.GerenciamentoTributario.models.entity.ImovelEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public class TributoDTO {

    private LocalDateTime dataLancamento;
    private String valor;
    private ImovelDTO imovel;

}
