package com.api.attornatus.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 6858680126350750402L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
    private Long id;
    @NonNull
    private String nome;
    private String dataNascimento;
    @OneToMany(cascade=CascadeType.PERSIST)
    private List<Endereco> endereco = new ArrayList<>();

}
