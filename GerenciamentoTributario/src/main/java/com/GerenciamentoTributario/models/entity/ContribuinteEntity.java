package com.GerenciamentoTributario.models.entity;

import javax.persistence.*;

@Entity
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



    //Getters e Setters
    public String getCodigoContribuinte() {
        return codigoContribuinte;
    }

    public void setCodigoContribuinte(String codigoContribuinte) {
        this.codigoContribuinte = codigoContribuinte;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
