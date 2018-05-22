package contactlist.management;

/**
 * Interface for management for data bases
 */
public interface DBManagement {

    public void deleteAllFromDBTable();

    public void deleteFromDBTableForName(String name);

    public void insertToDBTable(String firstName, String lastName, String email, String phone);

    public void selectAllFromDBTable();

    public void selectFromDBTableForName(String name);
}
