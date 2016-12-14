package com.softserve.edu.oms.tests.amaidanska;

import com.softserve.edu.oms.tests.TestRunner;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;


public class LoginWithEmptyCredentialsTest extends TestRunner {
    private static final String ERROR_MESSAGE = "Your login attempt was not successful, try again.\n" + "\n" +
            "Reason: Bad credentials.";

     @Test
    public void loginWithEmptyCredentials (){
         String currentErrorMessage = loginPage
                 .loginWithEmptyCredentials()
                 .getBadCredentialsErrorMessageText();

         assertThat(currentErrorMessage, CoreMatchers.equalTo(ERROR_MESSAGE));
     }
}
