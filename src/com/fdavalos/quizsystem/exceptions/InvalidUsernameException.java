package com.fdavalos.quizsystem.exceptions;
/**
 * Exception thrown when an invalid username is encountered during username validation.
 * This exception is used to indicate that the provided username is not valid according to the specified criteria.
 *
 * <p>
 *     This exception is a subclass of the {@link RuntimeException} class,
 *     which makes it an unchecked exception that does not require explicit exception handling.
 * </p>
 *
 * <p>
 *     The error message associated with this exception provides information about the cause of the invalid username.
 * </p>
 *
 * <p>
 *     Author: Francisco Davalos
 *     Date: May 17, 2023
 * </p>
 */
public class InvalidUsernameException extends RuntimeException{

    /**
     * Constructs an InvalidUsernameException with the specified error message.
     *
     * @param message the error message describing the cause of the exception
     */
    public InvalidUsernameException(String message){
        super(message);
    }
}
