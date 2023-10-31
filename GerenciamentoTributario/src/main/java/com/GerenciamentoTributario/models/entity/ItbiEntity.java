package com.GerenciamentoTributario.models.entity;

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
    @Column(name = "dataTransferencia")
    private LocalDateTime dataTransferencia;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "proprietarioAtual_id")
    private ContribuinteEntity proprietarioAtual;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "novoProprietario_id")
    private ContribuinteEntity novoProprietario;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "imovel_id")
    private ImovelEntity imovel;
}
