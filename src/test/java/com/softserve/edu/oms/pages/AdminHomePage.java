package com.softserve.edu.oms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminHomePage extends HomePage {

	private final static String ADMINISTRATION_TAB_XPATH = "//a[contains(@href, 'users.htm')]";
	private final static String ORDERING_TAB_XPATH = "//a[contains(@href, 'order.htm')]";

	public AdminHomePage(WebDriver driver) {
		super(driver);
	}

	// PageObject

	// get Data

	public WebElement getAdministrationTab() {
		return driver.findElement(By.xpath(ADMINISTRATION_TAB_XPATH));
	}

	public WebElement getOrderingTab(){
		return driver.findElement(By.xpath(ORDERING_TAB_XPATH));
	}


	// Functional
	
	public String getAdministrationTabText() {
		return getAdministrationTab().getText();
	}

	public String getOrderingTabText() {
		return getOrderingTab().getText();
	}

	// set Data

	public void clickAdministrationTab() {
		getAdministrationTab().click();
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
