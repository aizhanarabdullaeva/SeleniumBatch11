package Homework.Homework3;

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
import java.util.List;

public class telerikWebsite {
    @Test
    public void testCase1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();


//Thread.sleep(11000);
//WebElement advertisement = driver.findElement(By.className("qual_x_svg_dash"));
//advertisement.click();

        WebElement shiromiSalad = driver.findElement(By.xpath("//img[@title='Shiromi']"));
        BrowserUtils.clickWithJS(driver, shiromiSalad);

        Thread.sleep(1000);
        WebElement nextArrow = driver.findElement(By.xpath("//a[@id='navigate-next']"));
        nextArrow.click();

        Thread.sleep(1000);
        WebElement tekkaMaki = driver.findElement(By.xpath("//h1[.='Tekka maki']"));
        String actualValue = BrowserUtils.getTextMethod(tekkaMaki);
        String expectedValue = "Tekka maki";
        Assert.assertEquals(actualValue, expectedValue);
//a[@id='navigate-prev']

        Thread.sleep(1000);
        WebElement previousArrow = driver.findElement(By.xpath("//a[@id='navigate-prev']"));
        previousArrow.click();

//h1[.='Shiromi']

        Thread.sleep(1000);
        WebElement shiromiValidation = driver.findElement(By.xpath("//h1[.='Shiromi']"));
        String actualShiromiText = BrowserUtils.getTextMethod(shiromiValidation);
        String expectedShiromiText = "Shiromi";
        Assert.assertEquals(actualShiromiText, expectedShiromiText);

        WebElement shoppingCart = driver.findElement(By.xpath("//span[.='0']"));
        int actualAmount = Integer.parseInt(shoppingCart.getText());
        int expectedAmount = 0;
        Assert.assertEquals(actualAmount, expectedAmount);


    }

    @Test
    public void testCase2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();

        WebElement edamameAddToCart = driver.findElement(By.xpath("//a[@href='#/menu/4']/following-sibling::button"));
BrowserUtils.clickWithJS(driver, edamameAddToCart);

//Thread.sleep(11000);
//WebElement advertisement = driver.findElement(By.className("qual_x_svg_dash"));
//advertisement.click();

WebElement shoppingCartValidation = driver.findElement(By.xpath("//a//span[.='1']"));
int actualAmount = Integer.parseInt(shoppingCartValidation.getText());
int expectedAmount = 1;
Assert.assertEquals(actualAmount, expectedAmount);

WebElement priceValidation = driver.findElement(By.xpath("//p[.='$4.00']"));
double actualPrice = Double.parseDouble(BrowserUtils.getTextMethod(priceValidation).replace("$","").trim());
double expectedPrice = 4;
Assert.assertEquals(actualPrice, expectedPrice);

WebElement emptyCart = driver.findElement(By.xpath("//a[@id='empty-cart']"));
BrowserUtils.clickWithJS(driver, emptyCart);

        WebElement shoppingCartValidation2 = driver.findElement(By.xpath("//span[.='0']"));
        int actualAmount1 = Integer.parseInt(shoppingCartValidation.getText());
        int expectedAmount1 = 0;
        Assert.assertEquals(actualAmount1, expectedAmount1);



    }
    @Test
    public void testCase3() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();

WebElement salmonTeriyaki = driver.findElement(By.xpath("//img[@title='Salmon Teriyaki']"));
BrowserUtils.clickWithJS(driver, salmonTeriyaki);

WebElement addToCart = driver.findElement(By.xpath("//button[@class='buy']"));
        Actions actions = new Actions(driver);

   //  actions.doubleClick(addToCart).perform();
       addToCart = driver.findElement(By.xpath("//button[@class='buy']"));
      // actions.doubleClick(addToCart).perform();
      addToCart.click();
      addToCart.click();
        Thread.sleep(1000);

        WebElement priceValidation = driver.findElement(By.xpath("//p[@class='total-price']"));
        double actualPrice = Double.parseDouble(BrowserUtils.getTextMethod(priceValidation).replace("$", "").trim());
        double expectedPrice = 26.00;
        Assert.assertEquals(actualPrice, expectedPrice);

WebElement amountInShoppingCart = driver.findElement(By.xpath("//span[.='1']"));
int actualAmount = Integer.parseInt(amountInShoppingCart.getText().trim());
int expectedAmount = 1;
Assert.assertEquals(actualAmount, expectedAmount);

