package com.softserve.edu.oms.pages;

import com.softserve.edu.oms.locators.UserHomePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminHomePage extends HomePage {

	public AdminHomePage(WebDriver driver) {
		super(driver);
	}

	// PageObject

	// get Data

	public WebElement getAdministrationTab() {
		return driver.findElement(UserHomePageLocators.ADMINISTRATION_TAB_CSS.by);
	}

	public WebElement getOrderingTab(){
		return driver.findElement(UserHomePageLocators.ORDERING_TAB_XPATH.by);
	}


	// Functional
	
	public String getAdministrationTabText() {
		return getAdministrationTab().getText();
	}

	public String getOrderingTabText() {
		return getOrderingTab().getText();
	}

	// set Data

	public AdministrationPage clickAdministrationTab() {
		getAdministrationTab().click();
		return new AdministrationPage(driver);
	}

	public void clickOrderingTab() {
		getOrderingTab().click();
	}
	
    // Business Logic

    public AdministrationPage gotoAdministrationPage() {
    	clickAdministrationTab();
		return new AdministrationPage(driver);
	}

	public OrderingPage gotoOrderingPage(){
		clickOrderingTab();
		return new OrderingPage();
	}

}
