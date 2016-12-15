package com.softserve.edu.oms.tests.dvoropatc;

//import com.softserve.edu.oms.data.IUser;
//import com.softserve.edu.oms.data.UserRepository;
//import com.softserve.edu.oms.pages.AdminHomePage;
//import com.softserve.edu.oms.pages.CreateNewUserPage;
//import org.testng.Assert;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//    /*
//    * Test verifies that validation on empty mandatory fields works while
//    * creating new user
//    * */
//
//public class TestCaseFortyNineTest extends TestRunner {
//
//    private static final String EXPECTED_ERROR_MESSAGE_FOR_lOGIN = "Login name cannot be blank";
//    private static final String EXPECTED_ERROR_MESSAGE_FOR_FIRST_NAME = "First name cannot be blank";
//    private static final String EXPECTED_ERROR_MESSAGE_FOR_LAST_NAME = "Last name cannot be blank";
//    private static final String EXPECTED_ERROR_MESSAGE_FOR_PASSWORD = "Password cannot be shorter" +
//            " than 4 and longer than 10 characters";
//    private static final String EXPECTED_ERROR_MESSAGE_FOR_EMAIL_ADRESS = "Incorrect format of " +
//            "Email Address";
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
//    @Test(dataProvider = "validUserAdministrator", alwaysRun = true)
//    public void verifyErrorMessagesDuringUserCreation(IUser validUserAdministrator) {
//        AdminHomePage omsAdminHomePage = logInPage.successAdminLogin(validUserAdministrator);
//        CreateNewUserPage omsСreateNewUserPage = omsAdminHomePage
//                .gotoAdministrationPage()
//                .goToCreateNewUserPage()
//                .createUser()
//                .alertAccept();
//
//    //  Assert that messages appear on page for all mandatory fields
//        Assert.assertNotNull(omsСreateNewUserPage.getErrorLogin());
//        Assert.assertNotNull(omsСreateNewUserPage.getErrorFirstName());
//        Assert.assertNotNull(omsСreateNewUserPage.getErrorLastName());
//        Assert.assertNotNull(omsСreateNewUserPage.getErrorPassword());
//        Assert.assertNotNull(omsСreateNewUserPage.getErrorEmail());
//
//    //  Compare existing messages with expected
//        Assert.assertEquals(omsСreateNewUserPage.getErrorLogin(),
//                EXPECTED_ERROR_MESSAGE_FOR_lOGIN);
//        Assert.assertEquals(omsСreateNewUserPage.getErrorFirstName(),
//                EXPECTED_ERROR_MESSAGE_FOR_FIRST_NAME);
//        Assert.assertEquals(omsСreateNewUserPage.getErrorLastName(),
//                EXPECTED_ERROR_MESSAGE_FOR_LAST_NAME);
//        Assert.assertEquals(omsСreateNewUserPage.getErrorPassword(),
//                EXPECTED_ERROR_MESSAGE_FOR_PASSWORD);
//        Assert.assertEquals(omsСreateNewUserPage.getErrorEmail(),
//                EXPECTED_ERROR_MESSAGE_FOR_EMAIL_ADRESS);
//    }

//}
