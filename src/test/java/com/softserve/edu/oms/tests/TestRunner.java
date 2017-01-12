package com.softserve.edu.oms.tests;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.softserve.edu.oms.pages.LoginPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * This class represents common functionality for all test classes
 */
public class TestRunner {

	protected WebDriver driver;
	protected LoginPage loginPage;

	@BeforeMethod
	public void onStart(ITestContext testContext) {
		testContext.setAttribute("WebDriver", this.driver);
	}

	/**
	 * Logger method for Allure Framework. It method is used for inserting
	 * Allure Steps into different methods
	 * 
	 * @param stepMsg
	 */
	@Step("{0}")
	public void innerStep(String stepMsg) {
	}

	@BeforeClass
	public void oneTimeSetUp() {

		final String driverPath = "src/test/resources/drivers/";
		// Determine which OS: Linux or Windows and locating chromedriver
		// accordingly
		if (SystemUtils.IS_OS_WINDOWS) {
			System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		} else if (SystemUtils.IS_OS_LINUX) {
			System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver");
		} else {
			throw new RuntimeException("Your OS is not supported");
		}

		 final String loginPageUrl= System.getenv("oms_loginPageUrl");
		// final String loginPageUrl = "http://ssu-oms.training.local:8180/OMS/";

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get(loginPageUrl);
		loginPage = new LoginPage(driver);

	}

	@AfterClass
	public void oneTimeTearDown() {
		driver.get(System.getenv("oms_loginPageUrl"));
		loginPage.logout();
		driver.quit();
	}

}
