package com.test.etsy.tests;

import com.test.etsy.TestBaseEtsy;
import com.test.etsy.pages.MainPageEtsy;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class etsyTest extends TestBaseEtsy {
    @Parameters("Item")
    @Test
    public void etsyValidation(String item){
        MainPageEtsy mainPageEtsy = new MainPageEtsy(driver);
        mainPageEtsy.searchBoxSendKeys(item);
        Assert.assertTrue(mainPageEtsy.validateHeader());



    }
}
