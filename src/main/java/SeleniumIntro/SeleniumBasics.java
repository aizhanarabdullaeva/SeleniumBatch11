package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {
    public static void main(String[] args) {
        System.out.println("Hi Java, I missed you a lot");
        //Step1 we need to define the chrome driver into the project
        //as a property
        System.setProperty("webdriver.chrome.driver","chromedriver");
        //Step2 We need to instantiate/declare our driver
        WebDriver driver = new ChromeDriver();
        //driver is a reference name,  Webdriver -->interface
        //new ChromeDriver() --> new Object

        /*
        Interview question:

        Where do you use polymorphism in your testing framework?
        I use it to instantiate my driver like  WebDriver driver = new ChromeDriver();

        Can you instantiate your driver like:
        WebDriver driver = new WebDriver()?
        NO

        First method:
        get()-methods navigates to the given url

         */

      driver.get("https://www.techtorialacademy.com/");

      // getTitle()--> gets the title of the page

     String title =  driver.getTitle();
        System.out.println(title);
if(title.equals("Home Page - Techtorial")){
    System.out.println("Passed");
}else{
    System.out.println("failed");
}
String url = driver.getCurrentUrl();
if(url.equals("https://www.techtorialacademy.com/")){
    System.out.println("Passed");
}else{
    System.out.println("Failed");
}
    }
}
