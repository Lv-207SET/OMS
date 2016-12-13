package com.softserve.edu.oms.tests.amaidanska;


import com.softserve.edu.oms.data.DBUtils;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.User;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.pages.CreateNewUserPage;
import com.softserve.edu.oms.tests.TestRunner;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class CreateInvalidNewUserTest extends TestRunner {
    private static final String FIRST_NAME_ERROR_MESSAGE
            = "First name cannot contain digits";
    private static final String lLAST_NAME_ERROR_MESSAGE = "Last name cannot contain digits";

    @DataProvider
	public Object[][] invalidUsers() {
		return new Object[][] {
				{ UserRepository.get().invalidUser() }
			};
	}

    @Test(dataProvider = "invalidUsers")
    public void createInvalidNewUserTest (User user){
        IUser admin = UserRepository.get().adminUser();
        AdministrationPage administrationPage = loginPage
                .successAdminLogin(admin)
                .gotoAdministrationPage();
        CreateNewUserPage createNewUserPage =
                administrationPage.goToCreateNewUserPage();
        createNewUserPage.setLoginData(user);
        driver.switchTo().alert().accept();

        assertThat(createNewUserPage.getFirstNameErrorMessageText(), CoreMatchers.equalTo(FIRST_NAME_ERROR_MESSAGE));
        assertThat(createNewUserPage.getLastNameErrorMessageText(), CoreMatchers.equalTo(lLAST_NAME_ERROR_MESSAGE));
        DBUtils dbUtils = new DBUtils();
        assertThat(dbUtils.getUserByLogin(user.getLoginname()), CoreMatchers.equalTo(null));
    }

}
