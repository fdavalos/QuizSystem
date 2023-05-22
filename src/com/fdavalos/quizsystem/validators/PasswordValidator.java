package com.fdavalos.quizsystem.validators;

import com.fdavalos.quizsystem.exceptions.InvalidPasswordException;

/**
 * Validator class to validate passwords in the Quiz System.
 *
 * <p>
 *     This class provides a method to validate the complexity of passwords based on certain criteria.
 *     It throws an InvalidPasswordException if the password does not meet the complexity requirements.
 * </p>
 *
 * <p>
 *     Author: Francisco Davalos
 *     Date: May 17, 2023
 * </p>
 */
public class PasswordValidator {

    /**
     * Validates the complexity of a password.
     *
     * @param password the password to validate
     * @return true if the password is complex
     * @throws InvalidPasswordException if the password is not complex
     */
    public static boolean isPasswordComplex(String password){
        if(password.length() < 8 ){
            throw new InvalidPasswordException("Password should have a minimum of 8 characters");
        }

        if(password.length() > 20){
            throw new InvalidPasswordException("Password should be 20 or less characters");
        }

        if(!password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*")){
            throw new InvalidPasswordException("Password should include both uppercase and lowercase letters");
        }

        if(!password.matches(".*\\d.*")){
            throw new InvalidPasswordException("Password should include at least one numeric digit");
        }

        if(!password.matches(".*[@#$%^&+=!].*")){
            throw new InvalidPasswordException("Password should include at least one special character (@#$%^&+=!).");
        }
        return true;
    }
}
