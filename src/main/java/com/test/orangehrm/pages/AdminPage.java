package com.test.orangehrm.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminPage {
   public  AdminPage(WebDriver driver){
      PageFactory.initElements(driver, this);
   }
   @FindBy(id = "btnAdd")
   WebElement addButton;

@FindBy(id = "systemUser_userType")
   WebElement userRole;

@FindBy(id = "systemUser_employeeName_empName")
   WebElement employeeName;

@FindBy(id = "systemUser_userName")
   WebElement username;

@FindBy(xpath = "//select[@id='systemUser_status']")
   WebElement status;

@FindBy(name = "systemUser[password]")
   WebElement password;

@FindBy(name = "systemUser[confirmPassword]")
   WebElement confirmPassword;

@FindBy(id = "btnSave")
   WebElement save;

@FindBy(xpath = "//tr//a[contains(@href,'saveSystemUser')]")
   List<WebElement> allNames;

public void sendingAllInformationForEmployee() throws InterruptedException {
   addButton.click();
   BrowserUtils.SelectBy(userRole,"Admin","text");
   employeeName.sendKeys("Alice Duval");
   username.sendKeys("aizhana@527");
   BrowserUtils.SelectBy(status, "0","value");
   password.sendKeys("Aizhana12");
   confirmPassword.sendKeys("Aizhana12");
   Thread.sleep(1000);
   save.click();
   Thread.sleep(1000);

}
public boolean validationOfEmployeeIsAdded(String username){
   for(WebElement name : allNames){
      if(name.getText().trim().equals(username)){
         return true;
      }
   }
   return false;

}



}
