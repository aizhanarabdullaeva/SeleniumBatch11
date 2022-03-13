package com.test.demoPage.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageDemo {
    public MainPageDemo(WebDriver driver){
        PageFactory.initElements(driver, this);

    }
     @FindBy(xpath = "//h2[.='12K']")
    WebElement totalOrders;

    @FindBy(xpath = "//h2[.='11.8M']")
    WebElement totalSales;

    @FindBy(xpath = "//div[contains(text(), 'Total Customers')]/following-sibling::div//h2")
    WebElement totalCustomers;

    @FindBy(xpath = "//a[contains(text(),'Customers')]")
    WebElement customers;

    @FindBy(xpath = "//ul[@id=\"collapse33\"]//a[contains(text(),'Customers')]")
    WebElement customersSub;

    @FindBy(xpath = "//i[@class=\"fa fa-plus\"]")
    WebElement plusSign;

    public boolean validationOfTotalOrders(String totalorder){
      return  totalOrders.getText().trim().equals(totalorder);
    }
    public boolean validationOfTotalSales(String totalsales){
        return  totalSales.getText().trim().equals(totalsales);
    }
    public boolean validationOfTotalCustomers(String totalcustomers){
        return  totalCustomers.getText().trim().equals(totalcustomers);
    }

    public WebElement getCustomersSub() {
        return customersSub;
    }

    public WebElement getPlusSign() {
        return plusSign;
    }

    public void customersClick() throws InterruptedException {
        customers.click();
        Thread.sleep(1000);

       // customersSub.click();
        //plusSign.click();
}


}
