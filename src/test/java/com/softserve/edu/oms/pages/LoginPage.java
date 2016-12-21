package com.softserve.edu.oms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.oms.data.IUser;

import static com.softserve.edu.oms.locators.LoginPageLocators.*;

/**
 * PageObject class that represents Login page.
 *
 * @version 1.0
 * @since 16.12.16
 * @author Anastasiia Maidanska
 *
 */
public class LoginPage extends ABasePage{

	/** Class constructor */
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	/** Getters */
	private WebElement getLoginnameInput() {
		return this.driver.findElement(LOGIN_INPUT_FIELD.by);
	}

	private WebElement getPasswordInput() {
		return this.driver.findElement(PASSWORD_INPUT_FIELD.by);
	}

	private WebElement getSubmitButton() {
		return this.driver.findElement(LOGIN_BUTTON.by);
	}

	private WebElement getResetButton() {
		return this.driver.findElement(RESET_BUTTON.by);
	}

	private WebElement getRememberMeCheckbox() {
		return this.driver.findElement(REMEMBER_ME_CHECKBOX.by);
	}

	private WebElement getBadCredentialsErrorMessage() {
		return driver.findElement(BAD_CREDENTIALS_ERROR_MESSAGE_CSS.by);
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
		return getRememberMeCheckbox()
				.getAttribute(ATTRIBUTE.name()).toLowerCase().trim();
	}

	public String getBadCredentialsErrorMessageText() {
		return this.getBadCredentialsErrorMessage().getText();
	}

	/** Setters */
	public void setLoginnameInput(String login) {
		getLoginnameInput().sendKeys(login);
	}

	private void setLoginnameInputClear(String login) {
		clearLoginnameInput();
		setLoginnameInput(login);
	}

	public void setPasswordInput(String password) {
		getPasswordInput().sendKeys(password);
	}

	private void setPasswordInputClear(String password) {
		clearPasswordInput();
		setPasswordInput(password);
	}

	private void clearLoginnameInput() {
		getLoginnameInput().clear();
	}

	private void clearPasswordInput() {
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

	private void clickResetButton() {
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

    public LoginPage unsuccessfulLogin(IUser invalidUser) {
    	setLoginData(invalidUser);
		return this;
	}

	public LoginPage loginWithEmptyCredentials (){
		this.clearLoginnameInput();
		this.clearPasswordInput();
		this.clickSubmitButton();
		return this;
	}

}
