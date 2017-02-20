package com.prova.mock;


import com.prova.domain.Licitacao;
import com.prova.domain.StatusEnum;

import java.math.BigDecimal;
import java.util.*;

/**
 * Metodo de auxilio que retorna lista de licitacoes para facilitar o desenvolvimento  da prova
 */
public abstract class  MockLicitacao {
    public static List<Licitacao> recuperaLicitacao(){
        Calendar.getInstance().add(Calendar.MINUTE,3);
        Date time = Calendar.getInstance().getTime();

        Licitacao licitacao1 = new Licitacao();
        licitacao1.setDescricao("Licitacao de mesa");
        licitacao1.setDataLimite(time);
        licitacao1.setValorBase(new BigDecimal("2000"));
        licitacao1.setValorIncremento(new BigDecimal("200"));
        licitacao1.setStatus(StatusEnum.A);

        Licitacao licitacao2 = new Licitacao();
        licitacao2.setDescricao("Licitacao de Cadeira");
        licitacao2.setDataLimite(time);
        licitacao2.setValorBase(new BigDecimal("3000"));
        licitacao2.setValorIncremento(new BigDecimal("300"));
        licitacao2.setStatus(StatusEnum.A);

        Licitacao licitacao3 = new Licitacao();
        licitacao3.setDescricao("Licitacao de material de limpeza");
        licitacao3.setDataLimite(time);
        licitacao3.setValorBase(new BigDecimal("5000"));
        licitacao3.setValorIncremento(new BigDecimal("500"));
        licitacao3.setStatus(StatusEnum.A);

        List<Licitacao> licitacaoList = new ArrayList<>();
        licitacaoList.add(licitacao1);
        licitacaoList.add(licitacao2);
        licitacaoList.add(licitacao3);
        return licitacaoList;
    };
}
