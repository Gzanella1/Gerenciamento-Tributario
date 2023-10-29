package com.GerenciamentoTributario.models.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "iptu")
public class IptuEntity extends TributoEntity{
    @Column(name = "anoCompetencia")
    private String anoCompetencia;
}
