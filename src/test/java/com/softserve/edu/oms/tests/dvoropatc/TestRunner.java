//package com.softserve.edu.oms.tests.dvoropatc;
//
//import com.softserve.edu.oms.pages.LoginPage;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//import java.util.concurrent.TimeUnit;
//
//public class TestRunner {
//
//    private static final String PATH_TO_CHROME_DRIVER = "src/test/resources/drivers/";
//    private static final String LOGIN_PAGE_URL = "http://localhost:8080/OMS/login.htm";
//    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
//    protected WebDriver driver;
//    protected LoginPage logInPage;
//
//    @BeforeClass
//    public void setUpDriver() {
//
//        System.setProperty(WEBDRIVER_CHROME_DRIVER, PATH_TO_CHROME_DRIVER + "chromedriver.exe");
//
//        driver = new ChromeDriver();
//        driver
//                .manage()
//                .timeouts()
//                .implicitlyWait(30, TimeUnit.SECONDS);
//        driver
//                .manage()
//                .window()
//                .maximize();
//
//        driver.get(LOGIN_PAGE_URL);
//        logInPage = new LoginPage(driver);
//    }
//
//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }
//
//}
//
