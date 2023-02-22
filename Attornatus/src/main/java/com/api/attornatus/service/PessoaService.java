package com.api.attornatus.service;

import com.api.attornatus.modelo.Pessoa;
import com.api.attornatus.repository.EnderecoRepositoy;
import com.api.attornatus.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EnderecoRepositoy enderecoRepositoy;

    public Pessoa save(final Pessoa pessoa) {
        if(pessoaRepository.existsByNome(pessoa.getNome())){
            throw new RuntimeException("Pessoa ja possui cadastro");
        }
        return pessoaRepository.save(pessoa);
    }

    public Pessoa buscarPorIdPessoa(final Long id) {
        return pessoaRepository.findById(id).orElseThrow((() -> new RuntimeException("Pessoa nao existe")));
    }

    public List<Pessoa> buscarTodos() {
        return pessoaRepository.findAll();
    }

    public void alterar(final Pessoa pessoa, final Long idPessoa, final Long idEndereco) {

        var pessoaBase = pessoaRepository.findById(idPessoa).orElseThrow(() -> new RuntimeException("Pessoa nao existe"));
        var enderecoBase = enderecoRepositoy.findById(idEndereco).orElseThrow(() -> new RuntimeException("Endereco nao existe"));

        if(idEndereco.equals(enderecoBase.getId()) && pessoaBase.getId().equals(enderecoBase.getIdPessoa())){
            pessoaBase.setNome(pessoa.getNome());
            for(int i =0; i<pessoaBase.getEndereco().size(); i++) {
                if(pessoaBase.getEndereco().get(i).getId().equals(idEndereco)){
                    enderecoBase.setCep(pessoa.getEndereco().get(0).getCep());
                    enderecoBase.setCidade(pessoa.getEndereco().get(0).getCidade());
                    enderecoBase.setLogradouro(pessoa.getEndereco().get(0).getLogradouro());
                    enderecoBase.setNumero(pessoa.getEndereco().get(0).getNumero());
                    enderecoBase.setPrincipal(pessoa.getEndereco().get(0).getPrincipal());

                }
            }
            pessoaRepository.save(pessoaBase);
        }

    }

    private boolean verificaEndereco(final Long id, final String cep) {
        var base = pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa nao existe"));
        int i =0;
        for(Object item : base.getEndereco().toArray()) {
            if(base.getEndereco().get(i).getCep().equals(cep)) {
                return true;
            }
            i++;
        }
        return false;
    }
}
