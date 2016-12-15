package com.softserve.edu.oms.tests.vbybetc;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdminHomePage;
import com.softserve.edu.oms.tests.TestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * <h1>Switching tabs on UserInfo page for Admin user</h1>
 */
public class TC41vbTest extends TestRunner {

    @DataProvider
    public Object[][] admUser() {
        return new Object[][] {
                { UserRepository.get().adminUser() }
        };
    }

    /**
     * This test validates that Admin has an ability to switch between
     * tabs on UserInfo page
     *
     * @author Viktoriia Bybel
     * @version 1.0
     * @since 15.12.16
     * @param admUser
     */

    @Test(dataProvider = "admUser")
    public void TabSwitchingTest(IUser admUser) {

        AdminHomePage adminHomePage = loginPage.successAdminLogin(admUser);
        Assert.assertTrue(adminHomePage.getUserInfoTab().isEnabled());
        Assert.assertTrue(adminHomePage.getAdministrationTab().isDisplayed());

        adminHomePage.clickAdministrationTab();
        Assert.assertTrue((driver.getCurrentUrl()).contains("users.htm"));

        adminHomePage.clickUserInfoTab();
        Assert.assertTrue((driver.getCurrentUrl()).contains("userInfo.htm"));
    }
}
