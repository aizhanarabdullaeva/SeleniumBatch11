package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksAndTags {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/aizhanarabdullaeva/Downloads/Techtorial%20(2).html");
        driver.manage().window().maximize();
        WebElement javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.navigate().back();

        WebElement seleniumLink = driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();
        driver.navigate().back();

        WebElement cucumberLink = driver.findElement(By.linkText("Cucumber"));
        cucumberLink.click();
        driver.navigate().back();

        javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();
        driver.navigate().back();

        WebElement restApi = driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        driver.navigate().back();

        WebElement version = driver.findElement(By.tagName("u"));
        System.out.println(version.getText());

    }
}
