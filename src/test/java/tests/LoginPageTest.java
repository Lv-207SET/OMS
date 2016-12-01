package tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;
import pages.UserInfoPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoginPageTest extends TestRunner {
    private final String errorMessage = "";

    @Test
    public void verifyCorrectLogin (String login , String password) {
        UserInfoPage userInfoPage = logInPage
                .enterLoginName(login)
                .enterPassword(password)
                .clickLogInButton();

        assertThat(userInfoPage.getRoleLabel(), CoreMatchers.equalTo(""));
    }

    @Test
    public void verifyIncorrectLogin(String login, String password){
        logInPage.enterLoginName(login)
                .enterPassword(password)
                .clickLogInButton();
        assertThat(logInPage.getErrorMessage(), CoreMatchers.equalTo(errorMessage));
    }

    @Test
    public void verifyEmptyFormLogin(){
        logInPage.clickLogInButton();
       assertThat(logInPage.getErrorMessage(), CoreMatchers.equalTo(errorMessage));
    }

    @Test
    public  void  verifyCancelButton (String login, String password) {
        logInPage.enterLoginName(login)
                .enterPassword(password).clickCancelButton();
    }

    @Test
    public void verifyRememberMeCheckbox (String login, String password) {
        logInPage.enterLoginName(login)
                .enterPassword(password)
                .checkRememberMeCheckBox()
                .clickLogInButton()
                .clickLogoutButton();
        assertThat(logInPage.getLogInInputField().getText(),CoreMatchers.equalTo(login));
    }
}
