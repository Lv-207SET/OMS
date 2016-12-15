package com.softserve.edu.oms.tests;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepository;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC28atokTest extends TestRunner {

    @DataProvider
    public Object[][] admUser() {
        return new Object[][] {
                { UserRepository.get().adminUser() }
        };
    }

    @DataProvider
    public Object[][] customerUser() {
        return new Object[][] {
                { UserRepository.get().customerUser() }
        };
    }

    @DataProvider
    public Object[][] merchandiserUser() {
        return new Object[][] {
                { UserRepository.get().merchandiserUser() }
        };
    }

    @DataProvider
    public Object[][] supervisorUser() {
        return new Object[][] {
                { UserRepository.get().supervisorUser() }
        };
    }


    @Test(dataProvider = "admUser")
    public void assertAdministratorLogin(IUser admUser) {
        Assert.assertTrue(logInPage.logout()
                .successAdminLogin(admUser)
                .waitForLoad()
                .getRoleText().equals(admUser.getRole()));
    }

    @Test(dataProvider = "customerUser")
    public void assertCustomerLogin(IUser customerUser) {
        Assert.assertTrue(logInPage.logout()
                .succesCustomerLogin(customerUser)
                .waitForLoad()
                .getRoleText().equals(customerUser.getRole()));
    }

    @Test(dataProvider = "merchandiserUser")
    public void assertMerchandiserLogin(IUser merchandiserUser) {
        Assert.assertTrue(logInPage.logout()
                .succesMerchandiserLogin(merchandiserUser)
                .waitForLoad()
                .getRoleText().equals(merchandiserUser.getRole()));
    }

    @Test(dataProvider = "supervisorUser")
    public void assertSupervisorLogin(IUser supervisorUser) {
        Assert.assertTrue(logInPage.logout()
                .succesSupervisorLogin(supervisorUser)
                .waitForLoad()
                .getRoleText().equals(supervisorUser.getRole()));
    }



}
