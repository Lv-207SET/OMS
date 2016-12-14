package com.softserve.edu.oms.tests.ikyselchuk;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.tests.TestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC37ikTest extends TestRunner{

    @DataProvider
    public Object[][] someUser() {
        return new Object[][] {
                { UserRepository.get().invalidUser() }
        };
    }

    @Test(dataProvider = "someUser")
    public void verifyResetButtonFunctionality(IUser someUser) {

        loginPage.setLoginDataAndReset(someUser);
        Assert.assertTrue(loginPage
                .getLoginnameInputText()
                .isEmpty());
        Assert.assertTrue(loginPage
                .getPasswordInputText()
                .isEmpty());
    }
}
