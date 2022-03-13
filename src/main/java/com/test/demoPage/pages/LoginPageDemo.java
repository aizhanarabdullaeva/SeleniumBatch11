package com.test.demoPage.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageDemo {
public LoginPageDemo(WebDriver driver){
    PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//button[@class=\"btn btn-primary\"]")
    WebElement loginButton;
public void loginButton(){
    loginButton.click();
}



}
