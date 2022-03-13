package com.test.audiUsa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBaseAudi {
        public WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.audiusa.com/");
        driver.manage().window().maximize();
        System.out.println("I am running before each test annotation");

    }
    @AfterMethod
    public void tearDown(){
        System.out.println("I am running after each test annotation");
        //driver.quit();
    }
}
