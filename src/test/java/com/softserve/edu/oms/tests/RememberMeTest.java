package com.softserve.edu.oms.tests;

import com.softserve.edu.oms.tests.TestRunner;
import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.softserve.edu.oms.pages.UserInfoPage;
import com.softserve.edu.oms.pages.LoginPage;
import org.testng.asserts.SoftAssert;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyString;

public class RememberMeTest extends TestRunner {
    private SoftAssert softAssert = new SoftAssert();
    @Test
    public void  rememberMeTest(){
        Assert.assertEquals(logInPage.getLoginnameInputText(), "");
        Assert.assertEquals(logInPage.getPasswordInputText(),"");
        logInPage.setLoginnameInput("noneiva");
        logInPage.setPasswordInput("qwerty");
        logInPage.clickgetRememberMeCheckbox();
        logInPage.clickSubmitButton();
        UserInfoPage userInfoPage=new UserInfoPage(driver);
                Assert.assertEquals(userInfoPage.getFirstNameLabel(),"noneivanka");
        Assert.assertEquals(userInfoPage.getLastNameLabel(), "nonehoroshko");
        userInfoPage.clickLogoutButton();
        logInPage=new LoginPage(driver);
        softAssert.assertEquals(logInPage.getLoginnameInputText(), "noneiva");
        softAssert.assertEquals(logInPage.getPasswordInputText(), "qwerty");
        softAssert.assertAll();

    }
}
