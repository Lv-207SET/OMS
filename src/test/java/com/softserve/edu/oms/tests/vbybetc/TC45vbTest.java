package com.softserve.edu.oms.tests.vbybetc;

import com.softserve.edu.oms.data.DBUtils;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.User;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.tests.TestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class TC45vbTest extends TestRunner{

    @DataProvider
    public Object[][] admUser() {
        return new Object[][] {
                { UserRepository.get().adminUser() }
        };
    }

    @Test(dataProvider = "admUser")
    public void CorrectUserDisplayingTest(IUser admUser) {
        int numberOfFoundUsersFromDB;

        AdministrationPage administrationPage = loginPage.successAdminLogin(admUser)
                .clickAdministrationTab();

        int numberOfFoundUsersFromPage = administrationPage.getFoundUsersNumber();

        DBUtils dbUtils = new DBUtils();
        numberOfFoundUsersFromDB = dbUtils.countAllUsers();
        Assert.assertEquals(numberOfFoundUsersFromDB, numberOfFoundUsersFromPage);

        List<User> usersFromPage = administrationPage.getUsersFormCurrentPage();

        List<User> usersFromDB = dbUtils.getTopFiveUsers();

        for(int i = 0; i<usersFromPage.size();i++){
            Assert.assertTrue(usersFromDB.get(i).CompareTo(usersFromPage.get(i)));
        }
    }
}
