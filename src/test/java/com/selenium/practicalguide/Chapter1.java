package com.selenium.practicalguide;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import com.utils.BaseUtils;
import com.utils.TestngContext;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class Chapter1 extends BaseUtils {


    @BeforeClass(alwaysRun = true)
    public void launchBrowser(ITestContext context) {

        TestngContext.setContext(context);
        setDriver(); //get the driver;

    }

    @Test(priority = 10)
    public void GoogleSearch() {

        getDriver().get("http://www.google.com");
        WebElement searchBox = getDriver().findElement(By.name("q"));
        searchBox.sendKeys("huskers nebraska");
        searchBox.submit();

    }


    @Test(priority = 20)
    public void GoogleSearchButtonByName() {
        getDriver().get("http://www.google.com");
        WebElement searchBox = getDriver().findElement(By.id("btnK"));
        searchBox.submit();
        //sleep(5000);
        driver.quit(); // ***** NEED HELP. AfterClass 'terminateApp()' commented below did not work. So i used driver.quit(); instead.
    }

    @Test(priority = 30)
    public void GoogleSearchButtonByID() {
        //WebElement searchButton = getDriver().findElement(By.id("gbqfbb"));
        getDriver().get("http://www.google.com");
        WebElement searchBox = getDriver().findElement(By.id("gbqfbb"));
        Assert.assertTrue(true, "Google Search");
        searchBox.click();
        driver.quit();

    }

    @Test(priority = 40)
    public void GoogleSearchPageByTagName() {
        getDriver().get("http://www.google.com");
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        System.out.println(buttons.size());
        driver.quit();
    }

    @Test(priority = 50) // ***** NEED HELP . firebug returns class name gsfi lst-d-f. check with herb. 
    public void GoogleSearchByClassName() {

        getDriver().get("http://www.google.com");
        WebElement searchBox = getDriver().findElement(By.className("gsfi"));  //input[@class='gsfi lst-d-f'] 
        searchBox.sendKeys("Omaha Nebraska");
        sleep(5000);
    }


    @Test(priority = 51)
    public void GoogleSearchByLinkText() {
        getDriver().get("http://www.google.com");
        WebElement aboutLink = getDriver().findElement(By.xpath("//*[@id='hplogo']"));
        Assert.assertTrue(verifyTitle("Google"));
        aboutLink.click();

    }

    @Test(priority = 60)
    public void GoogleSearchByXpath() {

        getDriver().get("http://www.google.com");
        //WebElement searchButton = driver.findElement(By.xpath("//*[@id='gbqfbb']")); //driver.findElement(By.xpath("//input[@name='btnK']"));
        WebElement searchButton = getDriver().findElement(By.xpath("//input[@name='btnK']"));

        System.out.println(searchButton.getText());

        sleep(5000);
    }

    @Test(priority = 70)
    public void GoogleSearchByCSSSelector() {
        getDriver().get("http://www.google.com");
        WebElement searchButton = getDriver().findElement(By.cssSelector("#gbqfbb"));
        System.out.println(searchButton.getText()); // ** NEED HELP: does not return searchbutton text
        System.out.println("Hi vamsi");
    }


    @Test(priority = 80)
    public void GetAttributes() {
        getDriver().get("http://www.google.com");
        WebElement searchButton = getDriver().findElement(By.xpath("//input[@name='btnK']"));
        System.out.println("value of the button is: " + searchButton.getAttribute("value"));
        System.out.println("Label of the button is:" + searchButton.getAttribute("aria-label"));
        System.out.println("jsaction of the button is: " + searchButton.getAttribute("jsaction"));
        System.out.println("type of the button is:" + searchButton.getAttribute("type"));
    }


    @Test(priority = 90)
    public void sendKeys() {
        getDriver().get("http://www.google.com");
        WebElement searchBox = getDriver().findElement(By.name("q"));
        searchBox.sendKeys(Keys.chord(Keys.SHIFT, "test test test"));
        sleep(4000);
        searchBox.clear();
        searchBox.sendKeys(Keys.chord(Keys.SHIFT, "packt publishing in Upper Case"));
        searchBox.submit();
        sleep(5000);
    }



    @Test(priority = 100)
    public void GetCSSValue() {
        getDriver().get("http://www.google.com");
        WebElement searchBox = getDriver().findElement(By.name("btnK"));
        System.out.println(searchBox.getCssValue("font-family"));
    }

    @Test(priority = 110)
    public void GetTagName() {
        getDriver().get("http://www.google.com");
        WebElement searchButton = getDriver().findElement(By.name("btnK"));
        System.out.println(searchButton.getTagName());
    }

    @Test(priority = 120)
    public void isDisplayed() {
        getDriver().get("http://www.google.com");
        WebElement searchButton = getDriver().findElement(By.name("btnK"));
        System.out.println(searchButton.isDisplayed());
    }

    @Test(priority = 130)
    public void isEnabled() {
        getDriver().get("http://www.google.com");
        WebElement searchButton = getDriver().findElement(By.name("btnK"));
        System.out.println(searchButton.isEnabled());

    }

    @Test(priority = 140)
    public void isSelected() {
        getDriver().get("http://www.google.com");
        WebElement searchBox = getDriver().findElement(By.name("q"));
        System.out.println(searchBox.isSelected());
    }

    @AfterClass(alwaysRun = true)
    public void terminateApp() {

        tearDown();
    }


}
