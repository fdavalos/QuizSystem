package com.fdavalos.quizsystem.registration;

import com.fdavalos.quizsystem.exceptions.InvalidEmailException;
import com.fdavalos.quizsystem.exceptions.InvalidPasswordException;
import com.fdavalos.quizsystem.exceptions.InvalidUsernameException;
import com.fdavalos.quizsystem.validators.EmailValidator;
import com.fdavalos.quizsystem.validators.PasswordValidator;
import com.fdavalos.quizsystem.validators.UsernameValidator;
import com.fdavalos.quizsystem.dao.UserDAO;
import com.fdavalos.quizsystem.util.PasswordUtils;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Class responsible for registering a user in the Quiz System.
 *
 * <p>
 *     This class handles the user registration process by prompting the user to enter their username, email, and password.
 *     It performs validation checks on the entered values using appropriate validators.
 *     If the entered values are valid, it generates a salt, hashes the password, and inserts the user into the database using the {@link UserDAO} class.
 *     If any validation fails, appropriate exceptions are thrown and error messages are displayed to the user.
 * </p>
 *
 * <p>
 *     This class is not meant to be instantiated, as all its methods are static.
 * </p>
 *
 * <p>
 *     Author: Francisco Davalos
 *     Date: May 17, 2023
 * </p>
 */
public class UserRegistration {

    /**
     * Performs the user registration process.
     *
     * @throws SQLException if an error occurs while accessing the database
     */
    public static void registerUser() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("User Registration");
        System.out.println("-----------------");


        String username = "";
        while (true) {
            try{
                System.out.print("Enter username: ");
                username = scanner.nextLine();
                UsernameValidator.isValidUsername(username);
                break;
            }catch (InvalidUsernameException e){
                    System.out.println(e.getMessage() + ". Try again");
            }
        }

        String email = "";
        while(true) {
            try {
                System.out.print("Enter email: ");
                email = scanner.nextLine();
                EmailValidator.isValidEmail(email);
                break;
            } catch(InvalidEmailException e) {
                System.out.println(e.getMessage() + ". Try again");
            }
        }

        String password = "";
        while(true){
            try{
                System.out.print("Enter password: ");
                password = scanner.nextLine();
                PasswordValidator.isPasswordComplex(password);
                break;
            }catch (InvalidPasswordException e){
                System.out.println(e.getMessage() + ". Try again");
            }
        }

        String salt = PasswordUtils.generateSalt();
        String hashedPassword = PasswordUtils.hashPassword(password, salt);

        UserDAO.insertUser(username, email, hashedPassword,salt);
    }
}
