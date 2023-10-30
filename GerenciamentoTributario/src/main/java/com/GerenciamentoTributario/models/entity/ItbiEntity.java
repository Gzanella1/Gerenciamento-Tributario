package com.GerenciamentoTributario.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "itbi")
public class ItbiEntity extends TributoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    @Column(name = "proprietarioAtual")
    private String proprietarioAtual;
    @Column(name = "novoProprietario")
    private String novoProprietario;
    @Column(name = "dataTransferencia")
    private LocalDateTime dataTransferencia;


    public ItbiEntity(LocalDateTime dataLancamento, String valor, String proprietarioAtual, String novoProprietario, LocalDateTime dataTransferencia) {
        super(dataLancamento, valor);
        this.proprietarioAtual = proprietarioAtual;
        this.novoProprietario = novoProprietario;
        this.dataTransferencia = dataTransferencia;
    }
}
