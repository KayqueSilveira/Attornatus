package com.api.attornatus.controller;


import com.api.attornatus.modelo.Pessoa;
import com.api.attornatus.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pessoa")
@AllArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Pessoa> cadastrar(@RequestBody Pessoa pessoa) {
        pessoaService.save(pessoa);
        return new ResponseEntity<>(pessoa, HttpStatus.CREATED);
    }

    @GetMapping("buscar/{id}")
    public ResponseEntity<Pessoa> buscarPessoa(@PathVariable Long id){
        return new ResponseEntity<>(pessoaService.buscarPorIdPessoa(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("buscar")
    public ResponseEntity<List<Pessoa>> buscarTodos() {
        return new ResponseEntity<>(pessoaService.buscarTodos(), HttpStatus.ACCEPTED);
    }

    @PutMapping("alterar/")
    public void alterar(@RequestBody Pessoa pessoa, @RequestParam Long idPessoa, @RequestParam Long idEndereco) {
        pessoaService.alterar(pessoa, idPessoa, idEndereco);
    }

}
