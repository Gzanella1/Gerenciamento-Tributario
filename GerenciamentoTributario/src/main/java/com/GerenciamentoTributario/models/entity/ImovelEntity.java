package com.GerenciamentoTributario.models.entity;

import com.GerenciamentoTributario.Enum.MenuTipoImovel;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "imovel")
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

    //VER COM A JESSICA SOBRE O ENUM
    @Column(name = "tipoImovel")
    private Enum<MenuTipoImovel> tipoImovel;



}
