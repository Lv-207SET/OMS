package com.softserve.edu.oms.tests;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepository;
import org.testng.annotations.Test;


public class AtokTest extends TestRunner {


    @Test
    public void atoktest1() {
        IUser user = UserRepository.get().adminUser();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logInPage.successAdminLogin(user);

       // System.out.println(logInPage.getLoginnameInputText());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


      // List<IUser> list = UserRepository.get().getUsersFromDB();


    }


}
