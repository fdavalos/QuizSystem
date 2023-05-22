package com.fdavalos.quizsystem.exceptions;
/**
 * Exception thrown when an invalid password is encountered during password validation.
 * This exception is used to indicate that the provided password is not valid according to the specified criteria.
 *
 * <p>
 *     This exception is a subclass of the {@link RuntimeException} class,
 *     which makes it an unchecked exception that does not require explicit exception handling.
 * </p>
 *
 * <p>
 *     The error message associated with this exception provides information about the cause of the invalid password.
 * </p>
 *
 * <p>
 *     Author: Francisco Davalos
 *     Date: May 17, 2023
 * </p>
 */

public class InvalidPasswordException extends RuntimeException{

    /**
     * Constructs an InvalidPasswordException with the specified error message.
     *
     * @param message the error message describing the cause of the exception
     */
    public InvalidPasswordException(String message){
        super(message);
    }
}
