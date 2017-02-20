package com.prova;

import com.prova.domain.Licitacao;
import com.prova.domain.Oferta;
import com.prova.mock.MockLicitacao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Scope("singleton")
public class MemoriaComponent {
    Map<Licitacao, List<Oferta>> lances = new HashMap<>();

    public MemoriaComponent() {
        lances.put(MockLicitacao.recuperaLicitacao().get(0), null);
        lances.put(MockLicitacao.recuperaLicitacao().get(1), null);
        lances.put(MockLicitacao.recuperaLicitacao().get(2), null);

    }

    public List<Licitacao> getLicitacaoList() {
        return new ArrayList<>(lances.keySet());
    }

    public void addLicitacaoList(Licitacao licitacao) {
        lances.put(licitacao, null);
    }

    public void addOferta(Licitacao licitacao, Oferta oferta){
        if (lances.get(licitacao)==null)
            lances.put(licitacao, new ArrayList<>());
        lances.get(licitacao).add(oferta);
    }

    public List<Oferta> getOfertas(Licitacao licitacao){
        return lances.get(licitacao);
    }
}
