package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectClassPractice {
    @Test
    public void validationTripButton(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
driver.manage().window().maximize();
        WebElement oneWayButton = driver.findElement(By.xpath("//input[@value='oneway']"));
oneWayButton.click();
Assert.assertTrue(oneWayButton.isDisplayed());
        Assert.assertTrue(oneWayButton.isSelected());

WebElement roundtrip = driver.findElement(By.xpath("//input[@value='roundtrip']"));

        Assert.assertFalse(roundtrip.isSelected());
        Assert.assertTrue(roundtrip.isDisplayed());
    }
    @Test
    public void selectMethods() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        driver.manage().window().maximize();
        WebElement oneWayButton = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();

        WebElement passengerCount = driver.findElement(By.name("passCount"));
        Select passenger1= new Select(passengerCount);
        passenger1.selectByIndex(1);

        WebElement departingFrom = driver.findElement(By.name("fromPort"));
        Select departingFrom1 = new Select(departingFrom);
        departingFrom1.selectByValue("San Francisco");

        WebElement month = driver.findElement(By.name("fromMonth"));
        Select month1 = new Select(month);
        month1.selectByVisibleText("February");

       WebElement date = driver.findElement(By.name("fromDay"));
       Select date1= new Select(date);
       date1.selectByValue("17");

        WebElement arriveIn = driver.findElement(By.name("toPort"));
        Select arriveIn1= new Select(arriveIn);
      arriveIn1.selectByVisibleText("New York");

        WebElement returnOnMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select returnOn1 = new Select(returnOnMonth);
       returnOn1.selectByIndex(2);

        WebElement returnOnDate = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select returnOnDate1 = new Select(returnOnDate);
        returnOnDate1.selectByValue("25");
Thread.sleep(1000);
        WebElement preferences = driver.findElement(By.xpath("//input[@value='Business']"));
        preferences.click();
        Thread.sleep(1000);
        WebElement continueButton = driver.findElement(By.name("findFlights"));
        continueButton.click();

//        WebElement text = driver.findElement(By.xpath("//font[@size='4']"));
//    String actualText = text.getText();
//    String expectedText = "After flight finder - No Seats Available";
//    Assert.assertEquals(expectedText, actualText);

    }
@Test
    public void secondWay() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://demo.guru99.com/test/newtours/reservation.php");
    driver.manage().window().maximize();
    WebElement oneWayButton = driver.findElement(By.xpath("//input[@value='oneway']"));
    oneWayButton.click();

    WebElement passengerCount = driver.findElement(By.name("passCount"));
//    Select passenger1= new Select(passengerCount);
//    passenger1.selectByIndex(1);
    BrowserUtils.SelectBy(passengerCount,"2","index");

    WebElement departingFrom = driver.findElement(By.name("fromPort"));
//    Select departingFrom1 = new Select(departingFrom);
//    departingFrom1.selectByValue("San Francisco");
    BrowserUtils.SelectBy(departingFrom,"San Francisco", "value");

    WebElement month = driver.findElement(By.name("fromMonth"));
//    Select month1 = new Select(month);
//    month1.selectByVisibleText("February");
    BrowserUtils.SelectBy(month,"February","text");

    WebElement date = driver.findElement(By.name("fromDay"));
//    Select date1= new Select(date);
//    date1.selectByValue("17");
    BrowserUtils.SelectBy(date, "17", "value");

    WebElement arriveIn = driver.findElement(By.name("toPort"));
//    Select arriveIn1= new Select(arriveIn);
//    arriveIn1.selectByVisibleText("New York");
    BrowserUtils.SelectBy(arriveIn, "New York", "text");

    WebElement returnOnMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
//    Select returnOn1 = new Select(returnOnMonth);
//    returnOn1.selectByIndex(2);
    BrowserUtils.SelectBy(returnOnMonth, "2", "index");

    WebElement returnOnDate = driver.findElement(By.xpath("//select[@name='toDay']"));
//    Select returnOnDate1 = new Select(returnOnDate);
//    returnOnDate1.selectByValue("25");
    BrowserUtils.SelectBy(returnOnDate, "25", "value" );
    Thread.sleep(1000);
    WebElement preferences = driver.findElement(By.xpath("//input[@value='Business']"));
    preferences.click();
    Thread.sleep(1000);
    WebElement continueButton = driver.findElement(By.name("findFlights"));
    continueButton.click();

        WebElement text = driver.findElement(By.xpath("//font[@size='4']"));
    String actualText = text.getText();
//    String expectedText = "After flight finder - No Seats Available";
//    Assert.assertEquals(expectedText, actualText);








}



}
