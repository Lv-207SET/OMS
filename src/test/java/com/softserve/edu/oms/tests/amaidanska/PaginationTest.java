package com.softserve.edu.oms.tests.amaidanska;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.enums.UsersPerPage;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.tests.TestRunner;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class PaginationTest extends TestRunner{

    private static final String SHOW_ITEMS_LINK_NAME = "Show 10 items";
    @Test
    public void paginationTest() {
        IUser admin = UserRepository.get().adminUser();
        AdministrationPage administrationPage = loginPage
                .successAdminLogin(admin)
                .gotoAdministrationPage();

        assertThat(administrationPage.getQuantityOfUsersPerPage() ,
                CoreMatchers.equalTo(UsersPerPage.FIVE.getResultsPerPage()));
        assertTrue(administrationPage.showItemsLinkIsDisplayed());
        assertThat(administrationPage.getShowItemsLinkText(),
                CoreMatchers.equalTo(SHOW_ITEMS_LINK_NAME));

        double pagesNumber = administrationPage.getFoundUsersNumber() / (UsersPerPage.FIVE.getResultsPerPage() * 1.0);
        assertThat(administrationPage.getPagesQuantity(), CoreMatchers.equalTo((int)Math.ceil(pagesNumber)));

        administrationPage.changeQuantityOfUsersPerPage();

        assertThat(administrationPage.getQuantityOfUsersPerPage() ,
                CoreMatchers.equalTo(UsersPerPage.TEN.getResultsPerPage()));

        pagesNumber = administrationPage.getFoundUsersNumber() / (UsersPerPage.TEN.getResultsPerPage() * 1.0);
        assertThat(administrationPage.getPagesQuantity(), CoreMatchers.equalTo((int)Math.ceil(pagesNumber)));

    }
}
