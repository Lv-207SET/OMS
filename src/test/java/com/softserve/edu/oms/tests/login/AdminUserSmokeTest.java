package com.softserve.edu.oms.tests.login;

import static org.testng.AssertJUnit.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.CreateNewUserPage;
import com.softserve.edu.oms.tests.TestRunner;

/**
 * The Class AdminUserSmokeTest.
 * 
 * @author Bohdan Harasym
 * @since 22.12.2016
 */
public class AdminUserSmokeTest extends TestRunner {

	/**
	 * Gets the admin user DataProvider for adminUserSmokeTest
	 *
	 * @return the admin user
	 */
	@DataProvider
	public Object[][] getAdminUser() {
		return new Object[][] { { UserRepository.get().adminUser() } };
	}

	/**
	 * Admin user smoke test.
	 *
	 * @param admUser
	 *            the adm user
	 */
	@Test(dataProvider="getAdminUser")
	public void adminUserSmokeTest(IUser adminUser) {
		CreateNewUserPage createNewUserPage = loginPage.successAdminLogin(adminUser).clickAdministrationTab()
				.gotoCreateNewUserPage();
		assertTrue(createNewUserPage.getCreateButton().isEnabled());

	}

}
