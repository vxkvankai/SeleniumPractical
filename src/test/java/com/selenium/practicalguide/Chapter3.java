package com.selenium.practicalguide;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import com.utils.BaseUtils;
import com.utils.TestngContext;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Chapter3 extends BaseUtils {

    @BeforeClass(alwaysRun = true)
    public void launchBrowser(ITestContext context) {

        TestngContext.setContext(context);
        setDriver(); //get the driver;
    }

    @Test(priority = 10)
    public void BrowserCapabilities() {
        Map capabilitiesMap = new HashMap();
        capabilitiesMap.put("takesScreenshot", true);
        DesiredCapabilities capabilities = new DesiredCapabilities(capabilitiesMap);
        DesiredCapabilities driver = new DesiredCapabilities(capabilities);
        getDriver(capabilities);
        getDriver().get("http://www.google.com");


    }



    @AfterClass(alwaysRun = true)
    public void terminateApp() {

        tearDown();
    }

}
