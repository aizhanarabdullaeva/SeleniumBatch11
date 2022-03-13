package JavaScriptExecutor;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptMethods {
    @Test
    public void TitleMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle()+"from driver");
//        JavascriptExecutor JSExecutor = (JavascriptExecutor) driver;
//        String title = JSExecutor.executeScript("return document.title").toString();
//        System.out.println(title+"from JS");
        String actualTitle = BrowserUtils.getTitleWithJavaScript(driver);
        String expectedTitle = "Home Page - Techtorial";
        Assert.assertEquals(actualTitle, expectedTitle);


    }
    @Test
    public void clickWithJS(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        WebElement browseCourse = driver.findElement(By.xpath("//a[.='Browse Course']"));
//        javascriptExecutor.executeScript("arguments[0].click()", browseCourse);
        BrowserUtils.clickWithJS(driver,browseCourse);

        WebElement loginButton = driver.findElement(By.xpath("//header//div[2]//a[.='Student login']"));
        BrowserUtils.clickWithJS(driver, loginButton);







    }

    @Test
    public  void scrollIntoView(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();

WebElement copyRight = driver.findElement(By.xpath("//p[contains(text(),'Copy')]"));
JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)",copyRight);

    }
//Task
@Test
public  void scrollIntoViewPractice() {

    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("http://www.techtorialacademy.com/");
    driver.manage().window().maximize();

    WebElement browseCourse = driver.findElement(By.xpath("//a[.='Browse Course']"));
    BrowserUtils.clickWithJS(driver, browseCourse);

    WebElement onCampusGetStarted = driver.findElement(By.xpath("//h4[.='On-Campus Course']//..//a"));
//    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//    javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)",onCampusGetStarted);
    BrowserUtils.scrollWithJS(driver, onCampusGetStarted);
    BrowserUtils.clickWithJS(driver, onCampusGetStarted);

}
@Test
    public void scrollWithXandYCoordinateTest(){
    //This is interview question(POINT CLASS)
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("http://www.techtorialacademy.com/");
    driver.manage().window().maximize();

    WebElement copyRight = driver.findElement(By.xpath("//p[contains(text(),'Copy')]"));
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
    Point location = copyRight.getLocation();
    System.out.println(location.getX());
    System.out.println(location.getY());
    int xCord = location.getX();
    int yCord = location.getY();
    javascriptExecutor.executeScript("window.scrollTo("+xCord+","+yCord+")");


}




}
