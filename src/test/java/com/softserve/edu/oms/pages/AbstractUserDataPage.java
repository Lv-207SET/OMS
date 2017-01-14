package com.softserve.edu.oms.pages;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.enums.Region;
import com.softserve.edu.oms.enums.Role;
import com.softserve.edu.oms.locators.AbstractUserDataPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.softserve.edu.oms.locators.AbstractUserDataPageLocators.*;

/**
 * This abstract class represents common functionality for
 * Create New User Page and Edit User Page
 */
public abstract class AbstractUserDataPage extends AbstractBasePage {

	public static final Logger logger = LoggerFactory.getLogger(AbstractUserDataPage.class);

	AbstractUserDataPage(WebDriver driver) {
		super(driver);
	}

	// get Data
	public WebElement getLoginInput() {
		return this.driver.findElement(LOGIN_INPUT.by);
	}

	public WebElement getFirstNameInput() {
		return this.driver.findElement(FIRST_NAME_INPUT.by);
	}

	public WebElement getLastNameInput() {
		return this.driver.findElement(LAST_NAME_INPUT.by);
	}

	public WebElement getPasswordInput() {
		return this.driver.findElement(PASSWORD_INPUT.by);
	}

	public WebElement getConfirmPasswordInput() {
		return this.driver.findElement(CONFIRM_PASSWORD_INPUT.by);
	}

	public WebElement getEmailInput() {
		return this.driver.findElement(EMAIL_INPUT.by);
	}

	public WebElement getRegionDropDown() {
		return this.driver.findElement(REGION_SELECT.by);
	}

	public List<WebElement> getRoleRadioButton() {
		return this.driver.findElements(ROLE_RADIO_BUTTON.by);
	}

	public WebElement getCreateButton() {
		return this.driver.findElement(CREATE_BUTTON.by);
	}

	public WebElement getCancelButton() {
		return this.driver.findElement(CANCEL_BUTTON.by);
	}

	public WebElement getLoginErrorMessage() {
		return this.driver.findElement(ERROR_LOGIN.by);
	}

	public WebElement getFirstNameErrorMessage() {

		return this.waitForElement(ERROR_FIRST_NAME.by);
	}

	public WebElement getLastNameErrorMessage() {

		return this.waitForElement(ERROR_LAST_NAME.by);
	}

	public WebElement getPasswordErrorMessage() {
		return this.waitForElement(ERROR_PASSWORD.by);
	}

	public WebElement getConfirmPasswordErrorMessage() {
		return this.waitForElement(ERROR_CONFIRM_PASSWORD.by);
	}

	public WebElement getEmailErrorMessage() {
		return this.waitForElement(ERROR_EMAIL.by);
	}

	// functional

	public String getLoginInputText() {
		return getLoginInput().getText();
	}

	public String getFirstNameInputText() {
		return getFirstNameInput().getText();
	}

	public String getLastNameInputText() {
		return getLastNameInput().getText();
	}

	public String getPasswordInputText() {
		return getPasswordInput().getText();
	}

	public String getConfirmPasswordInputText() {
		return getConfirmPasswordInput().getText();
	}

	public String getEmailInputText() {
		return getEmailInput().getText();
	}

	public Select getSelectRegion() {
		return new Select(getRegionDropDown());
	}

	public String getCreateButtonText() {
		return getCreateButton().getText().trim();
	}

	public String getCancelButtonText() {
		return getCancelButton().getText().trim();
	}

	public String getLoginErrorMessageText() {
		return getLoginErrorMessage().getText();
	}

	public Boolean getLoginError() {
		return getLoginErrorMessage().isDisplayed();
	}

	public String getFirstNameErrorMessageText() {
		return getFirstNameErrorMessage().getText();
	}

	public String getLastNameErrorMessageText() {
		return getLastNameErrorMessage().getText();
	}

	public String getPasswordErrorMessageText() {
		return getPasswordErrorMessage().getText();
	}

