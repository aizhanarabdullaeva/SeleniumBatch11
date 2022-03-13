package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethods {
    public static void main(String[] args) {
/*
What is the difference between methods get() and navigate().to()
Difference between quit() and close()
 */
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://kodif.io/");
//        driver.quit();
//        driver.close();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        //System.out.println(driver.getPageSource());//html

        driver.navigate().to("https://www.techtorialacademy.com/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.close();
//thread.sleep(3000) putting 3 sec between going back and forward
  // we need to throw exception in order to use thread.sleep()

    }

}
