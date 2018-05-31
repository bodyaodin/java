package contactlist.management;

import contactlist.connections.MongoConnection;
import com.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This class is used for inserting, updating and selecting data from Mongo DB
 */
public class MongoDBManagement implements DBManagement {

    private MongoConnection mongoConnection;
    private Mongo mongo;
    private DB dataBase;

    private MongoDBManagement() {}

    @Autowired
    public MongoDBManagement (MongoConnection mongoConnection) {
        this.mongoConnection = mongoConnection;
    }

    /**
     * method for inserting data to DB collection
     */
    @Override
    public void insertToDBTable(String tableName, String firstName, String lastName, String email, String phone) {
        try {
            mongo = mongoConnection.getConnectionToDB();
            dataBase = mongo.getDB(mongoConnection.getDataBase());
            DBCollection dbCollection = dataBase.getCollection(tableName);

            BasicDBObject insertDoc = new BasicDBObject();
            insertDoc.put("FIRST_NAME", firstName);
            insertDoc.put("LAST_NAME", lastName);
            insertDoc.put("EMAIL", email);
            insertDoc.put("PHONE", phone);
            dbCollection.insert(insertDoc);

            System.out.printf("%s %s was added to %s!%n", firstName, lastName, tableName);
            System.out.println();
        } finally {
            mongo.close();
        }
    }

    /**
     * method for deleting all data from DB collection
     */
    @Override
    public void deleteAllFromDBTable(String tableName) {
        try {
            mongo = mongoConnection.getConnectionToDB();
            dataBase = mongo.getDB(mongoConnection.getDataBase());
            DBCollection dbCollection = dataBase.getCollection(tableName);

            BasicDBObject deleteQuery = new BasicDBObject();
            dbCollection.remove(deleteQuery);

            System.out.println("All data was deleted from " + tableName + " collection!");
            System.out.println();
        } finally {
            mongo.close();
        }
    }

    /**
     * method for deleting some data from DB collection where name is ...
     */
    @Override
    public void deleteFromDBTableForName(String tableName, String firstName) {
        try {
            mongo = mongoConnection.getConnectionToDB();
            dataBase = mongo.getDB(mongoConnection.getDataBase());
            DBCollection dbCollection = dataBase.getCollection(tableName);

            BasicDBObject deleteDoc = new BasicDBObject();
            deleteDoc.put("FIRST_NAME", firstName);
            dbCollection.remove(deleteDoc);

            System.out.println("Document with name " + firstName + " was deleted from " + tableName + "!");
            System.out.println();
        } finally {
            mongo.close();
        }
    }

    /**
     * method for selecting all data from DB collection
     */
    @Override
    public void selectAllFromDBTable(String tableName) {
        try {
            mongo = mongoConnection.getConnectionToDB();
            dataBase = mongo.getDB(mongoConnection.getDataBase());
            DBCollection dbCollection = dataBase.getCollection(tableName);

            DBCursor documents = dbCollection.find();
            int i = 1; //counter of people
            while (documents.hasNext()) {
                System.out.printf("Person #%d: %s%n", i++, documents.next());
            }
            System.out.println();
        } finally {
            mongo.close();
        }
    }

    /**
     * method for selecting some data from DB collection where name is ...
     */
    @Override
    public void selectFromDBTableForName(String tableName, String firstName) {
        try {
            mongo = mongoConnection.getConnectionToDB();
            dataBase = mongo.getDB(mongoConnection.getDataBase());
            DBCollection dbCollection = dataBase.getCollection(tableName);

            BasicDBObject selectDoc = new BasicDBObject();
            selectDoc.put("FIRST_NAME", firstName);

            DBCursor documents = dbCollection.find(selectDoc);
            int i = 1; //counter of people
            while (documents.hasNext()) {
                System.out.printf("Person #%d: %s%n", i++, documents.next());
            }
            System.out.println();
        } finally {
            mongo.close();
        }
    }
}
