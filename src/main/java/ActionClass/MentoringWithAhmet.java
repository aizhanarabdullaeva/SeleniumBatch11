package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MentoringWithAhmet {
@Test
    public void practiceHoverOver() throws InterruptedException {
   // WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.edureka.co/");
    driver.manage().window().maximize();
     Thread.sleep(1000);
    WebElement categories = driver.findElement(By.xpath("//a[@class='dropdown-toggle hidden-xs hidden-sm ga_browse_top_cat']//small[.='Browse']"));
    Actions actions = new Actions(driver);
    actions.moveToElement(categories).perform();

    Thread.sleep(1000);
    WebElement dataScience = driver.findElement(By.xpath("//a[@class='dropdown-toggle ga_top_category' and .='Cloud Computing']"));
    actions.moveToElement(dataScience).perform();

    Thread.sleep(1000);
    WebElement python = driver.findElement(By.xpath("//a[@class='ga_top_categories_course' and  .='Python Certification Training Course']"));
    Thread.sleep(2000);
    actions.moveToElement(python).perform();
    Thread.sleep(2000);
//a[.='Python Certification Training Course']
}
    @Test
    public void cyberSecurity() throws InterruptedException {
        // WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.edureka.co/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement categories = driver.findElement(By.xpath("//a[@class='dropdown-toggle hidden-xs hidden-sm ga_browse_top_cat']//small[.='Browse']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(categories).perform();

        Thread.sleep(1000);
        WebElement dataScience = driver.findElement(By.xpath("//a[@class='dropdown-toggle ga_top_category' and .='Cloud Computing']"));
        Actions action = new Actions(driver);
        action.moveToElement(dataScience).perform();
        //a[.='Cyber Security Course' and @class='ga_top_categories_course']

    }
    @Test
    public void PlanBpractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");
        driver.manage().window().maximize();

        WebElement acceptCookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        Thread.sleep(3000);
        acceptCookies.click();
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        Thread.sleep(10000);

WebElement advertisement = driver.findElement(By.className("qual_x_close"));
advertisement.click();


        List<WebElement> pictures=driver.findElements(By.xpath("//div[@role='listitem']"));
        List<WebElement> allPrices=driver.findElements(By.xpath("//div[@class='product-description']//p"));
        List<Double> prices=new ArrayList<>();

        for(int i = 0; i<pictures.size();i++){
            Thread.sleep(1000);
            actions.moveToElement(pictures.get(i)).perform();
//            prices.add(Double.parseDouble(allPrices.get(i).getText().trim().replace("$","")));
            prices.add(Double.parseDouble(allPrices.get(i).getText().replace("$","").trim()));
        }
        Collections.sort(prices);
        System.out.println(prices);
        Collections.reverse(prices);
        System.out.println(prices);





    }

}
