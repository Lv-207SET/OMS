package pages;

import org.openqa.selenium.WebElement;

public class LogInPage {
    final private WebElement logInInputField;
    final private WebElement passwordInputField;
    final private WebElement rememberMeCheckbox;
    final private WebElement cancelButton;
    final private WebElement logInButton;



    public void clickCancelButton(){
        cancelButton.click();
    }

    public UserInfoPage clickLogInButton (){
        logInButton.click();
        return new UserInfoPage();
    }


}
