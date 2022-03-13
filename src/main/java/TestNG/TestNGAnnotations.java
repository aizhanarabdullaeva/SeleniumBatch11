package TestNG;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite");
        //you can use to setup your chrome browser properties
        //delete cookies
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
        //You can use to launch your browser
    }
@BeforeClass
public void beforeClass(){
    System.out.println("Before class");
    //you can navigate to the website
}
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("before method");
        //you can use to login the page
    }
    @Test
    public void test1(){
        System.out.println("test1");
    }
    @Test
    public void test2(){
        System.out.println("test2");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("after method");
        // You can take a screenshot for failed test annotations
        //driver.quite();
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After class");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("after test");
    }
@AfterSuite
    public void afterSuite(){
    System.out.println("after suite");
}
}
