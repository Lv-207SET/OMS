package com.softserve.edu.oms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginValidatorPage  extends LoginPage{

    private static final String BAD_CREDENTIALS_ERROR_MESSAGE_CSS = "#edit>fieldset>font";

    public LoginValidatorPage(WebDriver driver){
        super(driver);
    }

    // get Data

    public WebElement getBadCredentialsErrorMessage() {
        return driver.findElement(By.cssSelector(BAD_CREDENTIALS_ERROR_MESSAGE_CSS));
    }

    // Functional

    public String getBadCredentialsErrorMessageText() {
        return driver.findElement(By.cssSelector(BAD_CREDENTIALS_ERROR_MESSAGE_CSS)).getText();
    }

}
