//package com.softserve.edu.oms.tests.dvoropatc;
//
//import com.softserve.edu.oms.data.DBUtils;
//import com.softserve.edu.oms.data.IUser;
//import com.softserve.edu.oms.data.User;
//import com.softserve.edu.oms.data.UserRepository;
//import com.softserve.edu.oms.pages.AdminHomePage;
//import com.softserve.edu.oms.pages.CreateNewUserPage;
//import org.testng.Assert;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//    /*
//    * This test case verifies that error messages appear when trying to create
//    * a new user with too long login, first /last name (longer than 13 characters)
//    * and password (longer than 10 characters).
//    * */
//
//public class TestCaseFiftyOneTest extends TestRunner{
//
//    private static final String EXPECTED_ERROR_MESSAGE_FOR_lOGIN = "Login name is too long";
//    private static final String EXPECTED_ERROR_MESSAGE_FOR_FIRST_NAME = "First name is too long";
//    private static final String EXPECTED_ERROR_MESSAGE_FOR_LAST_NAME = "Last name is too long";
//    private static final String EXPECTED_ERROR_MESSAGE_FOR_PASSWORD = "Password cannot be shorter" +
//            " than 4 and longer than 10 characters";
//
//    final private DBUtils dbUtils = new DBUtils();
//    final private User userWithLongCredetnials = UserRepository.get().UserWithLongCredetnials();
//
//    // Provides login and password of registered user
//    // with an "Administrator" role
//    @DataProvider
//    public Object[][] validUserAdministrator() {
//        return new Object[][] {
//                {UserRepository.get().adminUser()}
//        };
//    }
//
//    @Test(dataProvider = "validUserAdministrator",alwaysRun = true)
//    public void verifyCreateNewUserWithToLognData(IUser validUserAdministrator){
//        AdminHomePage omsAdminHomePage = logInPage.successAdminLogin(validUserAdministrator);
//        CreateNewUserPage omsСreateNewUserPage = omsAdminHomePage
//                .gotoAdministrationPage()
//                .goToCreateNewUserPage()
//                .fillFieldsForUserWithLongCredentials()
//                .createUser()
//                .alertAccept();
//
////        Check if correct messages appeared for required fields
//        Assert.assertEquals(omsСreateNewUserPage.getErrorLogin(),
//                EXPECTED_ERROR_MESSAGE_FOR_lOGIN);
//        Assert.assertEquals(omsСreateNewUserPage.getErrorFirstName(),
//                EXPECTED_ERROR_MESSAGE_FOR_FIRST_NAME);
//        Assert.assertEquals(omsСreateNewUserPage.getErrorLastName(),
//                EXPECTED_ERROR_MESSAGE_FOR_LAST_NAME);
//        Assert.assertEquals(omsСreateNewUserPage.getErrorPassword(),
//                EXPECTED_ERROR_MESSAGE_FOR_PASSWORD);
//
////        Check if user with too long credentials was not created in database
//        Assert.assertNull(dbUtils.getUserByLogin(userWithLongCredetnials.getLoginname()));
//    }
//}
