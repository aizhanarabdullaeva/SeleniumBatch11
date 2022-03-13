package com.test.audiUsa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class AudiQ5 {
    public WebElement getAudiQ5() {
        return audiQ5;
    }

    public AudiQ5(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[.=\"SUVs & Wagons\"]/parent::div/following-sibling::ul[@class='nm-model-band-container-item-list']//a")
   List<WebElement> allSuvAndWagons;
    @FindBy (xpath = "//a[contains(text(),'Starting at $')]")
   List <WebElement> carsPrice;
    @FindBy(xpath = "//div[@id='onetrust-close-btn-container']//button")
    WebElement cookies;
    @FindBy(xpath = "//span[.='2022 Audi Q5']")
    WebElement audiQ5;
    @FindBy(xpath = "//a[@class=\"sc-fzqBZW jkEZoQ\"]")
    WebElement buildButton;
    @FindBy(xpath = "//div[@class=\"audi-copy-m nm-module-trimline-engine-headline-sub\"]//span[.='$ 43,300']")
    WebElement startingPrice;
    @FindBy(xpath = "//div[@class=\"audi-headline-order-3 nm-module-trimline-engine-headline\"]")
    List<WebElement>typesOfCar;
    @FindBy(xpath = "//span[@class=\"nm-module-trimline-engine-price-tag\"]")
    List<WebElement>pricesOfCars;
public void cookiesClick(){
    cookies.click();
}

    public void buildButtonClick() {
        buildButton.click();
    }
    public double validationOfStartingPrice() {
       return  Double.parseDouble(startingPrice.getText().trim().replace("$", "").replace(",", ""));
    }
    public void validationOfTypes() {

        List<String> actualCarsTypes = new ArrayList<>();
        List<String> expectedCarsTypes = new ArrayList<>();
        for (WebElement type : typesOfCar) {
            actualCarsTypes.add(type.getText().trim());
        }
        expectedCarsTypes.add("Premium");
        expectedCarsTypes.add("Premium Plus");
        expectedCarsTypes.add("Prestige");
        Assert.assertEquals(actualCarsTypes, expectedCarsTypes);
    }
    public void validationOfPrices(){
        List<Double> actualPrices = new ArrayList<>();
        List<Double> expectedPrice = new ArrayList<>();
        for (WebElement price : pricesOfCars){
            actualPrices.add(Double.parseDouble(price.getText().trim().replace("$","").replace(",","")));

        }
expectedPrice.add(43300.0);
        expectedPrice.add(48300.0);
        expectedPrice.add(50000.0);






    }


}

