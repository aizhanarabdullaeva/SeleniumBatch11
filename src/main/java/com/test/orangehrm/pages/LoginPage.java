package com.test.orangehrm.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }
    @FindBy(id = "txtUsername")
    WebElement username;
    @FindBy(xpath = "//input[@id='txtPassword']")
    WebElement password;
    @FindBy(id = "btnLogin")
    WebElement login;
    @FindBy(id = "spanMessage")
    WebElement errorMessage;

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.login.click();

    }
    public String getErrorMessage(){
        return BrowserUtils.getTextMethod(errorMessage);
    }
    public String getColorOfErrorMessage(){

        return errorMessage.getCssValue("color");
    }
}
