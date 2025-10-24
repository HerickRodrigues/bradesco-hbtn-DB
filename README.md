# bradesco-hbtn-DB

Repositório com projetos de exemplo para estudo de JPA/Hibernate e MongoDB.

## Estrutura do repositório

- `java_jpa_hibernate_mapeamento/`
  - `gestao-cursos-api/` — API de exemplo para gestão de cursos usando JPA/Hibernate.
    - `pom.xml`
    - `src/main/java/` contém pacotes `demo`, `entities`, `models`.
    - `src/main/resources/META-INF/persistence.xml` — configuração JPA usada pelo projeto.

- `jpa_hibernate/`
  - Projeto com exemplos simples de JPA/Hibernate (ex.: `Pessoa`, `Produto`).
  - `pom.xml` e `src/main/resources/META-INF/persistence.xml`.

- `mongoDB/`
  - Exemplo de conexão/operações com MongoDB (classes: `MongoDBConnection.java`, `Usuario.java`, `UsuarioOperations.java`).
  - Cada exemplo tem seu próprio `pom.xml`.

## Como compilar

Os projetos usam Maven. A forma mais simples de compilar cada subprojeto é executar, no PowerShell (na raiz do repositório):

```powershell
# Compilar o projeto 'gestao-cursos-api'
mvn -f "java_jpa_hibernate_mapeamento/gestao-cursos-api/pom.xml" clean package

# Compilar o projeto 'jpa_hibernate'
mvn -f "jpa_hibernate/pom.xml" clean package

# Compilar o exemplo MongoDB
mvn -f "mongoDB/1/pom.xml" clean package
```

Obs: Ajuste caminhos se necessário. Se preferir, abra cada subprojeto na sua IDE (IntelliJ/Eclipse) e use as ferramentas de execução da IDE.

## Como executar

- Execução via IDE: importe o projeto Maven e rode a classe `main` desejada (por exemplo `demo.GestaoCursosMain` em `gestao-cursos-api`).

- Execução via Maven (se o plugin exec estiver configurado):

```powershell
mvn -f "java_jpa_hibernate_mapeamento/gestao-cursos-api/pom.xml" exec:java -Dexec.mainClass="demo.GestaoCursosMain"
```

Se o `exec` plugin não estiver configurado, rode via IDE ou monte o classpath com Maven e execute com `java -cp`.

## Configuração de banco de dados

- Os projetos JPA usam `persistence.xml` em `src/main/resources/META-INF/persistence.xml` de cada subprojeto. Edite esse arquivo para ajustar URL, usuário e senha do banco (ex.: H2, PostgreSQL, MySQL etc.).
- O arquivo `java_jpa_hibernate_mapeamento/gestao-cursos-api/sql_schema_database_admin_jpa.sql` contém scripts SQL de exemplo para criação do esquema.

## Notas rápidas

- Estes exemplos são didáticos — adapte configuração de persistência, conexões e propriedades de logging conforme seu ambiente.
- Para o MongoDB: certifique-se de ter o servidor MongoDB rodando e ajuste a string de conexão dentro de `MongoDBConnection.java` se necessário.

## Contato / Contribuição

Sinta-se à vontade para abrir issues ou enviar PRs com melhorias nos exemplos e documentação.

---
Gerado automaticamente para fornecer orientação rápida sobre como compilar e executar os exemplos do repositório.
