package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookPractice {
    /*
    Facebook Sign up:
Scenario:
Open a Chrome browser.
Navigate to "http://www.fb.com"
Verify that the page is redirected to "http://www.facebook.com", by getting the current URL. (use Assertion)
Verify that there is a "Create an account" section on the page.
Fill in the text boxes: First Name, Surname, Mobile Number or email address, "Re-enter mobile number", new password.
Update the date of birth in the drop-down.
Select gender.
Click on "Create an account".
Verify that the account is not created.
     */

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.facebook.com");
        System.out.println(driver.getCurrentUrl());
        driver.manage().window().maximize();
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.facebook.com/";
        if (actualURL.equals(expectedURL)) {
            System.out.println("The website is correct");
        } else {
            System.out.println("The website is wrong");
        }


        WebElement createAccount = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        boolean validationButton = createAccount.isDisplayed();
        boolean expectedValidationButton = true;
        if (validationButton == expectedValidationButton) {
            System.out.println("Button is displayed");
        } else {
            System.out.println("Button is not displayed");
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", createAccount);
        createAccount.click();
        Thread.sleep(300);
        WebElement firstname = driver.findElement(By.xpath("//input[@tabindex='0']"));

        firstname.sendKeys("Aizhana");
        Thread.sleep(300);
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Abdull");
        Thread.sleep(300);
        WebElement email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        email.sendKeys("Aizhana@gmail.com");
        Thread.sleep(300);
        WebElement emailConfirmation = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        emailConfirmation.sendKeys("Aizhana@gmail.com");

        Thread.sleep(300);
        WebElement password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        password.sendKeys("Aizhanar");

        Thread.sleep(300);
        WebElement month = driver.findElement(By.xpath("//select[@name='birthday_month']"));
        month.sendKeys("Jan");

        Thread.sleep(300);
        WebElement day = driver.findElement(By.xpath("//select[@name='birthday_day']"));
        day.sendKeys("2");

        Thread.sleep(300);
        WebElement year = driver.findElement(By.xpath("//select[@name='birthday_year']"));
        year.sendKeys("1999");

             Thread.sleep(300);
             WebElement gender = driver.findElement(By.xpath("//input[@name='sex' and @value='1']"));
             gender.click();
             
             Thread.sleep(300);
              WebElement sighUpButton = driver.findElement(By.xpath("//button[@name='websubmit']"));
              sighUpButton.click();
    }
}