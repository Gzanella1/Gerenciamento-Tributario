package com.GerenciamentoTributario.Enum;

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
