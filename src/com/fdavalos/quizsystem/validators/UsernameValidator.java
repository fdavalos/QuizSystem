package com.fdavalos.quizsystem.validators;

import com.fdavalos.quizsystem.exceptions.InvalidUsernameException;
import java.util.regex.Pattern;

/**
 * Validator class to validate usernames in the Quiz System.
 *
 * <p>
 *     This class provides a method to validate the format and length of usernames based on certain criteria.
 *     It throws an InvalidUsernameException if the username does not meet the requirements.
 * </p>
 *
 * <p>
 *     Author: Francisco Davalos
 *     Date: May 17, 2023
 * </p>
 */
public class UsernameValidator {
    private static final String USERNAME_REGEX = "^[A-Za-z]+[A-Za-z0-9]+$";
    private static final Pattern USERNAME_PATTERN = Pattern.compile(USERNAME_REGEX);

    /**
     * Validates the format and length of a username.
     *
     * @param username the username to validate
     * @return true if the username is valid
     * @throws InvalidUsernameException if the username is invalid
     */
    public static boolean isValidUsername(String username){
        if(username.length() < 5){
            throw new InvalidUsernameException("Username must be at least 5 characters long");
        }
        if(username.length() > 20){
            throw new InvalidUsernameException("Username must be at the most 20 characters");
        }

        if(!USERNAME_PATTERN.matcher(username).matches()){
            if(Character.isDigit(username.charAt(0))){
                throw new InvalidUsernameException("Username cannot start with a numeric digit");
            }
            throw new InvalidUsernameException("Username cannot contain special characters");
        }
        return true;
    }
}
