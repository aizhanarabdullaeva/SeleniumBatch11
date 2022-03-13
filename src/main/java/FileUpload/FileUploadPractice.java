package FileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadPractice {
    @Test
    public void validateFileUpload(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        WebElement chooseFile = driver.findElement(By.xpath("//input[@id=\"file-upload\"]"));
        chooseFile.sendKeys("/Users/aizhanarabdullaeva/Desktop/kgz.png");
        WebElement upload = driver.findElement(By.xpath("//input[@id=\"file-submit\"]"));
        upload.click();
        WebElement textValidation = driver.findElement(By.tagName("h3"));
       String actualText =  textValidation.getText();
       String expectedText = "File Uploaded!";
        Assert.assertEquals(actualText, expectedText);

        //div[@id="uploaded-files"]
        WebElement textValidation2 = driver.findElement(By.xpath("//div[@id=\"uploaded-files\"]"));
        String actualText2 =  textValidation2.getText();
        String expectedText2 = "kgz.png";
        Assert.assertEquals(actualText2, expectedText2);





    }






}
