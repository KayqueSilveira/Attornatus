# Attornatus

API gerenciamento de cadastro de pessoas.

Tecnologias:

* SpringBoot
* JPA
* Lombok
* Maven
* Banco H2

## Executar a aplicação

Para rodar a aplicação na sua IDE, execute a classe main ApiApplication.

Ao subir pode-se acessar:

```
Para cadastrar uma nova pessoa:
localhost:8080/pessoa/cadastrar

Para cadastrar um endereco para a pessoa:
localhost:8080/endereco/cadastrar
>Obs: É necessário inserir o id da pessoa no body, na variavel idPessoa

Para verificar todas as pessoas:
localhost:8080/pessoa/buscar

Para verificar pessoa expecifica digitando seu id:
localhost:8080/pessoa/buscar/<id da pessoa>

Para alterar as propriedados da pessoa expecifico digitando o id da pessoa e id do endereco:
localhost:8080/pessoa/alterar/?idPessoa=<valor>&idEndereco=<valor>

```

## Banco de Dados

Foi utilizado o banco H2. Para acessar o console execute a aplicação e acesse pelo navegador localhost:8080/h2-console:

```
Usuario: sa
Senha: 
Banco: jdbc:h2:mem:apiAttornatus
```
