package com.prova;


import com.prova.domain.Licitacao;
import com.prova.domain.Oferta;
import com.prova.service.LicitacaoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LicitacaoServiceTest {
    @Resource
    LicitacaoService licitacaoService;

    @Test
    public void ofertarLanceTest(){
        Date data = new Date();
        Licitacao licitacao = new Licitacao();
        licitacao.setDescricao("A");
        licitacao.setDataLimite(data);

        Oferta oferta = new Oferta();
        oferta.setLance(new BigDecimal("2000"));
        oferta.setLogin("Usuario 1");

        licitacaoService.ofertarLance(licitacao, oferta);

        Licitacao licitacao2 = new Licitacao();
        licitacao2.setDescricao("A");
        licitacao2.setDataLimite(data);

        Oferta oferta2 = new Oferta();
        oferta2.setLance(new BigDecimal("4000"));
        oferta2.setLogin("Usuario 2");

        licitacaoService.ofertarLance(licitacao2, oferta2);

        Assert.assertEquals(2, licitacaoService.recuperarOfertas(licitacao).size());
    }

    @Test
    public void verificaOmissaoDeValorTest(){
        Date data = new Date();
        Licitacao licitacao = new Licitacao();
        licitacao.setDescricao("A");
        licitacao.setDataLimite(data);
        licitacao.setValorIncremento(new BigDecimal("3000"));

        Oferta oferta = new Oferta();
        oferta.setLance(null);

        licitacaoService.verificaOmissaoDeValor(oferta, licitacao);

        Assert.assertEquals(new BigDecimal("3000"), oferta.getLance());

    }

    @Test
    public void verificaDataLimiteDaLicitacaoTest(){
        Calendar calendar = Calendar.getInstance();
        Calendar clone = Calendar.getInstance();

        Licitacao licitacao = new Licitacao();
        licitacao.setDescricao("A");
        licitacao.setDataLimite(calendar.getTime());
        licitacao.setValorIncremento(new BigDecimal("3000"));

        calendar.add(Calendar.SECOND,30);


        licitacaoService.verificaDataLimiteDaLicitacao(licitacao);

        clone.add(Calendar.SECOND,30);
        Date dataEsperada = clone.getTime();

        Assert.assertEquals(dataEsperada, licitacao.getDataLimite());

    }
}

