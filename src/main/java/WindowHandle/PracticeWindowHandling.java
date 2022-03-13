package WindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeWindowHandling {
  @Test
  public void practice() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
    driver.manage().window().maximize();
    WebElement button4 = driver.findElement(By.xpath("//button[@id='newTabsBtn']"));
    button4.click();

    BrowserUtils.switchByTitle(driver, "Basic Controls");

    WebElement header  = driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
    String actualHeader = BrowserUtils.getTextMethod(header);
    String expectedHeader = "Basic Controls";
    Assert.assertEquals(actualHeader, expectedHeader);

    WebElement id = driver.findElement(By.id("firstName"));
    id.sendKeys("Aizhana");

    WebElement lastname = driver.findElement(By.id("lastName"));
    lastname.sendKeys("Abdull");

//femalerb
    WebElement gender = driver.findElement(By.id("femalerb"));
   BrowserUtils.clickWithJS(driver, gender);

   //englishchbx

    WebElement language = driver.findElement(By.id("englishchbx"));
    BrowserUtils.clickWithJS(driver, language);
    //input[@id='email']


    WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
    email.sendKeys("aizhana@gmail.com");

    //input[@id='password']

    WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
    password.sendKeys("Aizhanar2702");
   // registerbtn

    WebElement register = driver.findElement(By.id("registerbtn"));
    BrowserUtils.clickWithJS(driver, register);

    //label[.='Registration is Successful']
    WebElement title = driver.findElement(By.xpath("//label[.='Registration is Successful']"));
    String actualTitle = BrowserUtils.getTextMethod(title);
    String expectedTitle = "Registration is Successful";
    Assert.assertEquals(actualTitle, expectedTitle);

Thread.sleep(2000);
    BrowserUtils.switchByTitle(driver, "AlertsDemo");

    WebElement alertBox = driver.findElement(By.xpath("//button[@id='alertBox']"));
    alertBox.click();
    Thread.sleep(2000);
    driver.quit();

  }



}
