# Projeto de exemplo: MongoDB Connection (Maven)

Este pequeno projeto demonstra como conectar a um cluster MongoDB Atlas usando o driver síncrono `mongodb-driver-sync` versão `4.10.1`.

Como usar:

1. Garanta que você tem o Java (11+) e Maven instalados.
2. Navegue até o diretório do projeto:

```powershell
cd "d:\Documentos\Ambiente de dev\Bradesco Curso\bradesco-hbtn-DB\mongoDB\0"
```

3. Compilar:

```powershell
mvn compile
```

4. Executar a classe principal (exemplo):

```powershell
mvn exec:java -Dexec.mainClass="MongoDBConnection"
```

Observações:
- As credenciais e o `CLUSTER_URL` já estão definidas na classe `MongoDBConnection`. Se precisar alterar, modifique as constantes no arquivo fonte.
- Se o Maven ou Java não estiverem instalados, instale-os antes de executar.
