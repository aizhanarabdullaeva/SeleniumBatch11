package Homework.Homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase3 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("Java");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Selenium");
WebElement login = driver.findElement(By.id("login-button"));
login.click();
WebElement validation = driver.findElement(By.xpath("//h3[@data-test='error']"));
        System.out.println(validation.getText());
String expectedOutput = "Epic sadface: Username and password do not match any user in this service";
String actual = validation.getText();
if(expectedOutput.equals(actual)){
    System.out.println("Passed");
}else{
    System.out.println("Failed");
}



    }
}
