package com.prova.domain;

/**
 * Enum com valores do status da licitacao
 */
public enum StatusEnum {
    F("FECHADA"), A("ABERTA");

    private String nome;

    StatusEnum(String nome) {
        this.nome = nome;
    }
}
