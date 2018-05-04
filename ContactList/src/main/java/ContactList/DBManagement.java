package ContactList;

import ContactList.Connections.PostgreSQLConnection;

import java.sql.*;

/**
 * For now all methods working only with one table!!!
 */
public class DBManagement {

    PostgreSQLConnection postgreSQLConnection;
    Connection connection;

    private DBManagement() {}

    public DBManagement(PostgreSQLConnection postgreSQLConnection) {
        this.postgreSQLConnection = postgreSQLConnection;
    }

    /**
     * method for deleting all data from DB table
     */
    public void deleteAllFromDBTable() {
        String deleteQuery = "DELETE FROM PEOPLELIST";

        try {
            try{
                connection = postgreSQLConnection.getConnectionToDB();

                Statement statement = connection.createStatement();
                int deletedLines = statement.executeUpdate(deleteQuery);
                statement.close();

                System.out.println("Count of deleted lines - " + deletedLines + "!");
                System.out.println();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * method for deleting some data from DB table where name is ...
     */
    public void deleteFromDBTableForName(String name) {
        String deleteQuery = "DELETE FROM PEOPLELIST WHERE FIRST_NAME = '" + name + "'";

        try {
            try{
                connection = postgreSQLConnection.getConnectionToDB();

                Statement statement = connection.createStatement();
                int deletedLines = statement.executeUpdate(deleteQuery);
                statement.close();

                System.out.println("Count of deleted lines - " + deletedLines + "!");
                System.out.println();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * method for inserting data to DB table
     */
    public void insertToDBTable(String firstName, String lastName, String email, String phone) {
        String updateQuery = "INSERT INTO PEOPLELIST (FIRST_NAME, LAST_NAME, EMAIL, PHONE) VALUES (?, ?, ?, ?)";

        try {
            try{
                connection = postgreSQLConnection.getConnectionToDB();

                PreparedStatement statement = connection.prepareStatement(updateQuery);
                statement.setString(1, firstName);
                statement.setString(2, lastName);
                statement.setString(3, email);
                statement.setString(4, phone);
                statement.executeUpdate();
                statement.close();

                System.out.printf("%s %s was added to PeopleList!%n", firstName, lastName);
                System.out.println();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * method for selecting all data from DB table
     */
    public void selectAllFromDBTable() {
        String selectQuery = "SELECT * FROM PEOPLELIST";

        try {
            try{
                connection = postgreSQLConnection.getConnectionToDB();

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(selectQuery);

                int i = 1; //counter of people
                while (resultSet.next()) {
                    String resultLine = resultSet.getString("FIRST_NAME") + " " + resultSet.getString("LAST_NAME")
                            + " - " + resultSet.getString("EMAIL") + "; " + resultSet.getString("PHONE") + " !";
                    System.out.printf("Person #%d: %s%n", i++, resultLine);
                }
                System.out.println();

                resultSet.close();
                statement.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * method for selecting some data from DB table where name is ...
     */
    public void selectFromDBTableForName(String name) {
        String selectQuery = "SELECT * FROM PEOPLELIST WHERE FIRST_NAME = '" + name + "'";

        try {
            try{
                connection = postgreSQLConnection.getConnectionToDB();

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(selectQuery);

                int i = 1; //counter of people
                while (resultSet.next()) {
                    String resultLine = resultSet.getString("FIRST_NAME") + " " + resultSet.getString("LAST_NAME")
                            + " - " + resultSet.getString("EMAIL") + "; " + resultSet.getString("PHONE") + " !";
                    System.out.printf("Person #%d: %s%n", i++, resultLine);
                }
                System.out.println();

                resultSet.close();
                statement.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
