package contactlist;

import contactlist.connections.MongoConnection;
import contactlist.connections.PostgreSQLConnection;
import contactlist.contacts.Person;
import contactlist.management.DBManagement;
import org.springframework.context.support.AbstractApplicationContext;

public class Test {

    public static void main(String[] args) {
        AbstractApplicationContext abstractApplicationContext = SpringContext.getAbstractApplicationContext();

        //----- Inserting peoples --------------------------------------------------------------------------------------

        Person person1 = (Person) abstractApplicationContext.getBean("Person");
        person1.setFIRST_NAME("Vasya");
        person1.setLAST_NAME("Pupkin");
        person1.setEMAIL("pupok@deneg.net");
        person1.setPHONE("0932745446");
        Person person2 = (Person) abstractApplicationContext.getBean("Person");
        person2.setFIRST_NAME("Dasha");
        person2.setLAST_NAME("Puteshestvennica");
        person2.setEMAIL("gogo@gmail.com");
        person2.setPHONE("0967774488");
        Person person3 = (Person) abstractApplicationContext.getBean("Person");
        person3.setFIRST_NAME("Bill");
        person3.setLAST_NAME("Gates");
        person3.setEMAIL("billy@dengi.est");
        person3.setPHONE("0997777777");

        //----- Creating Managements -----------------------------------------------------------------------------------

//        DBManagement dbManagement = (DBManagement) abstractApplicationContext.getBean("PostgreSQLDBManagement");
        DBManagement dbManagement = (DBManagement) abstractApplicationContext.getBean("MongoDBManagement");

        //----- Testing of Data Bases ----------------------------------------------------------------------------------

        dbManagement.deleteAllFromDBTable();

        dbManagement.insertToDBTable(person1);
        dbManagement.insertToDBTable(person2);
        dbManagement.insertToDBTable(person3);

        dbManagement.selectAllFromDBTable();

        dbManagement.deleteFromDBTableForName(person1);

        dbManagement.selectAllFromDBTable();

        dbManagement.selectFromDBTableForName(person2);
        //--------------------------------------------------------------------------------------------------------------

        abstractApplicationContext.close();

    }

}
