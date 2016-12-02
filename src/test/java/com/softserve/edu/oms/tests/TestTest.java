package com.softserve.edu.oms.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdminHomePage;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.pages.CreateNewUserPage;
import com.softserve.edu.oms.pages.LoginPage;

public class TestTest {

    @DataProvider//(parallel = true)
    public Object[][] validUsers() {
        return new Object[][] {
                { UserRepository.get().adminUser() },
                //   { UserRepository.get().customerUser() }
        };
//      return ListUtils.get()
//              .toMultiArray(UserRepository.get().getUsersFromCsvFile());
//      return ListUtils.get()
//              .toMultiArray(UserRepository.get().getUsersFromDB());
//        return ListUtils.get()
//                .toMultiArray(UserRepository.get().getUsersFromExcelFile());
    }

    @Test(dataProvider = "validUsers")
    public void test1(IUser admin) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getResource("/drivers/chromedriver.exe").getPath().substring(1));
        WebDriver driver = new ChromeDriver();
//        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/OMS/");
        Thread.sleep(2000);

        LoginPage omsLoginPage = new LoginPage(driver);
        // HomePage omsHomePage = omsLoginPage.successUserLogin(user);
        Thread.sleep(2000);
        AdminHomePage omsAdminHomePage = omsLoginPage.successAdminLogin(admin);
        AdministrationPage omsAdministrationPage = omsAdminHomePage.gotoAdministrationPage();
        int numberUsers = Integer.valueOf(omsAdministrationPage.getFoundUsersNumber());
        int y = numberUsers % 5;

        // System.out.println("++++number of users "+y);
        //omsAdministrationPage.clickOnForwardButton();

        Thread.sleep(3000);
        // omsAdministrationPage.goToCreateNewUserPage();

        for(int i=0; i<(5-y); i++){
            CreateNewUserPage createNewUserPage = omsAdministrationPage.goToCreateNewUserPage();
            String login ="roman";
            createNewUserPage.setLogin(login + login.charAt(i)).
                    setFirstName("rrd")
                    .setLastName("rrd")
                    .setPassword("1234")
                    .setConfirmPassword("1234")
                    .setEmail("rrws@gmail.com");
            //driver.switchTo().alert().accept();
            Thread.sleep(3000);
            omsAdministrationPage= createNewUserPage.createNewUser( );
        }




    }



}
