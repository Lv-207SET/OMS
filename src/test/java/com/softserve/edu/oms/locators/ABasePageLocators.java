package com.softserve.edu.oms.locators;


import org.openqa.selenium.By;

/**
 * Enum contains locators for elements on {@link com.softserve.edu.oms.pages.ABasePage}.
 */
public enum ABasePageLocators {

    LOGOUT_BUTTON(By.cssSelector(".spec a")),
    OMS_LABEL(By.cssSelector("#logo h1")),
    SIMPLE_SLIM_GENIUS_LABEL(By.cssSelector("#logo h2")),
    INSPIRED_BY_GOOGLE_LINK(By.cssSelector("#footer a")),
    USER_INFO_TAB(By.cssSelector("*[href=\"/OMS/userInfo.htm\"]"));

    public final By by;
    ABasePageLocators(final By by){
        this.by = by;
    }
}
