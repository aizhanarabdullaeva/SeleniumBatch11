package Homework.Project3;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Project3 {
    @Test
    public void testcase1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        WebElement cartEmpty = driver.findElement(By.xpath("//span[contains(text(),'(empty)')]"));
       boolean actualResult = cartEmpty.isDisplayed();
        Assert.assertTrue(actualResult);
List<WebElement> allPrices = driver.findElements(By.xpath("//span[@class=\"price product-price\"]"));
List<Double> productPrices = new ArrayList<>();
double actualtotal = 0;
double expectedtotal = 196.38;
for(int i =0; i< allPrices.size(); i++) {
    if (allPrices.get(i).isDisplayed()) {
        productPrices.add(Double.parseDouble(allPrices.get(i).getText().replace("$", "").trim()));


    }

}
    for(Double productPrice : productPrices){
        actualtotal+=productPrice;

    }


        System.out.println(actualtotal);
    Assert.assertEquals(actualtotal, expectedtotal);


    }
    @Test
    public void testcase2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        List<WebElement> allPrices = driver.findElements(By.xpath("//span[@class=\"price product-price\"]"));
        List<Double> productPrices = new ArrayList<>();
        for(int i =0; i< allPrices.size(); i++) {
            if (allPrices.get(i).isDisplayed()) {
                productPrices.add(Double.parseDouble(allPrices.get(i).getText().replace("$", "").trim()));


            }

        }
        System.out.println(productPrices);
        double cheapestProductPrice = productPrices.get(0);
        for(int i=0; i<productPrices.size(); i++){
              if(productPrices.get(i)<cheapestProductPrice){
                  cheapestProductPrice=productPrices.get(i);

              }


           }

        System.out.println(cheapestProductPrice);
        Assert.assertEquals(cheapestProductPrice,16.4);

        }

    @Test
    public void testcase3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();


        WebElement addToCart = driver.findElement(By.xpath("//a[@data-id-product='1']//span[.='Add to cart']"));
        BrowserUtils.clickWithJS(driver, addToCart);
        Thread.sleep(5000);
WebElement text = driver.findElement(By.xpath("//h2//i//.."));
  System.out.println(BrowserUtils.getTextMethod(text));
        String actualText = BrowserUtils.getTextMethod(text);
        String expectedText = "Product successfully added to your shopping cart";
        Assert.assertEquals(actualText, expectedText);
//
//text.getCssValue("color");
        System.out.println(text.getCssValue("color"));
        String actualColor = text.getCssValue("color");
        String expectedColor = "rgba(70, 167, 78, 1)";
        Assert.assertEquals(actualColor, expectedColor);







    }
    @Test
    public void testcase4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

WebElement women = driver.findElement(By.xpath("//a[@title=\"Women\"]"));
        Actions action = new Actions(driver);
action.moveToElement(women).perform();

WebElement summerDresses = driver.findElement(By.xpath("//a[@title=\"Summer Dresses\"]"));
summerDresses.click();

WebElement addToCart = driver.findElement(By.xpath("//a[@data-id-product=\"5\"]//span"));
BrowserUtils.clickWithJS(driver, addToCart);
Thread.sleep(5000);

WebElement validationOfText = driver.findElement(By.xpath("//h2//i//.."));
        String actualText = BrowserUtils.getTextMethod(validationOfText);
        String expectedText = "Product successfully added to your shopping cart";
        Assert.assertEquals(actualText, expectedText);

WebElement price = driver.findElement(By.xpath("//span[@id=\"layer_cart_product_price\"]"));
double priceFromPopUp  = Double.parseDouble(price.getText().replace("$","").trim());

Thread.sleep(1000);
WebElement validationOfTextOfCart = driver.findElement(By.xpath("//span[contains(text(),'There is 1 item in your cart.')]"));
String actualTextFromCart = BrowserUtils.getTextMethod(validationOfTextOfCart);
String expectedTextFromCart = "There is 1 item in your cart.";
Assert.assertEquals(actualTextFromCart, expectedTextFromCart);

WebElement continueButton = driver.findElement(By.xpath("//span[@title=\"Continue shopping\"]//span"));
BrowserUtils.clickWithJS(driver, continueButton);

WebElement text  = driver.findElement(By.xpath("//a[@title=\"View my shopping cart\"]"));
        String actualTextEnd = BrowserUtils.getTextMethod(text);
        String expectedTextEnd = "Cart 1 Product";
        Assert.assertEquals(actualTextEnd, expectedTextEnd);

WebElement shoppingCart = driver.findElement(By.xpath("//a[@title=\"View my shopping cart\"]"));
BrowserUtils.clickWithJS(driver, shoppingCart);

WebElement totalPrice = driver.findElement(By.xpath("//span[@id=\"total_price\"]"));
double actualTotalPrice = Double.parseDouble(totalPrice.getText().replace("$","").trim());
WebElement totalProduct = driver.findElement(By.xpath("//td[@id=\"total_product\"]"));
double totalProd = Double.parseDouble(totalProduct.getText().replace("$", "").trim());
WebElement  shippingPrice = driver.findElement(By.xpath("//td[@id=\"total_shipping\"]"));
double shipping = Double.parseDouble(shippingPrice.getText().replace("$", "").trim());
double shipAndProd = totalProd+shipping;
Assert.assertEquals(actualTotalPrice, shipAndProd);

Thread.sleep(1000);
WebElement increase = driver.findElement(By.xpath("//i[@class=\"icon-plus\"]"));
BrowserUtils.clickWithJS(driver,increase);

        WebElement updatedTotalPrice = driver.findElement(By.xpath("//span[@id=\"total_price\"]"));
        double updatTotalPrice = Double.parseDouble(totalPrice.getText().replace("$","").trim());

double updatedAddedAmount = actualTotalPrice+totalProd;
Assert.assertEquals(updatTotalPrice,updatedAddedAmount);









    }
    @Test
    public void testcase6() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        WebElement women = driver.findElement(By.xpath("//a[@title=\"Women\"]"));
        Actions action = new Actions(driver);
        action.moveToElement(women).perform();

        WebElement summerDresses = driver.findElement(By.xpath("//a[@title=\"Summer Dresses\"]"));
        summerDresses.click();

        List<WebElement> productDisplayed = driver.findElements(By.xpath("//span[@class=\"available-now\"]")) ;
//        List<String> numOfProdDisplayed = new ArrayList<>();
        int NumOfProd = 0;
      for(int i =0; i<productDisplayed.size();i++){
          if(productDisplayed.get(i).isDisplayed()){
            NumOfProd++;
          }
      }
        System.out.println(NumOfProd);

      WebElement validationOfShowingText = driver.findElement(By.xpath("//div[contains(text(),'Showing 1 - 3 of 3 items')]"));
      String actualText = BrowserUtils.getTextMethod(validationOfShowingText);
      String expectedText = "Showing 1 - 3 of 3 items";
      Assert.assertEquals(actualText, expectedText);
//a[@style=\"left: 0%;\"]
        WebElement slider = driver.findElement(By.xpath("//a[@style=\"left: 0%;\"]"));
        //html/body/div/div[2]/div/div[3]/div[1]/div[1]/div[1]/form/div/div[9]/ul/div/div/a[1]

        WebElement range = driver.findElement(By.xpath("//div[@id=\"layered_price_slider\"]"));
        String myRange = "20";
        while (!range.getText().trim().equals(myRange)) {

            slider.sendKeys(Keys.ARROW_RIGHT);

        }


    }

    }

