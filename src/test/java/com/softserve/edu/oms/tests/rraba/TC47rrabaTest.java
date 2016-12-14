package com.softserve.edu.oms.tests.rraba;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.softserve.edu.oms.data.DBUtils;
import com.softserve.edu.oms.data.User;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.enums.ConditionFilterDropdownList;
import com.softserve.edu.oms.enums.FieldFilterDropdownList;
import com.softserve.edu.oms.pages.AdminHomePage;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.tests.TestRunner;
 

public class TC47rrabaTest extends TestRunner{
    
    private AdministrationPage administrationPage;
    private final static String SEARCH_TEXT_NONE = "none";
    private final static String SEARCH_TEXT_ER = "er";
    private final static String byLastName = "lastName";
    private final static String byLoginName = "login";
    private final static String byRole = "role";
    
    @BeforeMethod 
    public void setUp() {
        AdminHomePage adminHomePage = 
                loginPage.successAdminLogin(UserRepository.get().adminUser());
        administrationPage = 
                adminHomePage.gotoAdministrationPage();
    }
    
    @AfterMethod
    public void tearDown() {
        administrationPage.logout();
    }
     
    @Test 
    public void verifySearchLastName(){
        List<String> columnListFromTable = new ArrayList<>();
        List<String> columnListFromDB;       
        DBUtils dbUtils;
        
        administrationPage.filterAndSearch(
                FieldFilterDropdownList.LAST_NAME, 
                ConditionFilterDropdownList.START_WITH, 
                SEARCH_TEXT_NONE);
        
        for(User user:administrationPage.getAllUsers()){
            columnListFromTable.add(user.getLastname());
           }
 
        dbUtils = new DBUtils();
        columnListFromDB = dbUtils.getOneColumn(byLastName);

        Assert.assertTrue(columnListFromTable.equals(columnListFromDB));   
     }
    
   
    @Test 
    public void verifySearchLoginName(){
        List<String> columnListFromTable = new ArrayList<>();
        List<String> columnListFromDB;       
        DBUtils dbUtils;
        
        administrationPage.filterAndSearch(
                FieldFilterDropdownList.LOGIN, 
                ConditionFilterDropdownList.CONTAINS, 
                SEARCH_TEXT_NONE);

        for(User user:administrationPage.getAllUsers()){
            columnListFromTable.add(user.getLoginname());
        }

        dbUtils = new DBUtils();
        columnListFromDB = dbUtils.getOneColumn(byLoginName);

        Assert.assertTrue(columnListFromTable.equals(columnListFromDB));
    }


   @Test 
    public void verifySearchRole(){
       List<String> columnListFromTable = new ArrayList<>();
       List<String> columnListFromDB;       
       DBUtils dbUtils;
       int numberOfusers;
       int pagesNumber;
       int newPagesCount;
       int numberOfItems;
        
        administrationPage.filterAndSearch(
                FieldFilterDropdownList.ROLE, 
                ConditionFilterDropdownList.DOES_NOT_CONTAIN, 
                SEARCH_TEXT_ER);

        columnListFromTable = new ArrayList<>();
        for(User user:administrationPage.getAllUsers()){
            columnListFromTable.add(user.getRole());
        }

        dbUtils = new DBUtils();
        columnListFromDB = dbUtils.getOneColumn(byRole);

        Assert.assertTrue(columnListFromTable.equals(columnListFromDB));
 
        numberOfusers =  administrationPage.getFoundUsersNumber();
        Assert.assertEquals(columnListFromDB.size(),numberOfusers);
        
        //numberOfItems = administrationPage.getUsersPerPage();
        numberOfItems = 5;
        
        if ((columnListFromDB.size() % numberOfItems) !=0) {
            pagesNumber = ((columnListFromDB.size() - 
                    (columnListFromDB.size() % numberOfItems)) / numberOfItems)+1;
        }
            else{
            pagesNumber = columnListFromDB.size() / numberOfItems;
        }

        newPagesCount = Integer.valueOf(administrationPage.getPagesQuantity());
        Assert.assertEquals(pagesNumber,newPagesCount);
 
    }

}
