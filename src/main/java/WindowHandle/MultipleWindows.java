package WindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
  @Test
  public void multipleWindowsTest(){
      WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();
      driver.get("https://the-internet.herokuapp.com/windows");
      driver.manage().window().maximize();
      WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));
      clickHere.click();

      JavascriptExecutor js = (JavascriptExecutor) driver;

js.executeScript("window.open('https://www.techtorialacademy.com/')");
      js.executeScript("window.open('https://www.techtorialacademy.com/about-us')");
      js.executeScript("window.open('https://www.techtorialacademy.com/programs')");

      Set<String> allPages = driver.getWindowHandles();
      for(String id : allPages){
          driver.switchTo().window(id);
          if(driver.getTitle().contains("About Us")){
              break;
          }
      }





  }
    @Test
    public void multipleWindowsTestPractice() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.open('https://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/about-us')");
        js.executeScript("window.open('https://www.techtorialacademy.com/programs')");

//        Set<String > allPages = driver.getWindowHandles();
//        for(String page: allPages){
//            driver.switchTo().window(page);
//            if(page.getTitle().contains("Home Page - Techtorial")){
//                break;
//            }
//
//        }
        BrowserUtils.switchByTitle(driver, "Home Page - Techtorial");

    }
}
