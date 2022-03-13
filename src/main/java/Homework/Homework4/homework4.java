package Homework.Homework4;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

public class homework4 {
    @Test
    public void testCase1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://uitestpractice.com/Students/Select#");
        driver.manage().window().maximize();

        WebElement indiaSelected = driver.findElement(By.xpath("//select[@id=\"countriesSingle\"]"));
  //BrowserUtils.SelectBy(indiaSelected, "india","value");

//        System.out.println(BrowserUtils.getTextMethod(indiaSelected));

        List<WebElement> gettingSize = driver.findElements(By.xpath("//select[@id='countriesSingle']//option"));
        int actualSize =0;
        for(int i=0; i< gettingSize.size(); i++){

            if(gettingSize.get(i).isDisplayed()){
                actualSize++;
            }

        }

        int expectedSize = 4;
        Assert.assertEquals(actualSize, expectedSize);

        List<String>actualValuesFromDropDownBox = new ArrayList<>();
        for (int i=0; i< gettingSize.size();i++){
            actualValuesFromDropDownBox.add(gettingSize.get(i).getText().trim());


        }

List<String> expectedValuesFromDropDownBox = new ArrayList<>();
        expectedValuesFromDropDownBox.add("India");
        expectedValuesFromDropDownBox.add("United states of America");
        expectedValuesFromDropDownBox.add("China");
        expectedValuesFromDropDownBox.add("England");

        Assert.assertEquals(actualValuesFromDropDownBox, expectedValuesFromDropDownBox);


        WebElement gettingSize1 = driver.findElement(By.xpath("//select[@id='countriesSingle']"));
//   BrowserUtils.SelectBy(gettingSize1,"value", "england");
Select select = new Select(gettingSize1);
select.selectByValue("england");
BrowserUtils.SelectBy(gettingSize1,"United states of America", "text");
BrowserUtils.SelectBy(gettingSize1, "2","index");



    }
    @Test
    public void testCase2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://uitestpractice.com/Students/Select#");
        driver.manage().window().maximize();

        List<WebElement> multipleSelectBox = driver.findElements(By.xpath("//select[@id='countriesMultiple']"));
        List<String> actualText = new ArrayList<>();
        List<String> expectedText = new ArrayList<>();
        for (int i = 0;i< multipleSelectBox.size();i++){
            actualText.add(multipleSelectBox.get(i).getText());

        }
expectedText.add("India");
        expectedText.add("United states of America");
        expectedText.add("China");
        expectedText.add("England");

        WebElement select = driver.findElement(By.xpath("//select[@id='countriesMultiple']"));
      BrowserUtils.SelectBy(select, "china","value");
      BrowserUtils.SelectBy(select, "England", "text");

      WebElement validationChinaEngland = driver.findElement(By.xpath("//div[@id=\"result\"]"));
      boolean validation= validationChinaEngland.isDisplayed();
      Assert.assertTrue(validation);

      Select select2 = new Select(select);
    select2.deselectAll();

        WebElement selectAllCountries = driver.findElement(By.xpath("//select[@id='countriesMultiple']"));
        BrowserUtils.SelectBy(selectAllCountries, "china","value");
        BrowserUtils.SelectBy(selectAllCountries, "England", "text");
        BrowserUtils.SelectBy(selectAllCountries, "0", "index");
        BrowserUtils.SelectBy(selectAllCountries, "usa", "value");

        WebElement validationOfAllCountriesIsDisplayed = driver.findElement(By.xpath("//div[@id=\"result\"]"));
        boolean isDisplayed = validationOfAllCountriesIsDisplayed.isDisplayed();
        Assert.assertTrue(isDisplayed);

select2.selectByIndex(2);
select2.selectByValue("england");





    }
    @Test
    public void testCase3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cars.com/");
        driver.manage().window().maximize();
WebElement dropDown = driver.findElement(By.xpath("//select[@id=\"make-model-search-stocktype\"]"));

