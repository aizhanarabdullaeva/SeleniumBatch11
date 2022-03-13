package Homework.Homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NoncommercePractice {
    public static void main(String[] args) throws InterruptedException {
        /*
        TASK 2:Creating an account for nopcommerce and validation
1-NAVIGATE TO THE WEBSITE https://demo.nopcommerce.com/
2-Click Register
3-Fill the information
4-Newsletter box should be left unclicked
5-Click Register
6-Validate “Your registration completed”
7-Click Continue (edited)
demo.nopcommerce.comdemo.nopcommerce.com
nopCommerce demo store
nopCommerce is the open-source eCommerce solution.
nopCommerce is available for free.
It has everything you need to get started in selling physical and digital goods
 over the internet.
         */
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        Thread.sleep(300);
        WebElement register = driver.findElement(By.xpath("//a[@class='ico-register']"));
        register.click();


        Thread.sleep(300);
        WebElement gender = driver.findElement(By.xpath("//label[@for='gender-female']"));
        gender.click();

        Thread.sleep(300);
        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
      firstName.sendKeys("Aizhana");

        Thread.sleep(300);
        WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
      lastName.sendKeys("Abdull");

        Thread.sleep(300);
        WebElement day = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        day.sendKeys("27");

        Thread.sleep(300);
        WebElement month = driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
      month.sendKeys("February");

        Thread.sleep(300);
        WebElement year = driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
        year.sendKeys("1999");

        Thread.sleep(300);
        WebElement email = driver.findElement(By.xpath("//input[@data-val-required='Email is required.']"));
        email.sendKeys("AizhanUmr379@gmail.com");

        Thread.sleep(300);
        WebElement companyName = driver.findElement(By.xpath("//input[@id='Company']"));
        companyName.sendKeys("Aizhana Aiym LLC");

        Thread.sleep(300);
        WebElement unClick = driver.findElement(By.xpath("//input[@id='Newsletter']"));
       unClick.click();


        Thread.sleep(300);
        WebElement password = driver.findElement(By.xpath("//input[@data-val-required='Password is required.' and @id='Password']"));
       password.sendKeys("123Timura!");

        Thread.sleep(300);
        WebElement passwordConfirmation = driver.findElement(By.xpath("//input[@data-val-required='Password is required.' and @id='ConfirmPassword']"));
        passwordConfirmation.sendKeys("123Timura!");

        Thread.sleep(300);
        WebElement registerButton = driver.findElement(By.xpath("//button[@name='register-button']"));
        registerButton.click();

        Thread.sleep(300);
        WebElement validation = driver.findElement(By.xpath("//div[@class='result']"));
        System.out.println(validation.getText());

        String expectedValue = "Your registration completed";
if (validation.getText().equals(expectedValue)){
    System.out.println("Passed");
}else{
    System.out.println("Failed");
}










    }

}
