package com.softserve.edu.oms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.oms.data.IUser;

public class OmsAdminHomePage extends AOmsHomePage {

	// Fields
	private WebElement administrationTab;

	public OmsAdminHomePage(WebDriver driver) {
		super(driver);
		this.administrationTab = driver.findElement(By.xpath("//a[contains(@href, 'users.htm')]"));
	}

	// PageObject

	// get Data

	public WebElement getAdministrationTab() {
		return this.administrationTab;
	}
	
	// Functional
	
	public String getgetAdministrationTabText() {
		return getAdministrationTab().getText();
	}

	// set Data

	public void clickgetAdministrationTab() {
		getAdministrationTab().click();
	}
	
    // Business Logic

    public OmsAdministrationPage gotoAdministrationPage() {
    	clickgetAdministrationTab();
		return new OmsAdministrationPage(driver);
	}

}
