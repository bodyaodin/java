package contactlist.management;

import contactlist.connections.MongoConnection;
import com.mongodb.*;

public class MongoDBManagement implements DBManagement {

    MongoConnection mongoConnection;
    Mongo mongo;
    DB dataBase;

    //name of collection
    public String collection = "Peoplelist";

    private MongoDBManagement() {}

    public MongoDBManagement (MongoConnection mongoConnection) {
        this.mongoConnection = mongoConnection;
    }

    /**
     * method for deleting all data from DB collection
     */
    @Override
    public void deleteAllFromDBTable() {
        try {
            mongo = mongoConnection.getConnectionToDB();
            dataBase = mongo.getDB(mongoConnection.getDataBase());
            DBCollection dbCollection = dataBase.getCollection(collection);

            BasicDBObject deleteQuery = new BasicDBObject();
            dbCollection.remove(deleteQuery);

            System.out.println("All data was deleted from " + collection + " collection!");
            System.out.println();
        } finally {
            mongo.close();
        }
    }

    /**
     * method for deleting some data from DB collection where name is ...
     */
    @Override
    public void deleteFromDBTableForName(String name) {
        try {
            mongo = mongoConnection.getConnectionToDB();
            dataBase = mongo.getDB(mongoConnection.getDataBase());
            DBCollection dbCollection = dataBase.getCollection(collection);

            BasicDBObject deleteDoc = new BasicDBObject();
            deleteDoc.put("FIRST_NAME", name);
            dbCollection.remove(deleteDoc);

            System.out.println("Document with name " + name + " was deleted from collection!");
            System.out.println();
        } finally {
            mongo.close();
        }
    }

    /**
     * method for inserting data to DB collection
     */
    @Override
    public void insertToDBTable(String firstName, String lastName, String email, String phone) {
        try {
            mongo = mongoConnection.getConnectionToDB();
            dataBase = mongo.getDB(mongoConnection.getDataBase());
            DBCollection dbCollection = dataBase.getCollection(collection);

            BasicDBObject insertDoc = new BasicDBObject();
            insertDoc.put("FIRST_NAME", firstName);
            insertDoc.put("LAST_NAME", lastName);
            insertDoc.put("EMAIL", email);
            insertDoc.put("PHONE", phone);
            dbCollection.insert(insertDoc);

            System.out.printf("%s %s was added to %s!%n", firstName, lastName, collection);
            System.out.println();
        } finally {
            mongo.close();
        }
    }

    /**
     * method for selecting all data from DB collection
     */
    @Override
    public void selectAllFromDBTable() {
        try {
            mongo = mongoConnection.getConnectionToDB();
            dataBase = mongo.getDB(mongoConnection.getDataBase());
            DBCollection dbCollection = dataBase.getCollection(collection);

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
    public void selectFromDBTableForName(String name) {
        try {
            mongo = mongoConnection.getConnectionToDB();
            dataBase = mongo.getDB(mongoConnection.getDataBase());
            DBCollection dbCollection = dataBase.getCollection(collection);

            BasicDBObject selectDoc = new BasicDBObject();
            selectDoc.put("FIRST_NAME", name);

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
