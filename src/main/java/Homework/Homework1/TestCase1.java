package Homework.Homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {
    public static void main(String[] args) throws InterruptedException {
        //First step of starting automation should be reading the test cases
        //step by step implement requirements
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("Aizhana Abdull");
        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("aizhanabdull@gmail.com");


        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        System.out.println(currentAddress.getText());
        currentAddress.sendKeys("1151 Sonora Ave");
WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
permanentAddress.sendKeys("1151 Sonora Ave");
WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
///////////////
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        Thread.sleep(500);
        /////////////////
button.click();

WebElement nameValidation = driver.findElement(By.xpath("//p[@id='name']"));
        System.out.println(nameValidation.getText());
String expectedValidation = "Name:Aizhana Abdull";
String actualValidation = nameValidation.getText();

WebElement emailValidation = driver.findElement(By.xpath("//p[@id='email']"));
        System.out.println(emailValidation.getText());
        String expectedEmailValidation = "Email:aizhanabdull@gmail.com";
        String actualEmailValidation = emailValidation.getText();

        WebElement currentAddressValidation = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        System.out.println(currentAddressValidation.getText());
        String expectedCAValidation = "Current Address :1151 Sonora Ave";
        String actualCAValidation = currentAddressValidation.getText();


WebElement permanentAddressValidation = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        System.out.println(permanentAddressValidation.getText());
String expectedPAValidaion = "Permananet Address :1151 Sonora Ave";
String actualPAValidation = permanentAddressValidation.getText();

if(expectedValidation.equals(actualValidation) && expectedEmailValidation.equals(actualEmailValidation) &&
expectedCAValidation.equals(actualCAValidation) && expectedPAValidaion.equals(actualPAValidation)){
    System.out.println("Passed");
}else{
    System.out.println("Failed");
}


    }
}
