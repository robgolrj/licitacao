package com.prova;

import com.prova.service.ILicitacaoService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Robo que executa a cada minuto verificando se existe licitacao para fechar
 * Temporariamente colocado para cada 3 minutos pra fim de testes
 *
 */
@Component
public class ScheduledConfiguration {
    @Resource
    ILicitacaoService licitacaoService;

    @Scheduled(cron="0 0/3 * * * ?")
    private void verificarLicitacaoEncerrada(){
        licitacaoService.verificarLicitacaoEncerrada();
    }
}
