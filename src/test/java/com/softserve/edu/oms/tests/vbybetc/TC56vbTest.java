package com.softserve.edu.oms.tests.vbybetc;

import com.softserve.edu.oms.data.DBUtils;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.enums.SQLQueries;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.pages.CreateNewUserPage;
import com.softserve.edu.oms.tests.TestRunner;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC56vbTest extends TestRunner{

    @DataProvider
    public Object[][] admUser() {
        return new Object[][] {
                { UserRepository.get().adminUser() }
        };
    }

    @DataProvider
    public Object[][] nonExistingUser() {
        return new Object[][] {
                { UserRepository.get().nonExistingUser() }
        };
    }

    @Test(dataProvider = "admUser")
    public void PreconditionTest(IUser admUser) {

        CreateNewUserPage adminHomePage = loginPage.successAdminLogin(admUser)
                .clickAdministrationTab()
                .goToCreateNewUserPage();
    }

    @Test(dataProvider = "nonExistingUser")
    public void UniqueUserCreatingTest(IUser nonExistingUser)  {

        DBUtils dbUtils = new DBUtils();

        String nonExistingLogin = nonExistingUser.getLoginname();

        while(dbUtils.verifyThatUserIsInDB(nonExistingLogin)) {
            nonExistingLogin = RandomStringUtils.random(5, true, false).toLowerCase();
        }

        CreateNewUserPage newUserPage = new CreateNewUserPage(driver);
        newUserPage
                .setLoginInput(nonExistingLogin)
                .setFirstNameInput(nonExistingUser.getFirstname())
                .setLastNameInput(nonExistingUser.getLastname())
                .setPasswordInput(nonExistingUser.getPassword())
                .setConfirmPasswordInput(nonExistingUser.getPassword())
                .setEmailInput(nonExistingUser.getEmail())
                .clickCreateButton();

        CreateNewUserPage newUserPageAgain = new AdministrationPage(driver)
                .goToCreateNewUserPage().setLoginInput(nonExistingLogin.toUpperCase());

        Assert.assertTrue(newUserPageAgain.getLoginErrorMessageText().contains("already in use"));

        dbUtils.deleteUsersFromDB(SQLQueries.DELETE_FROM_USERS_WHERE_LOGIN_EQUALS.getQuery(),
                nonExistingUser.getLoginname());
    }

}
