package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ThreadSleepExample {


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
    public void testThreadSleepWait() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/3");

        // To open web element, we need to wait some times like 6 seconds to make web element visible
        // 1st way to use Thread.sleep()
        Thread.sleep(6000); // It stop executions of the any codes. This doesn't check any condition. STATIC.
        driver.findElement(By.id("username")).sendKeys(" MIKE SMITH");
        Thread.sleep(2000);
    }


    }
