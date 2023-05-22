package com.fdavalos.quizsystem.util;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * Manages the database connection for the Quiz System.
 *
 * <p>
 *     This class provides methods to establish and close a database connection using HikariCP connection pooling.
 *     It utilizes the SQLite database located at the specified JDBC URL.
 * </p>
 *
 * <p>
 *     Author: Francisco Davalos
 *     Date: May 17, 2023
 * </p>
 */
public class DatabaseConnectionManager {
    private static final String jdbcUrl = "jdbc:sqlite:usersdb.db";
    private static final int maxPoolSize = 10;
    private static final String poolName = "QuizSystemPool";

    private static HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrl);
        config.setMaximumPoolSize(maxPoolSize);
        config.setPoolName(poolName);

        dataSource = new HikariDataSource(config);
    }

    /**
     * Retrieves a database connection from the connection pool.
     *
     * @return a database connection
     * @throws SQLException if an error occurs while retrieving a connection
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * Closes the database connection.
     *
     * @param connection the database connection to be closed
     * @throws SQLException if an error occurs while closing the connection
     */
    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            System.out.println(connection);
            connection.close();
        }
    }
}
