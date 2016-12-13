package com.softserve.edu.oms.tests.ikyselchuk;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdminHomePage;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.tests.TestRunner;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC44ikTest extends TestRunner{

    private AdminHomePage adminHomePage;
    private AdministrationPage administrationPage;

    @DataProvider
    public Object[][] adminUser() {
        return new Object[][] {
                { UserRepository.get().adminUser() }
        };
    }

    @Test(dataProvider = "adminUser")
    public void verifyNavigationButtons(IUser admin) {

        adminHomePage = loginPage.successAdminLogin(admin);
        administrationPage = adminHomePage.gotoAdministrationPage();

        int numberUsersOnPage = administrationPage
                .getQuantityOfUsersPerPage();
        int numberOfFoundUsers = administrationPage.getFoundUsersNumber();
        int expectedPageCount = numberOfFoundUsers / numberUsersOnPage;
        if ((numberOfFoundUsers % numberUsersOnPage) != 0) {
            expectedPageCount += 1;
        }

        Assert.assertFalse(administrationPage.isFirstButtonEnabled()
                && administrationPage.isBackwardButtonEnabled());
        Assert.assertTrue(administrationPage.isForwardButtonEnabled()
                && administrationPage.isLastButtonEnabled());
        Assert.assertTrue((administrationPage.getPagesQuantity() == expectedPageCount)
                && (administrationPage.getCurrentPageNumber() == 1));

        administrationPage.clickForwardButton();

        Assert.assertTrue(administrationPage.isFirstButtonEnabled()
                && administrationPage.isBackwardButtonEnabled()
                && administrationPage.isForwardButtonEnabled()
                && administrationPage.isLastButtonEnabled());
        Assert.assertTrue(administrationPage.getCurrentPageNumber() == 2);

        administrationPage.clickLastButton();

        Assert.assertTrue(administrationPage.isFirstButtonEnabled()
                && administrationPage.isBackwardButtonEnabled());
        Assert.assertFalse(administrationPage.isForwardButtonEnabled()
                && administrationPage.isLastButtonEnabled());
        Assert.assertTrue(administrationPage.getCurrentPageNumber() == expectedPageCount);

        administrationPage.clickBackwardButton();

        Assert.assertTrue(administrationPage.isFirstButtonEnabled()
                && administrationPage.isBackwardButtonEnabled()
                && administrationPage.isForwardButtonEnabled()
                && administrationPage.isLastButtonEnabled());
        Assert.assertTrue(administrationPage.getCurrentPageNumber() == (expectedPageCount-1));
    }

    @AfterMethod
    public void returnToPreviousState() {
        administrationPage.logout();
    }
}
