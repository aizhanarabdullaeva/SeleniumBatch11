package stepdefinitions;

import apple.security.KeychainStore;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class AmazonStepDefs {
    WebDriver driver;
    @When("I navigate to Amazon homepage")
    public void i_navigate_to_amazon_homepage() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.amazon.com/");

    }
    @When("I search for iphone  case")
    public void i_search_for_iphone_case() {
        WebElement searchBox = driver.findElement(By.xpath("//input[@name=\"field-keywords\"]"));
        searchBox.sendKeys("iphone 13 case", Keys.ENTER);
    }
    @Then("I should get more than {int} results")
    public void i_should_get_more_than_results(Integer expectedResult) {
        List<WebElement> allCases = driver.findElements(By.xpath("//a//span[@class=\"a-size-medium a-color-base a-text-normal\"]"));
        Assert.assertTrue(allCases.size()>expectedResult);
    }
    @Then("I validate search number")
    public void i_validate_search_number() {
        WebElement resultText = driver.findElement(By.xpath("//span[contains(text(),'1-16 of over 30,000 results for')]"));
        String[]resultsArray=resultText.getText().trim().split(" ");
        int result = Integer.parseInt(resultsArray[3].replace(",",""));
        Assert.assertEquals(result, 30000);

    }

}
