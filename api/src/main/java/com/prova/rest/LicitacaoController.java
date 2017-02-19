package com.prova.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class LicitacaoController {
    @RequestMapping("/metodo")
    public HttpEntity<String> home() {
        Map map = new HashMap();
        map.put("valor", "texto");
        return new ResponseEntity(map, HttpStatus.OK);
    }
}
