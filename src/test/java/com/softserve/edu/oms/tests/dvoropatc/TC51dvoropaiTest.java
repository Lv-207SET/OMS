package com.softserve.edu.oms.tests.dvoropatc;

import com.softserve.edu.oms.data.DBUtils;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdminHomePage;
import com.softserve.edu.oms.pages.CreateNewUserPage;
import com.softserve.edu.oms.tests.TestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

    /*
    * This test case verifies that error messages appear when trying to create
    * a new user with too long login, first /last name (longer than 13 characters)
    * and password (longer than 10 characters).
    * */

public class TC51dvoropaiTest extends TestRunner{

    private static final String EXPECTED_ERROR_MESSAGE_FOR_lOGIN_TC51 = "Login name is too long";
    private static final String EXPECTED_ERROR_MESSAGE_FOR_FIRST_NAME_TC51 = "First name is too long";
    private static final String EXPECTED_ERROR_MESSAGE_FOR_LAST_NAME_TC51 = "Last name is too long";
    private static final String EXPECTED_ERROR_MESSAGE_FOR_PASSWORD_TC51 = "Password cannot be shorter" +
            " than 4 and longer than 10 characters";

    final private DBUtils dbUtils = new DBUtils();
    final private IUser userWithLongCredentials= UserRepository.get().UserWithLongCredentials();

    // Provides login and password of registered user
    // with an "Administrator" role
    @DataProvider
    public Object[][] validUserAdministrator() {
        return new Object[][] {
                {UserRepository.get().adminUser()}
        };
    }

    @Test(dataProvider = "validUserAdministrator",alwaysRun = true)
    public void verifyCreateNewUserWithToLognData(IUser validUserAdministrator){
        AdminHomePage omsAdminHomePage = loginPage.successAdminLogin(validUserAdministrator);
        CreateNewUserPage omsСreateNewUserPage = omsAdminHomePage
                .gotoAdministrationPage()
                .gotoCreateNewUserPage()
                .setLoginData(userWithLongCredentials)
                .clickCreateButton()
                .acceptAlert();

//        Check if correct messages appeared for required fields
        Assert.assertEquals(omsСreateNewUserPage.getLoginErrorMessageText(),
                EXPECTED_ERROR_MESSAGE_FOR_lOGIN_TC51);
        Assert.assertEquals(omsСreateNewUserPage.getFirstNameErrorMessageText(),
                EXPECTED_ERROR_MESSAGE_FOR_FIRST_NAME_TC51);
        Assert.assertEquals(omsСreateNewUserPage.getLastNameErrorMessageText(),
                EXPECTED_ERROR_MESSAGE_FOR_LAST_NAME_TC51);
        Assert.assertEquals(omsСreateNewUserPage.getPasswordErrorMessageText(),
                EXPECTED_ERROR_MESSAGE_FOR_PASSWORD_TC51);

//        Check if user with too long credentials was not created in database
        Assert.assertNull(dbUtils.getUserByLogin(userWithLongCredentials.getLoginname()));
    }
}
