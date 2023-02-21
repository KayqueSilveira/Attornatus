package com.api.attornatus.service;

import com.api.attornatus.repository.EnderecoRepositoy;
import com.api.attornatus.modelo.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepositoy enderecoRepositoy;

    @Autowired
    private PessoaService pessoaService;

    public void save(final Endereco endereco) {
        var pessoa = pessoaService.buscarPorIdPessoa(endereco.getIdPessoa());
        pessoa.getEndereco().add(endereco);
        enderecoRepositoy.save(endereco);
    }

    public List<Endereco> buscarTodos() {
        return enderecoRepositoy.findAll();
    }

    public void alterar(final Endereco endereco, final Long id) {
        var pessoa = pessoaService.buscarPorIdPessoa(endereco.getIdPessoa());
        
        var enderecoBase = enderecoRepositoy.findById(id).orElseThrow(() -> new RuntimeException("Endero nao existe"));

        if(endereco != null){
            enderecoBase.setLogradouro(endereco.getLogradouro());
            enderecoBase.setCep(endereco.getCep());
            enderecoBase.setCidade(endereco.getCidade());
            enderecoBase.setNumero(endereco.getNumero());

            pessoa.getEndereco().add(enderecoBase);
        }

        enderecoRepositoy.save(enderecoBase);
    }

    public Endereco buscar(final Long id) {
        return enderecoRepositoy.findById(id).orElseThrow(() -> new RuntimeException("Endereco nao cadastrado"));
    }
}
