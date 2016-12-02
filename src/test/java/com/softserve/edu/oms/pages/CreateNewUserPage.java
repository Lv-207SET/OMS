package pages;

import enums.SelectRegionDropdownList;
import enums.SelectRoleDropdownList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateNewUserPage extends BasePage{
    public static final String INPUT_LOGIN_ID = "login";
    public static final String INPUT_FIRST_NAME_ID = "firstName";
    public static final String INPUT_LAST_NAME_ID = "lastName";
    public static final String INPUT_PASSWORD_ID = "password";
    public static final String INPUT_CONFIRM_PASSWORD_ID = "confirmPassword";
    public static final String INPUT_EMAIL_ID = "email";
    public static final String SELECT_REGION_ID = "regionID";
    public static final String SELECT_ROLE_ID = "roleID";
    public static final String BUTTON_CREATE_CSS = "input[value=\"Create\"]";
    public static final String BUTTON_CANCEL_CSS = "input[value=\"Cancel\"]";

    public static final String ERROR_LOGIN_ID = "nameError";
    public static final String ERROR_FIRST_NAME_ID = "firstNameError";
    public static final String ERROR_LAST_NAME_ID = "lastNameError";
    public static final String ERROR_PASSWORD_ID = "passwordError";
    public static final String ERROR_CONFIRM_PASSWORD_ID = "confirmError";
    public static final String ERROR_EMAIL_ID = "emailError";

    //private WebDriver driver;
    private WebElement inputLogin;
    private WebElement inputFirstName;
    private WebElement inputLastName;
    private WebElement inputPassword;
    private WebElement inputConfirmPassword;
    private WebElement inputEmail;
    private Select selectRegion;
    private Select selectRole;
    private WebElement buttonCreate;
    private WebElement buttonCancel;
    private WebElement errorLogin;
    private WebElement errorFirstName;
    private WebElement errorLastName;
    private WebElement errorPassword;
    private WebElement errorConfirmPassword;
    private WebElement errorEmail;

    public CreateNewUserPage(WebDriver driver) {
        super(driver);
        this.inputLogin = driver.findElement(By.id(INPUT_LOGIN_ID));
        this.inputFirstName = driver.findElement(By.id(INPUT_FIRST_NAME_ID));
        this.inputLastName = driver.findElement(By.id(INPUT_LAST_NAME_ID));
        this.inputPassword = driver.findElement(By.id(INPUT_PASSWORD_ID));
        this.inputConfirmPassword = driver.findElement(By.id(INPUT_CONFIRM_PASSWORD_ID));
        this.inputEmail = driver.findElement(By.id(INPUT_EMAIL_ID));
        this.selectRegion = new Select(driver.findElement(By.id(SELECT_REGION_ID)));
        this.selectRole = new Select(driver.findElement(By.id(SELECT_ROLE_ID)));
        this.buttonCreate = driver.findElement(By.id(BUTTON_CREATE_CSS));
        this.buttonCancel = driver.findElement(By.id(BUTTON_CANCEL_CSS));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getInputLogin() {
        return inputLogin;
    }

    public void setInputLogin(WebElement inputLogin) {
        this.inputLogin = inputLogin;
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

    public WebElement getButtonCreate() {
        return buttonCreate;
    }

    public void setButtonCreate(WebElement buttonCreate) {
        this.buttonCreate = buttonCreate;
    }

    public WebElement getButtonCancel() {
        return buttonCancel;
    }

    public void setButtonCancel(WebElement buttonCancel) {
        this.buttonCancel = buttonCancel;
    }

    public CreateNewUserPage setLogin(String login) {
        getInputLogin().clear();
        getInputLogin().sendKeys(login);
        return this;
    }

    public CreateNewUserPage setFirstName(String firstName) {
        getInputFirstName().clear();
        getInputFirstName().sendKeys(firstName);
        return this;
    }

    public CreateNewUserPage setLastName(String lastName) {
        getInputLastName().clear();
        getInputLastName().sendKeys(lastName);
        return this;
    }

    public CreateNewUserPage setPassword(String password) {
        getInputPassword().clear();
        getInputPassword().sendKeys(password);
        return this;
    }

    public CreateNewUserPage setConfirmPassword(String password) {
        getInputConfirmPassword().clear();
        getInputConfirmPassword().sendKeys(password);
        return this;
    }

    public CreateNewUserPage setEmail(String email) {
        getInputEmail().clear();
        getInputEmail().sendKeys(email);
        return this;
    }

    public CreateNewUserPage selectRegion(SelectRegionDropdownList region) {
        getSelectRegion().selectByValue(region.toString());
        return this;
    }

    public CreateNewUserPage selectRole(SelectRoleDropdownList role) {
        getSelectRole().selectByValue(role.toString());
        return this;
    }

    public CreateNewUserPage createUser() {
        buttonCreate.click();
        return this;
    }

    public AdministrationPage cancel() {
        buttonCancel.click();
        return new AdministrationPage(driver);
    }

    public String getErrorLogin() {
        errorLogin = driver.findElement(By.id(ERROR_LOGIN_ID));
        return errorLogin.getText();

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
