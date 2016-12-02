package com.softserve.edu.oms.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.ListUtils;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.OmsAdminHomePage;
import com.softserve.edu.oms.pages.OmsAdministrationPage;
import com.softserve.edu.oms.pages.OmsHomePage;
import com.softserve.edu.oms.pages.OmsLoginPage;

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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/OMS/");
        Thread.sleep(2000);
        
        OmsLoginPage omsLoginPage = new OmsLoginPage(driver);
       // OmsHomePage omsHomePage = omsLoginPage.successUserLogin(user);
        Thread.sleep(2000);
        OmsAdminHomePage omsAdminHomePage = omsLoginPage.successAdminLogin(admin);
        OmsAdministrationPage omsAdministrationPage = omsAdminHomePage.gotoAdministrationPage();
        
        
        
        
    }
       
   

}
