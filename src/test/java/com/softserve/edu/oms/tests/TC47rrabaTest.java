package com.softserve.edu.oms.tests;

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

        for(UserEntity userEntity:omsAdministrationPage.getAllUsers()){
            System.out.println(userEntity.getLastName());

        }

        System.out.println("++++++++++++++++++++++");
        DBUtils dbUtils = new DBUtils();
        dbUtils.getOneColumn();

        Assert.assertTrue(omsAdministrationPage.getAllUsers().retainAll(dbUtils.getOneColumn()));


    }

}