package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import controller.PropertyReader;
import org.apache.commons.dbcp.BasicDataSource;

public class ConnectionFactory {
    private ConnectionFactory() {}
    
    private static Connection  connection = null;
    private static final String POSTGRES_PROPERTIES = "db.properties";

    public static Connection getConnection() throws SQLException {
        PropertyReader propReader = new PropertyReader();
        Properties properties = propReader.getProperties(POSTGRES_PROPERTIES);
        connection = DriverManager.getConnection(properties.getProperty("db.url"),
                properties.getProperty("db.user"),
                properties.getProperty("db.password"));
        return connection;
    }
}
