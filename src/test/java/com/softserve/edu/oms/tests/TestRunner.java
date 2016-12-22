package com.softserve.edu.oms.tests;

import com.softserve.edu.oms.pages.LoginPage;
import org.apache.commons.lang.SystemUtils;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestRunner {

    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void oneTimeSetUp() {

        System.out.println("before");

        //Determine which OS: Linux or Windows and locating chromedriver accordingly
        if(SystemUtils.IS_OS_WINDOWS) {
            final String driverPath = "src/test/resources/drivers/";
            System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        }
        else if(SystemUtils.IS_OS_LINUX) {
            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        }
        else {
            throw new InvalidOperationException("Your OS is not supported");
        }

        final String loginPageUrl= System.getenv("oms_loginPageUrl");


        driver = new ChromeDriver();
        driver
                .manage()
                .timeouts()
                .implicitlyWait(30, TimeUnit.SECONDS);
        driver
                .manage()
                .window()
                .maximize();


        driver.get(loginPageUrl);
        loginPage = new LoginPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void oneTimeTearDown(){ 
        driver.quit();
    }
    
}

