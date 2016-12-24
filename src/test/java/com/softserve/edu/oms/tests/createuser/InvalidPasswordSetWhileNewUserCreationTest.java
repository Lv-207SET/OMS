package com.softserve.edu.oms.tests.createuser;

import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.pages.CreateNewUserPage;
import com.softserve.edu.oms.tests.TestRunner;

public class InvalidPasswordSetWhileNewUserCreationTest extends TestRunner{
	
	public void loginForTest(){
		CreateNewUserPage createNewUserPage = loginPage
				.successAdminLogin(UserRepository
						.get()
						.adminUser()).;
		
		
				
						
	}
	

}
