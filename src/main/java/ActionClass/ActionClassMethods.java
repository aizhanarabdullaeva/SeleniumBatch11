package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ActionClassMethods {
    //ContextClick --> right click
    @Test
    public void ContextClick() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement contextMenu = driver.findElement(By.partialLinkText("Context"));
        contextMenu.click();

        WebElement box = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        //in Action Class you must use perform at the end
        actions.contextClick(box).perform();


    }
    @Test
    public void hoverOver() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        WebElement hover = driver.findElement(By.linkText("Hovers"));
        hover.click();
        Thread.sleep(1000);;
Actions actions = new Actions(driver);

        List<WebElement> names = driver.findElements(By.tagName("h5"));
        List<WebElement> pictures = driver.findElements(By.xpath("//div[@class='figure']//img"));
        List<String> expectedNames = Arrays.asList("name: user1", "name: user2","name: user3");


        for(int i=0; i<names.size();i++){
            Thread.sleep(1000);
            actions.moveToElement(pictures.get(i)).perform(); // moveToElement --> hoverOver
            Assert.assertEquals(BrowserUtils.getTextMethod(names.get(i)),expectedNames.get(i));
            System.out.println(names.get(i).getText());
        }

    }
@Test
    public void doubleClick(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://demo.guru99.com/test/simple_context_menu.html");
    driver.manage().window().maximize();

//    WebElement doubleClickButton = driver.findElement(By.xpath("//button"));
    Actions actions = new Actions(driver);
  //  actions.doubleClick(doubleClickButton).perform();
//actions.doubleClick(driver.findElement(By.tagName("button"))).perform();
    //context-menu-one btn btn-neutral
WebElement rightClick = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
actions.contextClick(rightClick).perform();
}
@Test
    public  void practiceDoubleClick() throws InterruptedException {
    //TASK FOR STUDENTS
        /*
        Scenario to Automate:
1. Launch the Chrome web browser.
2. Open a URL "https://selenium08.blogspot.com/2019/11/double-click.html".
3. Locate the element "Double-click".
4.  click on the current location (i.e. on Double-click element).
5. Close the web browser.
         */
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://selenium08.blogspot.com/2019/11/double-click.html");
    driver.manage().window().maximize();
     WebElement doubleClickButton = driver.findElement(By.xpath("//button[.='Double-Click me to see Alert message']"));
Actions actions = new Actions(driver);
actions.doubleClick(doubleClickButton).perform();
Thread.sleep(1000);
driver.quit();


}
@Test
    public void dragAndDrop() throws InterruptedException {
     WebDriverManager.chromedriver().setup();
     WebDriver driver = new ChromeDriver();
     driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
     driver.manage().window().maximize();
    WebElement acceptCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
    Thread.sleep(3000);
    acceptCookies.click();
    Actions actions = new Actions(driver);
    for(int i=0; i<5; i++){
        actions.sendKeys(Keys.ARROW_DOWN).perform();
    }

WebElement draggableButton = driver.findElement(By.xpath("//div[@id='draggable']"));
WebElement orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
String actualMessage = orangeBox.getText();
String expectedMessage = "... Or here.";
Assert.assertEquals(actualMessage, expectedMessage);

actions.dragAndDrop(draggableButton,orangeBox).perform();
Thread.sleep(3000);
    orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
String actualAfterDragAndDown = BrowserUtils.getTextMethod(orangeBox);
String expectedAfterDragAndDown = "You did great!";
Assert.assertEquals(actualAfterDragAndDown, expectedAfterDragAndDown);

String actualCssValue = orangeBox.getCssValue("background-color");
String expectedCssValue = "rgba(238, 111, 11, 1)";
Assert.assertEquals(actualCssValue, expectedCssValue);


}
@Test
    public void clickAndHold() throws InterruptedException {
   WebDriverManager.chromedriver().setup();
   WebDriver driver = new ChromeDriver();
   driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
   driver.manage().window().maximize();
    WebElement acceptCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
    Thread.sleep(3000);
    acceptCookies.click();

WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
String actualBlueBox = BrowserUtils.getTextMethod(blueBox);
String expectedBlueBox = "Drag the small circle here ...";
Assert.assertEquals(actualBlueBox, expectedBlueBox);

Thread.sleep(1000);
    WebElement draggableButton = driver.findElement(By.xpath("//div[@id='draggable']"));
    Actions actions = new Actions(driver);
    actions.clickAndHold(draggableButton).moveToElement(blueBox).release().perform();

}

