package com.softserve.edu.oms.pages;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.enums.Region;
import com.softserve.edu.oms.enums.Role;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateNewUserPage extends ABasePage {
    private static final String LOGIN_INPUT_ID = "login";
    private static final String FIRST_NAME_INPUT_ID = "firstName";
    private static final String LAST_NAME_INPUT_ID = "lastName";
    private static final String PASSWORD_INPUT_ID = "password";
    private static final String CONFIRM_PASSWORD_INPUT_ID = "confirmPassword";
    private static final String EMAIL_INPUT_ID = "email";
    private static final String REGION_SELECT_ID = "regionID";
    private static final String ROLE_RADIO_BUTTON_NAME = "roleID";
    private static final String CREATE_BUTTON_CSS = "input[value=\"Create\"]";
    private static final String CANCEL_BUTTON_CSS = "input[value=\"Cancel\"]";
    private static final String ERROR_LOGIN_ID = "nameError";
    private static final String ERROR_FIRST_NAME_ID = "firstNameError";
    private static final String ERROR_LAST_NAME_ID = "lastNameError";
    private static final String ERROR_PASSWORD_ID = "passwordError";
    private static final String ERROR_CONFIRM_PASSWORD_ID = "confirmError";
    private static final String ERROR_EMAIL_ID = "emailError";

    public CreateNewUserPage(WebDriver driver) {
        super(driver);
    }

    // get Data

    public WebElement getLoginInput() {
        return this.driver.findElement(By.id(LOGIN_INPUT_ID));
    }

    public WebElement getFirstNameInput() {
        return this.driver.findElement(By.id(FIRST_NAME_INPUT_ID));
    }

    public WebElement getLastNameInput() {
        return this.driver.findElement(By.id(LAST_NAME_INPUT_ID));
    }

    public WebElement getPasswordInput() {
        return  this.driver.findElement(By.id(PASSWORD_INPUT_ID));
    }

    public WebElement getConfirmPasswordInput() {
        return this.driver.findElement(By.id(CONFIRM_PASSWORD_INPUT_ID));
    }

    public WebElement getEmailInput() {
        return  this.driver.findElement(By.id(EMAIL_INPUT_ID));
    }

    public WebElement getRegionDropDown() {
        return this.driver.findElement(By.id(REGION_SELECT_ID));
    }

    public List<WebElement> getRoleRadioButton() {
        return this.driver.findElements(By.name(ROLE_RADIO_BUTTON_NAME));
    }

    public WebElement getCreateButton() {
        return this.driver.findElement(By.cssSelector(CREATE_BUTTON_CSS));
    }

    public WebElement getCancelButton() {
        return this.driver.findElement(By.cssSelector(CANCEL_BUTTON_CSS));
    }

    public WebElement getLoginErrorMessage() {
        return this.driver.findElement(By.id(ERROR_LOGIN_ID));
    }

    public WebElement getFirstNameErrorMessage() {
        return this.driver.findElement(By.id(ERROR_FIRST_NAME_ID));
    }

    public WebElement getLastNameErrorMessage() {
        return this.driver.findElement(By.id(ERROR_LAST_NAME_ID));
    }

    public WebElement getPasswordErrorMessage() {
        return this.driver.findElement(By.id(ERROR_PASSWORD_ID));
    }

    public WebElement getConfirmPasswordErrorMessage() {
        return this.driver.findElement(By.id(ERROR_CONFIRM_PASSWORD_ID));
    }

    public WebElement getEmailErrorMessage() {
        return this.driver.findElement(By.id(ERROR_EMAIL_ID));
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

    // set Data

    public CreateNewUserPage setLoginInput(String login) {
        getLoginInput().clear();
        getLoginInput().sendKeys(login);
        return this;
    }

    public CreateNewUserPage setFirstNameInput(String firstName) {
        getFirstNameInput().clear();
        getFirstNameInput().sendKeys(firstName);
        return this;
    }

    public CreateNewUserPage setLastNameInput(String lastName) {
        getLastNameInput().clear();
        getLastNameInput().sendKeys(lastName);
        return this;
    }

    public CreateNewUserPage setPasswordInput(String password) {
        getPasswordInput().clear();
        getPasswordInput().sendKeys(password);
        return this;
    }

    public CreateNewUserPage setConfirmPasswordInput(String confirmPassword) {
        getConfirmPasswordInput().clear();
        getConfirmPasswordInput().sendKeys(confirmPassword);
        return this;
    }

    public CreateNewUserPage setEmailInput(String email) {
        getEmailInput().clear();
        getEmailInput().sendKeys(email);
        return this;
    }

    public CreateNewUserPage setSelectRegion(Region region) {
        getSelectRegion().selectByVisibleText(region.getRegionType());
        return this;
    }

    public CreateNewUserPage setSelectRole(Role roleId) {
        driver.findElement(By.id(roleId.getRoleId())).click();
        return this;
    }

    public CreateNewUserPage clearLoginInput() {
        getLoginInput().clear();
        return this;
    }

    public CreateNewUserPage clearFirstNameInput() {
        getFirstNameInput().clear();
        return this;
    }

    public CreateNewUserPage clearLastNameInput() {
        getLastNameInput().clear();
        return this;
    }

    public CreateNewUserPage clearPasswordInput() {
        getPasswordInput().clear();
        return this;
    }

    public CreateNewUserPage clearConfirmPasswordInput() {
        getConfirmPasswordInput().clear();
        return this;
    }

    public CreateNewUserPage clearEmailInput() {
        getEmailInput().clear();
        return this;
    }

    public CreateNewUserPage clickCreateButton() {
        getCreateButton().click();
        return this;
    }

    public CreateNewUserPage clickCancelButton() {
        getCancelButton().click();
        return this;
    }

    // business logic
    public CreateNewUserPage setLoginData(IUser user) {
        setLoginInput(user.getLoginname());
        setFirstNameInput(user.getFirstname());
        setLastNameInput(user.getLastname());
        setPasswordInput(user.getPassword());
        setConfirmPasswordInput(user.getPassword());
        setEmailInput(user.getEmail());
        setSelectRegion(Region.getRegion(user.getRegion()));
        setSelectRole(Role.valueOf(user.getRole().toUpperCase()));
        return this;
    }

    public AdministrationPage successCreateNewUser(IUser validUser){
        setLoginData(validUser);
        clickCreateButton();
        return new AdministrationPage(driver);
    }

    public CreateNewUserPage unsuccessCreateNewUser(IUser invalidUser){
        setLoginData(invalidUser);
        clickCreateButton();
        return this;
    }

    // ???
    public AdministrationPage successCreateNewUser(){
        clickCreateButton();
        return new AdministrationPage(driver);
    }

    public AdministrationPage cancelCreateNewUser(IUser someUser) {
        setLoginData(someUser);
        clickCancelButton();
        return new AdministrationPage(driver);
    }

    public CreateNewUserPage acceptAlert() {
        driver
                .switchTo()
                .alert()
                .accept();
        return this;
    }

    @Override
    public CreateNewUserPage waitForLoad(){
        super.waitForLoad();
        return this;
    }
}
