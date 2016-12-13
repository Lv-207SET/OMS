package com.softserve.edu.oms.pages;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.enums.Region;
import com.softserve.edu.oms.enums.Role;
import com.softserve.edu.oms.enums.SelectRegionDropdownList;
import com.softserve.edu.oms.enums.SelectRoleDropdownList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateNewUserPage extends ABasePage {
    private static final String INPUT_LOGIN_ID = "login";
    private static final String INPUT_FIRST_NAME_ID = "firstName";
    private static final String INPUT_LAST_NAME_ID = "lastName";
    private static final String INPUT_PASSWORD_ID = "password";
    private static final String INPUT_CONFIRM_PASSWORD_ID = "confirmPassword";
    private static final String INPUT_EMAIL_ID = "email";
    private static final String SELECT_REGION_ID = "regionID";
    private static final String RADIO_BUTTON_ROLE_NAME = "roleID";
    private static final String BUTTON_CREATE_CSS = "input[value=\"Create\"]";
    private static final String BUTTON_CANCEL_CSS = "input[value=\"Cancel\"]";
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

    public WebElement getInputLogin() {
        return this.driver.findElement(By.id(INPUT_LOGIN_ID));
    }

    public WebElement getInputFirstName() {
        return this.driver.findElement(By.id(INPUT_FIRST_NAME_ID));
    }

    public WebElement getInputLastName() {
        return this.driver.findElement(By.id(INPUT_LAST_NAME_ID));
    }

    public WebElement getInputPassword() {
        return  this.driver.findElement(By.id(INPUT_PASSWORD_ID));
    }

    public WebElement getInputConfirmPassword() {
        return this.driver.findElement(By.id(INPUT_CONFIRM_PASSWORD_ID));
    }

    public WebElement getInputEmail() {
        return  this.driver.findElement(By.id(INPUT_EMAIL_ID));
    }

    public WebElement getDropDownRegion() {
        return this.driver.findElement(By.id(SELECT_REGION_ID));
    }

    public List<WebElement> getRadioButtonRole() {
        return this.driver.findElements(By.name(RADIO_BUTTON_ROLE_NAME));
    }

    public WebElement getButtonCreate() {
        return this.driver.findElement(By.cssSelector(BUTTON_CREATE_CSS));
    }

    public WebElement getButtonCancel() {
        return this.driver.findElement(By.cssSelector(BUTTON_CANCEL_CSS));
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
        return getInputLogin().getText();
    }

    public String getFirstNameInputText() {
        return getInputFirstName().getText();
    }

    public String getLastNameInputText() {
        return getInputLastName().getText();
    }

    public String getPasswordInputText() {
        return getInputPassword().getText();
    }

    public String getConfirmPasswordInputText() {
        return getInputConfirmPassword().getText();
    }

    public String getEmailInputText() {
        return getInputEmail().getText();
    }

    public Select getSelectRegion() {
        return new Select(getDropDownRegion());
    }

    public String getCreateButtonText() {
        return getButtonCreate().getText().trim();
    }

    public String getCancelButtonText() {
        return getButtonCancel().getText().trim();
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

    public CreateNewUserPage setInputLogin(String login) {
        getInputLogin().clear();
        getInputLogin().sendKeys(login);
        return this;
    }

    public CreateNewUserPage setInputFirstName(String firstName) {
        getInputFirstName().clear();
        getInputFirstName().sendKeys(firstName);
        return this;
    }

    public CreateNewUserPage setInputLastName(String lastName) {
        getInputLastName().clear();
        getInputLastName().sendKeys(lastName);
        return this;
    }

    public CreateNewUserPage setInputPassword(String password) {
        getInputPassword().clear();
        getInputPassword().sendKeys(password);
        return this;
    }

    public CreateNewUserPage setInputConfirmPassword(String confirmPassword) {
        getInputConfirmPassword().clear();
        getInputConfirmPassword().sendKeys(confirmPassword);
        return this;
    }

    public CreateNewUserPage setInputEmail(String email) {
        getInputEmail().clear();
        getInputEmail().sendKeys(email);
        return this;
    }

    public CreateNewUserPage setSelectRegion(Region region) {
        getSelectRegion().selectByVisibleText(region.getRegionType());
        return this;
    }

    public CreateNewUserPage selectRole(Role roleId) {
        driver.findElement(By.id(roleId.getRoleId())).click();
        return this;
    }

    public CreateNewUserPage clearInputLogin() {
        getInputLogin().clear();
        return this;
    }

    public CreateNewUserPage clearInputFirstName() {
        getInputFirstName().clear();
        return this;
    }

    public CreateNewUserPage clearInputLastName() {
        getInputLastName().clear();
        return this;
    }

    public CreateNewUserPage clearInputPassword() {
        getInputPassword().clear();
        return this;
    }

    public CreateNewUserPage clearInputConfirmPassword() {
        getInputConfirmPassword().clear();
        return this;
    }

    public CreateNewUserPage clearInputEmail() {
        getInputEmail().clear();
        return this;
    }

    public CreateNewUserPage clickButtonCreate() {
        getButtonCreate().click();
        return this;
    }

    public CreateNewUserPage clickButtonCancel() {
        getButtonCancel().click();
        return this;
    }

    // business logic
    public CreateNewUserPage setLoginData(IUser user) {
        setInputLogin(user.getLoginname());
        setInputFirstName(user.getFirstname());
        setInputLastName(user.getLastname());
        setInputPassword(user.getPassword());
        setInputConfirmPassword(user.getPassword());
        setInputEmail(user.getEmail());
        setSelectRegion(Region.getRegion(user.getRegion()));
        selectRole(Role.valueOf(user.getRole().toUpperCase()));
        clickButtonCreate();
        return this;
    }


    public AdministrationPage successCreateNewUser(IUser validUser){
        setLoginData(validUser);
        return new AdministrationPage(driver);
    }

    public AdministrationPage cancelCreateNewUser(IUser someUser) {
        setLoginData(someUser);
        return new AdministrationPage(driver);
    }

    public CreateNewUserPage acceptAlert() {
        driver
                .switchTo()
                .alert()
                .accept();
        return this;
    }
}
