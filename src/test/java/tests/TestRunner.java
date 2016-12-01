package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LogInPage;

import java.util.concurrent.TimeUnit;

public class TestRunner {

    protected WebDriver driver;
    protected LogInPage logInPage;

    @BeforeClass
    public void setUpDriver() {

        final String driverPath = "src/test/resources/drivers/";
        final String logInPageUrl= "http://ssu-oms.training.local:8280/oms5/login.htm ";
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");

        driver = new ChromeDriver();
        driver
                .manage()
                .timeouts()
                .implicitlyWait(30, TimeUnit.SECONDS);
        driver
                .manage()
                .window()
                .maximize();

        driver.get(logInPageUrl);
        logInPage = new LogInPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){ 
        driver.quit();
    }
    
}

