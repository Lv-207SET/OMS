package com.softserve.edu.oms.tests;

import javarestclient.annotations.TransferToJiraImplementation;
import javarestclient.ZephyrRestClient;
import com.softserve.edu.oms.pages.LoginPage;
import org.apache.commons.lang.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

/**
 * This class represents common functionality for all test classes
 */
public class TestRunner {

    protected WebDriver driver;
    protected LoginPage loginPage;


    @BeforeClass
    public void oneTimeSetUp() {


        final String driverPath = "src/test/resources/drivers/";

        //Determine which OS: Linux or Windows and locating chromedriver accordingly
        if (SystemUtils.IS_OS_WINDOWS) {

            System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        } else if (SystemUtils.IS_OS_LINUX) {
            System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver");
        } else {
            throw new RuntimeException("Your OS is not supported");
        }

        final String loginPageUrl = System.getenv("oms_loginPageUrl");


        driver = new ChromeDriver();
        driver
                .manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        driver
                .manage()
                .window()
                .maximize();


        driver.get(loginPageUrl);
        loginPage = new LoginPage(driver);

//      Creating new cycle with desired parameters
        ZephyrRestClient.getInstance().setUpConnectionWithZapi();
        ZephyrRestClient.getInstance().createNewCycle("Java", "First", "4/Dec/17", "10001",
                "10100", "4/Dec/18", "Windows 10");
//      Annotation Initialization
        TransferToJiraImplementation.getAnnotatedMethods();
//    Create test cases
        ZephyrRestClient.createTestCase();
}

    @AfterClass
    public void oneTimeTearDown(){
        driver.get(System.getenv("oms_loginPageUrl"));
        loginPage.logout();
        driver.quit();
    }

}

