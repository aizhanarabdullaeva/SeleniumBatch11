package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageSentrifugo {
    public LoginPageSentrifugo(WebDriver driver){
        PageFactory.initElements(driver, this);

    }
// we are going to store our element's locations and methods here.
    @FindBy(xpath = "//input[@id='username']")
    WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='loginsubmit']")
    WebElement logInButton;

    public void logIn(){
        userName.sendKeys("EM01");
        password.sendKeys("sentrifugo");
        logInButton.click();

    }
    public void dynamicLogIn(String userName, String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        logInButton.click();


    }





}
