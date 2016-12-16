package com.softserve.edu.oms.expages;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.HomePage;
import com.softserve.edu.oms.pages.LoginPage;
import com.softserve.edu.oms.tests.TestRunner;
import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.softserve.edu.oms.enums.ErrorMessagesEnum.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginPageTest extends TestRunner{

    private static final String EXPECTED_ERROR_MESSAGE = "Such user does not exist " +
            "in the system - please try again";

    private SoftAssert softAssert = new SoftAssert();

    @DataProvider
    public Object[][] someUser() {
        return new Object[][] {
                { UserRepository.get().invalidUser() }
        };
    }

    //  Provides not register user login and password
    @DataProvider
    public Object[][] notExistUser() {
        return new Object[][] {
                {UserRepository.get().nonExistingUser() }
        };
    }



    @Test
    public void loginWithEmptyCredentials (){
        String currentErrorMessage = loginPage
                .loginWithEmptyCredentials()
                .getBadCredentialsErrorMessageText();

        assertThat(currentErrorMessage, CoreMatchers.equalTo(ERROR_MESSAGE.message));
    }

    @Test(dataProvider = "notExistUser", alwaysRun = true)
    public void verifyResetButtonFunctionality(IUser notExistUser){
//      Check if Object of String error message is not null.
        Assert.assertNotNull(loginPage.unsuccessfulLogin(notExistUser)
                .getBadCredentialsErrorMessageText());
//      Check if error message is the same as was expected
        Assert.assertEquals(loginPage.unsuccessfulLogin(notExistUser)
                .getBadCredentialsErrorMessageText(), EXPECTED_ERROR_MESSAGE);
    }

    @Test
    public void rememberMeTest() {
        IUser user= UserRepository.get().adminUser();
        Assert.assertEquals(loginPage.getLoginnameInputText(), "");
        Assert.assertEquals(loginPage.getPasswordInputText(), "");
        loginPage.setLoginnameInput(user.getLoginname());
        loginPage.setPasswordInput(user.getPassword());
        loginPage.clickgetRememberMeCheckbox();
        loginPage.clickSubmitButton();
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getFirstnameText(), user.getFirstname());
        Assert.assertEquals(homePage.getLastnameText(), user.getLastname());
        homePage.clickLogoutButton();
        loginPage = new LoginPage(driver);
        softAssert.assertEquals(loginPage.getLoginnameInputText(),user.getLoginname());
        softAssert.assertEquals(loginPage.getPasswordInputText().length(),user.getPassword().length());
        softAssert.assertAll();

    }


}
