package com.softserve.edu.oms.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerHomePage extends HomePage{

    private final static String ORDERING_TAB_XPATH = "//a[contains(@href, 'order.htm')]";

    public CustomerHomePage(WebDriver driver){
        super(driver);
    }


    // get Data

    public WebElement getOrderingTab(){
        return driver.findElement(By.xpath(ORDERING_TAB_XPATH));
    }


    // Functional

    public String getOrderingTabText() {
        return getOrderingTab().getText();
    }


    // set Data

    public void clickOrderingTab() {
        getOrderingTab().click();
    }


    // Business Logic

    public OrderingPage gotoOrderingPage(){
        clickOrderingTab();
        return new OrderingPage();
    }
}
