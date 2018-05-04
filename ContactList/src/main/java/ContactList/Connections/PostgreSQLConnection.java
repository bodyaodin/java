package ContactList.Connections;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnection {

    /**
     * URL, login and password for PostgreSQL database on localhost
     */
    private String url = "jdbc:postgresql://localhost:5432/ContactListDB";
    private String login = "postgres";
    private String password = "postgres";

    public PostgreSQLConnection(){}

    public PostgreSQLConnection(String url, String login, String password){
        this.url = url;
        this.login = login;
        this.password = password;
    }

    /**
     * create connection to DB
     */
    public Connection getConnectionToDB() {
        Connection connection = null;
        try {
            // register PostgreSQL driver in DriverManager
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