BrowserUtils.SelectBy(dropDown, "cpo", "value");

        Thread.sleep(1000);
        WebElement make = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.SelectBy(make, "Toyota", "text");

        Thread.sleep(1000);
        WebElement model = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.SelectBy(model, "Corolla", "text");

        Thread.sleep(1000);
        WebElement price = driver.findElement(By.xpath("//select[@id='make-model-max-price' and @name='list_price_max']"));
        BrowserUtils.SelectBy(price, "30000", "value");

        Thread.sleep(1000);
        WebElement mile = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.SelectBy(mile, "3", "index");

        Thread.sleep(1000);
        WebElement zipCode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipCode.clear();
        zipCode.sendKeys("60660");
        Thread.sleep(1000);
        WebElement search = driver.findElement(By.xpath("//button[@class='sds-button' and @data-linkname=\"search-cpo-make\"]"));
        search.click();
        Thread.sleep(1000);

        WebElement title = driver.findElement(By.xpath("//h1[.='Certified used Toyota Corolla for sale']"));

        boolean doesContain = title.getText().trim().contains("Certified used");
       Assert.assertTrue(doesContain);

        Thread.sleep(1000);
      boolean isDisplayed = title.isDisplayed();
      Assert.assertTrue(isDisplayed);
       Thread.sleep(1000);
WebElement miles40 = driver.findElement(By.xpath("//select[@id=\"location-distance\"]"));
Select select = new Select(miles40);
      Assert.assertEquals(select.getFirstSelectedOption().getText(),"40 miles");

      WebElement certifiedIsSelected = driver.findElement(By.id("stock-type-select"));
              Select select1 = new Select(certifiedIsSelected);
      Assert.assertEquals(select1.getFirstSelectedOption().getText(), "Certified");

WebElement toyotaIsSelected = driver.findElement(By.xpath("//select[@id='make_select']"));
Select select2 =  new Select(toyotaIsSelected);
Assert.assertEquals(select2.getFirstSelectedOption().getText(), "Toyota");







    }

    @Test
    public void testCase4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cars.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement dropDown = driver.findElement(By.xpath("//select[@id=\"make-model-search-stocktype\"]"));

        BrowserUtils.SelectBy(dropDown, "new_cpo", "value");

        Thread.sleep(1000);
        WebElement make = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.SelectBy(make, "Lexus", "text");

        Thread.sleep(1000);
        WebElement model = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.SelectBy(model, "lexus-es_350", "value");

        Thread.sleep(1000);
        WebElement price = driver.findElement(By.xpath("//select[@id='make-model-max-price' and @name='list_price_max']"));
        BrowserUtils.SelectBy(price, "50000", "value");

        Thread.sleep(1000);
        WebElement mile = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.SelectBy(mile, "4", "index");

        Thread.sleep(1000);
        WebElement zipCode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipCode.clear();
        zipCode.sendKeys("60016");
        Thread.sleep(1000);
        WebElement search = driver.findElement(By.xpath("//button[@data-linkname=\"search-new-and-cpo-make\"]"));
        search.click();

List<WebElement> cars = driver.findElements(By.xpath("//a[@class=\"vehicle-card-link js-gallery-click-link\"]"));
int count = 0;
for(WebElement car : cars ){
    if(car.isDisplayed()){
        count++;
    }
}

    Assert.assertTrue(count<20);


for(WebElement car :cars) {

    boolean actualValue = car.getText().trim().contains("Lexus ES 350");
    Assert.assertTrue(actualValue);

}
List<WebElement>miles = driver.findElements(By.xpath("//div[@class=\"vehicle-dealer\"]/following-sibling::div[@class=\"miles-from \"]"));
for(int i = 0; i<miles.size();i++) {
    System.out.println(miles.get(i).getText().trim());
}
WebElement sortBy = driver.findElement(By.xpath("//select[@id=\"sort-dropdown\"]"));
BrowserUtils.SelectBy(sortBy, "Highest price","text");
List<WebElement> prices = driver.findElements(By.xpath("//span[@class='primary-price']"));
List<Double> pricesInDouble = new ArrayList<>();
for(int i=0; i< prices.size();i++ ){
    pricesInDouble.add(Double.parseDouble(prices.get(0).getText().replace("$","").replace(",","").trim()));

}




    }






}
