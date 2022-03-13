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

public class alertTask {
    @Test
    public void alertTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        driver.manage().window().maximize();

        WebElement JSalertPreview = driver.findElement(By.xpath("//button[@onclick=\"alert('Oops, something went wrong!')\"]"));
       //h5[contains(text(),'Normal alert')]//..//button
        BrowserUtils.clickWithJS(driver, JSalertPreview);
        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        String expectedText = "Oops, something went wrong!";
        Assert.assertEquals(actualText, expectedText);
        alert.accept();

    }


    @Test
    public void alertTestHTML() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        driver.manage().window().maximize();

        WebElement HTMLalertPreview = driver.findElement(By.xpath("//h5[@class=\"swal-logo\"]/following-sibling::button"));
        BrowserUtils.clickWithJS(driver, HTMLalertPreview);

        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        String expectedText = "Something went wrong!";
        Assert.assertEquals(actualText, expectedText);
        alert.accept();

//NoAlertPresentException






    }
    @Test
    public void alertTestHTML1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        driver.manage().window().maximize();

        WebElement HTMLalertPreview = driver.findElement(By.xpath("//h5[@class=\"swal-logo\"]/following-sibling::button"));
        BrowserUtils.clickWithJS(driver, HTMLalertPreview);

//div[.='Something went wrong!']
    WebElement text = driver.findElement(By.xpath("//div[.='Something went wrong!']"));
        System.out.println(text.getText());

   String actualText =  text.getText();
   String expectedText = "Something went wrong!";
   Assert.assertEquals(actualText, expectedText);

    WebElement okButton = driver.findElement(By.xpath("//button[@class=\"swal-button swal-button--confirm\"]"));
    BrowserUtils.clickWithJS(driver, okButton);


    }
}
