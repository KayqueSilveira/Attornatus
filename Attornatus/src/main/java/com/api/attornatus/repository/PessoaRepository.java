package com.api.attornatus.repository;

import com.api.attornatus.modelo.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Pessoa findByNome(String nome);

    boolean existsByNome(String nome);

    Pessoa findByIdAndEnderecoId(Long idPessoa, Long idEndereco);
}
