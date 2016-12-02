package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage extends BasePage{
    private WebDriver driver;

    final private static String LOG_IN_INPUT_FIELD_NAME = "j_username";
    final private static String PASSWORD_INPUT_FIELD_NAME ="j_password";
    final private static String REMEMBER_ME_CHECKBOX_NAME = "_spring_security_remember_me";
    final private static String LOG_IN_BUTTON_NAME = "submit";
    final private static String CANCEL_BUTTON_NAME = "reset";
    final private static String ERROR_MESSAGE_XPATH = "//*[@id=\"edit\"]/fieldset/font";

    private WebElement logInInputField;
    private WebElement passwordInputField;


    public WebElement getLogInInputField() {
        return logInInputField;
    }

    public WebElement getPasswordInputField() {
        return passwordInputField;
    }

    public LogInPage (final WebDriver driver) {
        super(driver);
    }

    public LogInPage enterLoginName(String loginNameValue){
        logInInputField = driver.findElement(By.name(LOG_IN_INPUT_FIELD_NAME));
        logInInputField.clear();
        logInInputField.sendKeys(loginNameValue);
        return this;
    }
    public LogInPage enterPassword (String passwordValue){
        passwordInputField = driver.findElement(By.name(PASSWORD_INPUT_FIELD_NAME));
        passwordInputField.clear();
        passwordInputField.sendKeys(passwordValue);
        return this;
    }

    public LogInPage checkRememberMeCheckBox() {
        WebElement rememberMeCheckbox = driver.findElement(By.name(REMEMBER_ME_CHECKBOX_NAME));
        rememberMeCheckbox.click();
        return this;
    }

    public LogInPage clickCancelButton(){
        WebElement cancelButton = driver.findElement(By.name(CANCEL_BUTTON_NAME));
        cancelButton.click();
        return this;
    }

    public UserInfoPage clickLogInButton (){
        WebElement logInButton = driver.findElement(By.name(LOG_IN_BUTTON_NAME));
        logInButton.click();
        return new UserInfoPage(driver);
    }

    public String getErrorMessage() {
        WebElement errorMessage = driver.findElement(By.xpath(ERROR_MESSAGE_XPATH));
        return  errorMessage.getText();
    }

}