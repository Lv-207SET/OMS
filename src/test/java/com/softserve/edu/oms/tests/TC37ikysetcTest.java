package com.softserve.edu.oms.tests;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepository;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC37ikysetcTest extends TestRunner {

    WebDriver driver;

    @DataProvider
    public Object[][] someUser() {
		return new Object[][] {
		    { UserRepository.get().invalidUser() }
        };
    }

    @Test(dataProvider = "someUser")
    public void Test(IUser someUser) {
        logInPage.setLoginDataAndReset(someUser);
        Assert.assertTrue(logInPage.getLoginnameInputText().isEmpty());
        Assert.assertTrue(logInPage.getPasswordInputText().isEmpty());
    }

}
