# MongoDB Java Connection (Maven)

Projeto mínimo para demonstrar conexão ao MongoDB Atlas usando o driver síncrono (`mongodb-driver-sync:4.10.1`).

## Estrutura

- `pom.xml` - dependência do driver e configurações do compilador (Java 11)
- `src/main/java/com/example/mongodb/MongoDBConnection.java` - classe de conexão e teste no `main`.

## Como usar (Windows Powershell)

1. Abra um PowerShell na pasta do projeto:

```powershell
cd "d:\Documentos\Ambiente de dev\Bradesco Curso\bradesco-hbtn-DB\mongoDB\1"
```

2. Compilar o projeto (gera o jar em `target/`):

```powershell
mvn package
```

3. Executar a classe principal (substitua o caminho do classpath conforme necessário):

```powershell
# Executa diretamente com o classpath target/classes e dependências no local repo (método simples):
java -cp "target/classes;$(mvn -q -Dexec.executable=echo -Dexec.args='%classpath' --non-recursive org.codehaus.mojo:exec-maven-plugin:3.1.0:exec | Out-String)" com.example.mongodb.MongoDBConnection
```

Observação: o comando acima usa Maven para montar o classpath; se preferir, use o `mvn exec:java -Dexec.mainClass="com.example.mongodb.MongoDBConnection"` ou crie um JAR "fat"/uber com um plugin.

## Ajustes
Edite `MongoDBConnection.java` e altere as constantes `USERNAME`, `PASSWORD`, `CLUSTER_URL` e `DATABASE_NAME` caso necessário.

## Verificação
Ao executar, a aplicação deverá imprimir o nome do banco e listar collections (se existirem). Se houver erro de autenticação/verificação de rede, confira as credenciais e se seu IP está liberado no Atlas (Network Access).
