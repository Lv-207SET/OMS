package com.softserve.edu.oms.tests.rraba;


import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.oms.data.DBUtils;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdminHomePage;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.pages.CreateNewUserPage;
import com.softserve.edu.oms.tests.TestRunner;

public class TC53rrabaTest extends TestRunner{
 
    private AdministrationPage administrationPage;
    private int pagesCount;
    private int numberUsers;
    
    @BeforeMethod 
    public void setUp() {
        int numberOfImems;
        
        IUser user = UserRepository.get().someUser();
        
        AdminHomePage adminHomePage = 
                logInPage.successAdminLogin(UserRepository.get().adminUser());
        administrationPage = 
                adminHomePage.gotoAdministrationPage();
        numberUsers = Integer.valueOf(administrationPage.getFoundUsersNumber());
        pagesCount = Integer.valueOf(administrationPage.getPagesQuantity());
        
        numberOfImems = administrationPage.getUsersPerPage();

        if ((numberUsers % numberOfImems) != 0) {
            for (int i = 0; i < (numberOfImems - (numberUsers % numberOfImems)); i++) {
                CreateNewUserPage createNewUserPage = 
                        administrationPage.goToCreateNewUserPage();

                createNewUserPage.setLogin(user.getLoginname() + user.getLoginname().charAt(i)).
                      setFirstName(user.getFirstname()).
                      setLastName(user.getLastname()).
                      setPassword(user.getPassword()).
                      setConfirmPassword(user.getPassword()).
                      setEmail(user.getEmail()); 
                
                administrationPage = createNewUserPage.createNewUser();
            }
            numberUsers = numberUsers +(numberOfImems- (numberUsers % numberOfImems));
        }
    }
    
    @AfterMethod
    public void tearDown() {
        DBUtils dbUtils = new DBUtils();
        dbUtils.deleteUsersFromDB();
    }
    
    
    @DataProvider
    public Object[][] validUser() {
        return new Object[][] { { UserRepository.get().newUser()},
        };
    }
    
    
    @Test(dataProvider = "validUser")
    public void verifyChangePageNumber(IUser user){
        
        int newNumberOfUsers;
        int newPagesCount;

        CreateNewUserPage createNewUserPage = 
                administrationPage.goToCreateNewUserPage();
        createNewUserPage.
              setLogin(user.getLoginname()).
              setFirstName(user.getFirstname()).
              setLastName(user.getLastname()).
              setPassword(user.getPassword()).
              setConfirmPassword(user.getPassword()).
              setEmail(user.getEmail());
 
        administrationPage = createNewUserPage.createNewUser();
        newNumberOfUsers = Integer.valueOf(administrationPage.getFoundUsersNumber());
        newPagesCount = Integer.valueOf(administrationPage.getPagesQuantity());
        Assert.assertEquals(numberUsers + 1, newNumberOfUsers);
        Assert.assertEquals(pagesCount + 1, newPagesCount);
 
    }

}

