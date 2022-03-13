package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class SelectClassIntro {
    @Test
    public  void practice1() throws InterruptedException {
//        WebDriverManager.firefoxdriver().setup();
//        WebDriver driver = new SafariDriver();
    WebDriverManager.chromedriver().setup();
     WebDriver driver = new ChromeDriver();
     driver.get("https://the-internet.herokuapp.com/");
        WebElement dropDown = driver.findElement(By.linkText("Dropdown"));
        dropDown.click();
        WebElement optionBox = driver.findElement(By.id("dropdown"));
        Select option = new Select(optionBox); //provide webElement location
       Thread.sleep(1000);
        option.selectByIndex(1); //should return option2
        Thread.sleep(1000);
        option.selectByValue("2");
        Thread.sleep(1000);
       option.selectByVisibleText("Option 1");
       List<WebElement> options =  option.getOptions();
       for(WebElement option1 :options){
           System.out.println(option1.getText().trim());


       }


    }
}
