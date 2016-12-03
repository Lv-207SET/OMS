package com.softserve.edu.oms.tests;

import com.softserve.edu.oms.data.DBUtils;
import com.softserve.edu.oms.pages.AdminHomePage;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.pages.CreateNewUserPage;
import com.softserve.edu.oms.pages.LoginPage;
// import com.softserve.edu.oms.pages.UserInfoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CancelCreateUserTest extends TestRunner {
    @Test
    public void rememberMeTest() {
        Assert.assertEquals(logInPage.getLoginnameInputText(), "");
        Assert.assertEquals(logInPage.getPasswordInputText(), "");
        logInPage.setLoginnameInput("noneiva");
        logInPage.setPasswordInput("qwerty");
        logInPage.clickSubmitButton();
        AdminHomePage adminHomePage = new AdminHomePage(driver);
        adminHomePage.clickAdministrationTab();
        AdministrationPage adminPage = new AdministrationPage(driver);
        CreateNewUserPage createPage = adminPage.goToCreateNewUserPage();
        DBUtils dbUtils = new DBUtils();
        Assert.assertNull(dbUtils.getUserByLogin("hdftwqewq"));
        createPage.setLogin("hdftwqewq")
                .setFirstName("Rob")
                .setLastName("Roy")
                .setEmail("aaa@aaa.com")
                .setPassword("1111")
                .setConfirmPassword("1111")
                .cancel();
        Assert.assertNull(dbUtils.getUserByLogin("hdftwqewq"));
        //Assert.assertAll();

    }
}
