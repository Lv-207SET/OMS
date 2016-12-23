package com.softserve.edu.oms.tests.administration;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.enums.UsersPerPage;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.tests.TestRunner;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

import static com.softserve.edu.oms.enums.LabelsNamesEnum.SHOW_10_ITEMS_LINK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;


    /**
     * @author Anastasiia Maidanska
     * @version 1.0
     * @since 20.12.16
     */

    public class ChangeNumberOfUserPerPageTest extends TestRunner{

        /**
         * Verify that correct number of records displays in a table on 'Administration' tab
         */

        @Test
        @Step
        public void paginationTest() {
            // Get admin user from UserRepository
            IUser admin = UserRepository.get().adminUser();

            // Login and go to administration page
            AdministrationPage administrationPage = loginPage
                    .successAdminLogin(admin)
                    .gotoAdministrationPage();


             // Verification that 5 records are displayed in a table
            assertThat(administrationPage.getQuantityOfUsersPerPage() ,
                    CoreMatchers.equalTo(UsersPerPage.FIVE.getResultsPerPage()));

            // Verification that 'Show 10 items' link is displayed
            assertTrue(administrationPage.showItemsLinkIsDisplayed());

            // Verification that 'Show 10 items' link has correct name
            assertThat(administrationPage.getShowItemsLinkText(),
                    CoreMatchers.equalTo(SHOW_10_ITEMS_LINK.name));

            // Count number of pages
            double pagesNumber = administrationPage.getFoundUsersNumber() / (UsersPerPage.FIVE.getResultsPerPage() * 1.0);

            // Verification that correct number of pages displayed
            assertThat(administrationPage.getPagesQuantity(), CoreMatchers.equalTo((int)Math.ceil(pagesNumber)));

            administrationPage.changeQuantityOfUsersPerPage();

            // Verification that 10 records are displayed in a table
            assertThat(administrationPage.getQuantityOfUsersPerPage() ,
                    CoreMatchers.equalTo(UsersPerPage.TEN.getResultsPerPage()));

            // Count number of pages
            pagesNumber = administrationPage.getFoundUsersNumber() / (UsersPerPage.TEN.getResultsPerPage() * 1.0);

            // Verification that correct number of pages displayed
            assertThat(administrationPage.getPagesQuantity(), CoreMatchers.equalTo((int)Math.ceil(pagesNumber)));

        }
    }

