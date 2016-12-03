package com.softserve.edu.oms.tests;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdminHomePage;
import com.softserve.edu.oms.pages.AdministrationPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC44ikysetcTest extends TestRunner {

    WebDriver driver;

    @DataProvider
    public Object[][] adminUser() {
        return new Object[][] {
                { UserRepository.get().adminUser() }
        };
    }

    @Test(dataProvider = "adminUser")
    public void verifyNavigationButtons(IUser admin) {

        AdminHomePage adminHomePage = logInPage.successAdminLogin(admin);
        AdministrationPage administrationPage = adminHomePage.gotoAdministrationPage();

        int numberUsersOnPage = administrationPage.getUsersFormCurrentPage().size();
        int numberOfFoundUsers = Integer.parseInt(administrationPage.getFoundUsersNumber());
        int expectedPageCount = numberOfFoundUsers / numberUsersOnPage;
        if ((numberOfFoundUsers % numberUsersOnPage) != 0) {
            expectedPageCount += 1;
        }

        Assert.assertFalse(administrationPage.checkIsFirstButtonEnabled()
                && administrationPage.checkIsBackwardButtonEnabled());
        Assert.assertTrue(administrationPage.checkIsForwardButtonEnabled()
                && administrationPage.checkIsLastButtonEnabled());
        Assert.assertTrue((Integer.parseInt(administrationPage.getPagesQuantity()) == expectedPageCount)
                && (Integer.parseInt(administrationPage.getCurrentPageNumber()) == 1));

        administrationPage.clickOnForwardButton();

        Assert.assertTrue(administrationPage.checkIsFirstButtonEnabled()
                && administrationPage.checkIsBackwardButtonEnabled()
                && administrationPage.checkIsForwardButtonEnabled()
                && administrationPage.checkIsLastButtonEnabled());
        Assert.assertTrue(Integer.parseInt(administrationPage.getCurrentPageNumber()) == 2);

        administrationPage.clickOnLastButton();

        Assert.assertTrue(administrationPage.checkIsFirstButtonEnabled()
                && administrationPage.checkIsBackwardButtonEnabled());
        Assert.assertFalse(administrationPage.checkIsForwardButtonEnabled()
                && administrationPage.checkIsLastButtonEnabled());
        Assert.assertTrue(Integer.parseInt(administrationPage.getCurrentPageNumber()) == expectedPageCount);

        administrationPage.clickOnBackwardButton();

        Assert.assertTrue(administrationPage.checkIsFirstButtonEnabled()
                && administrationPage.checkIsBackwardButtonEnabled()
                && administrationPage.checkIsForwardButtonEnabled()
                && administrationPage.checkIsLastButtonEnabled());
        Assert.assertTrue(Integer.parseInt(administrationPage.getCurrentPageNumber()) == (expectedPageCount-1));
    }

}
