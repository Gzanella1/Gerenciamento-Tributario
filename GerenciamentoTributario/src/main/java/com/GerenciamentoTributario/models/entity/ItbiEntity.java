package com.GerenciamentoTributario.models.entity;

import com.GerenciamentoTributario.models.dto.ContribuinteDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="itbi")
public class ItbiEntity extends TributoEntity {

    @Column(name = "proprietarioAtual")
    private ContribuinteDTO proprietarioAtual;
    @Column(name = "novoProprietario")
    private ContribuinteDTO novoProprietario;
    @Column(name = "dataTransferencia")
    private LocalDateTime dataTransferencia;

    public ItbiEntity(String id, LocalDateTime dataLancamento, double valor, ContribuinteDTO proprietarioAtual, ContribuinteDTO novoProprietario, LocalDateTime dataTransferencia) {
        super(id, dataLancamento, valor);
        this.proprietarioAtual = proprietarioAtual;
        this.novoProprietario = novoProprietario;
        this.dataTransferencia = dataTransferencia;
    }
}