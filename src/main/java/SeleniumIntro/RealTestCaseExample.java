package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealTestCaseExample {
    public static void main(String[] args) {
        //  Test Case - Open Godaddy.com and validate it's Page title and the url.
//    Steps to Automate:
//            1. Launch browser of your choice say., Firefox, chrome etc.
//            2. Open this URL - https://www.godaddy.com/
//            3. Maximize or set size of browser window.
//4. Get Title of page and validate it.
//4. Get URL of current page and validate it.
//            5. Close browser.

        WebDriver driver =new ChromeDriver();
        driver.get("https://www.godaddy.com/");
        driver.manage().window().maximize();
String title = driver.getTitle();
        if(title.equals("Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy")){
            System.out.println("Your test case is passed");
        }else{
            System.out.println("Your test case failed");
        }
       String url = driver.getCurrentUrl();
        if(url.equals("https://www.godaddy.com/")){
            System.out.println("Your test case is passed");
        }else{
            System.out.println("Your test case failed");
        }
        driver.close();






    }
}
