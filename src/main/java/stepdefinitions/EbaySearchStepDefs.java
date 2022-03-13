package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Locale;

public class EbaySearchStepDefs {
    WebDriver driver;
    @Given("user is on ebay homepage")
    public void user_is_on_ebay_homepage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
    }
    @When("user searches for iMac 2020")
    public void user_searches_for_i_mac() {
        WebElement searchBox = driver.findElement(By.xpath("//input[@id=\"gh-ac\"]"));
        searchBox.sendKeys("iMac 2020", Keys.ENTER);
    }
    @Then("user sees results about iMac only")
    public void user_sees_results_about_i_mac_only() {
        List<WebElement>allHeaders = driver.findElements(By.xpath("//ul//a//h3[@class=\"s-item__title\"]"));
     for(WebElement header : allHeaders){
             Assert.assertTrue(header.getText().trim().toLowerCase().contains("imac"));
     }


    }
    @Then("there are more than {int} pages of results")
    public void there_are_more_than_pages_of_results(Integer expectedPages) {
        List<WebElement> pages = driver.findElements(By.xpath("//ol//li"));
        Assert.assertTrue(pages.size()>expectedPages);


    }
}
