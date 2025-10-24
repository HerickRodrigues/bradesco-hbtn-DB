# Projeto Administrativo JPA/Hibernate

Este projeto é uma aplicação Java que demonstra o uso de JPA (Java Persistence API) e Hibernate com banco de dados SQLite para gerenciamento de cadastros de Pessoas e Produtos.

## Estrutura do Projeto

```
jpa_hibernate/
├── src/
│   └── main/
│       ├── java/
│       │   ├── demo/
│       │   │   └── AdministrativoApp.java
│       │   ├── entities/
│       │   │   ├── Pessoa.java
│       │   │   └── Produto.java
│       │   └── models/
│       │       ├── PessoaModel.java
│       │       └── ProdutoModel.java
│       └── resources/
│           └── META-INF/
│               └── persistence.xml
├── pom.xml
├── database_admin.db
└── sql_schema_database_admin.sql
```

## Tecnologias Utilizadas

- Java
- Maven
- JPA/Hibernate
- SQLite

## Configuração do Projeto

1. O projeto utiliza Maven para gerenciamento de dependências
2. Configurado com Java 11
3. Banco de dados SQLite para persistência

### Dependências Principais

- hibernate-core (5.4.12.Final)
- hibernate-entitymanager (5.4.12.Final)
- sqlite-jdbc (3.36.0.3)
- sqlite-dialect (0.1.2)

## Entidades

### Pessoa
- id (Long)
- nome (String)
- email (String)
- idade (Integer)
- cpf (String)
- dataNascimento (Date)

### Produto
- id (Long)
- nome (String)
- quantidade (Integer)
- preco (Double)
- status (Boolean)

## Funcionalidades

O projeto implementa operações CRUD (Create, Read, Update, Delete) para ambas as entidades:

- Criar novo registro
- Buscar registro por ID
- Buscar todos os registros
- Atualizar registro
- Deletar registro

## Como Executar

1. Clone o repositório
2. Importe o projeto em sua IDE
3. Execute a classe `AdministrativoApp.java` para testar as funcionalidades

## Estrutura do Banco de Dados

O banco de dados é criado automaticamente ao executar a aplicação. O schema SQL pode ser encontrado no arquivo `sql_schema_database_admin.sql`.