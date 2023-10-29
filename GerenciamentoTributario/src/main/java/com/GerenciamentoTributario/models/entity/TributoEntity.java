package com.GerenciamentoTributario.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
//Ajuda a construir um objeto se usar get e set
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tributo")
@Data
@MappedSuperclass
public class TributoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected String id;
    @Column(name = "dataLancamento")
    protected  LocalDateTime dataLancamento;
    @Column(name = "valor")
    protected  double valor;
    // Ver com a jessica pois se conecta no imovel
    //private ImovelEntity imovel;


}
