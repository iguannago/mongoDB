package com.getinthecloud.mongoDB;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.ParseException;

/**
 * Created by davicres on 23/05/2016.
 */
public interface MongoOps {
    MongoDatabase connectToDB(String databaseName);
    void addItem(MongoDatabase db, String collectionName, Document document);
    Document createDocument() throws ParseException;
    FindIterable<Document> findAllDocumentsInCollection(MongoDatabase mongoDatabase, String collectionName);
    void findDocumentsFilteringForAField(String collectionName, MongoDatabase mongoDB);
    void anotherWayToFindDocumentFilteringForAField(String collectionName, MongoDatabase mongoDB);
    void queryByAFieldInAnEmbeddedDocument(String collectionName, MongoDatabase mongoDB);
    void queryByAFieldInAnEmbeddedDocumentUsingFilters(String collectionName, MongoDatabase mongoDB);
    void queryByAFieldInAnArray(String collectionName, MongoDatabase mongoDB);
    void queryFieldByAValueGreaterThan(String collectionName, MongoDatabase mongoDB);
    void queryDocumentsByFieldWithLogialAND(String collectionName, MongoDatabase mongoDB);
}
