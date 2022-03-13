package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.yahoo.com/");
        driver.manage().window().maximize();

        Thread.sleep(300);
        WebElement news = driver.findElement(By.xpath("//a[@id='root_2']"));
        news.click();

        Thread.sleep(300);
        List<WebElement> headers = driver.findElements(By.xpath("//li/a"));
        for(WebElement header: headers){

            if(header.getText().toUpperCase().contains("COVID")){
                System.out.println(header.getText());
            }

        }

/*
for(int i=0; i< headers.size(); i++{
sout(headers.get(i).getText());
}
 */


    }
}
