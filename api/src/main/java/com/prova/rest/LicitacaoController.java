package com.prova.rest;

import com.prova.domain.Licitacao;
import com.prova.domain.Oferta;
import com.prova.service.ILicitacaoService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/licitacao")
public class LicitacaoController {
    @Resource
    ILicitacaoService licitacaoService;

    @RequestMapping("/metodo")
    public HttpEntity<String> home() {
        Map map = new HashMap();
        map.put("valor", "texto");
        return new ResponseEntity(map, HttpStatus.OK);
    }

    @RequestMapping("/listarTodos")
    public HttpEntity<List<Licitacao>> listarTodos() {
        return new ResponseEntity(licitacaoService.listarTodos(), HttpStatus.OK);
    }

    @RequestMapping("/listarAbertas")
    public HttpEntity<List<Licitacao>> listarLicitacoesAberta() {
        return new ResponseEntity(licitacaoService.listarLicitacoesAberta(), HttpStatus.OK);
    }

    @RequestMapping("/incluir")
    public HttpEntity incluir(@RequestBody Licitacao licitacao) {
        licitacaoService.adicionarLicitacao(licitacao);
        return new HttpEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/ofertarLance")
    public HttpEntity ofertarLance(@RequestBody Licitacao licitacao, Oferta oferta) {
        licitacaoService.ofertarLance(licitacao, oferta);
        return new HttpEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/recuperarOfertas")
    public HttpEntity<List<Oferta>> recuperarOfertas(/*@RequestBody Licitacao licitacao*/) {
        Licitacao licitacao = licitacaoService.listarLicitacoesAberta().get(0);
        return new ResponseEntity(licitacaoService.recuperarOfertas(licitacao), HttpStatus.OK);
    }

}
