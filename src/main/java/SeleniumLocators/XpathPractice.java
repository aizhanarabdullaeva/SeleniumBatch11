package SeleniumLocators;

import com.sun.org.apache.xalan.internal.xsltc.dom.AdaptiveResultTreeImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.ws.WebEndpoint;

public class XpathPractice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
//        driver.get("file:///Users/aizhanarabdullaeva/Downloads/Techtorial%20(2).html");
//        WebElement javaLink = driver.findElement(By.xpath("//a[@href='https://www.techtorialacademy.com/']"));
//       javaLink.click();
//       driver.navigate().back();

       driver.get("https://the-internet.herokuapp.com/horizontal_slider");
       WebElement text = driver.findElement(By.xpath("//h3"));
        System.out.println(text.getText());
        WebElement text1 = driver.findElement(By.xpath("//h4[@class='subheader']"));
        System.out.println(text1.getText());

//Contains : it works with text
        //tagname[contains(text(),'HorizontalLine')]
WebElement contains = driver.findElement(By.xpath("//h3[contains(text(),'Horizontal Slider')]"));
        System.out.println(contains.getText());

        //text: it works with text as well this is for simplier
        //than contains method it looks for exact text
        //h3[.='text']
        WebElement textMethod = driver.findElement(By.xpath("//h3[.='Horizontal Slider']"));
        System.out.println(textMethod.getText());
    }
}
