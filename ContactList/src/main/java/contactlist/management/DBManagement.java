package contactlist.management;

import contactlist.contacts.Person;

/**
 * Interface for management for data bases
 */
public interface DBManagement {

    void insertToDBTable(Person person);

    void deleteAllFromDBTable();

    void deleteFromDBTableForName(Person person);

    void selectAllFromDBTable();

    void selectFromDBTableForName(Person person);

    void updateRecordInDBTable(Person oldPerson, Person newPerson);
}
