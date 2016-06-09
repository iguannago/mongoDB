package com.getinthecloud.mongoDB;

import com.mongodb.client.MongoDatabase;

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
        mongoOps.sortQueryResult(collectionName, mongoDB);

    }



}
