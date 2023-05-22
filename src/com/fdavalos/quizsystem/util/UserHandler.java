package com.fdavalos.quizsystem.util;

import com.fdavalos.quizsystem.dao.UserDAO;
import com.fdavalos.quizsystem.registration.UserRegistration;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Handles user-related operations in the Quiz System.
 *
 * <p>
 *     This class provides methods for user registration and login. It interacts with the UserRegistration and UserDAO
 *     classes to perform user registration and login operations.
 * </p>
 *
 * <p>
 *     Author: Francisco Davalos
 *     Date: May 17, 2023
 * </p>
 */
public class UserHandler {
    private static boolean isLoggedIn = false;

    /**
     * Registers a new user.
     *
     * @throws SQLException if an SQL exception occurs during the registration process
     */
    public static void registerUser() throws SQLException {
        UserRegistration.registerUser();
    }

    /**
     * Logs in a user.
     *
     * @return true if the login is successful, false otherwise
     * @throws SQLException if an SQL exception occurs during the login process
     */
    public static boolean loginUser() throws SQLException {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter your username: ");
            String username = scan.nextLine();
            System.out.print("Enter your password: ");
            String password = scan.nextLine();

            isLoggedIn = UserDAO.loginUser(username, password);

            return isLoggedIn;
    }
}
