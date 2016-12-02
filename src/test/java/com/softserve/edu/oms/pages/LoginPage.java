package com.softserve.edu.oms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.oms.data.IUser;

public class LoginPage {
	
	public static final String NAME_REMEMBER_ME = "remember_me";
	private static final String NAME_ATTRIBUTE = "name";

	// Fields
	private WebDriver driver;
	//
	//private static final String LOG_IN_INPUT_FIELD_NAME = "j_username";
	//private static final String PASSWORD_INPUT_FIELD_NAME ="j_password";
	//private static final String LOG_IN_BUTTON_NAME = "submit";
	//private static final String REMEMBER_ME_CHECKBOX_NAME = "_spring_security_remember_me";
	//
	private WebElement loginname;
    private WebElement password;
    private WebElement submit;
    private WebElement rememberMeCheckbox;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		//
		this.loginname = driver.findElement(By.name("j_username"));
		this.password = driver.findElement(By.name("j_password"));
		this.submit = driver.findElement(By.name("submit"));
		this.rememberMeCheckbox = driver.findElement(By.name("_spring_security_remember_me"));
	}

    // PageObject

	// get Data

	public WebElement getLoginnameInput() {
		return this.loginname;
		//return this.driver.findElement(By.name(LOG_IN_INPUT_FIELD_NAME));
	}

	public WebElement getPasswordInput() {
		return this.password;
		//return this.driver.findElement(By.name(PASSWORD_INPUT_FIELD_NAME));
	}

	public WebElement getSubmitButton() {
		return this.submit;
		//return this.driver.findElement(By.name(LOG_IN_BUTTON_NAME));
	}

	public WebElement getRememberMeCheckbox() {
		return this.rememberMeCheckbox;
		//return this.driver.findElement(By.name(REMEMBER_ME_CHECKBOX_NAME));
	}

	// Functional
	
	public String getLoginnameInputText() {
		return getLoginnameInput().getText();
	}

	public String getPasswordInputText() {
		return getPasswordInput().getText();
	}

	public String getSubmitButtonText() {
		return getSubmitButton().getText().trim();
	}

	public String getRememberMeCheckboxNameAttribute() {
		return getRememberMeCheckbox().getAttribute(NAME_ATTRIBUTE).toLowerCase().trim();
	}

	// set Data

	public void setLoginnameInput(String login) {
		getLoginnameInput().sendKeys(login);
	}

	public void setLoginnameInputClear(String login) {
		clearLoginnameInput();
		setLoginnameInput(login);
	}

	public void setPasswordInput(String password) {
		getPasswordInput().sendKeys(password);
	}

	public void setPasswordInputClear(String password) {
		clearPasswordInput();
		setPasswordInput(password);
	}

	public void clearLoginnameInput() {
		getLoginnameInput().clear();
	}

	public void clearPasswordInput() {
		getPasswordInput().clear();
	}

	public void clickLoginnameInput() {
		getLoginnameInput().click();
	}

	public void clickPasswordInput() {
		getPasswordInput().click();
	}

	public void clickSubmitButton() {
		getSubmitButton().click();
	}

	public void clickgetRememberMeCheckbox() {
		getRememberMeCheckbox().click();
	}

    // Business Logic

    // TODO Develop User class
    private void setLoginData(IUser user) {
    //private void setLoginData(String login, String password) {
		setLoginnameInputClear(user.getLoginname());
		setPasswordInputClear(user.getPassword());
		//setLoginInputClear(login);
		//setPasswordInputClear(password);
		clickSubmitButton();
	}

    public HomePage successUserLogin(IUser user) {
        setLoginData(user);
        // Return a new page object representing the destination.
        return new HomePage(driver);
    }

    public AdminHomePage successAdminLogin(IUser admin) {
    //public AdminHomePage successAdminLogin(String login, String password) {
		setLoginData(admin);
		//setLoginData(login, password);
		// Return a new page object representing the destination.
		return new AdminHomePage(driver);
	}

//	public RegistratorHomePage successRegistratorLogin(IUser registrator) {
//		setLoginData(registrator);
//		// Return a new page object representing the destination.
//		return new RegistratorHomePage();
//	}
//
    // TODO Develop User class
//    public LoginValidatorPage unsuccessfulLogin(IUser invalidUser) {
//	//public LoginValidatorPage unsuccessfulLogin(String login, String password) {
//    	setLoginData(invalidUser);
//		//setLoginData(login, password);
//		return new LoginValidatorPage(driver); // return this;
//	}

}
