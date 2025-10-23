import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.model.Filters;
import java.util.Arrays;

public class UsuarioOperations {
    private MongoCollection<Document> collection;

    public UsuarioOperations(MongoDatabase database) {
        this.collection = database.getCollection("usuarios");
    }

    public void inserirUsuarios() {
        collection.insertMany(Arrays.asList(
            new Usuario("Alice", 25).toDocument(),
            new Usuario("Bob", 30).toDocument(),
            new Usuario("Charlie", 35).toDocument()
        ));
    }

    public void consultarUsuarios() {
        for (Document doc : collection.find()) {
            System.out.println(Usuario.fromDocument(doc));
        }
    }

    public void alterarIdade(String nome, int novaIdade) {
        collection.updateOne(Filters.eq("nome", nome), new Document("$set", new Document("idade", novaIdade)));
    }

    public void apagarUsuario(String nome) {
        collection.deleteOne(Filters.eq("nome", nome));
    }
}