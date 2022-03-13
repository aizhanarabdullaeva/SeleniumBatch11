package Homework.homework5;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class audiWebsite {
    //div[@class="nm-model-band-container-item-car-info"]//span[.='2022 Audi Q5']

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.audiusa.com/");
        driver.manage().window().maximize();
        WebElement suvSection = driver.findElement(By.xpath("//span[.='SUVs & Wagons']"));
        BrowserUtils.clickWithJS(driver, suvSection);
        WebElement Q5 = driver.findElement(By.xpath("//span[.='2022 Audi Q5']"));
BrowserUtils.clickWithJS(driver, Q5);
WebElement build = driver.findElement(By.xpath("//a[@class=\"sc-fzqBZW jkEZoQ\"]"));
build.click();




    }



}
