package com.test.orangehrm.tests;

import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.AdminPage;
import com.test.orangehrm.pages.LoginPage;
import com.test.orangehrm.pages.MainPage;
import com.test.orangehrm.pages.PIMPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminTest extends TestBase {
    @Test
    public void validationOfCreatingEmployeeMessage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin121");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAdminButton();
        AdminPage adminPage = new AdminPage(driver);
        adminPage.sendingAllInformationForEmployee();
Assert.assertTrue(adminPage.validationOfEmployeeIsAdded("aizhana@527"));




    }


}
