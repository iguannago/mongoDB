package com.getinthecloud.mongoDB;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.ParseException;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;

/**
 * Created by davicres on 08/03/2016.
 */
public class MongoDBApp {

    public static void main(String[] args) throws ParseException {
        String dbName = "test";
        String collectionName = "restaurants";
        MongoOps mongoOps = new MongoOpsImp();

        MongoDatabase mongoDB = mongoOps.connectToDB(dbName);

//        mongoOps.addItem(mongoDB, collectionName, mongoOps.createDocument());
//        findAllDocumentsInCollection(collectionName, mongoOps, mongoDB);
//        FindDocumentsFilteringForAField(collectionName, mongoDB);
//        AnotherWayToFindDocumentFilteringForAField(collectionName, mongoDB);
//        QueryByAFieldInAnEmbeddedDocument(collectionName, mongoDB);
//        QueryByAFieldInAnEmbeddedDocumentUsingFilters(collectionName, mongoDB);
//        QueryByAFieldInAnArray(collectionName, mongoDB);
//        QueryFieldByAValueGreaterThan(collectionName, mongoDB);

    }

    private static void QueryFieldByAValueGreaterThan(String collectionName, MongoDatabase mongoDB) {
        System.out.println("query docuement by a field with value grater than");
        FindIterable<Document> documents = mongoDB.getCollection(collectionName).find(gt("grades.score", 60));
        documents.forEach((Block<Document>) System.out::println);
    }

    private static void QueryByAFieldInAnArray(String collectionName, MongoDatabase mongoDB) {
        System.out.println("Query by a field in an Array: ");
        FindIterable<Document> documents = mongoDB.getCollection(collectionName).find(
                new Document("grades.grade", "C"));
        documents.forEach((Block<Document>) System.out::println);
    }

    private static void QueryByAFieldInAnEmbeddedDocumentUsingFilters(String collectionName, MongoDatabase mongoDB) {
        System.out.println("Query by a field in an Embedded document using Filters: ");
        FindIterable<Document> documents = mongoDB.getCollection(collectionName).find(
                eq("user.name", "David"));
        documents.forEach((Block<Document>) System.out::println);
    }

    private static void QueryByAFieldInAnEmbeddedDocument(String collectionName, MongoDatabase mongoDB) {
        System.out.println("Query by a field in an Embedded document: ");
        FindIterable<Document> documents = mongoDB.getCollection(collectionName).find(
                new Document("user.name", "David"));
        documents.forEach((Block<Document>) System.out::println);
    }

    private static void AnotherWayToFindDocumentFilteringForAField(String collectionName, MongoDatabase mongoDB) {
        FindIterable<Document> documents;
        System.out.println("Find only documentes where lastName is Crespo using Filters: ");
        documents = mongoDB.getCollection(collectionName).find(eq("name", "Iguanna"));
        documents.forEach((Block<Document>) System.out::println);
    }

    private static void FindDocumentsFilteringForAField(String collectionName, MongoDatabase mongoDB) {
        FindIterable<Document> documents;
        System.out.println("Find only documentes where lastName is Crespo: ");
        documents = mongoDB.getCollection(collectionName).find(new Document("lastName", "Crespo"));
        documents.forEach((Block<Document>) System.out::println);
    }

    private static void findAllDocumentsInCollection(String collectionName, MongoOps mongoOps, MongoDatabase mongoDB) {
        System.out.println("Find all documents in the Collection: ");
        FindIterable<Document> documents = mongoOps.findAllDocumentsInCollection(mongoDB, collectionName);
        documents.forEach((Block<Document>) System.out::println);
    }

}
