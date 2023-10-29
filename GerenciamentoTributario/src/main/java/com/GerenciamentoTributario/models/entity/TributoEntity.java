package com.GerenciamentoTributario.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class TributoEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    @Column(name = "dataLancamento")
    protected LocalDateTime dataLancamento;
    @Column(name = "valor")
    public String valor;

   // protected ImovelEntity imovel;
}
