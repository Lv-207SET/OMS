package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
    private WebDriver driver;
    final private String LOG_IN_INPUT_FIELD_NAME = "j_username";
    final private String PASSWORD_INPUT_FIELD_NAME ="j_password";
    final private String REMEMBER_ME_CHECKBOX_NAME = "_spring_security_remember_me";
    final private String LOG_IN_BUTTON_NAME = "submit";
    final private String CANCEL_BUTTON_NAME = "reset";
    final private String ERROR_MESSAGE_XPATH = "//*[@id=\"edit\"]/fieldset/font";


    public LogInPage (final WebDriver driver) {
        this.driver = driver;
    }

    public void enterLoginName(String loginNameValue){
        WebElement logInInputField = driver.findElement(By.name(LOG_IN_INPUT_FIELD_NAME));
        logInInputField.clear();
        logInInputField.sendKeys(loginNameValue);
    }
    public void enterPassword (String passwordValue){
        WebElement passwordInputField = driver.findElement(By.name(PASSWORD_INPUT_FIELD_NAME));
        passwordInputField.clear();
        passwordInputField.sendKeys(passwordValue);
    }

    public void checkRememberMeCheckBox() {
        WebElement rememberMeCheckbox = driver.findElement(By.name(REMEMBER_ME_CHECKBOX_NAME));
        rememberMeCheckbox.click();
    }

    public void clickCancelButton(){
        WebElement cancelButton = driver.findElement(By.name(CANCEL_BUTTON_NAME));
        cancelButton.click();
    }

    public UserInfoPage clickLogInButton (){
        WebElement logInButton = driver.findElement(By.name(LOG_IN_BUTTON_NAME));
        logInButton.click();
        return new UserInfoPage();
    }

    public String getErrorMessage() {
        WebElement errorMessage = driver.findElement(By.name(ERROR_MESSAGE_XPATH));
        return  errorMessage.getText();
    }

}
