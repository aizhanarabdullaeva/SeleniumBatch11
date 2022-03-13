package WindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class SwitchWindow {
    @Test
    public void Practice1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//        driver.get("https://the-internet.herokuapp.com/windows/new");
//        driver.manage().window().maximize();
//
//        WebElement title = driver.findElement(By.xpath("//h3"));
//        System.out.println(title.getText());
driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        WebElement clickHere= driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();
       WebElement title = driver.findElement(By.xpath("//h3"));
       System.out.println(title.getText());




    }
    @Test
    public void switchWindow(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        System.out.println(driver.getWindowHandle());

        WebElement clickHere= driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();
        System.out.println(driver.getWindowHandles());
  //      WebElement title = driver.findElement(By.xpath("//h3[.='New Window']"));
String mainPageId = driver.getWindowHandle();
        Set<String>allPagesId = driver.getWindowHandles();

        //this implementation is only for 2 tabs
for(String id: allPagesId){
    System.out.println(id);
    if(!id.equals(mainPageId)){
        driver.switchTo().window(id);

    }
}
              WebElement title = driver.findElement(By.xpath("//h3[.='New Window']"));
        System.out.println(title.getText());
        String actualTitle = title.getText();
        String expectedTitle = "New Window";
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void switchWindowPractice() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().window().maximize();
        String mainPageId = driver.getWindowHandle();
WebElement newTab = driver.findElement(By.xpath("//button[@id='newTabBtn']"));
newTab.click();

//WebElement header = driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));

//        Set<String>allPagesId = driver.getWindowHandles();
//
//        for(String id: allPagesId){
//            System.out.println(id);
//            if(!id.equals(mainPageId)){
//                driver.switchTo().window(id);
//
//            }
//        }
BrowserUtils.switchOnlyForTwoTabs(driver, mainPageId);

        WebElement header = driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        System.out.println(header.getText());
        String actualTitle = header.getText();
        String expectedTitle = "AlertsDemo";
        Assert.assertEquals(actualTitle, expectedTitle);

        WebElement clickMe = driver.findElement(By.xpath("//button[@id='alertBox']"));
        clickMe.click();

    }

}
