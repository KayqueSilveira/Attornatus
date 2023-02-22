package com.api.attornatus.controller;

import com.api.attornatus.modelo.Endereco;
import com.api.attornatus.modelo.Pessoa;
import com.api.attornatus.service.PessoaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = PessoaController.class)
class PessoaControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired private ObjectMapper mapper;

    @MockBean
    private PessoaService pessoaService;

    @Test
    void deveCriarPessoa() throws Exception {
        when(pessoaService.save(any())).thenReturn(pessoaBuilder());
        Gson gson = new Gson();
        gson.toJson(pessoaBuilder());

        mockMvc.perform( MockMvcRequestBuilders
                        .post("/pessoa/cadastrar")
                        .content(gson.toJson(pessoaBuilder()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }

    @Test
    void buscarPessoa() throws Exception {
        ResultMatcher matcher;

        mockMvc.perform( MockMvcRequestBuilders
                        .get("/pessoa/buscar/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isAccepted())
                .andReturn().getResponse().getContentAsString();
    }


    @Test
    void buscarTodos() {
    }

    private Pessoa pessoaBuilder(){
        return Pessoa.builder()
                .id(1L)
                .dataNascimento("16/12/1997")
                .nome("Kayque")
                .endereco(enderecoBuilder())
                .build();
    }

    private List<Endereco> enderecoBuilder() {
        List<Endereco> enderecoList = new ArrayList<>();
        enderecoList.add(Endereco.builder()
                .idPessoa(1L)
                .cep("14570000")
                .numero(894)
                .cidade("Buritizal")
                .logradouro("Rua parana")
                .id(1L)
                .build());
        enderecoList.add(Endereco.builder()
                .idPessoa(1L)
                .cep("14570000")
                .numero(894)
                .cidade("Franca")
                .logradouro("Rua parana")
                .id(2L)
                .build());
        return enderecoList;
    }


}