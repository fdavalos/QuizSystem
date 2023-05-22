package com.fdavalos.quizsystem.ui;


import java.sql.SQLException;

/**
 * The main class of the Quiz System application.
 *
 * <p>
 *     This class serves as the entry point of the Quiz System application. It displays the login menu and main menu
 *     based on the user's login status and handles the user's menu choices accordingly.
 * </p>
 *
 * <p>
 *     Author: Francisco Davalos
 *     Date: May 17, 2023
 * </p>
 */
public class Main {

    public static void main(String[] args) throws SQLException {


        boolean isLoggedIn = false;

        System.out.println("---Welcome to the Quiz System---");

        while(true) {

            while(!isLoggedIn) {
                MenuHandler.displayLoginMenu();
                int choice = MenuHandler.getUserChoice();
                isLoggedIn = MenuHandler.handleLoginMenuChoice(choice);
            }

            while(isLoggedIn) {
                MenuHandler.displayMainMenu();
                int choice = MenuHandler.getUserChoice();
                isLoggedIn = MenuHandler.handleMainMenuChoice(choice);
            }

        }

    }

}

