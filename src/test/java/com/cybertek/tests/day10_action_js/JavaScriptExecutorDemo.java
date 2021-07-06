package com.cybertek.tests.day10_action_js;

import com.cybertek.tests.day9_waits.ThreadSleepExample;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorDemo {
    /*
    - Whenever regular click() method doesnot work, we can use Java Script code for clicking.
    - There is no selenium method for scrolling the page up and down. we can use Java Script codes for this.
    - We cannot write to enabled input box with selenium, but we can do it with Java Script codes.


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
    public void clickWithJS() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/");
        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));

        // Java script executor will force to click the link
        JavascriptExecutor jse = (JavascriptExecutor) driver; // casting driver to JavaScriptExecutor
        jse.executeScript("arguments[0].click()", dropdownLink);
    }

    @Test
    public void typeWithJS() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        // Java script executor will force to type something to the input-box
        String longscript = "WILLIAM SMITH";
        JavascriptExecutor jse = (JavascriptExecutor) driver; // casting driver to JavaScriptExecutor
        jse.executeScript("arguments[0].setAttribute('value', '"+ longscript + "')", inputBox);
    }

    @Test
    public void scrollDownAndUpWithJS() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        // scrolling is related to the webpage, therefore we DONT NEED to crate WebElement
        // Java script executor will force to type something to the input-box
        JavascriptExecutor jse = (JavascriptExecutor) driver; // casting driver to JavaScriptExecutor
        // (0,250) means move (horizontially, vertically)
        //jse.executeScript("window.scrollBy(0,250)");

        // we can scrol 10 times by for loop
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,250)");
        }

        // for scrolling up we use (0, -250)
        // we can scrol 10 times by for loop
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-250)");
        }




    }

    // SCROLLING DIRECTLY to the element
    @Test
    public void scrollToElement() throws InterruptedException {
        driver.get("https://amazon.com/");
        WebElement eng = driver.findElement(By.id("icp-touch-link-language"));
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", eng);


    }

    }
