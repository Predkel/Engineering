package by.pvt.predkel.settings;

import by.pvt.predkel.exceptions.DaoException;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class PoolManager {
    private static PoolManager instance;
    private BasicDataSource dataSource;

    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<>();

    private PoolManager() {
        ResourceBundle bundle = ResourceBundle.getBundle("database");
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName(bundle.getString("database.driver"));
        dataSource.setUsername(bundle.getString("database.user"));
        dataSource.setPassword(bundle.getString("database.password"));
        dataSource.setUrl(bundle.getString("database.url"));
    }

    public static synchronized PoolManager getInstance() {
        if (instance == null) {
            instance = new PoolManager();
        }
        return instance;
    }

    private Connection connect() throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection;
    }

    public Connection getConnection() throws DaoException {
        try {
            if (connectionHolder.get() == null) {
                Connection connection = connect();
                connectionHolder.set(connection);
            }
        } catch (SQLException e) {
            String message = "Unable to get connection";
            throw new DaoException(message, e);
        }
        return connectionHolder.get();
    }

    public void releaseConnection(Connection connection) throws DaoException {
        if (connection != null) {
            try {
                connection.close();
                connectionHolder.remove();
            } catch (SQLException e) {
                String message = "Unable to release connection";
                throw new DaoException(message, e);
            }
        }
    }
}