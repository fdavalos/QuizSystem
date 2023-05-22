package com.fdavalos.quizsystem.ui;

import com.fdavalos.quizsystem.util.QuizQuestionReader;
import com.fdavalos.quizsystem.util.UserHandler;
import com.fdavalos.quizsystem.util.DatabaseConnectionManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Handles the display and handling of menus in the Quiz System.
 *
 * <p>
 *     This class provides methods to display and handle the login and main menus in the Quiz System application.
 *     It interacts with the UserHandler, QuizQuestionReader, and DatabaseConnectionManager classes to perform
 *     user registration, user login, quiz options display, and database connection management.
 * </p>
 *
 * <p>
 *     Author: Francisco Davalos
 *     Date: May 17, 2023
 * </p>
 */
public class MenuHandler {
    private static Connection connection;

    /**
     * Displays the login menu options.
     */
    public static void displayLoginMenu() {
        for (LoginMenuOption option : LoginMenuOption.values()) {
            System.out.println(option.getCode() + ". " + option.getDescription());
        }
        System.out.print("Enter your choice: ");
    }

    /**
     * Displays the main menu options.
     */
    public static void displayMainMenu() {
        for (MainMenuOption option : MainMenuOption.values()) {
            System.out.println(option.getCode() + ". " + option.getDescription());
        }
        System.out.print("Enter your choice: ");
    }

    /**
     * Handles the user's choice in the login menu.
     *
     * @param choice the user's choice
     * @return true if the user is logged in, false otherwise
     * @throws SQLException if a database error occurs
     */
    public static boolean handleLoginMenuChoice(int choice) throws SQLException {
        LoginMenuOption selectedOption = LoginMenuOption.fromCode(choice);

        if (selectedOption == null) {
            System.out.println("Invalid choice. Please try again.");
            return false;
        }

        switch (selectedOption) {
            case REGISTER:
                UserHandler.registerUser();
                break;
            case LOGIN:
                boolean loginSuccess = UserHandler.loginUser();
                if (loginSuccess) {
                    try {
                        connection = DatabaseConnectionManager.getConnection();
                        System.out.println("You are logged in\n");
                        return true;
                    } catch (SQLException e) {
                        System.out.println("Failed to establish a database connection");
                        return false;
                    }
                }else{
                    System.out.println("Wrong Credentials. Try Again\n");
                }
                break;
            case EXIT:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
        }
        return false;
    }

    /**
     * Handles the user's choice in the main menu.
     *
     * @param choice the user's choice
     * @return true if the user is still logged in, false otherwise
     */
    public static boolean handleMainMenuChoice(int choice) {
        MainMenuOption selectedOption = MainMenuOption.fromCode(choice);

        if (selectedOption == null) {
            System.out.println("Invalid choice. Please try again.");
            return true;
        }

        switch (selectedOption) {
            case VIEW_OPTIONS:
                QuizGame quiz = new QuizGame(QuizQuestionReader.readQuizQuestions());
                quiz.startQuiz();
                break;
            case SIGN_OUT:
                try {
                    if (connection != null) {
                        DatabaseConnectionManager.closeConnection(connection);
                        connection = null;
                        System.out.println("Signed out");
                    } else {
                        System.out.println("You are not currently logged in");
                    }
                } catch (SQLException e) {
                    System.out.println("Failed to close the database connection");
                    return true;
                }
                return false;

            case EXIT:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
        }
        return true;
    }

    /**
     * Retrieves the user's choice from the console input.
     *
     * @return the user's choice as an integer
     */
    public static int getUserChoice() {
        Scanner scan = new Scanner(System.in);
        int choice;

        while (true) {
            try {
                choice = scan.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer");
                scan.next();
            }
        }
        return choice;
    }
}

