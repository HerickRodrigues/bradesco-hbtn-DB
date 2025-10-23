import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Classe de exemplo para conectar em um cluster MongoDB Atlas.
 * Ajustada para montar corretamente a connection string (fazendo URL-encode da senha)
 * e usar ServerApi V1 (recomendado para drivers modernos ao usar mongodb+srv).
 */
public class MongoDBConnection {

    // Variáveis de configuração
    private static final String USERNAME = "aluno";
    private static final String PASSWORD = "BN10UNhMxMDZUgEh";
    private static final String CLUSTER_URL = "cluster0.brbyr.mongodb.net"; // substitua se necessário
    private static final String DATABASE_NAME = "Cluster0"; // nome do banco a ser selecionado

    private MongoClient mongoClient;
    private MongoDatabase database;

    public MongoDBConnection() {
        try {
            // Faz URL-encode da senha para evitar problemas com caracteres especiais
            String encodedPassword = URLEncoder.encode(PASSWORD, StandardCharsets.UTF_8.toString());

            // Monta a connection string incluindo o nome do database (opcional)
            // Usamos mongodb+srv para SRV seedlist (Atlas)
            String connectionString = String.format(
                    "mongodb+srv://%s:%s@%s/%s?retryWrites=true&w=majority",
                    USERNAME, encodedPassword, CLUSTER_URL, DATABASE_NAME
            );

            // Configura Server API (opcional, mas recomendado ao usar drivers recentes com Atlas)
            ServerApi serverApi = ServerApi.builder()
                    .version(ServerApiVersion.V1)
                    .build();

            // Cria ConnectionString e MongoClientSettings
            ConnectionString connString = new ConnectionString(connectionString);
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(connString)
                    .serverApi(serverApi)
                    .build();

            // Cria o cliente
            mongoClient = MongoClients.create(settings);

            // Seleciona o banco de dados
            database = mongoClient.getDatabase(DATABASE_NAME);

            System.out.println("Conexão estabelecida com sucesso ao MongoDB!");
        } catch (Exception e) {
            System.err.println("Erro ao conectar ao MongoDB: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void closeConnection() {
        if (mongoClient != null) {
            try {
                mongoClient.close();
                System.out.println("Conexão encerrada com sucesso.");
            } catch (Exception e) {
                System.err.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        MongoDBConnection connection = new MongoDBConnection();

        // Exemplo de uso
        if (connection.getDatabase() != null) {
            System.out.println("Banco de dados selecionado: " + connection.getDatabase().getName());
        } else {
            System.err.println("Banco de dados não foi inicializado.");
        }

        // Aguarda um pouco antes de encerrar para permitir observação da saída
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }

        connection.closeConnection();
        //
    }
}
