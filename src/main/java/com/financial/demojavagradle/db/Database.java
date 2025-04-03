package com.financial.demojavagradle.db;

import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    /**
     * Location of database
     */
    private static final String location = DatabaseConfig.getDatabasePath();

    /**
     * Currently only table needed
     */
    private static final String requiredTable = "Expense";

    private static final Logger logger = Logger.getLogger(Database.class.getName());

    public static boolean isOK() {
        if (!checkDrivers()) {
            logger.log(Level.SEVERE, "Could not load JDBC driver");
            return false;
        }

        if (!checkConnection()) {
            logger.log(Level.SEVERE, "Could not connect to database");
            return false;
        }

        logger.log(Level.INFO, "Database connection established");
        return createTableIfNotExists(); //tables didn't exist
    }

    private static boolean checkDrivers() {
        try {
            Class.forName("org.sqlite.JDBC");
            DriverManager.registerDriver(new JDBC());
            return true;
        } catch (ClassNotFoundException | SQLException classNotFoundException) {
            logger.log(Level.SEVERE, "Could not load JDBC driver", classNotFoundException);
            return false;
        }
    }

    private static boolean checkConnection() {
        try (Connection connection = connect()) {
            return connection != null;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Could not connect to database", e);
            return false;
        }
    }

    private static boolean createTableIfNotExists() {
        String createTables =
                """
                             CREATE TABLE IF NOT EXISTS expense(
                                  date TEXT NOT NULL,
                                  housing REAL NOT NULL,
                                  food REAL NOT NULL,
                                  goingOut REAL NOT NULL,
                                  transportation REAL NOT NULL,
                                  travel REAL NOT NULL,
                                  tax REAL NOT NULL,
                                  other REAL NOT NULL
                          );
                        """;

        try (Connection connection = Database.connect()) {
            PreparedStatement statement = connection.prepareStatement(createTables);
            statement.executeUpdate();
            return true;
        } catch (SQLException exception) {
            logger.log(Level.SEVERE, "Could not create table", exception);
            return false;
        }
    }

    protected static Connection connect() {
        String dbPrefix = "jdbc:sqlite:";
        Connection connection;
        try {
            connection = DriverManager.getConnection(dbPrefix + location);
        } catch (SQLException exception) {
            logger.log(Level.SEVERE, "Could not connect to database", exception);
            return null;
        }
        return connection;
    }

}
