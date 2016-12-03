package com.softserve.edu.oms.pages;

import com.softserve.edu.oms.enums.SelectRegionDropdownList;
import com.softserve.edu.oms.enums.SelectRoleDropdownList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EditUserPage  extends ABasePage {
    public static final String LABEL_EDITING_CAPTION_CSS = "#edit>h3";
    public static final String LABEL_NO_CHANGE_CSS = "#edit>span";
    public static final String INPUT_FIRST_NAME_ID = "firstName";
    public static final String INPUT_LAST_NAME_ID = "lastName";
    public static final String INPUT_PASSWORD_ID = "password";
    public static final String INPUT_CONFIRM_PASSWORD_ID = "confirmPassword";
    public static final String INPUT_EMAIL_ID = "email";
    public static final String SELECT_REGION_ID = "regionID";
    public static final String SELECT_ROLE_ID = "roleID";
    public static final String BUTTON_SAVE_CHANGES_CSS = "input[value=\"Save changes\"]";
    public static final String BUTTON_CANCEL_CSS = "input[value=\"Cancel\"]";
    public static final String ERROR_FIRST_NAME_ID = "firstName.errors";
    public static final String ERROR_LAST_NAME_ID = "lastName.errors";
    public static final String ERROR_PASSWORD_ID = "password.errors";
    public static final String ERROR_CONFIRM_PASSWORD_ID = "confirmPassword.errors";
    public static final String ERROR_EMAIL_ID = "emailError";

    //private WebDriver driver;
    private WebElement labelEditingCaption;
    private WebElement labelNoChange;
    private WebElement inputFirstName;
    private WebElement inputLastName;
    private WebElement inputPassword;
    private WebElement inputConfirmPassword;
    private WebElement inputEmail;
    private Select selectRegion;
    private Select selectRole;
    private WebElement buttonSaveChanges;
    private WebElement buttonCancel;

    private WebElement errorFirstName;
    private WebElement errorLastName;
    private WebElement errorPassword;
    private WebElement errorConfirmPassword;
    private WebElement errorEmail;

    public EditUserPage(WebDriver driver) {
        super(driver);
        this.inputFirstName = driver.findElement(By.id(INPUT_FIRST_NAME_ID));
        this.inputLastName = driver.findElement(By.id(INPUT_LAST_NAME_ID));
        this.inputPassword = driver.findElement(By.id(INPUT_PASSWORD_ID));
        this.inputConfirmPassword = driver.findElement(By.id(INPUT_CONFIRM_PASSWORD_ID));
        this.inputEmail = driver.findElement(By.id(INPUT_EMAIL_ID));
        this.selectRegion = new Select(driver.findElement(By.id(SELECT_REGION_ID)));
        this.selectRole = new Select(driver.findElement(By.id(SELECT_ROLE_ID)));
        this.buttonSaveChanges = driver.findElement(By.id(BUTTON_SAVE_CHANGES_CSS));
        this.buttonCancel = driver.findElement(By.id(BUTTON_CANCEL_CSS));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getInputFirstName() {
        return inputFirstName;
    }

    public void setInputFirstName(WebElement inputFirstName) {
        this.inputFirstName = inputFirstName;
    }

    public WebElement getInputLastName() {
        return inputLastName;
    }

    public void setInputLastName(WebElement inputLastName) {
        this.inputLastName = inputLastName;
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public void setInputPassword(WebElement inputPassword) {
        this.inputPassword = inputPassword;
    }

    public WebElement getInputConfirmPassword() {
        return inputConfirmPassword;
    }

    public void setInputConfirmPassword(WebElement inputConfirmPassword) {
        this.inputConfirmPassword = inputConfirmPassword;
    }

    public WebElement getInputEmail() {
        return inputEmail;
    }

    public void setInputEmail(WebElement inputEmail) {
        this.inputEmail = inputEmail;
    }

    public Select getSelectRegion() {
        return selectRegion;
    }

    public void setSelectRegion(Select selectRegion) {
        this.selectRegion = selectRegion;
    }

    public Select getSelectRole() {
        return selectRole;
    }

    public void setSelectRole(Select selectRole) {
        this.selectRole = selectRole;
    }

    public WebElement getButtonSaveChanges() {
        return buttonSaveChanges;
    }

    public void setButtonSaveChanges(WebElement buttonSaveChanges) {
        this.buttonSaveChanges = buttonSaveChanges;
    }

    public WebElement getButtonCancel() {
        return buttonCancel;
    }

    public void setButtonCancel(WebElement buttonCancel) {
        this.buttonCancel = buttonCancel;
    }

    public EditUserPage setFirstName(String firstName) {
        getInputFirstName().clear();
        getInputFirstName().sendKeys(firstName);
        return this;
    }

    public EditUserPage setLastName(String lastName) {
        getInputLastName().clear();
        getInputLastName().sendKeys(lastName);
        return this;
    }

    public EditUserPage setPassword(String password) {
        getInputPassword().clear();
        getInputPassword().sendKeys(password);
        return this;
    }

    public EditUserPage setConfirmPassword(String password) {
        getInputConfirmPassword().clear();
        getInputConfirmPassword().sendKeys(password);
        return this;
    }

    public EditUserPage setEmail(String email) {
        getInputEmail().clear();
        getInputEmail().sendKeys(email);
        return this;
    }

    public EditUserPage selectRegion(SelectRegionDropdownList region) {
        getSelectRegion().selectByValue(region.toString());
        return this;
    }

    public EditUserPage selectRole(SelectRoleDropdownList role) {
        getSelectRole().selectByValue(role.toString());
        return this;
    }

    public EditUserPage saveChangesUser() {
        buttonSaveChanges.click();
        return this;
    }

    public AdministrationPage cancel() {
        buttonCancel.click();
        return new AdministrationPage(driver);
    }

    public String getEditingCaption() {
        return labelEditingCaption.getText();
    }

    public String getNoChangeMessage() {
        return labelNoChange.getText();
    }

    public String getErrorFirstName() {
        errorFirstName = driver.findElement(By.id(ERROR_FIRST_NAME_ID));
        return errorFirstName.getText();
    }

    public String getErrorLastName() {
        errorLastName = driver.findElement(By.id(ERROR_LAST_NAME_ID));
        return errorLastName.getText();
    }

    public String getErrorPassword() {
        errorPassword = driver.findElement(By.id(ERROR_PASSWORD_ID));
        return errorPassword.getText();
    }

    public String getErrorConfirmPassword() {
        errorConfirmPassword = driver.findElement(By.id(ERROR_CONFIRM_PASSWORD_ID));
        return errorConfirmPassword.getText();
    }

    public String getErrorEmail() {
        errorEmail = driver.findElement(By.id(ERROR_EMAIL_ID));
        return errorEmail.getText();
    }
}

