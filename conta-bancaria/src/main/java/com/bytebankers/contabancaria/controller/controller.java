package com.bytebankers.contabancaria.controller;

import com.bytebankers.contabancaria.ex.ContaNaoEncontradaException;
import com.bytebankers.contabancaria.ex.TipoInvalidoDeContaException;
import com.bytebankers.contabancaria.model.ContaBanco;
import com.bytebankers.contabancaria.service.ContaBancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class controller {
    @Autowired
    private ContaBancoService service;

    @PostMapping("/conta/{nome}/{tipo}")
    public ResponseEntity<ContaBanco> criarConta(@PathVariable String nome, @PathVariable String tipo){
        try {
            return ResponseEntity.ok().body(service.criarConta(nome, tipo));
        }catch(TipoInvalidoDeContaException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/conta")
    public ResponseEntity<ContaBanco> criarConta(@RequestBody HashMap<String, String > map){
        try {
            return ResponseEntity.ok().body(service.criarConta(map.get("nome"), map.get("tipo")));
        }catch(TipoInvalidoDeContaException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("conta/{id}/{nome}")
    public ResponseEntity<ContaBanco> entrarNaConta(@PathVariable int id, @PathVariable String nome){
        try {
            return ResponseEntity.ok().body(service.entrarNaConta(id, nome));
        }catch(ContaNaoEncontradaException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/conta")
    public ResponseEntity<ContaBanco> salvarAlterações(@RequestBody ContaBanco conta){
        try {
            return ResponseEntity.ok().body(service.salvarAlteracoes(conta));
        }catch(ContaNaoEncontradaException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
