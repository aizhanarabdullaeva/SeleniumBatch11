package Alert;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class alertIntro {
    @Test
    public void JSBasicAlertAcceptsMethod() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        WebElement clickJSAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        clickJSAlert.click();


//    WebElement header = driver.findElement(By.xpath("//h3"));//UnhandledAlertException
//    System.out.println(header.getText());

        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        String expectedText = "I am a JS Alert";
        Assert.assertEquals(actualText, expectedText);
        alert.accept();

        WebElement message = driver.findElement(By.xpath("//p[@id='result']"));
        String actualMessage = BrowserUtils.getTextMethod(message);
        String expectedMessage = "You successfully clicked an alert";
        Assert.assertEquals(actualMessage, expectedMessage);


    }

    @Test
    public void JSBasicAlertDismissMethod() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
WebElement clickJSConfirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
clickJSConfirm.click();
//button[.='Click for JS Confirm']
     Alert alert = driver.switchTo().alert();
     alert.dismiss();

        //p[@id="result"]
        WebElement message = driver.findElement(By.xpath("//p[@id='result']"));
        String actualMessage = BrowserUtils.getTextMethod(message);
        String expectedMessage = "You clicked: Cancel";
        Assert.assertEquals(actualMessage, expectedMessage);




    }
    @Test
    public void JSBasicAlertSendKeysMethod() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        WebElement clickJSPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        clickJSPrompt.click();
        Alert alert = driver.switchTo().alert();
       alert.sendKeys("Techtorial");
       alert.accept();
        WebElement message = driver.findElement(By.xpath("//p[@id='result']"));
        String actualMessage = BrowserUtils.getTextMethod(message);
        String expectedMessage = "You entered: Techtorial";
        Assert.assertEquals(actualMessage, expectedMessage);



    }
}