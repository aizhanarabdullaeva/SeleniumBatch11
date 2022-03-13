package Homework.Homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase4 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement login = driver.findElement(By.id("login-button"));
        login.click();
        System.out.println(driver.getCurrentUrl());
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = "https://www.saucedemo.com/inventory.html";
        if(expectedUrl.equals(actualUrl)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }


    }
}
