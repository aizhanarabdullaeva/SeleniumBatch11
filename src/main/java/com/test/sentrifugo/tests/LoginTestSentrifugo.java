package com.test.sentrifugo.tests;

import com.test.sentrifugo.pages.LoginPageSentrifugo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestSentrifugo {





    //        WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
//        userName.sendKeys("EM01");
//WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
//password.sendKeys("sentrifugo");
//WebElement logInButton = driver.findElement(By.xpath("//input[@id='loginsubmit']"));
//logInButton.submit();
//  String actualURL = driver.getCurrentUrl();
//        String expectedURL = "http://demo.sentrifugo.com/index.php/index/welcome";
//        Assert.assertEquals(actualURL, expectedURL);
    @Test
    public void validateSuperAdmin(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
        //input[@id='username']
        driver.manage().window().maximize();
        LoginPageSentrifugo loginPage = new LoginPageSentrifugo(driver);
        loginPage.logIn();
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "http://demo.sentrifugo.com/index.php/index/welcome";
        Assert.assertEquals(actualURL, expectedURL);


   }
   @Test
    public void validateManagement(){
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.navigate().to("http://demo.sentrifugo.com/index.php/");
       //input[@id='username']
       driver.manage().window().maximize();
       LoginPageSentrifugo loginPage = new LoginPageSentrifugo(driver);
       loginPage.dynamicLogIn("EM02","sentrifugo");
       String actualTitle = driver.getTitle();
       String expectedTitle = "Sentrifugo - Open Source HRMS";
       Assert.assertEquals(actualTitle, expectedTitle);

   }





}
