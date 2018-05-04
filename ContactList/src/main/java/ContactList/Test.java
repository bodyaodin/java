package ContactList;

import ContactList.Connections.PostgreSQLConnection;

public class Test {

    public static void main(String[] args) {
        PostgreSQLConnection PSConnection = new PostgreSQLConnection();
        DBManagement dbManagement = new DBManagement(PSConnection);

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
