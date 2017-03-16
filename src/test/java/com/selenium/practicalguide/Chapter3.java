package com.selenium.practicalguide;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import com.utils.BaseUtils;
import com.utils.TestngContext;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Chapter3 extends BaseUtils {

    @BeforeClass(alwaysRun = true)
    public void launchBrowser(ITestContext context) {

        TestngContext.setContext(context);
        setDriver(); //get the driver;
    }

    @Test(priority = 10)
    public void BrowserCapabilities() {

        getDriver().get("http://www.google.com");
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        System.out.println(scrFile.getAbsolutePath());
        try {
            FileUtils.copyFile(scrFile, new File("//Users//vbook//Desktop/test.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }



    @AfterClass(alwaysRun = true)
    public void terminateApp() {

        tearDown();
    }

}
