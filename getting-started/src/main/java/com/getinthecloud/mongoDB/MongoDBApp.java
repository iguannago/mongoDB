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

        FindIterable<Document> documents = mongoOps.findAllDocumentsInCollection(mongoDB, collectionName);
        documents.forEach((Block<Document>) System.out::println);


    }

}
