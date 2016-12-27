package com.softserve.edu.oms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import static com.softserve.edu.oms.locators.UserHomePageLocators.ADMINISTRATION_TAB;
import static com.softserve.edu.oms.locators.UserHomePageLocators.ORDERING_TAB;

/**
 * PageObject class that represents AdminHome page.
 *
 * @version 1.0
 * @since 16.12.16
 * @author Anastasiia Maidanska
 *
 */
public class AdminHomePage extends HomePage {

	public AdminHomePage(WebDriver driver) {
		super(driver);
	}

	// PageObject

	// get Data

	public WebElement getAdministrationTab() {
		return driver.findElement(ADMINISTRATION_TAB.by);
	}

	public WebElement getOrderingTab(){
		return driver.findElement(ORDERING_TAB.by);
	}


	// Functional
	
	public String getAdministrationTabText() {
		return getAdministrationTab().getText();
	}

	public String getOrderingTabText() {
		return getOrderingTab().getText();
	}

	// set Data

	@Step("Just a click on Administration tab")
	public AdministrationPage clickAdministrationTab() {
		getAdministrationTab().click();
		return new AdministrationPage(driver);
	}

	public void clickOrderingTab() {
		getOrderingTab().click();
	}
	
    // Business Logic

	@Step("Go to Administration page")
    public AdministrationPage gotoAdministrationPage() {
    	clickAdministrationTab();
		return new AdministrationPage(driver);
	}

	public OrderingPage gotoOrderingPage(){
		clickOrderingTab();
		return new OrderingPage();
	}

	public AdminHomePage waitForLoad() {
		super.waitForLoad();
		return this;
	}

}
