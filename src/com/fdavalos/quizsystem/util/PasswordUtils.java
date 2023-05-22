package com.fdavalos.quizsystem.util;

import org.mindrot.jbcrypt.BCrypt;
import java.security.SecureRandom;

/**
 * Provides utility methods for password-related operations in the Quiz System.
 *
 * <p>
 *     This class includes methods to generate a random salt, hash a password using BCrypt,
 *     and verify a password against its hashed version.
 * </p>
 *
 * <p>
 *     Author: Francisco Davalos
 *     Date: May 17, 2023
 * </p>
 */
public class PasswordUtils {
    private static final int SALT_LENGTH = 16;

    /**
     * Generates a random salt for password hashing.
     *
     * @return the generated salt as a string
     */
    public static String generateSalt(){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return BCrypt.gensalt(12,random);
    }

    /**
     * Hashes a password using BCrypt with the provided salt.
     *
     * @param password the password to be hashed
     * @param salt the salt used for hashing
     * @return the hashed password
     */
    public static String hashPassword(String password, String salt){

        return BCrypt.hashpw(password, salt);
    }

    /**
     * Verifies a password against its hashed version.
     *
     * @param password the password to be verified
     * @param hashedPassword the hashed password to compare against
     * @return true if the password matches the hashed password, false otherwise
     */
    public static boolean verifyPassword(String password, String hashedPassword){
        return BCrypt.checkpw(password, hashedPassword);
    }
}
