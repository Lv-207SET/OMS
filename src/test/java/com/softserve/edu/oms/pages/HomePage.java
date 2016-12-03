package com.softserve.edu.oms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends ABasePage {

	private static final String FIRST_NAME_LABEL_CSS = "fieldset tr:nth-child(1) td:last-child";
	private static final String LAST_NAME_LABEL_CSS = "fieldset tr:nth-child(2) td:last-child";
	private static final String ROLE_LABEL_CSS = "fieldset tr:nth-child(4) td:last-child";
	private static final String ENG_LANG_LINK_XPATH = "//a[contains(@href, 'en_US')]";
	private static final String UKR_LANG_LINK_XPATH = "//a[contains(@href, 'uk_UA')]";




	public HomePage(WebDriver driver) {
		super(driver);
	}

    // PageObject

	// get Data

	public WebElement getFirstname() {
		return driver.findElement(By.cssSelector(FIRST_NAME_LABEL_CSS));
	}
	
	public WebElement getLastname() {
		return driver.findElement(By.cssSelector(LAST_NAME_LABEL_CSS));
	}
	
	public WebElement getRole() {
		return driver.findElement(By.cssSelector(ROLE_LABEL_CSS));
	}

	public WebElement getEngLangLink() {
		return driver.findElement(By.xpath(ENG_LANG_LINK_XPATH));
	}

	public WebElement getUkrLangLink() {
		return driver.findElement(By.xpath(UKR_LANG_LINK_XPATH));
	}


	

	// Functional
	
	public String getFirstnameText() {
		return getFirstname().getText().trim();
	}

	public String getLastnameText() {
		return getLastname().getText().trim();
	}

	public String getRoleText() {
		return getRole().getText().trim();
	}

	public String getEngLangLinkText() {
		return getEngLangLink().getText().trim();
	}

	public String getUkrLangLinkText() {
		return getUkrLangLink().getText().trim();
	}

	
	// set Data

	public void clickEngLangLink() {
		getEngLangLink().click();
	}

	public void clickUkrLangLink() {
		getUkrLangLink().click();
	}


	// Business Logic

	@Override
	public HomePage gotoUserInfoTab(){
		String role = getRoleText();
		clickUserInfoTab();
		switch(role){
			case "Administrator":
				return new AdminHomePage(driver);

			case "Customer":
				return new CustomerHomePage(driver);

			case "Merchandiser":
				return new MerchandiserHomePage(driver);

			case "Supervisor":
				return new SupervisorHomePage(driver);

			default:
				return new HomePage(driver);

		}
	}




}
