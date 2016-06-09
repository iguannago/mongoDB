package com.getinthecloud.mongoDB;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.ParseException;

/**
 * Created by davicres on 08/03/2016.
 */
public class MongoDBApp {

    public static void main(String[] args) throws ParseException {
        String dbName = "test";
        String collectionName = "restaurants";
        MongoOps mongoOps = new MongoOpsImp();

        MongoDatabase mongoDB = mongoOps.connectToDB(dbName);

        mongoOps.addItem(mongoDB, collectionName, mongoOps.createDocument());

        System.out.println("Find all documents in the Collection: ");
        FindIterable<Document> documents = mongoOps.findAllDocumentsInCollection(mongoDB, collectionName);
        documents.forEach((Block<Document>) System.out::println);

        System.out.println("Find only documentes where lastName is Crespo: ");
        documents = mongoDB.getCollection(collectionName).find(new Document("lastName", "Crespo"));
        documents.forEach((Block<Document>) System.out::println);

    }

}
