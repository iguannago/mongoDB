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
    void FindDocumentsFilteringForAField(String collectionName, MongoDatabase mongoDB);
    void AnotherWayToFindDocumentFilteringForAField(String collectionName, MongoDatabase mongoDB);
    void QueryByAFieldInAnEmbeddedDocument(String collectionName, MongoDatabase mongoDB);
    void QueryByAFieldInAnEmbeddedDocumentUsingFilters(String collectionName, MongoDatabase mongoDB);
    void QueryByAFieldInAnArray(String collectionName, MongoDatabase mongoDB);
    void QueryFieldByAValueGreaterThan(String collectionName, MongoDatabase mongoDB);
}
