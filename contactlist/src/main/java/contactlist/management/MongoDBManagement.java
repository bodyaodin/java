package contactlist.management;

import com.mongodb.*;
import contactlist.contacts.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Iterator;
import java.util.List;

/**
 * This class is used for inserting, updating and selecting data from Mongo DB
 */
public class MongoDBManagement implements DBManagement {

//    private MongoConnection mongoConnection;
//    private Mongo mongo;
//    private DB dataBase;

    /**
     * Spring mongoTemplate for works with Mongo Data base queries
     */
    private MongoTemplate mongoTemplate;

    /**
     * Field for Collection name from Contact List
     */
    private String collectionName;


    @Autowired
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }


    public MongoDBManagement() {}

//    @Autowired
//    public MongoDBManagement (MongoConnection mongoConnection) {
//        this.mongoConnection = mongoConnection;
//    }


    /**
     * method for inserting data to DB collection
     */
    @Override
    public void insertToDBTable(Person person) {
        mongoTemplate.insert(person);

        System.out.printf("%s %s was added to %s!%n", person.getFIRST_NAME(), person.getLAST_NAME(), this.collectionName);
        System.out.println();

        /*
        try {
            mongo = mongoConnection.getConnectionToDB();
            dataBase = mongo.getDB(mongoConnection.getDataBase());
            DBCollection dbCollection = dataBase.getCollection(collectionName);

            BasicDBObject insertDoc = new BasicDBObject();
            insertDoc.put("FIRST_NAME", firstName);
            insertDoc.put("LAST_NAME", lastName);
            insertDoc.put("EMAIL", email);
            insertDoc.put("PHONE", phone);
            dbCollection.insert(insertDoc);

            System.out.printf("%s %s was added to %s!%n", firstName, lastName, collectionName);
            System.out.println();
        } finally {
            mongo.close();
        }
        */
    }

    /**
     * method for deleting all data from DB collection
     */
    @Override
    public void deleteAllFromDBTable() {
        BasicQuery deleteQuery = new BasicQuery("{}");
        mongoTemplate.remove(deleteQuery, Person.class);

        System.out.println("All data was deleted from " + this.collectionName + " collection!");
        System.out.println();

        /*
        try {
            mongo = mongoConnection.getConnectionToDB();
            dataBase = mongo.getDB(mongoConnection.getDataBase());
            DBCollection dbCollection = dataBase.getCollection(this.collectionName);

            BasicDBObject deleteQuery = new BasicDBObject();
            dbCollection.remove(deleteQuery);

            System.out.println("All data was deleted from " + this.collectionName + " collection!");
            System.out.println();
        } finally {
            mongo.close();
        }
        */
    }

    /**
     * method for deleting some data from DB collection where name is ...
     */
    @Override
    public void deleteFromDBTableForName(Person person) {
        BasicQuery deleteDoc = new BasicQuery("{FIRST_NAME:'" + person.getFIRST_NAME() + "'}");
        mongoTemplate.remove(deleteDoc, Person.class);

        System.out.println("Document with name " + person.getFIRST_NAME() + " was deleted from " + this.collectionName + "!");
        System.out.println();

        /*
        try {
            mongo = mongoConnection.getConnectionToDB();
            dataBase = mongo.getDB(mongoConnection.getDataBase());
            DBCollection dbCollection = dataBase.getCollection(collectionName);

            BasicDBObject deleteDoc = new BasicDBObject();
            deleteDoc.put("FIRST_NAME", firstName);
            dbCollection.remove(deleteDoc);

            System.out.println("Document with name " + firstName + " was deleted from " + collectionName + "!");
            System.out.println();
        } finally {
            mongo.close();
        }
        */
    }

    /**
     * method for selecting all data from DB collection
     */
    @Override
    public void selectAllFromDBTable() {
        List<Person> documents = mongoTemplate.findAll(Person.class);

        int i = 1; //counter of people
        for (Iterator<Person> iterator = documents.iterator(); iterator.hasNext(); ) {
            System.out.printf("Person #%d: %s%n", i++, iterator.next());
        }
        System.out.println();

        /*
        try {
            mongo = mongoConnection.getConnectionToDB();
            dataBase = mongo.getDB(mongoConnection.getDataBase());
            DBCollection dbCollection = dataBase.getCollection(collectionName);

            DBCursor documents = dbCollection.find();
            int i = 1; //counter of people
            while (documents.hasNext()) {
                System.out.printf("Person #%d: %s%n", i++, documents.next());
            }
            System.out.println();
        } finally {
            mongo.close();
        }
        */
    }

    /**
     * method for selecting some data from DB collection where name is ...
     */
    @Override
    public void selectFromDBTableForName(Person person) {
        Query selectDoc = new Query();
        selectDoc.addCriteria(Criteria.where("FIRST_NAME").is(person.getFIRST_NAME()));

        List<Person> documents = mongoTemplate.find(selectDoc, Person.class);

        int i = 1; //counter of people
        for (Iterator<Person> iterator = documents.iterator(); iterator.hasNext(); ) {
            System.out.printf("Person #%d: %s%n", i++, iterator.next());
        }
        System.out.println();

        /*
        try {
            mongo = mongoConnection.getConnectionToDB();
            dataBase = mongo.getDB(mongoConnection.getDataBase());
            DBCollection dbCollection = dataBase.getCollection(collectionName);

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
        */
    }

    @Override
    public void updateRecordInDBTable(Person oldPerson, Person newPerson) {
        Query updateDoc = new Query();
        updateDoc.addCriteria(Criteria.where("id").is(oldPerson.getId()));

        mongoTemplate.updateFirst(updateDoc, Update.update("FIRST_NAME", newPerson.getFIRST_NAME()), Person.class);
        mongoTemplate.updateFirst(updateDoc, Update.update("LAST_NAME", newPerson.getLAST_NAME()), Person.class);
        mongoTemplate.updateFirst(updateDoc, Update.update("EMAIL", newPerson.getEMAIL()), Person.class);
        mongoTemplate.updateFirst(updateDoc, Update.update("PHONE", newPerson.getPHONE()), Person.class);

        System.out.printf("Record with name %s was updated!%n", oldPerson.getFIRST_NAME());
        System.out.println();
    }
}
