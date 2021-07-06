package com.cybertek.tests.day10_action_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class ActionsTest {

    /*
    There are different kind of "Actions" on a web page. When you go to on Categories with mouse, It will show
    different options. We call this action.

     */

    WebDriver driver;  // we declare webDriver class in class that we can reach driver in anywhere in that class.

    @BeforeMethod
    public void setUp(){
        // It will run before each test case
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void testAction() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement image1 = driver.findElement(By.tagName("img")); // locating  first image

        // Action Class --> that contains all the user interactions
        // how to create actions object? --> passing driver as a constructor.
        Actions actions = new Actions(driver);

        // we say, move your mouse to element of image1 and with perform() (do the action.)
        actions.moveToElement(image1).perform();

        // In order for the profile link here to be visible, we must first move the mouse over the image1 element,
        // otherwise we will get an error.
        WebElement profileLink = driver.findElement(By.linkText("View profile"));
        Thread.sleep(2000);
        Assert.assertTrue(profileLink.isDisplayed(), "verify profile link is displayed");
        profileLink.click(); // click the profile link
        Assert.assertEquals("http://practice.cybertekschool.com/users/1", driver.getCurrentUrl(), "verify the current url");
        Thread.sleep(2000);
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions action1 = new Actions(driver); // In Action class, we have "dragAndDrop" method.

        // Accept the cookies
        List<WebElement> acceptAndClose = driver.findElements(By.xpath("//*[.='Accept and Close']"));
        List<WebElement> acceptCookies= driver.findElements(By.xpath("//*[.='Accept Cookies']"));
        Thread.sleep(2000);
        if(acceptAndClose.size()>0){
            driver.findElement(By.xpath("//*[.='Accept and Close']")).click();
        }else if(acceptCookies.size()>0){
            driver.findElement(By.xpath("//*[.='Accept Cookies']")).click();
        }

        // We need to define whic element is source element, and which one is target element
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement dropTarget = driver.findElement(By.id("droptarget"));

        //driver.findElement(By.xpath("//*[.='Accept and Close']")).click();
        //Thread.sleep(2000);
        action1.dragAndDrop(source, dropTarget).perform();
        Thread.sleep(2000);



    }

    @Test
    public void dragAndDrop2() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions action1 = new Actions(driver); // In Action class, we have "dragAndDrop" method.

        // Accept the cookies
        List<WebElement> acceptAndClose = driver.findElements(By.xpath("//*[.='Accept and Close']"));
        List<WebElement> acceptCookies = driver.findElements(By.xpath("//*[.='Accept Cookies']"));
        Thread.sleep(2000);
        if (acceptAndClose.size() > 0) {
            driver.findElement(By.xpath("//*[.='Accept and Close']")).click();
        } else if (acceptCookies.size() > 0) {
            driver.findElement(By.xpath("//*[.='Accept Cookies']")).click();
        }

        // 1st step move the mouse to the source
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement dropTarget = driver.findElement(By.id("droptarget"));
        // 2nd step click and hold the source
        // 3rd move the source to the target place
        // 4th release the source on to the target place
        action1.moveToElement(source).clickAndHold().moveToElement(dropTarget).pause(2000).release().perform();
        Thread.sleep(2000);

    }






}
