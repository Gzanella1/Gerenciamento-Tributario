package com.GerenciamentoTributario.models.dto;

import lombok.Data;
@Data
//@Data gera os getter es setters dos atributos
public class ContribuinteDTO{
        private String codigoContribuinte;
        private String cpf;
        private String nome;
        private int telefone;
        private String email;
}
