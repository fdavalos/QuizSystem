package com.fdavalos.quizsystem.ui;

/**
 * Enumeration representing the options available in the login menu.
 *
 * <p>
 *     This enum provides a list of options that can be chosen in the login menu of the Quiz System application.
 *     Each option is associated with a code, a description, and a menu category.
 * </p>
 *
 * <p>
 *     This enum is used to facilitate menu navigation and user input processing.
 * </p>
 *
 * <p>
 *     Author: Francisco Davalos
 *     Date: May 17, 2023
 * </p>
 */

public enum LoginMenuOption {
    REGISTER(1,"Register" , "Login"),
    LOGIN(2, "Login", "Login"),
    EXIT(3, "Exit", "All");

    private final int code;
    private final String description;

    private final String menu;

    /**
     * Constructs a LoginMenuOption with the specified code, description, and menu category.
     *
     * @param code        the code representing the option
     * @param description the description of the option
     * @param menu        the category of the option in the menu
     */
    LoginMenuOption(int code, String description, String menu){
        this.code = code;
        this.description = description;
        this.menu = menu;
    }

    /**
     * Returns the code of the LoginMenuOption.
     *
     * @return the code of the option
     */
    public int getCode(){
        return code;
    }

    /**
     * Returns the description of the LoginMenuOption.
     *
     * @return the description of the option
     */
    public String getDescription(){
        return description;
    }

    /**
     * Returns the LoginMenuOption associated with the given code.
     *
     * @param code the code of the option to retrieve
     * @return the LoginMenuOption associated with the code, or null if no matching option is found
     */
    public static LoginMenuOption fromCode(int code){
        for(LoginMenuOption option : values()){
            if(option.getCode() == code){
                return option;
            }
        }
        return null;
    }

}
