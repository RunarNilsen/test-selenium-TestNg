package com.cybertek.tests.day10_action_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverTest {
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

    /*
    * Hover over each image in the website
    * verify each name :user text is displayed.
    * try to Use for loop. try to not use web element if it is possible
     */


    @Test
    public void testUploadFileWithSelenium() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/upload");


    }


}
