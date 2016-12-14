//package com.softserve.edu.oms.tests;
//
//
//import com.softserve.edu.oms.data.DBUtils;
//import com.softserve.edu.oms.data.IUser;
//import com.softserve.edu.oms.data.SQLQueries;
//import com.softserve.edu.oms.data.UserRepository;
//import org.testng.Assert;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//public class TC50atokTest extends TestRunner {
//
//    @DataProvider
//    public Object[][] Users() {
//        return new Object[][] {
//                { UserRepository.get().adminUser(), UserRepository.get().newUser()  }
//        };
//    }
//
//
//
//    @DataProvider
//    public Object[][] newUser() {
//        return new Object[][] {
//                { UserRepository.get().newUser() }
//        };
//    }
//
//
//
//    @Test(dataProvider = "newUser")
//    public void assertNonExistence(IUser newUser){
//        String login = "'" + newUser.getLoginname() + "'";
//        DBUtils dbUtility = new DBUtils();
//        List<String> loginsFromDB =  dbUtility.getLogins(SQLQueries.SELECT_FROM_USERS_WHERE_LOGIN_EQUALS.getQuery() + login);
//        Assert.assertTrue(loginsFromDB.size() == 0);
//    }
//
//    @Test(dataProvider = "Users")
//    public void createAndDeleteNewUser(IUser admUser, IUser newUser){
//        logInPage.logout()
//                .successAdminLogin(admUser)
//                .gotoAdministrationPage()
//                .goToCreateNewUserPage()
//                .waitForLoad()
//                .setLogin(newUser.getLoginname())
//                .setPassword(newUser.getPassword())
//                .setConfirmPassword(newUser.getPassword())
//                .setFirstName(newUser.getFirstname())
//                .setLastName(newUser.getLastname())
//                .setEmail(newUser.getEmail())
//                .selectRegion(newUser.getRegion())
//                .selectRole(newUser.getRole())
//                .createUser()
//                .goToCreateReportPage()
//                .waitForLoad()
//                .filterAndSearch("Login Name", "equals", newUser.getLoginname());
//
//        // for demo purposes only
//            try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        String login = "'" + newUser.getLoginname() + "'";
//        DBUtils dbUtility = new DBUtils();
//        List<String> loginsFromDB =  dbUtility.getLogins(SQLQueries.SELECT_FROM_USERS_WHERE_LOGIN_EQUALS.getQuery() + login);
//        System.out.println("NewUser login is: "+ loginsFromDB.get(0));
//
//        int size = loginsFromDB.size();
//        String newLogin = loginsFromDB.get(0);
//
//        dbUtility.deleteUsersFromDB(SQLQueries.DELETE_FROM_USERS_WHERE_LOGIN_EQUALS.getQuery()+login);
//
//        Assert.assertTrue ((size == 1) && newLogin.equals(newUser.getLoginname()));
//
//    }
//
//}
