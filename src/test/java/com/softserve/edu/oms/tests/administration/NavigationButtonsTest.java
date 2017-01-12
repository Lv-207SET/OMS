package com.softserve.edu.oms.tests.administration;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdminHomePage;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.tests.TestRunner;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.model.SeverityLevel;

/**
 * This test verifies that Administrator can navigate
 * through table with users on 'Administrator' tab
 * by navigation buttons
 *
 * Based on LVSETOMS-44 in Jira
 *
 * @author Iryna Kyselchuk
 * @since 16.12.16
 */
@Features("Administration")
@Stories("LVSETOMS-4 As Admin I want to see all existing users and perform "
		+ "user searching on the 'Administration' tab so I can manage them ")

public class NavigationButtonsTest extends TestRunner {

    private AdministrationPage administrationPage;

    /**
     * Set preconditions for test:
     * login with Administrator role credentials
     * and go to Administration page
     */
    @BeforeMethod
    @Step("Login as Admin and go to Administration page")
    public void loginAndGotoAdministrationPage() {
        IUser admin = UserRepository.get().adminUser();
        AdminHomePage adminHomePage = loginPage.successAdminLogin(admin);
        administrationPage = adminHomePage.gotoAdministrationPage();
    }

    /**
     * This method verifies that Administrator can navigate the User table
     * by 'First', 'Last', 'Forward' and 'Backward' buttons
     * and current page in the pagination label changes according to navigation
     * where count of pages is number of records divided by
     * number of records per page and
     * rounded to the bigger integer
     */
    @TestCaseId("LVSETOMS-44")
	@Severity(SeverityLevel.NORMAL)
	@Description("This test case verifies that Administrator can navigate the User table on "
			+ "the 'Administration' tab by 'First', 'Last', 'Forward' and 'Backward' buttons")
    @Test
    @Step("Verify navigation buttons functionality")
    public void verifyNavigationButtons() {

        // determine the count of pages depending on count os users per page
        int numberUsersOnPage = administrationPage.getQuantityOfUsersPerPage();
        int numberOfFoundUsers = administrationPage.getFoundUsersNumber();
        int expectedPageCount = numberOfFoundUsers / numberUsersOnPage;

        // round count of pages to the bigger integer
        if ((numberOfFoundUsers % numberUsersOnPage) != 0) {
            expectedPageCount += 1;
        }

        // verify that 'First' and 'Backward' buttons are disabled
        innerStep("Verify that 'Password' 'First' and 'Backward' buttons are disabled");
        Assert.assertFalse(administrationPage.isFirstButtonEnabled()
                && administrationPage.isBackwardButtonEnabled());
        // verify that 'Forward' and 'Last' buttons are enabled
        innerStep("Verify that 'Forward' and 'Last' buttons are enabled");
        Assert.assertTrue(administrationPage.isForwardButtonEnabled()
                && administrationPage.isLastButtonEnabled());
        // verify that current page is: 1# of x#
        innerStep("Verify that current page is: 1# of x#");
        Assert.assertTrue((administrationPage.getPagesQuantity() == expectedPageCount)
                && (administrationPage.getCurrentPageNumber() == 1));

        administrationPage.clickForwardButton();

        // verify that after clicking 'Forward' button:
        // 'First', 'Backward', 'Forward' and 'Last' buttons are enabled
        innerStep("Verify that after clicking 'Forward' button all navigation buttons are enabled");
        Assert.assertTrue(administrationPage.isFirstButtonEnabled()
                && administrationPage.isBackwardButtonEnabled()
                && administrationPage.isForwardButtonEnabled()
                && administrationPage.isLastButtonEnabled());
        // verify that current page is: 2# of x#
        innerStep("Verify that current page is: 2# of x#");
        Assert.assertTrue(administrationPage.getCurrentPageNumber() == 2);

        administrationPage.clickLastButton();

        // verify that after clicking 'Last' button 'First' and 'Backward' buttons are enabled
        innerStep("Verify that after clicking 'Last' button 'First' and 'Backward' buttons are enabled");
        Assert.assertTrue(administrationPage.isFirstButtonEnabled()
                && administrationPage.isBackwardButtonEnabled());
        // verify that after clicking 'Last' button 'Forward' and 'Last' buttons are disabled
        innerStep("Verify that after clicking 'Last' button 'Forward' and 'Last' buttons are disabled");
        Assert.assertFalse(administrationPage.isForwardButtonEnabled()
                && administrationPage.isLastButtonEnabled());
        // verify that current page is: x# of x#
        innerStep("Verify that current page is: x# of x#");
        Assert.assertTrue(administrationPage.getCurrentPageNumber() == expectedPageCount);

        administrationPage.clickBackwardButton();

        // verify that after clicking 'Backward' button:
        // 'First', 'Backward', 'Forward' and 'Last' buttons are enabled
        innerStep("Verify that after clicking 'Backward' button all navigation buttons are enabled");
        Assert.assertTrue(administrationPage.isFirstButtonEnabled()
                && administrationPage.isBackwardButtonEnabled()
                && administrationPage.isForwardButtonEnabled()
                && administrationPage.isLastButtonEnabled());
        // verify that current page is: x#-1 of x#
        innerStep("Verify that current page is:  x#-1 of x#");
        Assert.assertTrue(administrationPage.getCurrentPageNumber() == (expectedPageCount-1));
    }

    /**
     * Logout from current page
     */
    @AfterMethod
    @Step("Logout from Administration page")
    public void returnToPreviousState() {
        administrationPage.logout();
    }
}
