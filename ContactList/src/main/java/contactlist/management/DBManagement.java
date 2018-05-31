package contactlist.management;

/**
 * Interface for management for data bases
 */
public interface DBManagement {

    public void insertToDBTable(String tableName, String firstName, String lastName, String email, String phone);

    public void deleteAllFromDBTable(String tableName);

    public void deleteFromDBTableForName(String tableName, String firstName);

    public void selectAllFromDBTable(String tableName);

    public void selectFromDBTableForName(String tableName, String firstName);
}
