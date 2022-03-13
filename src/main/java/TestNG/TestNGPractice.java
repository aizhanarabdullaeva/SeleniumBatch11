package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestNGPractice {
    @Test
    public void validatewebsite() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        String actualWebsite = driver.getCurrentUrl();
        String expectedWebsite = "https://demo.opencart.com/admin/";
        Assert.assertEquals(actualWebsite, expectedWebsite);
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
    }
    @Test
            public void validateCatalogDislpayed(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement catalog = driver.findElement(By.xpath("//li[@id='menu-catalog']"));
        boolean actualCatalog = catalog.isDisplayed();
        boolean expectedCatalog = true;
        Assert.assertEquals(actualCatalog,expectedCatalog, "Catalog is not there");
catalog.click();
    }
    @Test
    public void validateProductsDisplayed(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement catalog = driver.findElement(By.xpath("//li[@id='menu-catalog']"));

        catalog.click();
        WebElement productBar = driver.findElement(By.xpath("//a[.='Products']"));
        boolean actualProductBar = productBar.isDisplayed();
        boolean expectedProductbar = true;
        Assert.assertEquals(actualProductBar, expectedProductbar);
        productBar.click();

    }
@Test
    public void validationOfBoxes() throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.get("https://demo.opencart.com/admin/");
    driver.manage().window().maximize();
    WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
    loginButton.click();

    WebElement catalog = driver.findElement(By.xpath("//li[@id='menu-catalog']"));

    catalog.click();
    Thread.sleep(300);
    WebElement productBar = driver.findElement(By.xpath("//a[.='Products']"));
    productBar.click();

    List <WebElement> boxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
    for(int i=1; i<boxes.size();i++){
        Thread.sleep(300);
        boxes.get(i).click();
        boolean actualBoxValidation= boxes.get(i).isDisplayed();
        boolean expextedBoxValidation = true;
        boolean actualBoxValidationIsSelected= boxes.get(i).isSelected();
        boolean expextedBoxValidationIsSelected = true;
        Assert.assertEquals(actualBoxValidation, expextedBoxValidation);
        Assert.assertEquals(actualBoxValidationIsSelected, expextedBoxValidationIsSelected);


    }




}


}
