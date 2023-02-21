package com.api.attornatus.controller;


import com.api.attornatus.modelo.Pessoa;
import com.api.attornatus.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pessoa")
@AllArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping("/cadastrar")
    public void cadastrar(@RequestBody Pessoa pessoa) {
        pessoaService.save(pessoa);
    }

    @GetMapping("buscar/{id}")
    public Pessoa buscarPessoa(@PathVariable Long id){
        return pessoaService.buscarPorIdPessoa(id);
    }

    @GetMapping("buscar")
    public List<Pessoa> buscarTodos() {
        return pessoaService.buscarTodos();
    }

    @PutMapping("alterar/")
    public void alterar(@RequestBody Pessoa pessoa, @RequestParam Long idCliente, @RequestParam Long idEndereco) {
        pessoaService.alterar(pessoa, idCliente, idEndereco);
    }

}
