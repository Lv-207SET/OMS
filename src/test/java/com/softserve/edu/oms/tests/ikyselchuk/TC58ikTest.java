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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserve.edu.oms.enums.ErrorMessagesEnum.CONFIRM_PASSWORD_ERROR_MESSAGE;
import static org.hamcrest.MatcherAssert.assertThat;

public class TC58ikTest extends TestRunner{

    private AdminHomePage adminHomePage;
    private AdministrationPage administrationPage;
    private CreateNewUserPage createNewUserPage;
    private DBUtils dbUtils;

    @DataProvider
    public Object[][] badMemoryUser() {
        return new Object[][] {
                { UserRepository.get().badMemoryUser() }
        };
    }

    @BeforeMethod
    public void setTestPreconditions() {
        IUser admin = UserRepository.get().adminUser();
        adminHomePage = loginPage.successAdminLogin(admin);
        administrationPage = adminHomePage.gotoAdministrationPage();
        createNewUserPage = administrationPage.gotoCreateNewUserPage();
    }

    @Test(dataProvider = "badMemoryUser")
    public void verifyErrorMsgUserWithNotConfirmedPassword(IUser newUser) {
        dbUtils = new DBUtils();
        assertThat(dbUtils.getUserByLogin(newUser.getLoginname()), CoreMatchers.equalTo(null));
        createNewUserPage
                .setLoginInput(newUser.getLoginname())
                .setFirstNameInput(newUser.getFirstname())
                .setLastNameInput(newUser.getLastname())
                .setPasswordInput(newUser.getPassword())
                .setConfirmPasswordInput(newUser.getPassword().toUpperCase())
                .setEmailInput(newUser.getEmail())
                .clickCreateButton();
        createNewUserPage.acceptAlert();

        Assert.assertTrue(createNewUserPage.getConfirmPasswordErrorMessage().isDisplayed()
                && createNewUserPage.getConfirmPasswordErrorMessageText().equals(CONFIRM_PASSWORD_ERROR_MESSAGE.message));
        assertThat(dbUtils.getUserByLogin(newUser.getLoginname()), CoreMatchers.equalTo(null));
    }

    @AfterMethod
    public void returnToPreviousState() {
        createNewUserPage.logout();
    }
}
