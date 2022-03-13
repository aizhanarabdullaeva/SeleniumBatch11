package TestNG;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
//    @DataProvider(name = "FullNameTest")
//    public Object[][] getData(){
//        return new Object[][]{
//                {"aizhana","abdull","aizhana abdull"},
//                {"enes","enes2","enes enes2"},
//                {"maria","sharapova","maria sharapova"},
//                {"george","sergei","george sergei"},
//                {"aizhana1","abdull1","aizhana1 abdull1"},
//                {"ivan","ivanov","ivan ivanov"}
//        };
//    }



        @Test(dataProvider = "FullNameTest", dataProviderClass = DataForNames.class)
    public void test(String username, String lastname, String expectedFullName){
        String userName= username;
        String lastName = lastname;
        String fullName = userName+" "+lastName;
        Assert.assertEquals(fullName,expectedFullName);

    }






}
