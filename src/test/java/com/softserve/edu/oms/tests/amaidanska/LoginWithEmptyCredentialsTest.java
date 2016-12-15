package com.softserve.edu.oms.tests.amaidanska;

import com.softserve.edu.oms.tests.TestRunner;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;

import static com.softserve.edu.oms.enums.ErrorMessagesEnum.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class LoginWithEmptyCredentialsTest extends TestRunner {

     @Test
    public void loginWithEmptyCredentials (){
         String currentErrorMessage = loginPage
                 .loginWithEmptyCredentials()
                 .getBadCredentialsErrorMessageText();

         assertThat(currentErrorMessage, CoreMatchers.equalTo(ERROR_MESSAGE.message));
     }
}
