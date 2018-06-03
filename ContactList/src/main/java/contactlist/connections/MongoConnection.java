package contactlist.connections;

import java.util.Properties;
import com.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * For now connection to Mongo DB is executing through Spring Mongo configuration.
 * This class is alternative option for connection to Mongo DB without Spring.
 */
public class MongoConnection {

    private static MongoConnection instance;

    /**
     * ContactList configuration from properties
     */
    private Properties configuration;

    /**
     * info for connection to Mongo database
     */
    private String host;
    private int port;
    private String dataBase;
    private String login;
    private String password;

    public String getDataBase() {
        return dataBase;
    }

    @Autowired
    public void setConfiguration(Properties configuration) {
        this.configuration = configuration;
    }

    /**
     * private constructor to exclude creation of instance
     */
    private MongoConnection() {
    }

    /**
     * @return instance of PostgreSQLConnection if it exists or create new one
     */
    public static MongoConnection getInstance() {
        if (instance == null) {
            MongoConnection.instance = new MongoConnection();
        }
        return instance;
    }

    /**
     * setting info for connection to DB
     */
    public void setConnectionInfo() {
        this.host = configuration.getProperty("mongo.host");
        this.port = Integer.parseInt(configuration.getProperty("mongo.port"));
        this.dataBase = configuration.getProperty("mongo.dataBase");
        this.login = configuration.getProperty("mongo.login");
        this.password = configuration.getProperty("mongo.password");
    }

    public void setConnectionInfo(String host, int port, String dataBase, String login, String password) {
        this.host = host;
        this.port = port;
        this.dataBase = dataBase;
        this.login = login;
        this.password = password;
    }

    /**
     * create connection to DB
     */
    public Mongo getConnectionToDB() {
        Mongo mongo = new Mongo(host, port);
        return mongo;
    }
}
