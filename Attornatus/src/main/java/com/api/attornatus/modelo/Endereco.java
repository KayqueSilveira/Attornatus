package com.api.attornatus.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Endereco implements Serializable {

    private static final long serialVersionUID = 3314373291549278677L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
    private Long id;
    private String logradouro;
    private int numero;
    private Boolean principal = false;
    private Long idPessoa;
    private String cidade;
    private String cep;
}
