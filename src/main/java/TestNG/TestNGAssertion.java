package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {
    // create one method that takes 2 parameters and return multiplication of these numbers

    public double multiplication(double a, double b){
        double c = a*b;
        return c;
    }

    @Test
    public void validateMultiplication(){

        double actualResult = multiplication(4,5);
        double expectedResult = 20;

        Assert.assertEquals(actualResult,expectedResult,"My first TestNg test");
        //message will show up if it fails
    }
    public double division(double num1, double num2){
        if(num1>num2){

            return num1/num2;
        }
        return num2/num1;
    }
    public int subtraction(int num1, int num2){
        if(num1>num2){

            return num1-num2;
        }
        return num2-num1;
    }



@Test
    public void validateDivision(){
        double actualResult = division(15,3);
        double expectedResult = 5;
        Assert.assertEquals(actualResult,expectedResult);


}
    @Test
    public void validateSubtraction(){
        double actualResult = subtraction(3,3);
        double expectedResult = 0;
        Assert.assertEquals(actualResult,expectedResult);


    }

}
