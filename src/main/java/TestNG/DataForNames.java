package TestNG;

import org.testng.annotations.DataProvider;

public class DataForNames {
    @DataProvider(name = "FullNameTest")
    public Object[][] getData(){
        return new Object[][]{
                {"aizhana","abdull","aizhana abdull"},
                {"enes","enes2","enes enes2"},
                {"maria","sharapova","maria sharapova"},
                {"george","sergei","george sergei"},
                {"aizhana1","abdull1","aizhana1 abdull1"},
                {"ivan","ivanov","ivan ivanov"}
        };
    }
}
