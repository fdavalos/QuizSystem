package com.fdavalos.quizsystem.validators;

import com.fdavalos.quizsystem.exceptions.InvalidEmailException;
import java.util.regex.Pattern;

/**
 * Validator class to validate email addresses in the Quiz System.
 *
 * <p>
 *     This class provides a method to validate email addresses using a regular expression pattern.
 *     It throws an InvalidEmailException if the email address does not match the expected format.
 * </p>
 *
 * <p>
 *     Author: Francisco Davalos
 *     Date: May 17, 2023
 * </p>
 */
public class EmailValidator {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    /**
     * Validates an email address.
     *
     * @param email the email address to validate
     * @return true if the email address is valid
     * @throws InvalidEmailException if the email address is invalid
     */
    public static boolean isValidEmail(String email){
        if(!EMAIL_PATTERN.matcher(email).matches()){
            throw new InvalidEmailException("Invalid email format");
        }
        return true;
    }
}
