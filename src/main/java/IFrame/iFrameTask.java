package IFrame;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class iFrameTask {
    @Test
    public void selfTask() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://skpatro.github.io/demo/iframes/");
        driver.manage().window().maximize();

        WebElement pavilion = driver.findElement(By.xpath("//a[.='Pavilion']"));
        BrowserUtils.clickWithJS(driver, pavilion);
        //span[@class='menu-text' and .='Selenium-Java']
//       Thread.sleep(10000);
        //i//preceding-sibling::span[.='Selenium']
       BrowserUtils.switchByTitle(driver,"Home - qavalidation");
       WebElement selenium = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']//.."));

        Actions actions = new Actions(driver);
        actions.moveToElement(selenium).perform();

        WebElement seleniumJava=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Java']//.."));
        seleniumJava.click();

        WebElement validationText = driver.findElement(By.tagName("h1"));
        String actualHeader = BrowserUtils.getTextMethod(validationText);
        String expectedHeader = "Selenium-Java Tutorial – Basic to Advance";
        Assert.assertEquals(actualHeader, expectedHeader);

        BrowserUtils.switchByTitle(driver, "iframes");
Thread.sleep(1000);
        driver.switchTo().frame("Frame1");
        WebElement category1 = driver.findElement(By.xpath("//a[.='Category1']"));
      BrowserUtils.clickWithJS(driver, category1);

BrowserUtils.switchByTitle(driver, "qavalidation");
  Assert.assertTrue(driver.getTitle().trim().endsWith("qavalidation"));
        BrowserUtils.switchByTitle(driver, "iframes");
  driver.switchTo().frame("Frame2");
        WebElement category3 = driver.findElement(By.xpath("//a[.='Category3']"));
        category3.click();

        BrowserUtils.switchByTitle(driver, "SoftwareTesting Archives - qavalidation");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl="https://qavalidation.com/category/softwaretesting/";
        Assert.assertEquals(actualUrl, expectedUrl);



    }





}
