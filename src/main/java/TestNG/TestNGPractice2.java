package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class TestNGPractice2 {
    @Test
            public void ValidationOfAscendingOrderOfOptions() throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar = driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        Thread.sleep(200);
        WebElement options = driver.findElement(By.xpath("//a[.='Options']"));
        options.click();
        Thread.sleep(200);
        List<WebElement> alloptions = driver.findElements(By.xpath("//tbody//tr//td[2]"));
        Set<String> expectedOptionsOrder = new TreeSet<>();
        //LinkedHashSet stores insertion order
        Set<String> actualOptionsOrder = new LinkedHashSet<>();
        for (WebElement option : alloptions) {
            actualOptionsOrder.add(option.getText().trim());
            expectedOptionsOrder.add(option.getText().trim());

            Assert.assertEquals(actualOptionsOrder, expectedOptionsOrder);
        }
    }
    @Test
            public void validationOfDescendingOrder() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar = driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        Thread.sleep(300);
        WebElement options = driver.findElement(By.xpath("//a[.='Options']"));
        options.click();
        Thread.sleep(300);

        WebElement validationOfOptionName = driver.findElement(By.xpath("//a[.='Option Name']"));

        validationOfOptionName.click();

        List<WebElement> descendingAllOptions = driver.findElements(By.xpath("//tbody//tr//td[2]"));
        List<String> actualDescendingOrder = new LinkedList<>();
        List<String> expectedDescendingOrder = new ArrayList<>();
        for (int i = 0; i < descendingAllOptions.size(); i++) {
            actualDescendingOrder.add(descendingAllOptions.get(i).getText().trim());
            expectedDescendingOrder.add(descendingAllOptions.get(i).getText().trim());
            Collections.sort(expectedDescendingOrder);
            Collections.reverse(expectedDescendingOrder);

        }
        Assert.assertEquals(actualDescendingOrder, expectedDescendingOrder);

    }

    @Test
    public void validationOfAscendingOrderOfSortOrders() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar = driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        Thread.sleep(1000);
        WebElement options = driver.findElement(By.xpath("//a[.='Options']"));
        options.click();
        Thread.sleep(1000);
        List<WebElement> allSortOrders = driver.findElements(By.xpath("//tbody//tr/td[3]"));
Set<String> expectedValue = new TreeSet<>();
Set<String> actualValue = new LinkedHashSet<>();
        for (int i = 0; i < allSortOrders.size(); i++) {
            expectedValue.add(allSortOrders.get(i).getText().trim());
            actualValue.add(allSortOrders.get(i).getText().trim());

        }
Assert.assertEquals(actualValue,expectedValue);

    }
    @Test
    public void descendingOrderOfSortOrder() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement catalogBar = driver.findElement(By.id("menu-catalog"));
        catalogBar.click();

        Thread.sleep(1000);
        WebElement options = driver.findElement(By.xpath("//a[.='Options']"));
        options.click();

        Thread.sleep(1000);
        WebElement sortOrderButton = driver.findElement(By.xpath("//a[.='Sort Order']"));
        sortOrderButton.click();

        List<WebElement> allSortOrders = driver.findElements(By.xpath("//tbody//tr/td[3]"));
        List<Integer> expectedValue = new ArrayList<>();
        List<Integer> actualValue = new LinkedList<>();
        for (WebElement sortOrder : allSortOrders) {
            expectedValue.add(Integer.parseInt(sortOrder.getText().trim()));
            actualValue.add(Integer.parseInt(sortOrder.getText().trim()));
            Collections.sort(expectedValue);
            Collections.reverse(expectedValue);
            Assert.assertEquals(expectedValue, actualValue);



        }


    }
    }



