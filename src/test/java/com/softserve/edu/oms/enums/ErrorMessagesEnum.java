package com.softserve.edu.oms.enums;

public enum ErrorMessagesEnum {
    ERROR_MESSAGE("Your login attempt was not successful, try again.\n" + "\n" + "Reason: Bad credentials."),
    FIRST_NAME_ERROR_MESSAGE("First name cannot contain digits"),
    LAST_NAME_ERROR_MESSAGE("Last name cannot contain digits"),
    CONFIRM_PASSWORD_ERROR_MESSAGE("Confirm password has to be equal to password"),
    SQL_EXCEPTION_MESSAGE ("SQL Exception found");

    public final String message;

    ErrorMessagesEnum (final String message){
        this.message = message;
    }


}
