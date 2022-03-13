package Homework.Homework3;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.util.*;
//command+n

public class TestCase1 {
    @Test
    public void testCase1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        Thread.sleep(1000);
        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        Thread.sleep(1000);
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");


        Thread.sleep(1000);
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        Thread.sleep(1000);
        WebElement ZtoA = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        BrowserUtils.SelectBy(ZtoA, "za", "value");

        Thread.sleep(1000);
        List<WebElement> productsNames = driver.findElements(By.xpath("//a//div"));
        List<String> expectedValue = new ArrayList<>();
        List<String> actualValue = new LinkedList<>();
        for (int i = 0; i < productsNames.size(); i++) {
            expectedValue.add(productsNames.get(i).getText().trim());
            actualValue.add(productsNames.get(i).getText().trim());
            Collections.sort(expectedValue);
            Collections.reverse(expectedValue);

            Assert.assertEquals(actualValue, expectedValue);
        }
    }

    @Test
    public void testCase2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        Thread.sleep(1000);
        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        Thread.sleep(1000);
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");


        Thread.sleep(1000);
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        Thread.sleep(1000);
        WebElement lowToHigh = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        BrowserUtils.SelectBy(lowToHigh, "lohi", "value");

        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<Double> expectedValue = new ArrayList<>();
        List<Double> actualValue = new LinkedList<>();
        for (int i = 0; i < prices.size(); i++) {
            expectedValue.add(Double.parseDouble(prices.get(i).getText().replace("$","").trim()));
            actualValue.add(Double.parseDouble(prices.get(i).getText().replace("$","").trim()));
           Collections.sort(expectedValue);

        }

        Assert.assertEquals(actualValue, expectedValue);
        System.out.println(expectedValue);
        System.out.println(actualValue);


    }

    @Test
    public void testCase3() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        Thread.sleep(1000);
        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        Thread.sleep(1000);
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");


        Thread.sleep(1000);
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        Thread.sleep(1000);
        WebElement lowToHigh = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        BrowserUtils.SelectBy(lowToHigh, "lohi", "value");

//

        List<WebElement> cheapestProducts = driver.findElements(By.xpath("//a//div"));
        List<WebElement>addButton = driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
        for (int i = 0; i < 2; i++) {
cheapestProducts.get(i).getText();

        }
        for (int i= 0; i<cheapestProducts.size(); i++){
            addButton.get(i).click();
        }



        Thread.sleep(1000);
        WebElement shoppingCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        shoppingCart.click();

        Thread.sleep(1000);
        List<WebElement> productsInCart = driver.findElements(By.xpath("//div[@class='cart_item_label']"));
        for (WebElement product : productsInCart) {
            boolean expectedValue = product.isDisplayed();
            Assert.assertTrue(expectedValue);

        }

    }


    @Test
    public void testCase4() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        Thread.sleep(1000);
        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        Thread.sleep(1000);
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");


        Thread.sleep(1000);
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        Thread.sleep(1000);
        WebElement highToLow = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        BrowserUtils.SelectBy(highToLow, "lohi", "value");

        Thread.sleep(1000);
        WebElement cheapestProduct1 = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
        cheapestProduct1.click();

        Thread.sleep(1000);
        WebElement cheapestProduct2 = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        cheapestProduct2.click();

        Thread.sleep(1000);
        WebElement shoppingCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        shoppingCart.click();

Thread.sleep(1000);
WebElement checkOut = driver.findElement(By.xpath("//button[@id='checkout']"));
checkOut.click();

        Thread.sleep(1000);
        WebElement firstName = driver.findElement(By.name("firstName"));
       firstName.sendKeys("AJ");

        Thread.sleep(1000);
        WebElement lastName = driver.findElement(By.id("last-name"));
    lastName.sendKeys("Abdull");

        Thread.sleep(1000);
        WebElement zipCode= driver.findElement(By.id("postal-code"));
      zipCode.sendKeys("60660");

        Thread.sleep(1000);
        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        Thread.sleep(1000);
List<WebElement> prices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
List<Double> doublePrice = new ArrayList<>();
        for (WebElement price:prices) {
           doublePrice.add(Double.parseDouble(price.getText().replace("$", "")));

        }

        System.out.println(doublePrice);
        double actualItemTotal = 0;
        for(Double dbPrice: doublePrice){
actualItemTotal+=dbPrice;
        }

        System.out.println(actualItemTotal);

        WebElement itemTotal = driver.findElement(By.className("summary_subtotal_label"));

       Double  expectedItemTotal = Double.parseDouble(itemTotal.getText().substring(13,18));
       double expItemTotal = expectedItemTotal;
       double actItemTotal = actualItemTotal;
 Assert.assertEquals(actItemTotal,expItemTotal);

  WebElement summaryTotal = driver.findElement(By.className("summary_total_label"));
 Double expectedSummaryTotal = Double.parseDouble(summaryTotal.getText().substring(8,13));
 Double actualSummaryTotal = actualItemTotal+1.44;
 double expSumTotal= expectedSummaryTotal;
 double actSumTotal = actualSummaryTotal;
 Assert.assertEquals(actSumTotal, expSumTotal);

 boolean isExpextedContains= driver.getCurrentUrl().toLowerCase().contains("checkout");
 Assert.assertTrue(isExpextedContains);

WebElement finish = driver.findElement(By.id("finish"));
finish.click();

WebElement validationOfText = driver.findElement(By.xpath("//h2[.='THANK YOU FOR YOUR ORDER']"));
boolean expectedResult = validationOfText.isDisplayed();
Assert.assertTrue(expectedResult);




    }
    @Test
    public void testCase5() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // Why do we use backslash in string?
        // \n -> next line
        // \" -> to add " (double quotes) in to string.
        driver.get("https://demoqa.com/select-menu");

        WebElement searchFieldForTitle = driver.findElement(By.cssSelector("#react-select-3-input"));
        searchFieldForTitle.sendKeys("Other", Keys.ENTER);
        WebElement searchFieldForValue= driver.findElement(By.xpath("//input[@id=\"react-select-2-input\"]"));
        searchFieldForValue.sendKeys("Group 2, option 1",Keys.ENTER);
        Select selectColor = new Select(driver.findElement(By.xpath("//select[@id=\"oldSelectMenu\"]")));
        // How many ways can we chose with select class?
        // visibleText, index, value
        selectColor.selectByValue("red");
        WebElement searchFieldForSelect= driver.findElement(By.xpath("//input[@id=\"react-select-4-input\"]"));

        searchFieldForSelect.sendKeys("black", Keys.ENTER);
        Thread.sleep(2000);
        driver.manage().window().maximize();

// control + shift + r -> runs the code

        Actions actions = new Actions(driver);
        WebElement elementToCloseDropDownSelect = driver.findElement(By.xpath("//*[.='Multiselect drop down']"));
        actions.click(elementToCloseDropDownSelect).build().perform();



    }
}

