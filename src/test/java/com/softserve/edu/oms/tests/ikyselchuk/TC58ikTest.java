package com.softserve.edu.oms.tests.ikyselchuk;

import com.softserve.edu.oms.data.DBUtils;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdminHomePage;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.pages.CreateNewUserPage;
import com.softserve.edu.oms.tests.TestRunner;
import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class TC58ikTest extends TestRunner{

    private AdminHomePage adminHomePage;
    private AdministrationPage administrationPage;
    private CreateNewUserPage createNewUserPage;
    private DBUtils dbUtils;
    private final static String ERROR_MESSAGE = "Confirm password has to be equal to password";

    @DataProvider
    public Object[][] adminUser() {
        return new Object[][] {
                { UserRepository.get().adminUser() }
        };
    }

    @DataProvider
    public Object[][] badMemoryUser() {
        return new Object[][] {
                { UserRepository.get().badMemoryUser() }
        };
    }

    @Test(dataProvider = "adminUser")
    public void setTestPreconditions(IUser admin) {
        adminHomePage = loginPage.successAdminLogin(admin);
        administrationPage = adminHomePage.gotoAdministrationPage();
        createNewUserPage = administrationPage.goToCreateNewUserPage();
    }

    @Test(dataProvider = "badMemoryUser", dependsOnMethods = "setTestPreconditions")
    public void verifyErrorMsgUserWithNotConfirmedPassword(IUser newUser) {
        dbUtils = new DBUtils();
        assertThat(dbUtils.getUserByLogin(newUser.getLoginname()), CoreMatchers.equalTo(null));
        createNewUserPage
                .setInputLogin(newUser.getLoginname())
                .setInputFirstName(newUser.getFirstname())
                .setInputLastName(newUser.getLastname())
                .setInputPassword(newUser.getPassword())
                .setInputConfirmPassword(newUser.getPassword().toUpperCase())
                .setInputEmail(newUser.getEmail())
                .clickButtonCreate();
        createNewUserPage.acceptAlert();

        Assert.assertTrue(createNewUserPage.getConfirmPasswordErrorMessage().isDisplayed()
                && createNewUserPage.getConfirmPasswordErrorMessageText().equals(ERROR_MESSAGE));
        assertThat(dbUtils.getUserByLogin(newUser.getLoginname()), CoreMatchers.equalTo(null));
    }

    @Test(dependsOnMethods = "verifyErrorMsgUserWithNotConfirmedPassword")
    public void returnToPreviousState() {
        createNewUserPage.logout();
    }
}
