package contactlist.management;

import contactlist.connections.PostgreSQLConnection;
import java.sql.*;

public class PostgreSQLDBManagement implements DBManagement {

    PostgreSQLConnection postgreSQLConnection;
    Connection connection;

    private PostgreSQLDBManagement() {}

    public PostgreSQLDBManagement(PostgreSQLConnection postgreSQLConnection) {
        this.postgreSQLConnection = postgreSQLConnection;
    }

    /**
     * method for deleting all data from DB table
     */
    @Override
    public void deleteAllFromDBTable(String tableName) {
        String deleteQuery = "DELETE FROM " + tableName.toUpperCase();

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
    @Override
    public void deleteFromDBTableForName(String tableName, String firstName) {
        String deleteQuery = "DELETE FROM " + tableName.toUpperCase() + " WHERE FIRST_NAME = '" + firstName + "'";

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
    @Override
    public void insertToDBTable(String tableName, String firstName, String lastName, String email, String phone) {
        String updateQuery = "INSERT INTO " + tableName.toUpperCase() + " (FIRST_NAME, LAST_NAME, EMAIL, PHONE) VALUES (?, ?, ?, ?)";

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

                System.out.printf("%s %s was added to %s!%n", firstName, lastName, tableName);
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
    @Override
    public void selectAllFromDBTable(String tableName) {
        String selectQuery = "SELECT * FROM " + tableName.toUpperCase();

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
    @Override
    public void selectFromDBTableForName(String tableName, String firstName) {
        String selectQuery = "SELECT * FROM " + tableName.toUpperCase() + " WHERE FIRST_NAME = '" + firstName + "'";

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
