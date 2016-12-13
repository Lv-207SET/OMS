package com.softserve.edu.oms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.oms.data.IUser;

public class LoginPage extends ABasePage{

	private static final String ATTRIBUTE_NAME = "name";
	private static final String LOGIN_INPUT_FIELD_NAME = "j_username";
	private static final String PASSWORD_INPUT_FIELD_NAME ="j_password";
	private static final String LOGIN_BUTTON_NAME = "submit";
	private static final String RESET_BUTTON_NAME = "reset";
	private static final String REMEMBER_ME_CHECKBOX_NAME = "_spring_security_remember_me";

	public LoginPage(WebDriver driver) {
		super(driver);
	}

    // PageObject

	// get Data

	public WebElement getLoginnameInput() {
		return this.driver.findElement(By.name(LOGIN_INPUT_FIELD_NAME));
	}

	public WebElement getPasswordInput() {
		return this.driver.findElement(By.name(PASSWORD_INPUT_FIELD_NAME));
	}

	public WebElement getSubmitButton() {
		return this.driver.findElement(By.name(LOGIN_BUTTON_NAME));
	}

	public WebElement getResetButton() {
		return this.driver.findElement(By.name(RESET_BUTTON_NAME));
	}

	public WebElement getRememberMeCheckbox() {
		return this.driver.findElement(By.name(REMEMBER_ME_CHECKBOX_NAME));
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

	public String getResetButtonText() {
		return getResetButton().getText().trim();
	}

	public String getRememberMeCheckboxNameAttribute() {
		return getRememberMeCheckbox().getAttribute(ATTRIBUTE_NAME).toLowerCase().trim();
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

	public void clickResetButton() {
		getResetButton().click();
	}

	public void clickgetRememberMeCheckbox() {
		getRememberMeCheckbox().click();
	}

    // Business Logic

    private void setLoginData(IUser user) {
		setLoginnameInputClear(user.getLoginname());
		setPasswordInputClear(user.getPassword());
		clickSubmitButton();
	}

	public void setLoginDataAndReset(IUser user) {
		setLoginnameInputClear(user.getLoginname());
		setPasswordInputClear(user.getPassword());
		clickResetButton();
	}

    public HomePage successUserLogin(IUser user) {
        setLoginData(user);
        return new HomePage(driver);
    }

    public AdminHomePage successAdminLogin(IUser admin) {
		setLoginData(admin);
		return new AdminHomePage(driver);
	}

	public CustomerHomePage succesCustomerLogin (IUser customer){
		setLoginData(customer);
		return new CustomerHomePage(driver);
	}

	public MerchandiserHomePage succesMerchandiserLogin (IUser merchandiser){
		setLoginData(merchandiser);
		return new MerchandiserHomePage(driver);
	}

	public SupervisorHomePage succesSupervisorLogin (IUser supervisor){
		setLoginData(supervisor);
		return new SupervisorHomePage(driver);
	}


    public LoginValidatorPage unsuccessfulLogin(IUser invalidUser) {
    	setLoginData(invalidUser);
		return new LoginValidatorPage(driver);
	}

	public LoginValidatorPage loginWithEmptyCredentials (){
		this.clearLoginnameInput();
		this.clearPasswordInput();
		this.clickSubmitButton();
		return new LoginValidatorPage(driver);
	}

}
