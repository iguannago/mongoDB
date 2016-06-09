package com.getinthecloud.mongoDB;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static java.util.Arrays.asList;

/**
 * Created by davicres on 23/05/2016.
 */
public class MongoOpsImp implements MongoOps {
    @Override
    public MongoDatabase connectToDB(String databaseName) {
        MongoClient mongoClient = new MongoClient();
        return mongoClient.getDatabase(databaseName);
    }

    @Override
    public void addItem(MongoDatabase db, String collectionName, Document document) {
        db.getCollection(collectionName).insertOne(document);
    }

    @Override
    public Document createDocument() throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        return new Document("address",
                new Document()
                        .append("street", "2 Avenue")
                        .append("zipcode", "10075")
                        .append("building", "1480")
                        .append("coord", asList(-73.9557413, 40.7720266)))
                .append("borough", "Manhattan")
                .append("cuisine", "Italian")
                .append("grades", asList(
                        new Document()
                                .append("date", format.parse("2014-10-01T00:00:00Z"))
                                .append("grade", "A")
                                .append("score", 11),
                        new Document()
                                .append("date", format.parse("2014-01-16T00:00:00Z"))
                                .append("grade", "B")
                                .append("score", 17)))
                .append("name", "Iguanna2")
                .append("lastName", "Crespo")
                .append("restaurant_id", "41704620")
                .append("user",
                        new Document()
                            .append("name", "David")
                            .append("lastName", "Crespo"));
    }

    @Override
    public FindIterable<Document> findAllDocumentsInCollection(MongoDatabase mongoDatabase, String collectionName) {
        return mongoDatabase.getCollection(collectionName).find();
    }


}
