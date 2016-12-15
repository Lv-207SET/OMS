package com.softserve.edu.oms.locators;

import org.openqa.selenium.By;


public enum LoginPageLocators {

    ATTRIBUTE(LocatorType.NAME, "name"),
    LOGIN_INPUT_FIELD(LocatorType.NAME, "j_username"),
    PASSWORD_INPUT_FIELD(LocatorType.NAME, "j_password");

    private LocatorType locatorType;
    private String locator;

    LoginPageLocators(LocatorType locatorType, String locator){
        this.locatorType = locatorType;
        this.locator = locator;

    }

    public By getBy(){
        switch(locatorType) {
            case CLASSNAME:
                return new By.ByClassName(locator);
            case CSS:
                return new By.ByCssSelector(locator);
            case ID:
                return new By.ById(locator);
            case LINK:
                return new By.ByLinkText(locator);
            case NAME:
                return new By.ByName(locator);
            case TAGNAME:
                return new By.ByTagName(locator);
            case XPATH:
                return new By.ByXPath(locator);
        }
        return null;

    }
}
