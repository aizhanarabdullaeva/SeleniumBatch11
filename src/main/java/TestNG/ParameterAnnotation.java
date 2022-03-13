package TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterAnnotation {
    @Parameters("FirstName")

@Test (priority = 2, invocationCount = 10)//how mny times it will count
public void test(String name){
    System.out.println(name);
}
@Parameters({"city","state"})
@Test (priority = 1, invocationTimeOut = 2000)
    public void test1(String city, String state){
    System.out.println(city);
    System.out.println(state);
}

}
