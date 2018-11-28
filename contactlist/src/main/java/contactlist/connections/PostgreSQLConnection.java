package contactlist.connections;

import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * For now connection to PostgreSQL DB is executing through Spring JDBC configuration.
 * This class is alternative option for connection to PostgreSQL DB without Spring.
 */
public class PostgreSQLConnection {

    private static PostgreSQLConnection instance;

    /**
     * ContactList configuration from properties
     */
    private Properties configuration;

    /**
     * URL, login and password for PostgreSQL database on localhost
     */
    private String url;
    private String login;
    private String password;

    @Autowired
    public void setConfiguration(Properties configuration) {
        this.configuration = configuration;
    }

    /**
     * private constructor to exclude creation of instance
     */
    private PostgreSQLConnection() {
    }

    /**
     * @return instance of PostgreSQLConnection if it exists or create new one
     */
    public static PostgreSQLConnection getInstance() {
        if (instance == null) {
            instance = new PostgreSQLConnection();
        }
        return instance;
    }

    /**
     * setting info for connection to DB
     */
    public void setConnectionInfo() {
        this.url = configuration.getProperty("postgreSQL.url");
        this.login = configuration.getProperty("postgreSQL.login");
        this.password = configuration.getProperty("postgreSQL.password");
    }

    public void setConnectionInfo(String url, String login, String password) {
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
            // registering PostgreSQL driver in DriverManager
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
