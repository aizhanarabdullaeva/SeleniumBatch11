package com.test.audiUsa.pages;

import Utils.BrowserUtils;
import com.test.audiUsa.TestBaseAudi;
import com.test.orangehrm.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageAudi  {

    public WebElement getSuvAndWagons() {
        return suvAndWagons;
    }

    public MainPageAudi(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//label[@for=\"nm-model-band-9625151-types-0\"]//span[.='SUVs & Wagons']")
    WebElement suvAndWagons;
 public void clickSuvAndWagons(){

 }

}

