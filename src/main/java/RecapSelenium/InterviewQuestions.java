package RecapSelenium;

public class InterviewQuestions {
    /*
    1)What are the advantages and disadvantages of Selenium?
    Advantages: *Free open source;
               *It supports languages(java, phyton, C#, c++)
               *Big Community
               *It supports multiple browsers(chrome, firefox, safari)

    Disadvantages: *You cannot automate captcha,pictures, mobile application
                    *There is no direct call for tge error report(no support call)
                    *It only automates the web application
                    *It doesn't have any syste, to generate report, so we use testing
                    report system as TestNG, Cucumber ...

     2) What type of testing can you automate with selenium?

     **smoke
     **Regression
     ***Functional test(positive and negative

     3)What are the test do not automate with Selenium?
       *Performance Testing
       *Manual Testing (captcha, pictures, AdHoc testing)
        *Non-Functional testing(performance, stress, load ...)
        *Load Testing
        *Stress Testing

        4)What is Locator and what are types of Locators?

       Locator is a way to find the elements from DOM(development tool/page)

                 *ID
                 *ClassName
                 *Name
                 *Xpath
                 *TagName
                 *LinkedTest
                 *PartialLinkTest
                 *CSS

           5)How do you handle Dynamic Elements? CVS*********
           In my project, I faced  many dynamic elements and i used diffreent
           ways to handle it.
           *I used parent child relationship to locate the elements.
           *I used special element types (following-sibling::, preceding-sibling, contains ,
           and, or syntax//I would give more infromation about and or conditions
           *I went with different attributes which are not dynamic

           6) Difference between driver.get and driver.navigate.to()

           Navigate.to()-->It doesn't wait webElement(page) to be loaded.
                        -->it has some methods: back, forward, refresh,to


           Get --> It will wait all the WebElements(page) to be loaded.
                --> it doesn't have any methods

         6) Difference between driver.close() and driver.quit()
         close()--> it specifically closes the window that you are currently working
         (where your driver is located)

         quit()--> it closes all the windows(whole browsers)

         7)What is XPATH?
          * is one of the types of Locators
          *is used to find the location of the Elements on a webpage by using HTML structure

          There are two types of Xpath:
          1)Absolute Xpath:
          it goes from all the way parent to child step by step

          2)Relative Xpath: it directly focuses on the child(location of the element)

          I use mostly in my project relative xpath because it directly focuses on the child
          which I need to locate, It is a way shorter than absolute xpath

          9) what is the difference between absolute and relative xpath
          Absolute Xpath:
         * it goes from all the way parent to child step by step
          *It has (/) single slash
          *syntax is different

          Relative Xpath:
          *it directly focuses on the child(location of the element)
             *It has (//) double slash
          *syntax is different

          10) How do you handle static drop down menu?
          In my project I was handling static dropdown with different ways:
          *I would definitely check the tag of the location
          *If the location has SELECT tag I use select class
          *If the location doesn't have SELECT tag, ---> I use locators to locate my elements(sendKeys())
          *I can also use Action class to hover over my Element

          11) What are the Methods of Select?
          select class is really useful for my project, to be able to use Select class, Element must have Select Tag

          I can Locate the Elements with these Select Methods:
            *SelectByVisibleText()
            *SelectByIndex()
            *SelectByValue()


         12) What kind of exceptions did you face in Selenium?
         *NoSuchElementException
         *StaleElementReferenceException
         *ElementNotInteractable Exception
         *NoSuchFrameException
         *NoSuchWindowException
         *AlertHandledException

         13)In what condition do you get StaleElementException?
         *once the element is not in DOM anymore(removed or changed)
          *Navigate to the another page and come back(element needs a little bit time to be loaded)

         --> I can handle this exception either putting some time to be updated (Thread.sleep)
         -->I reinitialize  my element before i do my actions
         --> I can also refresh the page

         14)How do you handle the alerts?
         There are different types of alert in my framework

         1)Operation system Alert
         *I cannot handle this alert directly, but we can ROBOT class

         *HTML alert, i just need to find the element and click on pop-up

          *JavaScript alert I handle it with Alert class(remoteAlertClass)
Alert alert =driver.switchTo().Alert().

15) For the AlertInterface what kind of methods do you know?

alert is an Interface I agree, but the methods are coming from RemoteAlertClass:
We have 4 methods of AlertClass:
Alert alert =driver.switchTo().Alert()
1-alert.Accept()--> it clicks OK button
2-alert.dismiss()-->it clicks Cancel button
3-alert.getText()-->get Text from pop-up
4-alert.sendKeys()-->sends keys to pop-up

16)


19) What are the driver and WebElement methods

driver methods:
get
navigate
getTitle
getCurrentUrl
findElement/findElements
mange
close
quit

WebElement methods:
sendKeys
click
getText
clear
isDisplayed/IsSelected/
submit
getattribute
GetCssValue

20) what is the difference between check-box and ratio button?

CheckBox: you can click multiple boxes

RadioButton: you can choose only one
21) Difference between isDisplayed, isSelected, isEnabled

isDisplayed it checks if the element is visible or not

IsEnabled: it checks the element is enabled or not -->mostly I use to click
the element to make sure it is not disabled

isSelected: the element selected or not(check mark inside of the box)

22) How do you switch the multiple windows?
I can use driver.WindowHandle and driver.WindowHandles method to switch my windows and handle
the element from other websites. we use set to store our page ids(unique)

23)How do you scroll down to the page from webBrowser?
I would use JavaScript with ScrollIntoView, ScrollTo(x,y) and Point Class
Point point = new Point()
point.getX()
point.getY()
MoveByOffset(x,y)

24) How do you download and upload file?
*Find the element that triggers window(choose file button)
*Find the path of the file you want to upload
*driver.findElement(chooseButton).sendKeys(location of the file+kgz.png)

25) What is the difference between assert and soft assert
Assert: is a class that have some methods to validate the actual and expected data with
the methods like assert.assertEquals....

SoftAssert: is a class that have some methods to validate the actual and expected data with the methods
like assert.assertEquals...

When it fails it doesn't throw an exception



















     */
}
