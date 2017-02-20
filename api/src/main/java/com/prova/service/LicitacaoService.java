package com.prova.service;

import com.prova.MemoriaComponent;
import com.prova.domain.Licitacao;
import com.prova.domain.Oferta;
import com.prova.domain.StatusEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class LicitacaoService implements ILicitacaoService{
    @Resource
    MemoriaComponent memoriaComponent;

    @Override
    public List<Licitacao> listarTodos() {
        return memoriaComponent.getLicitacaoList();
    }

    @Override
    public List<Licitacao> listarLicitacoesAberta() {
        List<Licitacao> licitacaoList = new ArrayList<>();

        for (Licitacao licitacao : memoriaComponent.getLicitacaoList()){
            if (licitacao.getStatus().equals(StatusEnum.A)){
                licitacaoList.add(licitacao);
            }
        }
        return licitacaoList;
    }

    @Override
    public void adicionarLicitacao(Licitacao licitacao) {
        licitacao.setStatus(StatusEnum.A);
        memoriaComponent.addLicitacaoList(licitacao);
    }

    @Override
    public void ofertarLance(Licitacao licitacao, Oferta oferta) {
        verificaOmissaoDeValor(oferta, licitacao);
        memoriaComponent.addOferta(licitacao, oferta);
    }

    @Override
    public void verificaOmissaoDeValor(Oferta oferta, Licitacao licitacao){
        if(oferta.getLance()==null){
            oferta.setLance(licitacao.getValorIncremento());
        }
    }

    @Override
    public void verificaDataLimiteDaLicitacao(Licitacao licitacao){
        Calendar dataAtual = Calendar.getInstance();
        Calendar dataLimite = Calendar.getInstance();
        dataLimite.setTime(licitacao.getDataLimite());
        dataAtual.add(Calendar.SECOND,60);
        if(!dataAtual.before(dataLimite)){
            dataLimite.add(Calendar.SECOND,30);
            licitacao.setDataLimite(dataLimite.getTime());
        }
    }

    @Override
    public List<Oferta> recuperarOfertas(Licitacao licitacao) {
        return memoriaComponent.getOfertas(licitacao);
    }


}
