package com.fdavalos.quizsystem.ui;

/**
 * An enumeration representing the options available in the main menu of the Quiz System.
 *
 * <p>
 *     This enumeration defines the available options in the main menu of the Quiz System application.
 *     Each option has a unique code and a description.
 * </p>
 *
 * <p>
 *     Author: Francisco Davalos
 *     Date: May 17, 2023
 * </p>
 */
public enum MainMenuOption {

    VIEW_OPTIONS(1, "View Quiz Options"),
    SIGN_OUT(2, "Sign Out"),
    EXIT(3, "Exit");

    private final int code;
    private final String description;

    MainMenuOption(int code, String description){
        this.code = code;
        this.description = description;
    }

    public int getCode(){
        return code;
    }

    public String getDescription(){
        return description;
    }

    public static MainMenuOption fromCode(int code){
        for(MainMenuOption option : values()){
            if(option.getCode() == code){
                return option;
            }
        }
        return null;
    }
}
