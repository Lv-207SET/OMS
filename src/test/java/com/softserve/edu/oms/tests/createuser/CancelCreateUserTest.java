package com.softserve.edu.oms.tests.createuser;

/**
 * Created by Oleh Lavrynenko on 13.12.2016.
 */

import com.softserve.edu.oms.data.DBUtils;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdminHomePage;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.pages.CreateNewUserPage;
import com.softserve.edu.oms.tests.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CancelCreateUserTest extends TestRunner {
    /**
     * Verify that a new user isn't created after
     * click "Cancel" button on Create New User Page
     *
     * @author Oleh Lavrynenko
     * @version 1.0
     * @since 16.12.16
     * @link http://ssu-jira.softserveinc.com/browse/LVSETOMS-55
     */
    @Test
    public void cancelCreateUserTest() {
        IUser user = UserRepository.get().adminUser();
        Assert.assertEquals(loginPage.getLoginnameInputText(), "");
        Assert.assertEquals(loginPage.getPasswordInputText(), "");
        loginPage.setLoginnameInput(user.getLoginname());
        loginPage.setPasswordInput(user.getPassword());
        loginPage.clickSubmitButton();
        AdminHomePage adminHomePage = new AdminHomePage(driver);
        adminHomePage.clickAdministrationTab();
        AdministrationPage adminPage = new AdministrationPage(driver);
        CreateNewUserPage createPage = adminPage.gotoCreateNewUserPage();
        DBUtils dbUtils = new DBUtils();
        user = UserRepository.get().invalidUser();
        Assert.assertNull(dbUtils.getUserByLogin(user.getLoginname()));
        createPage.setLoginInput(user.getLoginname())
                .setFirstNameInput(user.getFirstname())
                .setLastNameInput(user.getLastname())
                .setEmailInput(user.getEmail())
                .setPasswordInput(user.getPassword())
                .setConfirmPasswordInput(user.getPassword())
                .clickCancelButton();
        Assert.assertNull(dbUtils.getUserByLogin(user.getLoginname()));
        //Assert.assertAll();

    }
}
