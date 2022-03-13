package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Locale;

public class CarsPractice {
    @Test
    public void Lexus() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cars.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement newUsed = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.SelectBy(newUsed, "new", "value");

        Thread.sleep(1000);
        WebElement make = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.SelectBy(make, "Lexus", "text");

        Thread.sleep(1000);
        WebElement model = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.SelectBy(model, "All models", "text");

        Thread.sleep(1000);
        WebElement price = driver.findElement(By.xpath("//select[@id='make-model-max-price' and @name='list_price_max']"));
        BrowserUtils.SelectBy(price, "175000", "value");

        Thread.sleep(1000);
        WebElement mile = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.SelectBy(mile, "6", "index");

        Thread.sleep(1000);
        WebElement zipCode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipCode.clear();
        zipCode.sendKeys("60660");
        Thread.sleep(1000);
        WebElement search = driver.findElement(By.xpath("//button[@class='sds-button' and @data-linkname='search-new-make']"));
        search.click();

        Thread.sleep(1000);
        WebElement validationOfHeader = driver.findElement(By.xpath("//h1[.='New Lexus for sale']"));
        String expectedText = BrowserUtils.getTextMethod(validationOfHeader);
        String actualText = "New Lexus for sale";
        Assert.assertEquals(actualText, expectedText);

    }

    @Test
    public void validationOfSubHeader() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cars.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement newUsed = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.SelectBy(newUsed, "new", "value");

        Thread.sleep(1000);
        WebElement make = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.SelectBy(make, "Lexus", "text");

        Thread.sleep(1000);
        WebElement model = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.SelectBy(model, "All models", "text");

        Thread.sleep(1000);
        WebElement price = driver.findElement(By.xpath("//select[@id='make-model-max-price' and @name='list_price_max']"));
        BrowserUtils.SelectBy(price, "175000", "value");

        Thread.sleep(1000);
        WebElement mile = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.SelectBy(mile, "6", "index");

        Thread.sleep(1000);
        WebElement zipCode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipCode.clear();
        zipCode.sendKeys("60660");
        Thread.sleep(1000);
        WebElement search = driver.findElement(By.xpath("//button[@class='sds-button' and @data-linkname='search-new-make']"));
        search.click();

        Thread.sleep(1000);
        List<WebElement>subHeaders = driver.findElements(By.xpath("//a//h2"));
        for(WebElement subHeader: subHeaders){
            boolean  expectedValue = subHeader.getText().trim().toLowerCase().contains("lexus");
            boolean actualValue = true;
            Assert.assertEquals(actualValue, expectedValue);
            //Assert.assertTrue(subHeader.getText().trim().toLowerCase().contains("lexus"));

        }

    }
}