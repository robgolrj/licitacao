package com.prova.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.prova.commom.JsonDateDeserializer;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Classe que representa uma licitacao
 */
public class Licitacao {
    String descricao;
    BigDecimal valorBase;
    BigDecimal valorIncremento;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    Date dataLimite;
    StatusEnum status;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValorBase() {
        return valorBase;
    }

    public void setValorBase(BigDecimal valorBase) {
        this.valorBase = valorBase;
    }

    public BigDecimal getValorIncremento() {
        return valorIncremento;
    }

    public void setValorIncremento(BigDecimal valorIncremento) {
        this.valorIncremento = valorIncremento;
    }

    public Date getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(Date dataLimite) {
        this.dataLimite = dataLimite;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Licitacao licitacao = (Licitacao) o;

        if (!descricao.equals(licitacao.descricao)) return false;
        return dataLimite.equals(licitacao.dataLimite);
    }

    @Override
    public int hashCode() {
        int result = descricao.hashCode();
        result = 31 * result + dataLimite.hashCode();
        return result;
    }
}
