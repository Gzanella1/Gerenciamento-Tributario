package com.GerenciamentoTributario.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TributoEntity {

    @Column(name = "dataLancamento")
    protected LocalDateTime dataLancamento;
    @Column(name = "valor")
    public String valor;


}
