package IFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IFramePractice {
    @Test
    public void iFrameTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
        driver.switchTo().frame("mce_0_ifr");
        WebElement box = driver.findElement(By.xpath("//body[@id='tinymce']"));
        box.clear();
        box.sendKeys("Love Selenium");
       driver.switchTo().parentFrame();
        WebElement header = driver.findElement(By.xpath("//h3"));
String actualHeader = header.getText();
String expectedHeader = "An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(actualHeader, expectedHeader);




    }
}
