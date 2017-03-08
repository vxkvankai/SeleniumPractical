package com.selenium.practicalguide;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.BaseUtils;
import com.utils.TestngContext;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class Chapter2 extends BaseUtils {

    @BeforeClass(alwaysRun = true)
    public void launchBrowser(ITestContext context) {

        TestngContext.setContext(context);
        setDriver(); //get the driver;

    }

    @Test(priority = 10)
    public void ActionBuildPerform() {

        getDriver().get("file:////Users//vbook//Desktop//8850OS_Code//Chapter%202//HTML//selectable.html");

        WebElement one = driver.findElement(By.name("one"));
        WebElement three = driver.findElement(By.name("three"));
        WebElement five = driver.findElement(By.name("five"));
        // Add all the actions into the Actions builder.
        Actions builder = new Actions(driver);
        builder.keyDown(Keys.CONTROL)
            .click(one)
            .click(three)
            .click(five)
            .keyUp(Keys.CONTROL);
        // Generate the composite action.
        Action compositeAction = builder.build();
        // Perform the composite action.
        compositeAction.perform();
    }

    @Test(priority = 20)
    public void MoveByOffSet() {
        driver.get("file:////Users//vbook//Desktop//8850OS_Code//Chapter%202//HTML//selectable.html");
        WebElement three = driver.findElement(By.name("three"));
        System.out.println("X coordinate: " + three.getLocation().getX() + "Y coordinate: " + three.getLocation().getY());
        Actions builder = new Actions(driver);
        builder.moveByOffset(three.getLocation().getX() + 1, three.getLocation().getY() + 1);
        builder.perform();
    }

    @AfterClass(alwaysRun = true)
    public void terminateApp() {

        tearDown();
    }

}
