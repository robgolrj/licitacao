package com.prova.domain;

/**
 * Enum com valores do status da licitacao
 */
public enum StatusEnum {
    F("FECHADA");

    private String nome;

    StatusEnum(String nome) {
        this.nome = nome;
    }
}
