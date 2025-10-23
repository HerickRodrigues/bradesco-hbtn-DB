package com.example.mongodb;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 * Classe de utilidade para conectar ao MongoDB Atlas usando o driver síncrono.
 * Ajuste as constantes USERNAME, PASSWORD, CLUSTER_URL e DATABASE_NAME conforme necessário.
 */
public class MongoDBConnection {

    // Variáveis de configuração (ajuste conforme necessário)
    private static final String USERNAME = "aluno";
    private static final String PASSWORD = "BN10UNhMxMDZUgEh";
    private static final String CLUSTER_URL = "cluster0.brbyr.mongodb.net"; // substitua se outro
    private static final String DATABASE_NAME = "Cluster0"; // substitua pelo nome do DB criado

    private MongoClient mongoClient;
    private MongoDatabase database;

    public MongoDBConnection() {
        try {
            // Inclui o nome do database na path do URI para que o driver direcione corretamente
            String connectionString = String.format(
                    "mongodb+srv://%s:%s@%s/%s?retryWrites=true&w=majority",
                    USERNAME, PASSWORD, CLUSTER_URL, DATABASE_NAME
            );

            ConnectionString connString = new ConnectionString(connectionString);
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(connString)
                    .build();

            mongoClient = MongoClients.create(settings);
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
            mongoClient.close();
            System.out.println("Conexão encerrada com sucesso.");
        }
    }

    public static void main(String[] args) {
        MongoDBConnection connection = new MongoDBConnection();

        // Exemplo de uso: mostra nome do banco e lista de collections (se houver)
        if (connection.getDatabase() != null) {
            System.out.println("Banco de dados: " + connection.getDatabase().getName());
            System.out.println("Collections presentes:");
            try {
                connection.getDatabase().listCollectionNames().forEach(name -> System.out.println(" - " + name));
            } catch (Exception e) {
                System.err.println("Erro ao listar collections: " + e.getMessage());
            }
        }

        // Fecha a conexão antes de sair
        connection.closeConnection();
    }
}
