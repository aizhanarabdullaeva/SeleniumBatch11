package TestNG;
import org.testng.annotations.Test;
public class TestNGIntro {
    @Test(priority =1)
    public void test2(){
        System.out.println(":( What am I gonna do without you");

    }
    @Test(priority = 3)
    public void test1(){
        System.out.println("You are my motivation");
    }
    @Test(priority = 2)
    public void test(){
        System.out.println("Kerima please do not leave me");
    }








}
