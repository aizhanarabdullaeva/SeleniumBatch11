package Homework.Homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");
        WebElement yesBox = driver.findElement(By.id("yesRadio"));
      ((JavascriptExecutor) driver).executeScript("arguments[0].click()",yesBox);


       WebElement yesValidation = driver.findElement(By.xpath("//p[@class='mt-3']"));
    if(yesValidation.getText().contains("You have selected Yes")){         System.out.println("Passed");
     }else{
         System.out.println("Failed");
     }

        WebElement impressiveBox = driver.findElement(By.id("impressiveRadio"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",impressiveBox);

WebElement impressiveValidation = driver.findElement(By.xpath("//p[@class='mt-3']"));
if(impressiveValidation.getText().equals("You have selected Impressive")){
    System.out.println("You are all good");
}else{
    System.out.println("Hmm something is wrong");
}


    }
}
