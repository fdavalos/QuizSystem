/*
 * UserDAO - Handles database operations related to users, such as inserting and retrieving user information.
 *
 * This class provides methods to interact with the users table in the database. It allows inserting new users
 * and validating user login credentials.
 *
 * Created: May 17, 2023
 * Author: Francisco Davalos
 */
package com.fdavalos.quizsystem.dao;

import com.fdavalos.quizsystem.util.DatabaseConnectionManager;
import com.fdavalos.quizsystem.util.PasswordUtils;
import org.sqlite.SQLiteException;

import java.sql.*;

public class UserDAO {
    private static final DatabaseConnectionManager connectionManager = new DatabaseConnectionManager();

    /**
     * Inserts a new user into the database.
     *
     * @param username the username of the user
     * @param email    the email of the user
     * @param password the password of the user
     * @param salt     the salt used for password hashing
     */
    public static void insertUser(String username, String email, String password, String salt) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO users (username, email, password, salt) VALUES (?,?,?,?)")) {

            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setString(4, salt);
            statement.executeUpdate();
        } catch (SQLiteException e) {
            if (e.getMessage().contains("UNIQUE constraint failed: users.email")) {
                System.out.println("Failed to insert user. A user with the same email already exists.");
            } else if (e.getMessage().contains("UNIQUE constraint failed: users.username")) {
                System.out.println("Failed to insert user. A user with the same username already exists.");
            } else {
                System.out.println("Failed to insert user: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e);
        }
    }

    /**
     * Authenticates a user by checking the provided username and password against the database.
     *
     * @param username the username of the user
     * @param password the password of the user
     * @return true if the user is authenticated, false otherwise
     */
    public static boolean loginUser(String username, String password) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT password, salt FROM users WHERE username = ?")) {

            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String hashedPassword = resultSet.getString("password");

                if (PasswordUtils.verifyPassword(password, hashedPassword)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e);
        }
        return false;
    }

}


