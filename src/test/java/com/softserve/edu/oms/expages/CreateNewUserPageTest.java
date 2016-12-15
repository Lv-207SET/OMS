package com.softserve.edu.oms.expages;

import com.softserve.edu.oms.data.DBUtils;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.User;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.enums.Region;
import com.softserve.edu.oms.enums.Role;
import com.softserve.edu.oms.enums.SQLQueries;
import com.softserve.edu.oms.pages.AdminHomePage;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.pages.CreateNewUserPage;
import com.softserve.edu.oms.tests.TestRunner;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserve.edu.oms.enums.ErrorMessagesEnum.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class CreateNewUserPageTest extends TestRunner {


    private AdminHomePage adminHomePage;
    private AdministrationPage administrationPage;
    private CreateNewUserPage createNewUserPage;
    private DBUtils dbUtils;
    private int pagesCount;
    private int numberUsers;


    @DataProvider
    public Object[][] validUser() {
        return new Object[][] { { UserRepository.get().newUser()},
        };
    }

    @DataProvider
    public Object[][] invalidUsers() {
        return new Object[][] {
                { UserRepository.get().invalidUser() }
        };
    }

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

    @DataProvider
    public Object[][] nonExistingUser() {
        return new Object[][] {
                { UserRepository.get().nonExistingUser() }
        };
    }


    @BeforeMethod
    public void setUp() {
        int numberOfImems;

        IUser user = UserRepository.get().someUser();

        AdminHomePage adminHomePage =
                loginPage.successAdminLogin(UserRepository.get().adminUser());
        administrationPage =
                adminHomePage.gotoAdministrationPage();
        numberUsers = administrationPage.getFoundUsersNumber();
        pagesCount =  administrationPage.getPagesQuantity();

        numberOfImems = administrationPage.getUsersPerPageNumber();

        if ((numberUsers % numberOfImems) != 0) {
            for (int i = 0; i < (numberOfImems - (numberUsers % numberOfImems)); i++) {
                CreateNewUserPage createNewUserPage =
                        administrationPage.goToCreateNewUserPage();

                createNewUserPage.setLoginInput(user.getLoginname() + user.getLoginname().charAt(i)).
                        setFirstNameInput(user.getFirstname()).
                        setLastNameInput(user.getLastname()).
                        setPasswordInput(user.getPassword()).
                        setConfirmPasswordInput(user.getPassword()).
                        setEmailInput(user.getEmail()).
                        setSelectRegion(Region.getRegion(user.getRegion())).
                        setSelectRole(Role.valueOf(user.getRole().toUpperCase()));

                administrationPage = createNewUserPage.successCreateNewUser();
            }
            numberUsers = numberUsers +(numberOfImems- (numberUsers % numberOfImems));
        }
    }

    @AfterMethod
    public void tearDown() {
        DBUtils dbUtils = new DBUtils();
        dbUtils.deleteUsersFromDB(SQLQueries.DELETE_USERS_BY_FIRSTNAME.getQuery(),
                UserRepository.get().someUser().getFirstname());
    }

    @Test(dataProvider = "invalidUsers")
    public void createInvalidNewUserTest (User user){
        IUser admin = UserRepository.get().adminUser();
        AdministrationPage administrationPage = loginPage
                .successAdminLogin(admin)
                .gotoAdministrationPage();
        CreateNewUserPage createNewUserPage =
                administrationPage.goToCreateNewUserPage();
        createNewUserPage.setLoginData(user);
        driver.switchTo().alert().accept();

        assertThat(createNewUserPage.getFirstNameErrorMessageText(),
                CoreMatchers.equalTo(FIRST_NAME_ERROR_MESSAGE.message));
        assertThat(createNewUserPage.getLastNameErrorMessageText(),
                CoreMatchers.equalTo(LAST_NAME_ERROR_MESSAGE.message));
        DBUtils dbUtils = new DBUtils();
        assertThat(dbUtils.getUserByLogin(user.getLoginname()), CoreMatchers.equalTo(null));
    }

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
        CreateNewUserPage createPage = adminPage.goToCreateNewUserPage();
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

    /**
     * just for login
     * @param admUser
     */
//    @Test(dataProvider = "adminUser")
//    public void PreconditionTest(IUser admUser) {
//
//        CreateNewUserPage adminHomePage = loginPage.successAdminLogin(admUser)
//                .clickAdministrationTab()
//                .goToCreateNewUserPage();
//    }
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

    @Test(dataProvider = "nonExistingUser", dependsOnMethods = "PreconditionTest")
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

        if (!(dbUtils.verifyThatUserIsInDB(nonExistingLogin))) {

            CreateNewUserPage newUserPageAgain = new AdministrationPage(driver)
                    .goToCreateNewUserPage().setLoginInput(nonExistingLogin.toUpperCase());

            Assert.assertTrue(newUserPageAgain.getLoginErrorMessageText().contains("already in use"));

            dbUtils.deleteUsersFromDB(SQLQueries.DELETE_USER_BY_LOGIN.getQuery(),
                    nonExistingUser.getLoginname());
        }
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

    @Test(dependsOnMethods = "verifyErrorMsgUserWithNotConfirmedPassword")
    public void returnToPreviousState() {
        createNewUserPage.logout();
    }

    @Test(dataProvider = "validUser")
    public void verifyChangePageNumber(IUser user){

        int newNumberOfUsers;
        int newPagesCount;

        CreateNewUserPage createNewUserPage =
                administrationPage.goToCreateNewUserPage();

        administrationPage = createNewUserPage.successCreateNewUser(user);
        newNumberOfUsers = Integer.valueOf(administrationPage.getFoundUsersNumber());
        newPagesCount = Integer.valueOf(administrationPage.getPagesQuantity());
        org.junit.Assert.assertEquals(numberUsers + 1, newNumberOfUsers);
        org.junit.Assert.assertEquals(pagesCount + 1, newPagesCount);

    }



}
