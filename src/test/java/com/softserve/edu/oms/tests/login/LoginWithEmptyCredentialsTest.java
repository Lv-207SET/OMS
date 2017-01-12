package com.softserve.edu.oms.tests.login;

import com.softserve.edu.oms.tests.TestRunner;
import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.model.SeverityLevel;

import static com.softserve.edu.oms.enums.ErrorMessagesEnum.ERROR_MESSAGE;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Test verifies that error message is shown,
 * when user try to login with empty "Login" and "Password" fields.
 *
 * Based on LVSETOMS-30 in Jira
 *
 * @author Anastasiia Maidanska
 * @version 1.0
 * @since 20.12.16
 */
@Features("Authorization")
@Stories("LVSETOMS-1 As User Admin I want to login so I can enter the system and add new users to system")

public  class LoginWithEmptyCredentialsTest extends TestRunner {

    /**
     * Test verifies that error message is shown,
     * when user try to login with empty "Login" and "Password" fields.
     */
	@TestCaseId("LVSETOMS-30")
	@Severity(SeverityLevel.BLOCKER)
	@Description("This test case verifies that error message is shown when "
			+ "user tries to login with empty 'User' and 'Password' fields")
	

    @Test()
    @Step
    public void verifyErrorMessageWhenUserLoginWithEmptyCredentials(){

        // Click on 'Submit' button and get  error message
        innerStep("Click on 'Submit' button and get  error message");
        String currentErrorMessage = loginPage
                .loginWithEmptyCredentials()
                .getBadCredentialsErrorMessageText();

        // Verify that error message is correct
        innerStep("Verify that error message is correct");
        assertThat(currentErrorMessage, CoreMatchers.equalTo(ERROR_MESSAGE.message));

    }
}
