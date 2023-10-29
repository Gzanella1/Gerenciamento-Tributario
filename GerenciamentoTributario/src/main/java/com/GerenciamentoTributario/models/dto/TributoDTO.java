package com.GerenciamentoTributario.models.dto;

import com.GerenciamentoTributario.models.entity.ImovelEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public class TributoDTO {
    protected LocalDateTime dataLancamento;
    protected String valor;
    protected ImovelEntity imovel;
}
