package dataaccess;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dataobject.Book;
import dataobject.Category;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class MongoDbClient {

    private static Logger log = Logger.getLogger(MongoDbClient.class);
    private static MongoDatabase db;
    private static MongoClient client;

    public MongoDbClient() {
        List<MongoCredential> mongoCredentials = new ArrayList<>();
        mongoCredentials.add(MongoCredential.createCredential("user123", "admin", "password123".toCharArray()));
        ServerAddress serverAddress = new ServerAddress();
        client = new MongoClient(serverAddress, mongoCredentials);

        db = client.getDatabase("service");

        log.info("Connected to {service} database successfully");
    }

    public MongoClient getClient() {
        return client;
    }
}