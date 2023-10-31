package com.GerenciamentoTributario.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Data gera os getter es setters dos atributos
public class ContribuinteDTO {
    private String codigoContribuinte;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
}
