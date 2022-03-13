package com.test.demoPage.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage {
    public CustomersPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "input-firstname")
    WebElement firstName;

    @FindBy(id = "input-lastname")
    WebElement lastName;

    @FindBy(xpath = "//input[@id=\"input-email\"]")
    WebElement email;

    @FindBy(xpath = "//input[@id=\"input-telephone\"]")
    WebElement phoneNumber;

    @FindBy(xpath = "//input[@id=\"input-password\"]")
WebElement password;

    @FindBy(xpath = "//input[@id=\"input-confirm\"]")
    WebElement confirmPassword;

    @FindBy(xpath = "//button[@class=\"btn btn-primary\"]")
    WebElement saveButton;

    @FindBy(xpath = "//div[@class=\"alert alert-danger alert-dismissible\"]")
    WebElement text;



    public void addingCustomer(){
        firstName.sendKeys("Aizhana");
        lastName.sendKeys("Abdull");
        email.sendKeys("aizhana@gmail.com");
        phoneNumber.sendKeys("2134578991");
        password.sendKeys("Aizhana27");
        confirmPassword.sendKeys("Aizhana27");
        saveButton.click();

    }
    public String validationOfText(){
        System.out.println(text.getText());
        return  text.getText().trim();
    }
//    public String validationOfColor(){
//        return
//    }


}
