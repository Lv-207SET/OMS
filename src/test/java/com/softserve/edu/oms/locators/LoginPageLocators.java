package com.softserve.edu.oms.locators;

import org.openqa.selenium.By;


public enum LoginPageLocators {

    ATTRIBUTE(By.name("name")),
    LOGIN_INPUT_FIELD(By.name("j_username") ),
    PASSWORD_INPUT_FIELD(By.name("j_password")),
    LOGIN_BUTTON(By.name("submit")),
    RESET_BUTTON(By.name("reset")),
    REMEMBER_ME_CHECKBOX(By.name("_spring_security_remember_me"));


    public final By by;

    LoginPageLocators(final By by){
        this.by = by;
    }

}
