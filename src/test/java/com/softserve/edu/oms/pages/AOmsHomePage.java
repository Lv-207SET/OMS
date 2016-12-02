package com.softserve.edu.oms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AOmsHomePage {

	// Fields
	protected WebDriver driver;
	//
	private WebElement userInfoTab;
    private WebElement firstname;
    private WebElement lastname;
    private WebElement role;
    private WebElement logout;

	public AOmsHomePage(WebDriver driver) {
		this.driver = driver;
		//
		this.userInfoTab = driver.findElement(By.xpath("//a[contains(@href,'userInfo.htm')]"));
		this.firstname = driver.findElement(By.cssSelector("fieldset tr:nth-child(1) td:last-child"));
		this.lastname = driver.findElement(By.cssSelector("fieldset tr:nth-child(2) td:last-child"));
		this.role = driver.findElement(By.cssSelector("fieldset tr:nth-child(4) td:last-child"));
		this.logout = driver.findElement(By.cssSelector("a img"));
	}

    // PageObject

	// get Data

	public WebElement getUserInfoTab() {
		return this.userInfoTab;
	}

	public WebElement getFirstname() {
		return this.firstname;
	}
	
	public WebElement getLastname() {
		return this.lastname;
	}
	
	public WebElement getRole() {
		return this.role;
	}
	
	public WebElement getLogout() {
		return this.logout;
	}

	// Functional
	
	public String getUserInfoTabText() {
		return getUserInfoTab().getText().trim();
	}

	public String getFirstnameText() {
		return getFirstname().getText().trim();
	}

	public String getLastnameText() {
		return getLastname().getText().trim();
	}

	public String getRoleText() {
		return getRole().getText().trim();
	}
	
//	public String getLogoutText() {
//		return getLogout().getText().trim();
//	}
	
	// set Data

	public void clickgetUserInfoTab() {
		getUserInfoTab().click();
	}

	public void clickgetLogout() {
		getLogout().click();
	}

    // Business Logic

    public OmsLoginPage gotoLoginPage() {
    	clickgetLogout();
		return new OmsLoginPage(driver);
	}

}
