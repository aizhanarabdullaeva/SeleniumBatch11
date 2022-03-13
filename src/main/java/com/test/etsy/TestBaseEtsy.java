package com.test.etsy;

import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBaseEtsy {
    public WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= DriverHelper.getDriver();
        driver.get("https://www.etsy.com/");
        System.out.println("I am running before each test annotation");

    }
    @AfterMethod
    public void tearDown(){
        System.out.println("I am running after each test annotation");
        //driver.quit();
        DriverHelper.tearDown();
    }

}
