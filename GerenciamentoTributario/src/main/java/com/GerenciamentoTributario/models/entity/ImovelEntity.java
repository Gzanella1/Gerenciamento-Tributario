package com.GerenciamentoTributario.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Table(name = "imovel")
@Entity
public class ImovelEntity{
    @Id
    @Column(name = "codigoImovel")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String codigoImovel ;
    @Column(name = "dataInscricao")
    private LocalDateTime dataInscricao;
    @Column(name = "area")
    private double area;
    @Column(name = "valorVenal")
    private double valorVenal;
//    @Column(name = "tipoImovel")
//    private MenuTipoImovel tipoImovel;
    @ManyToOne
    @JoinColumn(name = "id")
    private ContribuinteEntity proprietario;
}
