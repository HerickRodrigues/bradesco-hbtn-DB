# java_jpa_hibernate_mapeamento

Este diretório contém um subprojeto de exemplo que demonstra mapeamento JPA/Hibernate para uma aplicação de gestão de cursos.

Subprojeto principal:

- `gestao-cursos-api/` — API de exemplo com entidades JPA para `Aluno`, `Curso`, `Professor`, `Endereco`, `Telefone`, `MaterialCurso`, entre outras.
  - `pom.xml` — build Maven do subprojeto.
  - `src/main/java/` — código-fonte Java (`demo`, `entities`, `models`).
  - `src/main/resources/META-INF/persistence.xml` — configuração JPA/Hibernate (dialeto, datasource, properties).
  - `sql_schema_database_admin_jpa.sql` — script SQL de exemplo para criação do esquema de banco.

Requisitos

- Java JDK (11+ recomendado conforme seu `pom.xml`).
- Maven (3.x).
- Banco de dados relacional configurado (H2, PostgreSQL, MySQL, etc.) se quiser testar persistência real.

Como compilar

Abra o PowerShell na raiz do repositório e execute:

```powershell
mvn -f "java_jpa_hibernate_mapeamento/gestao-cursos-api/pom.xml" clean package
```

Como executar

- Pela IDE: importe o subprojeto Maven `java_jpa_hibernate_mapeamento/gestao-cursos-api` e execute a classe `demo.GestaoCursosMain` (ou outra classe `main` existente em `demo`).

- Pelo Maven (se o plugin `exec` estiver configurado):

```powershell
mvn -f "java_jpa_hibernate_mapeamento/gestao-cursos-api/pom.xml" exec:java -Dexec.mainClass="demo.GestaoCursosMain"
```

Se o plugin `exec` não estiver presente no `pom.xml`, rode pela sua IDE ou exporte o JAR com dependências e execute com `java -jar` (ou monte o classpath com `mvn dependency:build-classpath`).

Configuração da persistência

- Edite `java_jpa_hibernate_mapeamento/gestao-cursos-api/src/main/resources/META-INF/persistence.xml` para ajustar a connection URL, usuário e senha do banco, além de propriedades do Hibernate (por exemplo `hibernate.hbm2ddl.auto`, `hibernate.dialect`, logging).
- O arquivo `sql_schema_database_admin_jpa.sql` contém instruções SQL de exemplo que podem ser executadas diretamente no seu banco para criar o esquema inicial.

Notas

- Estes exemplos são didáticos — revise as configurações de conexão antes de executar em um banco de produção.
- Para testes rápidos sem banco externo, considere alterar a configuração para usar um banco em memória (H2) no `persistence.xml`.

Contribuições

Sugestões e PRs são bem-vindos. Se quiser, posso também:
- Adicionar instruções de execução passo-a-passo para Windows (ex.: criação do banco localmente);
- Incluir exemplos de `application.properties` ou profiles para H2/Postgres;
- Gerar um pequeno script para criar um JAR executável com dependências empacotadas.