WebElement nextClick = driver.findElement(By.xpath("//a[@id='navigate-next']"));
nextClick.click();

WebElement gohanAddToCart = driver.findElement(By.xpath("//button[@class='buy']"));
BrowserUtils.clickWithJS(driver, gohanAddToCart);

WebElement totalAmount = driver.findElement(By.xpath("//p[@class='total-price']"));
double actualAmountOfTotal = Double.parseDouble(totalAmount.getText().replace("$","").trim());
double expectedValue = 29.00;
Assert.assertEquals(actualAmount, expectedAmount);

        WebElement amountInShoppingCartTotal = driver.findElement(By.xpath("//span[.='2']"));
        int actualAmountTotal = Integer.parseInt(amountInShoppingCart.getText().trim());
        int expectedAmountTotal = 2;
        Assert.assertEquals(actualAmountTotal, expectedAmountTotal);







    }

    @Test
    public void testCase4() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();

        Thread.sleep(1000);

    List< WebElement> allProductsPrice = driver.findElements(By.xpath("//span[@class='price']"));
    List<Double > PriceOfAllProducts = new ArrayList<>();
    double actualTotal = 0;
    for (int i = 0; i< allProductsPrice.size(); i++){
      actualTotal+=  Double.parseDouble(allProductsPrice.get(i).getText().replace("$","").trim());

    }
        System.out.println(actualTotal);
    boolean actualTotalPrice = true;
if(actualTotal<25.00){
    actualTotalPrice = false;
    Assert.assertTrue(actualTotalPrice);
}





    }
    @Test
    public void testCase5() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        WebElement ebiRolls = driver.findElement(By.xpath("//a[@href='#/menu/14']/following-sibling::button"));
       ebiRolls.click();
      WebElement tunaRolls = driver.findElement(By.xpath("//a[@href='#/menu/13']/following-sibling::button"));
      tunaRolls.click();


        WebElement chickenTeriyaki = driver.findElement(By.xpath("//a[@href='#/menu/15']/following-sibling::button"));
        chickenTeriyaki.click();

        WebElement clickX = driver.findElement(By.xpath("//img[@width='100' and @src='/kendo-ui/content/spa/websushi/images/200/chicken-teriyaki.jpg']"));
       BrowserUtils.clickWithJS(driver, clickX);
        WebElement amountInShoppingCart = driver.findElement(By.xpath("//span[.='2']"));
        int actualAmount = Integer.parseInt(amountInShoppingCart.getText().trim());
        int expectedAmount = 2;
        Assert.assertEquals(actualAmount, expectedAmount);





    }
    @Test
    public void testCase6() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        WebElement ebiRolls = driver.findElement(By.xpath("//a[@href='#/menu/14']/following-sibling::button"));
        ebiRolls.click();

        WebElement shiromi = driver.findElement(By.xpath("//a[@href='#/menu/8']/following-sibling::button"));
        shiromi.click();

        WebElement checkOut = driver.findElement(By.xpath("//a[@id='checkout']"));
        checkOut.click();

        WebElement totalPriceValidation = driver.findElement(By.xpath("//span[.='$17.00']"));
        double actualTotalPrice= Double.parseDouble(totalPriceValidation.getText().replace("$","").trim());
        double expectedTotalPrice = 17;
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice);

//        WebElement increaseAmount = driver.findElement(By.xpath("//tr[1]/td[2]/span/span[2]/button[1]"));
//        increaseAmount.click();






//        WebElement totalPriceValidationAfterIncrease = driver.findElement(By.xpath("//span[.='$25.00']"));
//        double actualTotalPriceAfterIncrease= Double.parseDouble(totalPriceValidation.getText().replace("$","").trim());
//        double expectedTotalPriceAfterIncrease = 25;
//        Assert.assertEquals(actualTotalPriceAfterIncrease, expectedTotalPriceAfterIncrease);

// WebElement orderNow = driver.findElement(By.xpath("//button[@class='order-now']"));
// orderNow.click();
//
//
//        WebElement amountInShoppingCart = driver.findElement(By.xpath("//span[.='0']"));
//        int actualAmount = Integer.parseInt(amountInShoppingCart.getText().trim());
//        int expectedAmount = 0;
//        Assert.assertEquals(actualAmount, expectedAmount);





    }
}