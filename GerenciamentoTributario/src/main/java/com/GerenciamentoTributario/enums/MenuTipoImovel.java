package com.GerenciamentoTributario.enums;

public enum MenuTipoImovel {
    LOTE("lote"),
    CASA("casa"),
    CONDOMINIO("condomínio"),
    COMERCIO("comércio");

    private String descricao;

    MenuTipoImovel(String descricao) {
        this.descricao = descricao;
    }
}
