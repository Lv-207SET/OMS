package com.softserve.edu.oms.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SupervisorHomePage extends HomePage{

    private static final String ITEM_MANAGEMENT_TAB_XPATH = "//a[contains(@href, 'itemManagement.htm')]";

    public SupervisorHomePage (WebDriver driver){
        super(driver);
    }

    // get Data

    public WebElement getItemManagementTab() {
        return driver.findElement(By.xpath(ITEM_MANAGEMENT_TAB_XPATH));
    }


    // set Data

    public void clickItemManagementTab() {
        getItemManagementTab().click();
    }


    // Business Logic

    public ItemManagementPage gotoItemManagementPage() {
        clickItemManagementTab();
        return new ItemManagementPage(driver);
    }


}
