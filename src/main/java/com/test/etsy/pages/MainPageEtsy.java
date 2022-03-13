package com.test.etsy.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import java.util.List;
import java.util.Locale;

public class MainPageEtsy {
    public MainPageEtsy(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
@FindBy(xpath = "//input[@id=\"global-enhancements-search-query\"]")
    WebElement searchBox;

//    @FindBy(xpath = "//button[@data-id=\"gnav-search-submit-button\"]")
//    WebElement enter;

    @FindBy(xpath = "//li//h3")
    List<WebElement> allHeader;



    public void searchBoxSendKeys(String item){
        searchBox.sendKeys(item, Keys.ENTER);

    }
    public boolean validateHeader(){
        for (WebElement header: allHeader){
            String headers = header.getText().trim().toLowerCase();
            if(!(headers.contains("iphone") || headers.contains("13")
            ||headers.contains("case"))){
                return false;
            }
        }
        return true;
    }

}
