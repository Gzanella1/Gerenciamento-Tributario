package com.GerenciamentoTributario.models.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="contribuinte")
public class ContribuinteEntity {

    @Id
    @Column(name = "codigoContribuinte")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String codigoContribuinte;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "nome")
    private String nome;
    @Column(name = "telefone")
    private int telefone;
    @Column(name = "email")
    private String email;


}
