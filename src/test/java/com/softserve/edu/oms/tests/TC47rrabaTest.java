package com.softserve.edu.oms.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import com.softserve.edu.oms.database.UserEntity;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.oms.data.DBUtils;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.enums.ConditionFilterDropdownList;
import com.softserve.edu.oms.enums.FieldFilterDropdownList;
import com.softserve.edu.oms.pages.AdminHomePage;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.pages.LoginPage;

public class TC47rrabaTest {

    WebDriver driver;

    @DataProvider // (parallel = true)
    public Object[][] validUsers() {
        return new Object[][] { { UserRepository.get().adminUser() },
                // { UserRepository.get().customerUser() }
        };
        // return ListUtils.get()
        // .toMultiArray(UserRepository.get().getUsersFromCsvFile());
        // return ListUtils.get()
        // .toMultiArray(UserRepository.get().getUsersFromDB());
        // return ListUtils.get()
        // .toMultiArray(UserRepository.get().getUsersFromExcelFile());
    }


    @Test(dataProvider = "validUsers")
    public void test2(IUser admin){
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getResource("/drivers/chromedriver.exe").getPath().substring(1));
        driver = new ChromeDriver();
//         WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/OMS/");

        LoginPage omsLoginPage = new LoginPage(driver);
        AdminHomePage omsAdminHomePage = omsLoginPage.successAdminLogin(admin);
        AdministrationPage omsAdministrationPage = omsAdminHomePage.gotoAdministrationPage();


        omsAdministrationPage
                .selectFieldFilterDropdownList(FieldFilterDropdownList.LAST_NAME)
                .selectConditionFilterDropdownList(ConditionFilterDropdownList.START_WITH)
                .inputIntoSearchField("none")
                .clickSearchButton();

        List<String> listLastNameFromTable = new ArrayList<>();
        for(UserEntity userEntity:omsAdministrationPage.getAllUsers()){
            listLastNameFromTable.add(userEntity.getLastName());
            System.out.println(userEntity.getLastName());

        }

        System.out.println("++++++++++++++++++++++");
        List<String> listLastNameFromDB = new ArrayList<>();
        DBUtils dbUtils = new DBUtils();
        listLastNameFromDB = dbUtils.getOneColumn("lastName");

        Assert.assertTrue(listLastNameFromTable.equals(listLastNameFromDB));

        driver.quit();

    }
     @Test(dataProvider = "validUsers")
    public void test3(IUser admin){
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getResource("/drivers/chromedriver.exe").getPath().substring(1));
        driver = new ChromeDriver();
//         WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/OMS/");

        LoginPage omsLoginPage = new LoginPage(driver);
        AdminHomePage omsAdminHomePage = omsLoginPage.successAdminLogin(admin);
        AdministrationPage omsAdministrationPage = omsAdminHomePage.gotoAdministrationPage();


        omsAdministrationPage
                .selectFieldFilterDropdownList(FieldFilterDropdownList.LOGIN)
                .selectConditionFilterDropdownList(ConditionFilterDropdownList.CONTAINS)
                .inputIntoSearchField("none")
                .clickSearchButton();

        List<String> listLastNameFromTable = new ArrayList<>();
        for(UserEntity userEntity:omsAdministrationPage.getAllUsers()){
            listLastNameFromTable.add(userEntity.getLogin());
            System.out.println(userEntity.getLogin());

        }

        System.out.println("++++++++++++++++++++++");
         List<String> listLastNameFromDB = new ArrayList<>();
        DBUtils dbUtils = new DBUtils();
         listLastNameFromDB = dbUtils.getOneColumn("login");

        ;

        // Assert.assertTrue(listLastNmeFromTable.retainAll(dbUtils.getOneColumn()));
        Assert.assertTrue(listLastNameFromTable.equals(listLastNameFromDB));


        driver.quit();



    }


    @Test(dataProvider = "validUsers")
    public void test4(IUser admin){
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getResource("/drivers/chromedriver.exe").getPath().substring(1));
        driver = new ChromeDriver();
//         WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/OMS/");

        LoginPage omsLoginPage = new LoginPage(driver);
        AdminHomePage omsAdminHomePage = omsLoginPage.successAdminLogin(admin);
        AdministrationPage omsAdministrationPage = omsAdminHomePage.gotoAdministrationPage();


        omsAdministrationPage
                .selectFieldFilterDropdownList(FieldFilterDropdownList.ROLE)
                .selectConditionFilterDropdownList(ConditionFilterDropdownList.DOES_NOT_CONTAIN)
                .inputIntoSearchField("er")
                .clickSearchButton();

        List<String> listLastNameFromTable = new ArrayList<>();
        for(UserEntity userEntity:omsAdministrationPage.getAllUsers()){
            listLastNameFromTable.add(userEntity.getRole().getRoleType());
            System.out.println(userEntity.getRole().getRoleType());

        }

        System.out.println("++++++++++++++++++++++");
        DBUtils dbUtils = new DBUtils();
        List<String> listLastNameFromDB = new ArrayList<>();
        listLastNameFromDB = dbUtils.getOneColumn("role");


        // Assert.assertTrue(listLastNmeFromTable.retainAll(dbUtils.getOneColumn()));
        Assert.assertTrue(listLastNameFromTable.equals(listLastNameFromDB));


        driver.quit();



    }



}
