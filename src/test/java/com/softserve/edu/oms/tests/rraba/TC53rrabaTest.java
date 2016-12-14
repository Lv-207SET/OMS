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
                loginPage.successAdminLogin(UserRepository.get().adminUser());
        administrationPage = 
                adminHomePage.gotoAdministrationPage();
        numberUsers = administrationPage.getFoundUsersNumber();
        pagesCount =  administrationPage.getPagesQuantity();
        
        //numberOfImems = administrationPage.getUsersPerPage();
        numberOfImems = 5;

        if ((numberUsers % numberOfImems) != 0) {
            for (int i = 0; i < (numberOfImems - (numberUsers % numberOfImems)); i++) {
                CreateNewUserPage createNewUserPage = 
                        administrationPage.goToCreateNewUserPage();

                createNewUserPage.setInputLogin(user.getLoginname() + user.getLoginname().charAt(i)).
                      setInputFirstName(user.getFirstname()).
                      setInputLastName(user.getLastname()).
                      setInputPassword(user.getPassword()).
                      setInputConfirmPassword(user.getPassword()).
                      setInputEmail(user.getEmail()); 
                
                
                administrationPage = createNewUserPage.successCreateNewUser();
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
 
        administrationPage = createNewUserPage.successCreateNewUser(user);
        newNumberOfUsers = Integer.valueOf(administrationPage.getFoundUsersNumber());
        newPagesCount = Integer.valueOf(administrationPage.getPagesQuantity());
        Assert.assertEquals(numberUsers + 1, newNumberOfUsers);
        Assert.assertEquals(pagesCount + 1, newPagesCount);
 
    }

}

