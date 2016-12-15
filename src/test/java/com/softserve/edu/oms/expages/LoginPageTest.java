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

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Vika on 12/15/2016.
 */
public class LoginPageTest extends TestRunner{

    private static final String ERROR_MESSAGE = "Your login attempt was not successful, try again.\n" + "\n" +
            "Reason: Bad credentials.";
    private SoftAssert softAssert = new SoftAssert();

    @DataProvider
    public Object[][] someUser() {
        return new Object[][] {
                { UserRepository.get().invalidUser() }
        };
    }

    @Test
    public void loginWithEmptyCredentials (){
        String currentErrorMessage = loginPage
                .loginWithEmptyCredentials()
                .getBadCredentialsErrorMessageText();

        assertThat(currentErrorMessage, CoreMatchers.equalTo(ERROR_MESSAGE));
    }

    @Test(dataProvider = "someUser")
    public void verifyResetButtonFunctionality(IUser someUser) {

        loginPage.setLoginDataAndReset(someUser);
        Assert.assertTrue(loginPage
                .getLoginnameInputText()
                .isEmpty());
        Assert.assertTrue(loginPage
                .getPasswordInputText()
                .isEmpty());
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
