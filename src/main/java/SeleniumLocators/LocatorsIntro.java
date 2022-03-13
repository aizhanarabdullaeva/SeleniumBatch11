package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    public static void main(String[] args) {
        //Locator: ID
        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/aizhanarabdullaeva/Downloads/Techtorial%20(2).html");
        WebElement header = driver.findElement(By.id("techtorial1"));
       String actualText =  header.getText();//from the website
        String expectedText = "Techtorial Academy";//from the business requirement

if(actualText.equals(expectedText)){
    System.out.println("Passed");
}else{
    System.out.println("Failed");
}
WebElement paragraph = driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());
//Locators: ClassName
        WebElement tools = driver.findElement(By.className("group_checkbox"));
        System.out.println(tools.getText());
        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Aizhanar");
WebElement lastname = driver.findElement(By.name("lastName"));
WebElement email = driver.findElement(By.name("userName"));
        WebElement phone = driver.findElement(By.name("phone"));
lastname.sendKeys("Abdull");
email.sendKeys("aizhanabdull@gmail.com");
phone.sendKeys("283493475");
WebElement javaBox = driver.findElement(By.id("cond1"));
javaBox.click();
        System.out.println(javaBox.isDisplayed()); // boolean
        System.out.println(  javaBox.isSelected()); // is clicked or not

WebElement testNG = driver.findElement(By.id("cond3"));
testNG.click();
        System.out.println(testNG.isSelected());
        System.out.println(testNG.isDisplayed());

WebElement cucumber = driver.findElement(By.id("cond4"));
cucumber.click();
        System.out.println(cucumber.isDisplayed());
        System.out.println(cucumber.isSelected());


    }
}
