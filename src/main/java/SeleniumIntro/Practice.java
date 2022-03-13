package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {
    public static void main(String[] args) {
        //Go to 3 websites and going back and forward with them
        //and lastly quit
        //get the title, currenturl,
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        driver.get("https://www.instagram.com/?hl=en");
        System.out.println(driver.getTitle());
        driver.get("https://www.dickssportinggoods.com/");
        System.out.println( driver.getTitle());
        driver.navigate().forward();

        driver.navigate().back();
        driver.quit();


    }
}
