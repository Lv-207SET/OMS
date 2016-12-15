package com.softserve.edu.oms.tests.dvoropatc;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepository;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

 /*
  * Test verifies that error message is shown when user tries to login without
  * being registered in the system
  * */
public class TestCaseTwentyNineTest extends TestRunner {

        private static final String EXPECTED_ERROR_MESSAGE = "Such user does not exist " +
            "in the system - please try again";

//  Provides not register user login and password
    @DataProvider
    public Object[][] notExistUser() {
        return new Object[][] {
                {UserRepository.get().nonExistingUser() }
        };
    }

    @Test(dataProvider = "notExistUser", alwaysRun = true)
    public void verifyResetButtonFunctionality(IUser notExistUser){
//      Check if Object of String error message is not null.
        Assert.assertNotNull(logInPage.unsuccessfulLogin(notExistUser)
                .getBadCredentialsErrorMessageText());
//      Check if error message is the same as was expected
        Assert.assertEquals(logInPage.unsuccessfulLogin(notExistUser)
                .getBadCredentialsErrorMessageText(), EXPECTED_ERROR_MESSAGE);
    }
}
