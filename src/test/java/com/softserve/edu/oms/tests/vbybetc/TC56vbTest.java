package com.softserve.edu.oms.tests.vbybetc;

import com.softserve.edu.oms.data.DBUtils;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.enums.SQLQueries;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.pages.CreateNewUserPage;
import com.softserve.edu.oms.tests.TestRunner;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

/**

 */
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

    /**
     * just for login
     * @param admUser
     */
    @Test(dataProvider = "admUser")
    public void PreconditionTest(IUser admUser) {

        CreateNewUserPage adminHomePage = loginPage.successAdminLogin(admUser)
                .clickAdministrationTab()
                .gotoCreateNewUserPage();
    }
    /**
     * <h1>Verify that Login field is case insensitive</h1>
     * This test goes to Create New User Page,
     * 1) executes SQL query to verify that nonExistingUser from UserRepository
     * really is not in DB
     * 2) If he, for some reason, exists - then generates new random Login
     * 3) Then the data for nonExistingUser are set in the form "Create new user"
     * 4) the fields "Role" and "Region" are not used, and leave as default
     * 5) the same Login, but in reverse case is set in Login field
     * 6) error message should appear - if so test passed
     *
     * <p>Note: there are two data providers and thus two tests, because
     * first we login as Admin and then trying to create New User</p>
     *
     * @author Viktoriia Bybel
     * @version 1.0
     * @since 15.12.16
     * @param nonExistingUser
     * @see UserRepository
     */

    @Test(dataProvider = "nonExistingUser")
    @Step("UniqueUserCreatingTest")
    public void UniqueUserCreatingTest(IUser nonExistingUser) {


        DBUtils dbUtils = new DBUtils();

        String nonExistingLogin = nonExistingUser.getLoginname();

        while (dbUtils.verifyThatUserIsInDB(nonExistingLogin)) {
            nonExistingLogin = RandomStringUtils.random(5, true, false).toLowerCase();
        }

        CreateNewUserPage newUserPage = new CreateNewUserPage(driver);
        newUserPage
                .waitForLoad()
                .setLoginInput(nonExistingLogin)
                .setFirstNameInput(nonExistingUser.getFirstname())
                .setLastNameInput(nonExistingUser.getLastname())
                .setPasswordInput(nonExistingUser.getPassword())
                .setConfirmPasswordInput(nonExistingUser.getPassword())
                .setEmailInput(nonExistingUser.getEmail())
                .clickCreateButton();

            try {
                newUserPage.acceptAlert();
            } catch (NoAlertPresentException e) {

            }

            CreateNewUserPage newUserPageAgain = new AdministrationPage(driver)
                    .gotoCreateNewUserPage()
                    .setLoginInput(nonExistingLogin.toUpperCase());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(newUserPageAgain.getLoginErrorMessageText().contains("in use"));

            dbUtils.deleteUsersFromDB(SQLQueries.DELETE_USER_BY_LOGIN.getQuery(),
                    nonExistingUser.getLoginname());

    }


}
