package com.test.orangehrm.tests;

import Utils.ConfigReader;
import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

@Test
    public void validateLoginPositiveFunctionality(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login(ConfigReader.readProperty("orangehrmusername"), ConfigReader.readProperty("orangehrmpassword"));
    Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/dashboard");


}
@Test
    public void validateLoginNegativeScenario(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("Admin", "aizhana");
Assert.assertEquals(loginPage.getErrorMessage(), "Invalid credentials");


}
@Test
    public  void validateLoginNegative(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("", "");
    Assert.assertEquals(loginPage.getErrorMessage(), "Username cannot be empty");
    Assert.assertEquals(loginPage.getColorOfErrorMessage(),"rgba(221, 119, 0, 1)");

}


}
