package com.softserve.edu.oms.tests.administration;

import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.softserve.edu.oms.data.DBUtils;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.enums.Region;
import com.softserve.edu.oms.enums.Role;
import com.softserve.edu.oms.enums.SQLQueries;
import com.softserve.edu.oms.expages.CreateNewUserPageTest;
import com.softserve.edu.oms.pages.AdminHomePage;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.pages.CreateNewUserPage;
import com.softserve.edu.oms.tests.TestRunner;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * This test verifies that new user creation affects
 * 'Number of Found User' and pagination label on main
 * page of 'Administration' tab
 *
 * Based on LVSETOMS-53 in Jira
 *
 * @author Roman Raba
 * @since 16.12.16
 * @link http://ssu-jira.softserveinc.com/browse/LVSETOMS-53
 */
public class PaginationTest extends TestRunner{
    
    private AdministrationPage administrationPage;
    private int pagesCount;
    private int numberUsers;
    
    @DataProvider
    public Object[][] validUser() {
        return new Object[][]{{UserRepository.get().userForDelete()},
        };
    }
    
    /**
     * Verify that values in 'Number of found users' and 'Page#:' links
     * are properly updated after creation a new user.
     */
    @Test(dataProvider = "validUser")
    @Step("verifyChangePageNumber")
    public void verifyChangePageNumber(IUser user) {

        int newNumberOfUsers;
        int newPagesCount;

        verifyAndCreateUsers();

        CreateNewUserPage createNewUserPage =
                administrationPage.gotoCreateNewUserPage();

        administrationPage = createNewUserPage.successCreateNewUser(user);
        newNumberOfUsers = Integer.valueOf(administrationPage.getFoundUsersNumber());
        newPagesCount = Integer.valueOf(administrationPage.getPagesQuantity());
        Assert.assertEquals(numberUsers + 1, newNumberOfUsers);
        Assert.assertEquals(pagesCount + 1, newPagesCount);

        deleteUsersFromDB();
    }


    /**
     * Verify that number of active registered users is aliquot to 5.
     * And creates necessary number of users.
     */
    public void verifyAndCreateUsers() {
        int numberOfImems;

        IUser user = UserRepository.get().someUser();

        AdminHomePage adminHomePage =
                loginPage.successAdminLogin(UserRepository.get().adminUser());
        administrationPage =
                adminHomePage.gotoAdministrationPage();
        numberUsers = administrationPage.getFoundUsersNumber();
        pagesCount = administrationPage.getPagesQuantity();

        numberOfImems = administrationPage.getUsersPerPageNumber();

        if ((numberUsers % numberOfImems) != 0) {
            for (int i = 0; i < (numberOfImems - (numberUsers % numberOfImems)); i++) {
                CreateNewUserPage createNewUserPage =
                        administrationPage.gotoCreateNewUserPage();

                createNewUserPage.setLoginInput(user.getLoginname() + user.getLoginname().charAt(i)).
                        setFirstNameInput(user.getFirstname()).
                        setLastNameInput(user.getLastname()).
                        setPasswordInput(user.getPassword()).
                        setConfirmPasswordInput(user.getPassword()).
                        setEmailInput(user.getEmail()).
                        setSelectRegion(Region.getRegion(user.getRegion())).
                        setSelectRole(Role.valueOf(user.getRole().toUpperCase()));

                administrationPage = createNewUserPage.successCreateNewUser();
            }
            numberUsers = numberUsers + (numberOfImems - (numberUsers % numberOfImems));
        }
    }


    /**
     * Deletes users from DB after creation in test.
     */
    public void deleteUsersFromDB() {
        DBUtils dbUtils = new DBUtils();
        dbUtils.deleteUsersFromDB(SQLQueries.DELETE_USERS_BY_FIRSTNAME.getQuery(),
                UserRepository.get().someUser().getFirstname());
    }

}
