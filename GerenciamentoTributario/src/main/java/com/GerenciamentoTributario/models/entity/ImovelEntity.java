package com.GerenciamentoTributario.models.entity;

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
public class ImovelEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "codigoImovel")
    private String codigoImovel;

    @OneToOne
    @Column(name = "proprietario")
    @JoinColumn(name = "codigoContribuinte")
    private ContribuinteEntity proprietario;

}
