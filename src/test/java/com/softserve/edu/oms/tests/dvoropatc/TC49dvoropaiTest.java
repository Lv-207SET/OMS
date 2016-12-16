package com.softserve.edu.oms.tests.dvoropatc;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdminHomePage;
import com.softserve.edu.oms.pages.CreateNewUserPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC49dvoropaiTest extends com.softserve.edu.oms.tests.TestRunner {

    private static final String EXPECTED_ERROR_MESSAGE_FOR_lOGIN = "Login name cannot be blank";
   private static final String EXPECTED_ERROR_MESSAGE_FOR_FIRST_NAME = "First name cannot be blank";
    private static final String EXPECTED_ERROR_MESSAGE_FOR_LAST_NAME = "Last name cannot be blank";
    private static final String EXPECTED_ERROR_MESSAGE_FOR_PASSWORD = "Password cannot be shorter" +
            " than 4 and longer than 10 characters";
    private static final String EXPECTED_ERROR_MESSAGE_FOR_EMAIL_ADRESS = "Incorrect format of " +
            "Email Address";

    // Provides login and password of registered user
    // with an "Administrator" role
    @DataProvider
    public Object[][] validUserAdministrator() {
        return new Object[][] {
                {UserRepository.get().adminUser()}
        };
    }

    /**
     * Test verifies that validation on empty mandatory fields works while
     * creating new user
     *
     * Based on LVSETOMS-49 in Jira
     *
     * @author Dmytro Voropai
     * @param validUserAdministrator {@link com.softserve.edu.oms.data.UserRepository}
     */
    @Test(dataProvider = "validUserAdministrator", alwaysRun = true)
    public void verifyErrorMessagesDuringUserCreation(IUser validUserAdministrator) {
        AdminHomePage omsAdminHomePage = loginPage.successAdminLogin(validUserAdministrator);
        CreateNewUserPage omsСreateNewUserPage = omsAdminHomePage
                .gotoAdministrationPage()
                .gotoCreateNewUserPage()
                .clickCreateButton()
                .acceptAlert();

   //  Assert that messages appear on page for all mandatory fields
        Assert.assertNotNull(omsСreateNewUserPage.getLoginErrorMessageText());
        Assert.assertNotNull(omsСreateNewUserPage.getFirstNameErrorMessageText());
        Assert.assertNotNull(omsСreateNewUserPage.getLastNameErrorMessageText());
        Assert.assertNotNull(omsСreateNewUserPage.getPasswordErrorMessageText());
        Assert.assertNotNull(omsСreateNewUserPage.getEmailErrorMessageText());

    //  Compare existing messages with expected
        Assert.assertEquals(omsСreateNewUserPage.getLoginErrorMessageText(),
                EXPECTED_ERROR_MESSAGE_FOR_lOGIN);
        Assert.assertEquals(omsСreateNewUserPage.getFirstNameErrorMessageText(),
                EXPECTED_ERROR_MESSAGE_FOR_FIRST_NAME);
        Assert.assertEquals(omsСreateNewUserPage.getLastNameErrorMessageText(),
                EXPECTED_ERROR_MESSAGE_FOR_LAST_NAME);
        Assert.assertEquals(omsСreateNewUserPage.getPasswordErrorMessageText(),
                EXPECTED_ERROR_MESSAGE_FOR_PASSWORD);
        Assert.assertEquals(omsСreateNewUserPage.getEmailErrorMessageText(),
                EXPECTED_ERROR_MESSAGE_FOR_EMAIL_ADRESS);
    }
}
