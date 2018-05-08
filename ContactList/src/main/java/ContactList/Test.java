package ContactList;

import ContactList.Connections.PostgreSQLConnection;
import ContactList.Management.DBManagement;
import ContactList.Management.PostgreSQLDBManagement;

public class Test {

    public static void main(String[] args) {
        PostgreSQLConnection PSConnection = PostgreSQLConnection.getInstance();
        PSConnection.setConnectionInfo();
        DBManagement dbManagement = new PostgreSQLDBManagement(PSConnection);

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
