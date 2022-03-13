package FileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTask {
    @Test
    public void validateFileUploadTask() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.guru99.com/test/upload/");
        driver.manage().window().maximize();

        WebElement chooseFile = driver.findElement(By.xpath("//input[@id=\"uploadfile_0\"]"));
        chooseFile.sendKeys("/Users/aizhanarabdullaeva/Desktop/kgz.png");

        WebElement accept = driver.findElement(By.xpath("//input[@id=\"terms\"]"));
        accept.click();
        boolean isSelected = accept.isSelected();
        Assert.assertTrue(isSelected);
Thread.sleep(1000);
        WebElement submit = driver.findElement(By.xpath("//button[@id=\"submitbutton\"]"));
        submit.click();


WebElement text = driver.findElement(By.xpath("//div[@class='formbuttons']//center"));
        String actualText = text.getText();
        String expectedText = "1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(actualText, expectedText);





    }
}
