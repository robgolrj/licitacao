package com.prova.service;


import com.prova.domain.Licitacao;
import com.prova.domain.Oferta;

import java.util.List;

public interface ILicitacaoService {
    void verificarLicitacaoEncerrada();

    List<Licitacao> listarTodos();

    List<Licitacao> listarLicitacoesAberta();

    void adicionarLicitacao(Licitacao licitacao);

    /**
     * Registra todos os lances dos participantes por licitacao
     *
     * @param licitacao
     * @param oferta
     */
    void ofertarLance(Licitacao licitacao, Oferta oferta);

    /**
     * Verifica se o valor foi omidito e acrescenta o valor de incremento
     *
     * @param oferta
     * @param licitacao
     */
    void verificaOmissaoDeValor(Oferta oferta, Licitacao licitacao);

        /** Verifica se a oferta foi dentro do ultimo minuto e acresta 3 segundos
         *
         * @param licitacao
     */
    void verificaDataLimiteDaLicitacao(Licitacao licitacao);

    /**
     * Recupera os lances de uma licitacao
     *
     * @param licitacao
     * @return
     */
    List<Oferta> recuperarOfertas(Licitacao licitacao);
}
