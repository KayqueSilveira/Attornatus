package com.api.attornatus.controller;


import com.api.attornatus.modelo.Endereco;
import com.api.attornatus.service.EnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("endereco")
@AllArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;

    @PostMapping("cadastrar")
    public void cadastrar(@RequestBody Endereco endereco){
        enderecoService.save(endereco);
    }

    @PutMapping("alterar")
    public void alterar(@RequestBody Endereco endereco, @RequestParam Long idEndereco){
        enderecoService.alterar(endereco, idEndereco);
    }

    @GetMapping("buscar")
    public Endereco buscar(@RequestParam Long id) {
        return enderecoService.buscar(id);
    }
}
