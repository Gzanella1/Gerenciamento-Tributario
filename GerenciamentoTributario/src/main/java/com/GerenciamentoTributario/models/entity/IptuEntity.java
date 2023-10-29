package com.GerenciamentoTributario.models.entity;

import com.GerenciamentoTributario.models.entity.TributoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="iptu")
public class IptuEntity extends TributoEntity {
    @Column(name = "anoCompetencia")
    private String anoCompetencia;

    public IptuEntity(String id, LocalDateTime dataLancamento, double valor, String anoCompetencia) {
        super(id, dataLancamento, valor);
        this.anoCompetencia = anoCompetencia;
    }
}

