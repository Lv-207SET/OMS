package com.softserve.edu.oms.tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Created by Oleh Lavrynenko on 13.12.2016.
 */
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.HomePage;
//import com.softserve.edu.oms.pages.UserInfoPage;
import com.softserve.edu.oms.pages.LoginPage;
import com.softserve.edu.oms.tests.TestRunner;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.model.SeverityLevel;

@Features("Authorization")
@Stories("LVSETOMS-1 As User Admin I want to login so I can enter the system and add new users to system")

public class RememberMeTest extends TestRunner {
    private SoftAssert softAssert = new SoftAssert();

    /**
     * Verify that after check "Remember me" checkbox
     * entered login and password save in input fields
     * after logout
     *
     * @author Oleh Lavrynenko
     * @version 1.0
     * @since 16.12.16
     * @link http://ssu-jira.softserveinc.com/browse/LVSETOMS-38
     */
    @Features("Authorization")
    @Stories("LVSETOMS-1 As User Admin I want to login so I can enter the system and add new users to system")
    @TestCaseId("LVSETOMS-38")
   	@Severity(SeverityLevel.NORMAL)
   	@Description("This test case verifies that 'Login' form is filled by default with the values "
   			+ "in case previously succesfully logged in user did it with checked 'Remember me' option.")
    @Test
    public void rememberMeTest() {
        IUser user= UserRepository.get().adminUser();
        // check if input fields are empty
        Assert.assertEquals(loginPage.getLoginnameInputText(), "");
        Assert.assertEquals(loginPage.getPasswordInputText(), "");
        loginPage.clickGetRememberMeCheckbox();
        //log in as admin
        loginPage.successAdminLogin(user);

        HomePage homePage = new HomePage(driver);
        // verify if we log in successfully
        Assert.assertEquals(homePage.getFirstnameText(), user.getFirstname());
        Assert.assertEquals(homePage.getLastnameText(), user.getLastname());

        // log out
        homePage.clickLogoutButton();
        loginPage = new LoginPage(driver);
        //verify if text values are saved in text inputs
        softAssert.assertEquals(loginPage.getLoginnameInputText(),user.getLoginname());
        softAssert.assertEquals(loginPage.getPasswordInputText().length(),user.getPassword().length());
        softAssert.assertAll();

    }
}

