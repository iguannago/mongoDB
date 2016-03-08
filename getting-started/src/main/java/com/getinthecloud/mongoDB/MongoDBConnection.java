package com.getinthecloud.mongoDB;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Created by davicres on 08/03/2016.
 */
public class MongoDBConnection {

    public MongoDBConnection() {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("test");
    }


    public static void main(String[] args) {
        MongoDBConnection mongoDBConnection = new MongoDBConnection();
    }

}
