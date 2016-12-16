package com.softserve.edu.oms.expages;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import com.softserve.edu.oms.data.IUser;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.softserve.edu.oms.data.DBUtils;
import com.softserve.edu.oms.data.User;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.enums.ConditionFilterDropdownList;
import com.softserve.edu.oms.enums.FieldFilterDropdownList;
import com.softserve.edu.oms.enums.LabelsNamesEnum;
import com.softserve.edu.oms.enums.SQLQueries;
import com.softserve.edu.oms.pages.AdminHomePage;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.tests.TestRunner;
import org.testng.asserts.SoftAssert;

/**
 * Test class which verifies search function on Administration page.  
 * @version  1.0
 * @since 16.12.16
 * @author  Oleh Lavrynenko, Roman Raba 
 * 
 */
public class FindingTest extends TestRunner{
    private SoftAssert softAssert = new SoftAssert();
    private AdministrationPage administrationPage;
    private final String TOO_LONG_NAME="zxcvbnm asdfghjk qwertyuio pxmfjfn jvnvkh";
    private final String VALID_NAME=UserRepository.get().adminUser().getLoginname();

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
    public void testOptionValues() {
        softAssert=new SoftAssert();
        softAssert.assertEquals(administrationPage.getSelectFieldDefaultValue(), FieldFilterDropdownList.FIRST_NAME.getFieldName());
        softAssert.assertEquals(administrationPage.getSelectFieldOptions(), new HashSet<>(Arrays.asList(FieldFilterDropdownList.values()))
                .stream()
                .map(p -> p.getFieldName().toLowerCase()).collect(Collectors.toSet()));
        softAssert.assertEquals(administrationPage.getSelectConditionDefaultValue(), ConditionFilterDropdownList.EQUALS.getNameOfConditionFilterField());
        softAssert.assertEquals(administrationPage.getSelectConditionOptions(),
                new HashSet<>(Arrays.asList(ConditionFilterDropdownList.values()))
                        .stream()
                        .map(condition-> condition.getNameOfConditionFilterField()).collect(Collectors.toSet()));
        softAssert.assertAll();
    }
    //@Test(dataProvider = "validUsers")
    public void verifySearchTooLongName(IUser admin) {
        softAssert=new SoftAssert();
        administrationPage.clickSearchButton();
        administrationPage.filterAndSearch(FieldFilterDropdownList.FIRST_NAME, ConditionFilterDropdownList.EQUALS, TOO_LONG_NAME);

        DBUtils dbUtils = new DBUtils();
        int numberOfUsers = dbUtils.getAllCells("","").size();

        softAssert.assertEquals(administrationPage.getAllUsers().size(),numberOfUsers );
        softAssert.assertAll();

    }

    @Test
    public void verifySearchByEquals() {
        softAssert=new SoftAssert();

        administrationPage.clickSearchButton();
        administrationPage.filterAndSearch(FieldFilterDropdownList.LOGIN, ConditionFilterDropdownList.EQUALS, VALID_NAME);

        DBUtils dbUtils = new DBUtils();
        int numberOfUsers = dbUtils.getUserByLogin(VALID_NAME) == null ? 0 : 1;
        softAssert.assertEquals(administrationPage.getAllUsers().size(),numberOfUsers );
        softAssert.assertAll();
    }

    @Test
    public void verifySearchByNotEquals() {
        softAssert=new SoftAssert();

        administrationPage.clickSearchButton();
        administrationPage.selectField(FieldFilterDropdownList.LOGIN);
        administrationPage.selectConditionByIndex(1);
        administrationPage.search(VALID_NAME);

        DBUtils dbUtils = new DBUtils();

        int numberOfUsersWithLogin = dbUtils.getUserByLogin(VALID_NAME) == null ? 0 : 1;
        int numberOfUsers = dbUtils.countAllUsers() - numberOfUsersWithLogin;
        softAssert.assertEquals(new AdministrationPage(driver).getAllUsers().size(),numberOfUsers);
        softAssert.assertAll();
    }
   
    
    /**
     * Verify that search by "Last Name" and "starts with" work correctly.
     *
     * @author Roman Raba
     * @version 1.0
     * @since 16.12.16
     */
    @Test 
    public void verifySearchLastName(){
        List<String> columnListFromTable = new ArrayList<>();
        List<String> columnListFromDB;       
        DBUtils dbUtils;
        
        administrationPage.filterAndSearch(
                FieldFilterDropdownList.LAST_NAME, 
                ConditionFilterDropdownList.START_WITH, 
                LabelsNamesEnum.SEARCH_TEXT_NONE.name);
        
        for(User user:administrationPage.getAllUsers()){
            columnListFromTable.add(user.getLastname());
           }
 
        dbUtils = new DBUtils();
        columnListFromDB = dbUtils.getOneColumn(SQLQueries.GET_LASTNAME_LIKE.getQuery(),
                LabelsNamesEnum.BY_LAST_NAME.name, 
                LabelsNamesEnum.SEARCH_TEXT_NONE.name, 
                LabelsNamesEnum.SEARCH_TEXT_ER.name);

        Assert.assertTrue(columnListFromTable.equals(columnListFromDB));   
     }
    
   
    /**
     * Verify that search by "Login Name" and "contains" work correctly.
     *
     * @author Roman Raba
     * @version 1.0
     * @since 16.12.16
     */
    @Test 
    public void verifySearchLoginName(){
        List<String> columnListFromTable = new ArrayList<>();
        List<String> columnListFromDB;       
        DBUtils dbUtils;
        
        administrationPage.filterAndSearch(
                FieldFilterDropdownList.LOGIN, 
                ConditionFilterDropdownList.CONTAINS, 
                LabelsNamesEnum.SEARCH_TEXT_NONE.name);

        for(User user:administrationPage.getAllUsers()){
            columnListFromTable.add(user.getLoginname());
        }

        dbUtils = new DBUtils();
        columnListFromDB = dbUtils.getOneColumn(SQLQueries.GET_LOGIN_LIKE.getQuery(),
                LabelsNamesEnum.BY_LOGIN_NAME.name, 
                LabelsNamesEnum.SEARCH_TEXT_NONE.name, 
                LabelsNamesEnum.SEARCH_TEXT_ER.name);

        Assert.assertTrue(columnListFromTable.equals(columnListFromDB));
    }


    /**
     * Verify that search by "Role" and "does not contain" work correctly.
     *
     * @author Roman Raba
     * @version 1.0
     * @since 16.12.16
     */
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
                LabelsNamesEnum.SEARCH_TEXT_ER.name);

        columnListFromTable = new ArrayList<>();
        for(User user:administrationPage.getAllUsers()){
            columnListFromTable.add(user.getRole());
        }

        dbUtils = new DBUtils();
        columnListFromDB = dbUtils.getOneColumn(SQLQueries.GET_ROLE_NOT_LIKE.getQuery(),
                LabelsNamesEnum.BY_ROLE.name, 
                LabelsNamesEnum.SEARCH_TEXT_NONE.name, 
                LabelsNamesEnum.SEARCH_TEXT_ER.name);

        Assert.assertTrue(columnListFromTable.equals(columnListFromDB));
 
        numberOfusers =  administrationPage.getFoundUsersNumber();
        Assert.assertEquals(columnListFromDB.size(),numberOfusers);
        
        numberOfItems = administrationPage.getUsersPerPageNumber();
        
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

