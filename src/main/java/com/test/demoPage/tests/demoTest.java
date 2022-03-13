package com.test.demoPage.tests;

import Utils.BrowserUtils;
import com.test.demoPage.TestBaseDemo;
import com.test.demoPage.pages.CustomersPage;
import com.test.demoPage.pages.LoginPageDemo;
import com.test.demoPage.pages.MainPageDemo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class demoTest extends TestBaseDemo {
    @Test
    public void validationOfMainPage() throws InterruptedException {
        LoginPageDemo loginPageDemo = new LoginPageDemo(driver);
        loginPageDemo.loginButton();
        MainPageDemo mainPageDemo = new MainPageDemo(driver);

        Assert.assertTrue(mainPageDemo.validationOfTotalOrders("12K"));
        Assert.assertTrue(mainPageDemo.validationOfTotalSales("11.8M"));
        Assert.assertTrue(mainPageDemo.validationOfTotalCustomers("145.4K"));

        mainPageDemo.customersClick();
        BrowserUtils.clickWithJS(driver, mainPageDemo.getCustomersSub());
        BrowserUtils.clickWithJS(driver, mainPageDemo.getPlusSign());
        CustomersPage customersPage= new CustomersPage(driver);
        customersPage.addingCustomer();
        Assert.assertEquals(customersPage.validationOfText(),"Warning: You do not have permission to modify customers!\n" +
                "×");


    }
}
