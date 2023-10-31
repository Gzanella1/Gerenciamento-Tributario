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
public class IptuEntity extends TributoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    @Column(name = "anoCompetencia")
    private String anoCompetencia;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "imovel_id")
    private ImovelEntity imovel;

    public IptuEntity(LocalDateTime dataLancamento, String valor, int id, String anoCompetencia, ImovelEntity imovel) {
        super(dataLancamento, valor);
        this.id = id;
        this.anoCompetencia = anoCompetencia;
        this.imovel = imovel;
    }
}
