package com.test.orangehrm.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PIMPage {
    public PIMPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='btnAdd']")
    WebElement addButton;

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(xpath = "//input[@id=\"employeeId\"]")
    WebElement id;

    @FindBy(name = "photofile")
    WebElement chooseFile;
    @FindBy(xpath = "//input[@id=\"btnSave\"]")
    WebElement saveButton;
    @FindBy(xpath = "//input[@name=\"personal[txtEmpFirstName]\"]")
    WebElement nameCheck;
    @FindBy(xpath = "//input[@name=\"personal[txtEmpLastName]\"]")
    WebElement lastNameCheck;

    @FindBy(xpath = "//input[@name=\"personal[txtEmployeeId]\"]")
    WebElement idCheck;

    @FindBy(xpath = "//input[@id=\"btnSave\"]")
    WebElement edit;
    @FindBy(id = "personal_optGender_2")
    WebElement gender;
    @FindBy(name = "personal[cmbNation]")
    WebElement nationality;

    @FindBy(id = "personal_cmbMarital")
    WebElement maritalStatus;

    @FindBy(xpath = "//input[@id=\"personal_DOB\"]")
    WebElement dateOfBirth;

@FindBy(xpath = "//select[@class=\"ui-datepicker-month\"]")
WebElement month;

    @FindBy(xpath = "//select[@class=\"ui-datepicker-year\"]")
    WebElement year;

    @FindBy(xpath = "//a[.='27']")
    WebElement date;

    @FindBy(xpath = "//input[@id=\"btnSave\"]")
    WebElement saveButton2;
    @FindBy(xpath = "//select[@name=\"personal[cmbNation]\"]")
    WebElement nationalityCheck;







    public void addEmployeeInfo(String firstname, String lastname, String idEmployee, String choosefile){
        addButton.click();
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        id.sendKeys(idEmployee);
        chooseFile.sendKeys(choosefile);
        saveButton.click();
        edit.click();
        gender.click();
        BrowserUtils.SelectBy(maritalStatus,"Single","value");

        BrowserUtils.SelectBy(nationality,"97","value");
dateOfBirth.click();

BrowserUtils.SelectBy(year,"1999","value");
BrowserUtils.SelectBy(month, "2","value");
date.click();
saveButton2.click();





    }
    public boolean validationOfName(String name){
      return nameCheck.getAttribute("value").equals(name);


    }
    public boolean validationOfLastName(String lastname){
        return lastNameCheck.getAttribute("value").equals(lastname);


    }
    public boolean validationOfID(String id){
        return idCheck.getAttribute("value").endsWith(id);


    }
    public boolean validationOfNationality(String nationality1){
        Select select = new Select(nationalityCheck);
        //System.out.println(select.getFirstSelectedOption().);
        return select.getFirstSelectedOption().getText().trim().equals(nationality1);

    }


}
