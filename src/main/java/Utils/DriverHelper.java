package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverHelper {
    //private variable
   private static WebDriver driver;

   //private constructor we are creating to make sure they do not crate an object from this class
   private DriverHelper(){}

    public static WebDriver getDriver(){

       if(driver == null){// I am checking whether my driver is null or not
                           //if driver is null, I am going to create a new one
                         //if not, it is not going to create a new Driver. It will use the existiong/current one.
          switch(ConfigReader.readProperty("browser")){
              case "chrome":
                  WebDriverManager.chromedriver().setup();
                  driver = new ChromeDriver();
              break;
              case "firefox":
                      WebDriverManager.firefoxdriver().setup();
                      driver = new FirefoxDriver();
                      break;
              default:
                  WebDriverManager.chromedriver().setup();
                  driver = new ChromeDriver();
                  break;
          }
           driver.manage().window().maximize();
           driver.manage().deleteAllCookies(); // delete all the history, fresh start of the webPage
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


       }
       return driver;
    }
    public static void tearDown(){
       driver.quit();
       driver=null;


    }
}
