package com.softserve.edu.oms.tests.atokmtc;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.enums.SQLQueries;
import com.softserve.edu.oms.data.UserRepository;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.softserve.edu.oms.tests.TestRunner;


public class TC46atokTEST extends TestRunner {

    @DataProvider
    public Object[][] admUser() {
        return new Object[][] {
                { UserRepository.get().adminUser() }
        };
    }


    @Test(dataProvider = "admUser")
    public void assertSortById(IUser admUser) {
        Assert.assertTrue(loginPage.logout()
                .successAdminLogin(admUser)
                .gotoAdministrationPage()
                .goToCreateReportPage()
                .waitForLoad()
                .showTenRows()
                .waitForLoad()
                .compareLogins(SQLQueries.ACTIVE_USERS_ORDER_BY_ID.getQuery()));
    }



    @Test(dataProvider = "admUser")
    public void assertSortByFirstNameASC(IUser admUser) {
        Assert.assertTrue( loginPage.logout()
                .successAdminLogin(admUser)
                .gotoAdministrationPage()
                .goToCreateReportPage()
                .waitForLoad()
                .showTenRows()
                .waitForLoad()
                .sortByFirstNameASC()
                .waitForLoad()
                .compareLogins(SQLQueries.ACTIVE_USERS_ORDER_BY_FIRST_NAME_ASC.getQuery()));
    }

    @Test(dataProvider = "admUser")
    public void assertSortByFirstNameDESC(IUser admUser) {
        Assert.assertTrue(loginPage.logout()
                .successAdminLogin(admUser)
                .gotoAdministrationPage()
                .goToCreateReportPage()
                .waitForLoad()
                .showTenRows()
                .waitForLoad()
                .sortByFirstNameDESC()
                .waitForLoad()
                .compareLogins(SQLQueries.ACTIVE_USERS_ORDER_BY_FIRST_NAME_DESC.getQuery()));
    }

    @Test(dataProvider = "admUser")
    public void assertSortByLastNameASC(IUser admUser) {
        Assert.assertTrue( logInPage.logout()
                .successAdminLogin(admUser)
                .gotoAdministrationPage()
                .goToCreateReportPage()
                .waitForLoad()
                .showTenRows()
                .waitForLoad()
                .sortByLastNameASC()
                .waitForLoad()
                .compareLogins(SQLQueries.ACTIVE_USERS_ORDER_BY_LAST_NAME_ASC.getQuery()));
    }

    @Test(dataProvider = "admUser")
    public void assertSortByLastNameDESC(IUser admUser) {
        Assert.assertTrue( logInPage.logout()
                .successAdminLogin(admUser)
                .gotoAdministrationPage()
                .goToCreateReportPage()
                .waitForLoad()
                .showTenRows()
                .waitForLoad()
                .sortByLastNameDESC()
                .waitForLoad()
                .compareLogins(SQLQueries.ACTIVE_USERS_ORDER_BY_LAST_NAME_DESC.getQuery()));
    }





}
