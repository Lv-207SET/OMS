package com.softserve.edu.oms.tests.administration;

import static org.testng.AssertJUnit.*;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.oms.data.ReadDataFromFile;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.tests.TestRunner;

import ru.yandex.qatools.allure.annotations.Step;

/**
 * The Class SortingByLoginRoleRegionUsersTabeTest.
 * 
 * @author Bohdan Harasym
 * @since 22.12.2016
 */
public class SortingByRoleRegionUsersTabeTest extends TestRunner {

	/** The administration page. */
	AdministrationPage administrationPage;

	/**
	 * Login for tests.
	 *
	 * @param adminUser
	 *            the admin user
	 */

	@BeforeMethod
	public void loginForTests() {
		administrationPage = loginPage.successAdminLogin(UserRepository.get().adminUser())
				.gotoAdministrationPage();
		administrationPage.showTenRows();
	}

	/**
	 * Tear down.
	 */
	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}

	/**
	 * Sort table by login test.
	 *
	 * @param query            the query
	 */
	@Step("Sorting of Users Table Test")
	@Test(dataProvider = "sortingTableDataProvider")
	public void sortUsersTableTest(String query) {

		String switchCond = null;
		Pattern p = Pattern.compile("\\w+\\W*(ASC|DESC)?\\W?$");
		Matcher m = p.matcher(query);
		
		while (m.find()) {
			switchCond = query.substring(m.start(), m.end())
					          .toUpperCase()
					          .replace(" ", "_");
		}

		System.out.println(switchCond);
		switch (switchCond) {
		
		case "ROLEREF_ASC":
			administrationPage.sortByFirstNameASC();
			break;
		case "ROLEREF_DESC":
			administrationPage.sortByRoleDESC();
			break;
		case "REGIONREF_ASC":
			administrationPage.sortByRegionASC();
			break;
		case "REGIONREF_DESC":
			administrationPage.sortByRegionDESC();
			break;
		default:
			throw new RuntimeException("Invalid query!");
		}
		assertTrue(administrationPage.compareLogins(query));
	}
	
    @Step("Getting data from file")
	@DataProvider(name = "sortingTableDataProvider")
	public static Iterator<Object[]> sortingTableDataProvider() {
		return ReadDataFromFile.readSortUsersTableTest("sortUsersTableTest").iterator();
	}
	
	@AfterMethod
	public void gotostartpage(){
		loginPage = administrationPage.logout();
	}

}
