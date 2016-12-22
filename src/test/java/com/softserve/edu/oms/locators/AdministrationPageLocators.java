package com.softserve.edu.oms.locators;

import org.openqa.selenium.By;

/**
 * Created by Voropai Dmytro
 */
public enum AdministrationPageLocators {

    DELETE_LINK_TEXT(By.linkText("Delete")),
    GO_TO_CREATE_NEW_USER_PAGE_CSS(By.cssSelector("#list>a")),
    EDIT_USER_LINK_TEXT(By.linkText("Edit")),
    CREATE_REPORT_CSS_SELECTOR(By.cssSelector("#list h5 a"));



    public final By by;
    AdministrationPageLocators(final By by){
        this.by = by;
    }
}
