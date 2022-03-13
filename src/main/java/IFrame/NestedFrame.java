package IFrame;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedFrame {
    @Test
    public void nestedFrameValidation(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
driver.manage().window().maximize();
//it is an example of switching with the index number
driver.switchTo().frame(0); // I am on the top frame
        WebElement middleFrame = driver.findElement(By.xpath("//frame[@name=\"frame-middle\"]"));
        driver.switchTo().frame(middleFrame); //I am in the middle Frame
        WebElement textBox = driver.findElement(By.xpath("//div[@id='content']"));
        String actualText = BrowserUtils.getTextMethod(textBox);
        String expectedText = "MIDDLE";
        Assert.assertEquals(actualText, expectedText);

        driver.switchTo().parentFrame();
        WebElement leftBox = driver.findElement(By.xpath("//frame[@name='frame-left']"));
        driver.switchTo().frame(leftBox);
        WebElement leftText = driver.findElement(By.xpath("//body[contains(text(), 'LEFT')]"));
        String actualText1 = BrowserUtils.getTextMethod(leftText);
        String expectedText1 = "LEFT";
        Assert.assertEquals(actualText1, expectedText1);
//        driver.switchTo().parentFrame();
//        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        WebElement bottom = driver.findElement(By.xpath("//body[contains(text(), 'BOTTOM')]"));
        String actualText2 = bottom.getText();
        String expectedText2 = "BOTTOM";
        Assert.assertEquals(actualText2, expectedText2);











    }
}
