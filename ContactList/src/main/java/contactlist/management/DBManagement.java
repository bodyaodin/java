package contactlist.management;

import contactlist.contacts.Person;

/**
 * Interface for management for data bases
 */
public interface DBManagement {

    public void insertToDBTable(Person person);

    public void deleteAllFromDBTable();

    public void deleteFromDBTableForName(Person person);

    public void selectAllFromDBTable();

    public void selectFromDBTableForName(Person person);

    public void updateRecordInDBTable(Person oldPerson, Person newPerson);
}
