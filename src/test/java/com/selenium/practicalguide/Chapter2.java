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

        /// test
    }

    @Test(priority = 10)
    public void ActionBuildPerform1() {

        getDriver().get("file:////Users//vbook//Desktop//8850OS_Code//Chapter%202//HTML//Selectable.html");

        WebElement one = getDriver().findElement(By.name("one"));
        WebElement three = getDriver().findElement(By.name("three"));
        WebElement five = getDriver().findElement(By.name("five"));
        // Add all the actions into the Actions builder.
        Actions builder = new Actions(getDriver());
        builder.keyDown(Keys.CONTROL).click(one).click(three).click(five).keyUp(Keys.CONTROL);
        // Generate the composite action.
        Action compositeAction = builder.build();
        // Perform the composite action.
        compositeAction.perform();
    }

    @Test(priority = 20)
    public void MoveByOffSet() {
        driver.get("file:////Users//vbook//Desktop//8850OS_Code//Chapter%202//HTML//selectable.html");
        WebElement three = getDriver().findElement(By.name("three"));
        System.out.println("X coordinate: " + three.getLocation().getX() + "Y coordinate: " + three.getLocation().getY());
        Actions builder = new Actions(getDriver());
        builder.moveByOffset(three.getLocation().getX() + 1, three.getLocation().getY() + 1);
        builder.perform();
    }

    @Test(priority = 30)
    public void MoveByOffSetPage46() {

        driver.get("file:////Users//vbook//Desktop//8850OS_Code//Chapter%202//HTML//selectable.html");
        WebElement three = driver.findElement(By.name("three"));
        System.out.println("X coordinate: " + three.getLocation().getX() + "Y coordinate: " + three.getLocation().getY());
        Actions builder = new Actions(driver);
        builder.moveByOffset(three.getLocation().getX() + 1, three.getLocation().getY() + 1);
        builder.perform();
    }

    @Test(priority = 40)
    public void MoveByOffsetAndClick() {
        driver.get("file:////Users//vbook//Desktop//8850OS_Code//Chapter%202//HTML//selectable.html");
        WebElement seven = driver.findElement(By.name("seven"));
        System.out.println("X Coordinate: " + seven.getLocation().getX() + " Y Coordinate:" + seven.getLocation().getY());
        sleep(10000);
        Actions builder = new Actions(driver);
        builder.moveByOffset(seven.getLocation().getX() + 3, seven.getLocation().getY() + 3).click();
        builder.perform();
        sleep(10000);
        System.out.println("X Coordinate: " + seven.getLocation().getX() + " Y Coordinate:" + seven.getLocation().getY());

    }

    @Test(priority = 10)
    public void ActionBuildPerform() {

        getDriver().get("file:////Users//vbook//Desktop//8850OS_Code//Chapter%202//HTML//Selectable.html");
        WebElement one = getDriver().findElement(By.name("one"));
        WebElement three = getDriver().findElement(By.name("three"));
        WebElement five = getDriver().findElement(By.name("five"));
        // add all the actions into the actions builder as follows:
        Actions builder = new Actions(getDriver());
        builder.keyDown(Keys.CONTROL).click(one).click(three).click(five).keyUp(Keys.CONTROL);
        // now generate a composite actions
        // Action compositAction = builder.build();
        // perform the action
        sleep(5000);
        builder.perform();
        sleep(5000);
    }

    // Key points:All user actions are divided in to 2. Mouse based and keyboard based actions.There are around 8 mouse based actions in Actions class

    @Test(priority = 20)
    public void MoveByOffset() {
        getDriver().get("file:////Users//vbook//Desktop//8850OS_Code//Chapter%202//HTML//selectable.html");
        WebElement three = getDriver().findElement(By.name("three"));
        System.out.println("X Coordinate of tile 3 is: " + three.getLocation().getX() + "Y Coordinate of tiel 3 is: "
            + three.getLocation().getY());
        Actions builder = new Actions(getDriver());
        builder.moveByOffset(three.getLocation().getX() + 1, three.getLocation().getY() + 1);
        sleep(3000);
        builder.perform();
    }

    @Test(priority = 30)
    public void MoveByOffsetAndClic() {
        getDriver().get("file:////Users//vbook//Desktop//8850OS_Code//Chapter%202//HTML//selectable.html");
        WebElement seven = getDriver().findElement(By.name("seven"));
        System.out.println(
            "X Coordinate of Seven is:" + seven.getLocation().getX() + "Y Coordinate of Seven is: " + seven.getLocation().getY());
        Actions builder = new Actions(getDriver());
        sleep(3000);
        builder.moveByOffset(seven.getLocation().getX() + 1, seven.getLocation().getY() + 1).click();
        sleep(300);
        builder.click();
        sleep(300);

    }

    @Test(priority = 40)
    public void MoveByOffsetAndClilck() {
        getDriver().get("file:////Users//vbook//Desktop//8850OS_Code//Chapter%202//HTML//Selectable.html");

        // Decalring and initializing tile web elements one, eleven and five
        WebElement one = getDriver().findElement(By.name("one"));
        WebElement eleven = getDriver().findElement(By.name("eleven"));
        WebElement five = getDriver().findElement(By.name("five"));

        // Decalring and initializing style element for tile one
        int border = 1;
        int tileWidth = 100;
        int tileHeight = 80;

        // building actions builder
        Actions builder = new Actions(getDriver());

        // Click one
        builder.moveByOffset(one.getLocation().getX() + border, one.getLocation().getY() + border).click();

        //Click eleven
        builder.moveByOffset(2 * tileWidth + 4 * border, 2 * tileHeight + 4 * border);

        //click five
        builder.moveByOffset(-2 * tileWidth - 4, -tileHeight - 2 - 2 * border).click();



    }


    @Test(priority = 50)
    public void ClickOnWebElement() {
        getDriver().get("file:////Users//vbook//Desktop//8850OS_Code//Chapter%202//HTML//Selectable.html");
        WebElement one = getDriver().findElement(By.name("one"));
        WebElement eleven = getDriver().findElement(By.name("eleven"));
        WebElement five = getDriver().findElement(By.name("five"));
        Actions builder = new Actions(getDriver());

        //        //Click on One
        //        builder.click(one);
        //        builder.perform();
        //        sleep(3000);
        //
        //        //Click on eleven
        //        builder.click(eleven);
        //        builder.perform();
        //        sleep(3000);
        //
        //        //Click on five
        //        builder.click(five);
        //        builder.perform();
        //        sleep(3000);
        // Or you can click all tiles at once, as follows

        builder.click(one).click(eleven).click(five);
        builder.build().perform();

    }

    @Test(priority = 60)
    public void ClickAndHold() {
        getDriver().get("file:////Users//vbook//Desktop//8850OS_Code//Chapter%202//HTML//Sortable.html");
        WebElement three = getDriver().findElement(By.name("three"));
        Actions builder = new Actions(getDriver());
        // Move tile3 to the position of tile  by coordinates
        builder.moveByOffset(200, 20).click().moveByOffset(120, 20).perform();

        // or  // Move tile3 to the position of the tile 2 by passing element

        builder.clickAndHold(three).moveByOffset(120, 0).perform();
        sleep(3000);
    }

    @Test(priority = 70)
    public void ClickAndRelease() {
        getDriver().get("file:////Users//vbook//Desktop//8850OS_Code//Chapter%202//HTML//Sortable.html");
        WebElement three = getDriver().findElement(By.name("three"));
        Actions builder = new Actions(getDriver());
        // Move tile3 to the position of the tile 2 by passing element
        builder.clickAndHold(three).moveByOffset(120, 0).release().perform();
        sleep(3000);

    }

    @Test(priority = 80) // page 55. dragAndDropBy method using an offset
    public void DragMe() {
        getDriver().get("file:////Users//vbook//Desktop//8850OS_Code//Chapter%202//HTML//DragMe.html");
        WebElement dragMe = getDriver().findElement(By.id("draggable"));
        Actions builder = new Actions(driver);
        builder.dragAndDropBy(dragMe, 300, 200).perform();
        sleep(5000);

    }

    @Test(priority = 90)
    public void DraMeWithSrcAndTarget() {
        getDriver().get("file:////Users//vbook//Desktop//8850OS_Code//Chapter%202//HTML//DragAndDrop.html");
        WebElement src = getDriver().findElement(By.id("draggable"));
        WebElement target = getDriver().findElement(By.id("droppable"));
        Actions builder = new Actions(getDriver());
        builder.dragAndDrop(src, target).perform();
    }

    @Test(priority = 100)
    public void DoubleClick() {
        getDriver().get("file:////Users//vbook//Desktop//8850OS_Code//Chapter%202//HTML//DoubleClick.html");
        WebElement dblClick = getDriver().findElement(By.name("dblClick"));
        Actions builder = new Actions(getDriver());
        builder.moveToElement(dblClick).doubleClick().perform();
        sleep(5000);
    }

    @Test(priority = 110)
    public void DoubleClickVersion2() {
        getDriver().get("file:////Users//vbook//Desktop//8850OS_Code//Chapter%202//HTML//DoubleClick.html");
        WebElement dblClick = getDriver().findElement(By.name("dblClick"));
        Actions builder = new Actions(getDriver());
        builder.doubleClick(dblClick).perform();
        //Assert.assertEquals(true, "Double Clicked !!."); HELP ****: why is assert is deprecated? any alternative for assert?
    }


    @Test(priority = 120)
    public void ContectClick() {
        getDriver().get("file:////Users//vbook//Desktop//8850OS_Code//Chapter%202//HTML//ContextClick.html");
        WebElement contextMenu = getDriver().findElement(By.id("div-context"));
        Actions builder = new Actions(getDriver());
        builder.contextClick(contextMenu).click(getDriver().findElement(By.name("Item 4"))).perform();

    }

    @Test(priority = 130)
    public void ContextClick() {
        getDriver().get("file:////Users//vbook//Desktop//8850OS_Code//Chapter%202//HTML//ContextClick.html");
        WebElement contextMenu = getDriver().findElement(By.id("div-context"));
        Actions builder = new Actions(getDriver());
        builder.moveToElement(contextMenu).contextClick().click(getDriver().findElement(By.name("Item 4"))).perform();

    }

    // learning note: keysUp and keysDown works with Shift, Ctrl, and Alt keys and returns An IllegalArgumentException is thrown when the passed key is not one of the
    //Shift, Ctrl, and Alt keys.

    // keysUp exercise:

    @Test(priority = 140)
    public void KeysDown() {
        getDriver().get("file:////Users//vbook//Desktop//8850OS_Code//Chapter%202//HTML//ContextClick.html");
        WebElement contextMenu = getDriver().findElement(By.id("div-context"));
        Actions builder = new Actions(getDriver());
        builder.moveToElement(contextMenu).contextClick().click(getDriver().findElement(By.name("Item 4"))).perform();
        builder.keyDown(Keys.CONTROL).click();
        builder.keyUp(Keys.CONTROL);
    }

    @AfterClass(alwaysRun = true)
    public void terminateApp() {

        tearDown();
    }

}
