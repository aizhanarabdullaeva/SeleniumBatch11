package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class BrowserUtils {
    //we create browser utils to be able to call reusable methods from here to
    // reduce amount of codes
    public static void SelectBy(WebElement element, String value, String methodName){
        Select select = new Select(element);

        switch(methodName){

            case "text":
                select.selectByVisibleText(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            case "value":
                select.selectByValue(value);
            default:
                System.out.println("Method Name is not available. Use text, value, index");
                break;
        }



    }
    public static String getTextMethod(WebElement element){
return element.getText().trim();

    }

   public static String getTitleWithJavaScript(WebDriver driver){

       JavascriptExecutor JSExecutor = (JavascriptExecutor) driver;
       String title = JSExecutor.executeScript("return document.title").toString();
       return title;
   }

public static void  clickWithJS(WebDriver driver, WebElement element) {


    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
    javascriptExecutor.executeScript("arguments[0].click()", element);

}
public static void scrollWithJS(WebDriver driver, WebElement element){
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
    javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)",element);


}
public static void scrollWithXandYCord(WebDriver driver, WebElement element){
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
    Point location = element.getLocation();
    int xCord = location.getX();
    int yCord = location.getY();
    javascriptExecutor.executeScript("window.scrollTo("+xCord+","+yCord+")");




}
public static void switchOnlyForTwoTabs(WebDriver driver, String mainPageId){
    Set<String> allPagesId = driver.getWindowHandles();

    for(String id: allPagesId){
        System.out.println(id);
        if(!id.equals(mainPageId)){
            driver.switchTo().window(id);

        }
    }




}
public static void  switchByTitle(WebDriver driver, String title){
    Set<String> allPages = driver.getWindowHandles();
    for(String id : allPages){
        driver.switchTo().window(id);
        if(driver.getTitle().contains(title)){
            break;
        }
    }

}
public static void getScreenShot(WebDriver driver, String packageName){
    File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    String location = System.getProperty("user.dir")+"/src/java/screenshot"+packageName;
    try {
        FileUtils.copyFile(file, new File(location+System.currentTimeMillis()));
    } catch (IOException e) {
        e.printStackTrace();
    }

}





}
