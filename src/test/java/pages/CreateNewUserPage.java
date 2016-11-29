package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateNewUserPage {
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

    private WebDriver driver;
    private WebElement inputLogin;
    private WebElement inputFirstName;
    private WebElement inputLastName;
    private WebElement inputPassword;
    private WebElement inputComfirmPassword;
    private WebElement inputEmail;
    private Select selectRegion;
    private Select selectRole;
    private WebElement buttonCreate;
    private WebElement buttonCancel;

    public CreateNewUserPage(WebDriver driver) {
        this.driver = driver;

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

    public WebElement getInputComfirmPassword() {
        return inputComfirmPassword;
    }

    public void setInputComfirmPassword(WebElement inputComfirmPassword) {
        this.inputComfirmPassword = inputComfirmPassword;
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

    public void createUser() {

    }
}