	public String getConfirmPasswordErrorMessageText() {
		return getConfirmPasswordErrorMessage().getText();
	}

	public String getEmailErrorMessageText() {
		return getEmailErrorMessage().getText();
	}

	// set data
	public AbstractUserDataPage setFirstNameInput(String firstName) {
		getFirstNameInput().clear();
		getFirstNameInput().sendKeys(firstName);
		logger.info("Setting First Name " + firstName);
		return this;
	}

	public AbstractUserDataPage setLastNameInput(String lastName) {
		getLastNameInput().clear();
		getLastNameInput().sendKeys(lastName);
		logger.info("Setting Last Name " + lastName);
		return this;
	}

	public AbstractUserDataPage setPasswordInput(String password) {
		getPasswordInput().clear();
		getPasswordInput().sendKeys(password);
		logger.info("Setting Password " + password);
		return this;
	}

	public AbstractUserDataPage setConfirmPasswordInput(String confirmPassword) {
		getConfirmPasswordInput().clear();
		getConfirmPasswordInput().sendKeys(confirmPassword);
		logger.info("Setting Confirm Password " + confirmPassword);
		return this;
	}

	public AbstractUserDataPage setEmailInput(String email) {
		getEmailInput().clear();
		getEmailInput().sendKeys(email);
		logger.info("Setting Email " + email);
		return this;
	}

	public AbstractUserDataPage setSelectRegion(Region region) {
		getSelectRegion().selectByVisibleText(region.getRegionType());
		logger.info("Selecting Region");
		return this;
	}

	public AbstractUserDataPage setSelectRole(Role roleId) {
		driver.findElement(By.id(roleId.getRoleId())).click();
		waitForLoad();
		logger.info("Selecting Role");
		return this;
	}

	public AbstractUserDataPage clearFirstNameInput() {
		getFirstNameInput().clear();
		return this;
	}

	public AbstractUserDataPage clearLastNameInput() {
		getLastNameInput().clear();
		return this;
	}

	public AbstractUserDataPage clearPasswordInput() {
		getPasswordInput().clear();
		return this;
	}

	public AbstractUserDataPage clearConfirmPasswordInput() {
		getConfirmPasswordInput().clear();
		return this;
	}

	public AbstractUserDataPage clearEmailInput() {
		getEmailInput().clear();
		return this;
	}

	public AbstractUserDataPage clickCreateButton() {
		getCreateButton().click();
		logger.info("Create button is clicked");
		return this;
	}

	public AbstractUserDataPage clickCancelButton() {
		getCancelButton().click();
		waitForLoad();
		logger.info("Cancel button is clicked");
		return this;
	}

	public AbstractUserDataPage setLoginData(IUser user) {
		setFirstNameInput(user.getFirstname());
		setLastNameInput(user.getLastname());
		setPasswordInput(user.getPassword());
		setConfirmPasswordInput(user.getPassword());
		setEmailInput(user.getEmail());
		setSelectRegion(Region.getRegion(user.getRegion()));
		setSelectRole(Role.valueOf(user.getRole().toUpperCase()));
		return this;
	}

	public AdministrationPage successCreateNewUser() {
		waitForInputErrorsToDisappear();
		clickCreateButton();
		return new AdministrationPage(driver);
	}

	/**
	 * This method is used to wait for every possible input error which is displayed
	 * due to a lag to disappear.
	 * Precondition of inputting valid data should be met when using this method.
	 */
	protected void waitForInputErrorsToDisappear() {
		if (waitForElementToDisappear(AbstractUserDataPageLocators.ERROR_PASSWORD.by)
				&& waitForElementToDisappear(AbstractUserDataPageLocators.ERROR_CONFIRM_PASSWORD.by)
				&& waitForElementToDisappear(AbstractUserDataPageLocators.ERROR_EMAIL.by)) {
			System.out.println("**************Input errors disappeared**************");
		} else {
			throw new RuntimeException("Waiting for input errors to disappear failed!");
		}
	}
}
