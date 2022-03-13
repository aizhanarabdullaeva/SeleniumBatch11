package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiSelect {
    @Test
    public void multipleSelectAndFirstSelectClass() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///Users/aizhanarabdullaeva/Downloads/Techtorial%20(3).html");
        driver.manage().window().maximize();
        WebElement header = driver.findElement(By.id("techtorial1"));
        System.out.println(BrowserUtils.getTextMethod(header));
        WebElement multiSelectBox = driver.findElement(By.xpath("//select[@class='select']"));
        BrowserUtils.SelectBy(multiSelectBox,"Two","text");
        BrowserUtils.SelectBy(multiSelectBox, "3", "index");
        BrowserUtils.SelectBy(multiSelectBox, "5","value");
Thread.sleep(2000);
        Select select = new Select(multiSelectBox);
       // select.deselectAll();
        select.deselectByIndex(3);

        WebElement countryName = driver.findElement(By.name("country"));
        Select country = new Select(countryName);
//        String actualFirstSelectedOption = country.getFirstSelectedOption().getText().trim();
                String actualFirstSelectedOption = BrowserUtils.getTextMethod(country.getFirstSelectedOption());
        String expectedFirstSelectedOption = "UNITED STATES";
        Assert.assertEquals(actualFirstSelectedOption, expectedFirstSelectedOption);













    }
}
