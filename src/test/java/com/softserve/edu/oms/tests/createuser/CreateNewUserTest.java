package com.softserve.edu.oms.tests.createuser;


import com.softserve.edu.oms.data.DBUtils;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.User;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.enums.ConditionFilterDropdownList;
import com.softserve.edu.oms.enums.FieldFilterDropdownList;
import com.softserve.edu.oms.enums.SQLQueries;
import com.softserve.edu.oms.tests.TestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * This test verifies that user with valid data
 * that is not registered with the site currently
 * can be successfully created by the site administrator
 *
 * Based on LVSETOMS-50 in Jira
 *
 * @author Anton Tokmakov
 * @since 16.12.16
 */

public class CreateNewUserTest extends TestRunner {

    @DataProvider
    public Object[][] Users() {
        return new Object[][]{
                {UserRepository.get().adminUser(), UserRepository.get().newUser()}
        };
    }

    @DataProvider
    public Object[][] newUser() {
        return new Object[][]{
                {UserRepository.get().newUser()}
        };
    }

    /** Checks if tested user is not present
     * in the site database at the moment
     */
    @Test(dataProvider = "newUser")
    public void assertNonExistence(IUser newUser) {
        DBUtils dbUtility = new DBUtils();
        Assert.assertFalse(dbUtility.verifyThatUserIsInDB(newUser.getLoginname()));
    }

    @Test(dataProvider = "Users")
    public void createNewUser(IUser admUser, IUser newUser) {
        List<User> users = loginPage.logout()
                .successAdminLogin(admUser)
                .gotoAdministrationPage()
                .waitForLoad()
                .gotoCreateNewUserPage()
                .waitForLoad()
                .setLoginData(newUser)
                .waitForEmailErrorToDisappear()
                .successCreateNewUser()
                .waitForLoad()
                .filterAndSearch(FieldFilterDropdownList.LOGIN, ConditionFilterDropdownList.EQUALS, newUser.getLoginname())
                .waitForLoad()
                .getAllUsers();

        //If list contains anything but a single newly created user
        //then something went wrong and it asserts false
        if(users.size()>1)
            Assert.assertTrue(false);

        Assert.assertEquals(users.get(0).getLoginname(), newUser.getLoginname());
    }

    /** Remove newly created user from the site database
     * to ensure clean test execution
     */
    @Test(dataProvider = "newUser")
    public void deleteUser (IUser newUser){
        DBUtils dbUtility = new DBUtils();
        dbUtility.deleteUsersFromDB(SQLQueries.DELETE_USER_BY_LOGIN.getQuery(), newUser.getLoginname());
        Assert.assertFalse(dbUtility.verifyThatUserIsInDB(newUser.getLoginname()));
    }

}
