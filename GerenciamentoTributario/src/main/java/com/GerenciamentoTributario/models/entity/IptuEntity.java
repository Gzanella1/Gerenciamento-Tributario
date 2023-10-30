package com.GerenciamentoTributario.models.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "iptu")
public class IptuEntity extends TributoEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    @Column(name = "anoCompetencia")
    private String anoCompetencia;

    public IptuEntity(int id, LocalDateTime dataLancamento, String valor, String anoCompetencia) {
        super(dataLancamento, valor);
        this.anoCompetencia = anoCompetencia;
    }
}
