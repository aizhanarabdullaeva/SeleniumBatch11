package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeysActions {
    @Test
    public void keysPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        WebElement googleSearch = driver.findElement(By.name("q"));
        actions.moveToElement(googleSearch).click().keyDown(Keys.SHIFT)
                .sendKeys("s").keyUp(Keys.SHIFT).sendKeys("elenium")
                .doubleClick().keyDown(Keys.COMMAND).sendKeys("c")
                .keyUp(Keys.COMMAND).sendKeys(Keys.ARROW_RIGHT)
                .keyDown(Keys.COMMAND).sendKeys("v")
                .keyUp(Keys.COMMAND).sendKeys(Keys.RETURN).perform();





    }
    @Test
    public void selfPracticeTask(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://text-compare.com/");
        driver.manage().window().maximize();
        WebElement box1 = driver.findElement(By.xpath("//textarea[@name='text1']"));
        WebElement box2 = driver.findElement(By.xpath("//textarea[@name='text2']"));
      Actions actions = new Actions(driver);
      actions.moveToElement(box1).click().keyDown(Keys.SHIFT).sendKeys("G").keyUp(Keys.SHIFT)
              .sendKeys("ood-Bye").keyDown(Keys.SPACE).perform();
//              .keyUp(Keys.SPACE).keyDown(Keys.SHIFT).sendKeys("k")
//              .keyUp(Keys.SHIFT).sendKeys("eys").keyDown(Keys.COMMAND).sendKeys("a").keyDown(Keys.COMMAND)
//              .sendKeys("c").moveToElement(box2).keyDown(Keys.COMMAND).sendKeys("v");



    }
}
