
<div>

# 🚀 Api Rest agendamento Meetup
Repositório do projeto final do Bootcamp WoMakersCode microservice que simula o app do meetup em Java.

</div><br>


## 📚 Índice
 1. [Sobre o Projeto](#projeto)
 2. [Tecnologias Utilizadas](#tecnologias)
 3. [Pré-requisitos e como rodar a aplicação](#requisitos)
 

<div id='projeto'/>  

<br>

## 👩🏽‍💻 💻 Sobre o Projeto

Foi desenvolvido um microserviço para demostrar algumas funcionalidade do agendamento de Meetup, por meio do relacionamento de Duas tabelas sendo elas: Registration e Meetup.

 No projeto é possivel realizar:
- Cadastro de um Registro no sistema;
- Editar dados do Registro;
- Consultar todos os registros cadastrados no sistema;
- Consultar se um determinado registro esta cadastrado;
- Remover um Registro;
- Cadastro de um Meetup no sistema;
- Editar dados do Meetup;
- Consultar todos os meetups cadastrados no sistema;
- Consultar se um determinado registro esta cadastrado;
- Remover um Meetup;

<div id='tecnologias'/>

<br>

## 🛠 Tecnologias Utilizadas

As seguintes ferramentas foram utilizadas na construção do projeto:


&rarr; <a href="https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html">Java</a> - Linguagem de programação utilizada. <br>
&rarr; <a href="https://spring.io/">SpringBoot</a> - Frameworks java utlizada no projeto. <br>
&rarr; <a href="https://maven.apache.org/">Maven </a> - Gerenciar as dependências do projeto. <br>
&rarr; <a href="https://www.h2database.com/html/main.html">H2</a> - Banco de dados  <br>
&rarr; <a href="https://www.postman.com/">Postman</a> - Teste local das APIs  <br>
&rarr; <a href="https://swagger.io/">Swagger</a> - Documentação da APIs.  <br>
&rarr; <a href="https://junit.org/junit5/">Junit/Mockito</a> - Teste automatizados da APIs.  <br>
&rarr; <a href="https://azure.microsoft.com/en-us/">Azure</a> - Deploy da APIs.  <br>

<div id='requisitos'/>

<br>

## 👷‍♀️ Pré-requisitos e como rodar a aplicação

### Pré-requisitos para rodar:

* Ter o [Java](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html) instalado (JDK e JRE).
* Ter o [Maven](https://maven.apache.org/) instaldo.

### Dependências do projeto:

- <a href="https://spring.io/projects/spring-data-jpa#overview">Spring Data JPA</a><br>
- <a href="https://spring.io/projects/spring-ws">Spring Web</a><br>
- <a href="https://spring.io/projects/spring-boot">Spring Boot DevTools</a><br>
- <a href="https://spring.io/guides/gs/accessing-data-jpa/">H2database</a><br>
- <a href="https://projectlombok.org/setup/maven">Lombok </a><br>

### Faça uma copia do projeto para sua maquina:

Clone o repositório:
```bash
$ git clone https://github.com/deborah6150/api-agendamento-meetup
```
Entre dentro da pasta:
```bash
$ cd agendamento-meetup
```

### Compilando e rodando o projeto:

- Acesse o projeto por uma IDE de sua preferência: INTELIJ, ECLIPSE, VSCODE etc.

    
- Para compilar o projeto vá até a pasta onde se encontra o arquivo `pom.xml` e execute no terminal o comando: `mvn clean install`

- Se o resultado do build for `BUILD SUCCESS`, rode o projeto usando: `mvn exec:java`

- Logo após, abra o seu navegador e acesse a pagina inicial: `http://localhost:8080/`

### Teste da API

- Pode ser feito pelo swagger: <a href="http://localhost:8080/swagger-ui/index.html#/">http://localhost:8080/swagger-ui/index.html#/</a><br>


<br>


<br>

<p></p><br>
