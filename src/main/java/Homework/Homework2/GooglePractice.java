package Homework.Homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GooglePractice {
    public static void main(String[] args) throws InterruptedException {
        /*
        TASK: CREATING AN ACCOUNT FOR AMAZON:
1-NAVIGATE TO THE WEBSITE https://www.amazon.com/
2_Click Hello, Sign in Button
3-Click Create your amazon account button
4-Fill the information and click Continue Button
5-If there is an error or message. Validate it, if not then you completed the task

         */

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        WebElement signInButton = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        signInButton.click();

        Thread.sleep(300);
        WebElement createAccount = driver.findElement(By.xpath("//a[@id='createAccountSubmit']"));
        createAccount.click();

        Thread.sleep(300);
        WebElement name = driver.findElement(By.xpath("//input[@id='ap_customer_name']"));
        name.sendKeys("Aizhana");

        Thread.sleep(300);
        WebElement email = driver.findElement(By.xpath("//input[@id='ap_email']"));
        email.sendKeys("Aizhankou6329@gmail.com");

        Thread.sleep(300);
        WebElement password = driver.findElement(By.xpath("//input[@id='ap_password']"));
        password.sendKeys("123Timura!");

        Thread.sleep(300);
        WebElement passwordConfirmation = driver.findElement(By.xpath("//input[@id='ap_password_check']"));
        passwordConfirmation.sendKeys("123Timura!");

        Thread.sleep(300);
        WebElement continueButton = driver.findElement(By.xpath("//input[@aria-labelledby='auth-continue-announce']"));
        continueButton.click();














    }
}
