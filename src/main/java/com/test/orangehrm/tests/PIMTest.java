package com.test.orangehrm.tests;

import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.LoginPage;
import com.test.orangehrm.pages.MainPage;
import com.test.orangehrm.pages.PIMPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PIMTest extends TestBase {
    LoginPage loginPage;
    MainPage mainPage;
    PIMPage pimPage;

    @BeforeMethod
    public void initializingPages(){
         loginPage = new LoginPage(driver);
         mainPage = new MainPage(driver);
        pimPage = new PIMPage(driver);
    }
    @Test
    public void validationOfAddingEmployeeToPIMPage() throws InterruptedException {

        loginPage.login("Admin","admin123");
        mainPage.clickPIMButton();
        pimPage.addEmployeeInfo("aizhana78","abdull78","422","/Users/aizhanarabdullaeva/Desktop/kgz.png");
      Assert.assertTrue(pimPage.validationOfName("aizhana78"));

      Assert.assertTrue(pimPage.validationOfLastName("abdull78"));

      Assert.assertTrue(pimPage.validationOfID("422"));
       // pimPage.validationOfNationality("Kyrgyz");
Assert.assertTrue(pimPage.validationOfNationality("Kyrgyz"));
    }
    @Test
    public void validatePersonalDetailElement(){



    }
}