@Test
    public void selfTask() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://demoqa.com/droppable");
    driver.manage().window().maximize();
    Thread.sleep(1000);
    WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
    WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
Actions actions =new Actions(driver);
actions.dragAndDrop(drag,drop).perform();

String actualText = "Dropped!";
Thread.sleep(1000);
  drop = driver.findElement(By.xpath("//div[@id='droppable']"));
    Thread.sleep(1000);
String expectedText = BrowserUtils.getTextMethod(drop);
    Assert.assertEquals(actualText, expectedText);

    String actualCssValue = drop.getCssValue("background-color");
    String expectedCssValue = "rgba(70, 130, 180, 1)";
    Assert.assertEquals(actualCssValue, expectedCssValue);


}
@Test
    public void clickAndHoldTask() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://demoqa.com/droppable");
    driver.manage().window().maximize();
    Thread.sleep(1000);
WebElement accept = driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
accept.click();

WebElement NotAcceptable = driver.findElement(By.xpath("//div[@id='notAcceptable']"));
WebElement dropBox = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[2]"));
Actions actions = new Actions(driver);
actions.clickAndHold(NotAcceptable).moveToElement(dropBox).release().perform();

WebElement whiteBox = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[2]/p"));
String actualText = whiteBox.getText();
String expectedText = "Drop here";
Assert.assertEquals(actualText, expectedText);
    WebElement whiteBox1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[2]"));
//color
   String actualColor = whiteBox1.getCssValue("color");
   String expectedColor = "rgba(33, 37, 41, 1)";
   Assert.assertEquals(actualColor, expectedColor);
//div[@id='droppable' and  @class='drop-box ui-droppable']//p[.='Drop here']

    WebElement acceptable = driver.findElement(By.xpath("//div[@id='acceptable']"));
    actions.clickAndHold(acceptable).moveToElement(whiteBox1).release().perform();

    whiteBox = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[2]/p"));
    String actualDroppedText = whiteBox.getText();
    String expectedDroppedText = "Dropped!";
    Assert.assertEquals(actualDroppedText, expectedDroppedText);

    whiteBox1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[2]"));
//color
    String actualColorAfterDropped = whiteBox1.getCssValue("background-color");
    String expectedColorAfterDropped = "rgba(70, 130, 180, 1)";
    Assert.assertEquals(actualColorAfterDropped, expectedColorAfterDropped);


}
@Test
    public void moveByOffset(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        driver.manage().window().maximize();

        WebElement slider = driver.findElement(By.xpath("//input"));
        Actions actions = new Actions(driver);
        //x--> horizontal
    //y--> vertical
        actions.clickAndHold(slider).moveByOffset(50,0).perform();

}
@Test
    public void shortCutForTestingSlider() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://the-internet.herokuapp.com/horizontal_slider");
    driver.manage().window().maximize();

    WebElement slider = driver.findElement(By.xpath("//input"));
    WebElement range = driver.findElement(By.xpath("//span[@id='range']"));

    String myRange = "5";
    while (!range.getText().trim().equals(myRange)) {

        slider.sendKeys(Keys.ARROW_RIGHT);

    }
}
@Test
    public void MoveByOffsetPractice(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("http://www.techtorialacademy.com/");
    driver.manage().window().maximize();

    WebElement contactUs = driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Contact Us']"));
    Point coordinatesOfContactUs = contactUs.getLocation();

    int xCord = coordinatesOfContactUs.getX();
    int yCord = coordinatesOfContactUs.getY();
    Actions actions = new Actions(driver);
    actions.moveByOffset(xCord,yCord).click().perform();




}





}
