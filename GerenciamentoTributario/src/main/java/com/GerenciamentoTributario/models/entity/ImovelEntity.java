package com.GerenciamentoTributario.models.entity;

import com.GerenciamentoTributario.enums.MenuTipoImovel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "imovel")
public class ImovelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "codigoImovel")
    private String codigoImovel;
    @Column(name = "dataInscricao")
    private LocalDateTime dataInscricao;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "contribuinte_id")
    private ContribuinteEntity proprietario;

    @Column(name = "area")
    private double area;
    @Column(name = "valorVenal")
    private double valorVenal;
    @Column(name = "tipoImovel")
    private MenuTipoImovel tipoImovel;

}
