package com.GerenciamentoTributario.models.entity;

import com.GerenciamentoTributario.Enum.MenuTipoImovel;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
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




    //Getters e Setters
    public String getCodigoImovel() {
        return codigoImovel;
    }

    public void setCodigoImovel(String codigoImovel) {
        this.codigoImovel = codigoImovel;
    }

    public LocalDateTime getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(LocalDateTime dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getValorVenal() {
        return valorVenal;
    }

    public void setValorVenal(double valorVenal) {
        this.valorVenal = valorVenal;
    }

    public Enum<MenuTipoImovel> getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(Enum<MenuTipoImovel> tipoImovel) {
        this.tipoImovel = tipoImovel;
    }
}
