package com.getinthecloud.mongoDB;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Sorts.ascending;
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
        System.out.println("Find all documents in the Collection: ");
        return mongoDatabase.getCollection(collectionName).find();
    }

    @Override
    public void queryFieldByAValueGreaterThan(String collectionName, MongoDatabase mongoDB) {
        System.out.println("query docuement by a field with value grater than");
        FindIterable<Document> documents = mongoDB.getCollection(collectionName).find(gt("grades.score", 60));
        documents.forEach((Block<Document>) System.out::println);
    }

    @Override
    public void queryDocumentsByFieldWithLogialAND(String collectionName, MongoDatabase mongoDB) {
        System.out.println("Query documents by fields using logical AND");
        FindIterable<Document> documents = mongoDB.getCollection(collectionName).find(
                new Document("name", "La Rubia Restaurant").append("address.zipcode", "11385"));
        documents.forEach((Block<Document>) System.out::println);
    }

    @Override
    public void queryDocumentsByFieldWithLogicalANDwithFilters(String collectionName, MongoDatabase mongoDB) {
        System.out.println("Query documents by fields using logical AND with Filters");
        FindIterable<Document> documents = mongoDB.getCollection(collectionName).find(and(eq("name", "La Rubia Restaurant"),
                eq("address.zipcode", "11385")));
        documents.forEach((Block<Document>) System.out::println);
    }

    @Override
    public void queryDocumentsByFieldWithLogicalORWithFilters(String collectionName, MongoDatabase mongoDB) {
        System.out.println("Query documents by fields using logical OR with Filters");
        FindIterable<Document> documents = mongoDB.getCollection(collectionName).find(or(eq("name", "La Rubia Restaurant"),
                eq("address.zipcode", "11385")));
        documents.forEach((Block<Document>) System.out::println);
    }

    @Override
    public void sortQueryResult(String collectionName, MongoDatabase mongoDB) {
        System.out.println("Sort Query Result");
        FindIterable<Document> documents = mongoDB.getCollection(collectionName).
                find().sort(ascending("borough", "address.zipcode"));
        documents.forEach((Block<Document>) System.out::println);
    }

    @Override
    public void queryByAFieldInAnArray(String collectionName, MongoDatabase mongoDB) {
        System.out.println("Query by a field in an Array: ");
        FindIterable<Document> documents = mongoDB.getCollection(collectionName).find(
                new Document("grades.grade", "C"));
        documents.forEach((Block<Document>) System.out::println);
    }

    @Override
    public void queryByAFieldInAnEmbeddedDocumentUsingFilters(String collectionName, MongoDatabase mongoDB) {
        System.out.println("Query by a field in an Embedded document using Filters: ");
        FindIterable<Document> documents = mongoDB.getCollection(collectionName).find(
                eq("user.name", "David"));
        documents.forEach((Block<Document>) System.out::println);
    }

    @Override
    public void queryByAFieldInAnEmbeddedDocument(String collectionName, MongoDatabase mongoDB) {
        System.out.println("Query by a field in an Embedded document: ");
        FindIterable<Document> documents = mongoDB.getCollection(collectionName).find(
                new Document("user.name", "David"));
        documents.forEach((Block<Document>) System.out::println);
    }

    @Override
    public void anotherWayToFindDocumentFilteringForAField(String collectionName, MongoDatabase mongoDB) {
        FindIterable<Document> documents;
        System.out.println("Find only documentes where lastName is Crespo using Filters: ");
        documents = mongoDB.getCollection(collectionName).find(eq("name", "Iguanna"));
        documents.forEach((Block<Document>) System.out::println);
    }

    @Override
    public void findDocumentsFilteringForAField(String collectionName, MongoDatabase mongoDB) {
        FindIterable<Document> documents;
        System.out.println("Find only documentes where lastName is Crespo: ");
        documents = mongoDB.getCollection(collectionName).find(new Document("lastName", "Crespo"));
        documents.forEach((Block<Document>) System.out::println);
    }

}
