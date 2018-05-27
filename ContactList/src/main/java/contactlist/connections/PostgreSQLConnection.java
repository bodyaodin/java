package contactlist.connections;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class PostgreSQLConnection {

    private static PostgreSQLConnection instance;

    /**
     * ContactList configuration from properties file
     */
    private String configFileName;
    private Properties configuration;

    /**
     * URL, login and password for PostgreSQL database on localhost
     */
    private String url;
    private String login;
    private String password;

    /**
     * private constructor to exclude creation of instance
     */
    private PostgreSQLConnection(){}

    /**
     * @return instance of PostgreSQLConnection if it exists or create new one
     */
    public static PostgreSQLConnection getInstance() {
        if (instance == null) {
            PostgreSQLConnection.instance = new PostgreSQLConnection();
        }
        return instance;
    }

    public void setConfigFileName(String configFileName) {
        this.configFileName = configFileName;
    }

    /**
     * setting info for connection to DB
     */
    public void setConnectionInfo () {
        configuration = new Properties();
        try {
            configuration.load(new FileReader(configFileName));

            this.url = configuration.getProperty("postgreSQL.url");
            this.login = configuration.getProperty("postgreSQL.login");
            this.password = configuration.getProperty("postgreSQL.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setConnectionInfo (String url, String login, String password){
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
