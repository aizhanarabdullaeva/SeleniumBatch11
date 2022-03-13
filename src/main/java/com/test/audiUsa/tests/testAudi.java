package com.test.audiUsa.tests;

import Utils.BrowserUtils;
import com.test.audiUsa.TestBaseAudi;
import com.test.audiUsa.pages.AudiQ5;
import com.test.audiUsa.pages.MainPageAudi;
import com.test.orangehrm.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testAudi extends TestBaseAudi {
MainPageAudi mainPageAudi;
AudiQ5 audiQ5;
@BeforeMethod
public void initialization(){
    mainPageAudi=new MainPageAudi(driver);
    audiQ5 = new AudiQ5(driver);
}
    @Test
    public void validationOf2022AudiQ5(){
    BrowserUtils.clickWithJS(driver,mainPageAudi.getSuvAndWagons());
    BrowserUtils.clickWithJS(driver, audiQ5.getAudiQ5());
     audiQ5.buildButtonClick();
     Assert.assertEquals(audiQ5.validationOfStartingPrice(),43300.0);
     audiQ5.validationOfTypes();

    }
}
