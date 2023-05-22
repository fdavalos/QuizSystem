/**
 * Exception thrown when an invalid email is encountered during email validation.
 * This exception is used to indicate that the provided email is not valid according to the specified criteria.
 *
 * <p>
 *     This exception is a subclass of the {@link RuntimeException} class,
 *     which makes it an unchecked exception that does not require explicit exception handling.
 * </p>
 *
 * <p>
 *     The error message associated with this exception provides information about the cause of the invalid email.
 * </p>
 *
 * <p>
 *     Author: Francisco Davalos
 *     Date: May 17, 2023
 * </p>
 */
package com.fdavalos.quizsystem.exceptions;

public class InvalidEmailException extends RuntimeException{

    /**
     * Constructs an InvalidEmailException with the specified error message.
     *
     * @param message the error message
     */
    public InvalidEmailException(String message){
        super(message);
    }
}
