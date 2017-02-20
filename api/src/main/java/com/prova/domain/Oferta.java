package com.prova.domain;

import org.springframework.web.context.annotation.SessionScope;

import java.math.BigDecimal;

public class Oferta {
    BigDecimal lance;
    String login;

    public BigDecimal getLance() {
        return lance;
    }

    public void setLance(BigDecimal lance) {
        this.lance = lance;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Oferta oferta = (Oferta) o;

        return login.equals(oferta.login);
    }

    @Override
    public int hashCode() {
        return login.hashCode();
    }
}
