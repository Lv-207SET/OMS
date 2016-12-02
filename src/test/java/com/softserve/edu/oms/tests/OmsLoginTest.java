package com.softserve.edu.oms.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.ListUtils;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.OmsAdministrationPage;
import com.softserve.edu.oms.pages.OmsHomePage;
import com.softserve.edu.oms.pages.OmsLoginPage;

public class OmsLoginTest {
	
	@DataProvider//(parallel = true)
	public Object[][] validUsers() {
//		return new Object[][] {
//				{ UserRepository.get().adminUser() },
//				{ UserRepository.get().customerUser() }
//			};
//		return ListUtils.get()
//				.toMultiArray(UserRepository.get().getUsersFromCsvFile());
//		return ListUtils.get()
//				.toMultiArray(UserRepository.get().getUsersFromDB());
		return ListUtils.get()
				.toMultiArray(UserRepository.get().getUsersFromExcelFile());
	}

	@Test(dataProvider = "validUsers")
	public void checkValidLogin(IUser user) throws Exception {
		// Precondition
		//System.out.println("+++ PATH = " + this.getClass().getResource("/drivers/chromedriver.exe").getPath().substring(1));
		System.setProperty("webdriver.chrome.driver",
				this.getClass().getResource("/drivers/chromedriver.exe").getPath().substring(1));
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/OMS/");
		Thread.sleep(2000);
		//
		// Test steps.
		OmsLoginPage omsLoginPage = new OmsLoginPage(driver);
		OmsHomePage omsHomePage = omsLoginPage.successUserLogin(user);
		Thread.sleep(2000);
		//
		// Check
		Assert.assertEquals(omsHomePage.getFirstnameText(),
				user.getFirstname());
		Assert.assertEquals(omsHomePage.getLastnameText(),
				user.getLastname());
		Assert.assertEquals(omsHomePage.getRoleText(),
				user.getRole());
		//
		// Return to previous state
		omsLoginPage = omsHomePage.gotoLoginPage();
		Assert.assertTrue(omsLoginPage.getRememberMeCheckboxNameAttribute()
				.contains(OmsLoginPage.NAME_REMEMBER_ME));
		//
		Thread.sleep(2000);
		driver.quit();
	}

	@DataProvider//(parallel = true)
	public Object[][] adminUsers() {
		return new Object[][] {
				{ UserRepository.get().adminUser() }
			};
	}

	//@Test(dataProvider = "adminUsers")
	public void checkAdminLogin(IUser admin) throws Exception {
		// Precondition
		//System.out.println("+++ PATH = " + this.getClass().getResource("/drivers/chromedriver.exe").getPath().substring(1));
		System.setProperty("webdriver.chrome.driver",
				this.getClass().getResource("/drivers/chromedriver.exe").getPath().substring(1));
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/OMS/");
		Thread.sleep(2000);
		//
		// Test steps.
		OmsAdministrationPage omsAdministrationPage = new OmsLoginPage(driver)
				.successAdminLogin(admin)
				.gotoAdministrationPage();
		//
		// Check
		System.out.println("\nUsers from DB\n"
				+ UserRepository.get().getUsersFromDB());
		//
		// Return to previous state
		//
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void checkAdmin() {
		System.out.println("checkAdmin() DONE");
		Assert.assertEquals(3, 1 + 2);
	}

}
