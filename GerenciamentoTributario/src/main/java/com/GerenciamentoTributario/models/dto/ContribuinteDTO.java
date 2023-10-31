package com.GerenciamentoTributario.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
//@Data gera os getter es setters dos atributos
public class ContribuinteDTO {
    private String codigoContribuinte;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;

    public ContribuinteDTO(String codigoContribuinte, String cpf, String nome, String telefone, String email) {
        this.codigoContribuinte = codigoContribuinte;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

}
