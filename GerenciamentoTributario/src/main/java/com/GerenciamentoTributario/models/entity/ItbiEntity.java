package com.GerenciamentoTributario.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "itbi")
public class ItbiEntity extends TributoEntity {

    @Column(name = "proprietarioAtual")
    private String proprietarioAtual;

    @Column(name = "novoProprietario")
    private String novoProprietario;

    @Column(name = "dataTransferencia")
    private LocalDateTime dataTransferencia;
}
