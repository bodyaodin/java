package contactlist;

import contactlist.connections.MongoConnection;
import contactlist.connections.PostgreSQLConnection;
import contactlist.management.DBManagement;
import contactlist.management.MongoDBManagement;
import contactlist.management.PostgreSQLDBManagement;
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

        dbManagement.deleteAllFromDBTable();

        dbManagement.insertToDBTable("Vasya","Pupkin","pupok@deneg.net","0932745446");
        dbManagement.insertToDBTable("Dasha","Puteshestvennica","gogo@gmail.com","0967774488");
        dbManagement.insertToDBTable("Bill","Gates","billy@dengi.est","0997777777");

        dbManagement.selectAllFromDBTable();

        dbManagement.deleteFromDBTableForName("Vasya");

        dbManagement.selectAllFromDBTable();

        dbManagement.selectFromDBTableForName("Dasha");


    }

}
