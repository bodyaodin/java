package contactlist;

import contactlist.connections.MongoConnection;
import contactlist.connections.PostgreSQLConnection;
import contactlist.management.DBManagement;
import org.springframework.context.support.AbstractApplicationContext;

public class Test {

    public static void main(String[] args) {
        AbstractApplicationContext abstractApplicationContext = SpringContext.getAbstractApplicationContext();

//        PostgreSQLConnection psConnection = (PostgreSQLConnection) abstractApplicationContext.getBean("PostgreSQLConnection");
//        psConnection.setConnectionInfo();
//        DBManagement dbManagement = (DBManagement) abstractApplicationContext.getBean("PostgreSQLDBManagement");

        MongoConnection mongoConnection = (MongoConnection) abstractApplicationContext.getBean("MongoConnection");
        mongoConnection.setConnectionInfo();
        DBManagement dbManagement = (DBManagement) abstractApplicationContext.getBean("MongoDBManagement");

        dbManagement.deleteAllFromDBTable("Peoplelist");

        dbManagement.insertToDBTable("Peoplelist","Vasya","Pupkin","pupok@deneg.net","0932745446");
        dbManagement.insertToDBTable("Peoplelist","Dasha","Puteshestvennica","gogo@gmail.com","0967774488");
        dbManagement.insertToDBTable("Peoplelist","Bill","Gates","billy@dengi.est","0997777777");

        dbManagement.selectAllFromDBTable("Peoplelist");

        dbManagement.deleteFromDBTableForName("Peoplelist","Vasya");

        dbManagement.selectAllFromDBTable("Peoplelist");

        dbManagement.selectFromDBTableForName("Peoplelist","Dasha");


    }

}
