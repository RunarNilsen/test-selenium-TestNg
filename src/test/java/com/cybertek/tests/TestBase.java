package com.cybertek.tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    /*
    We need to write BeforeMethod and AfterMethod in every single class which is not efficient.
    Instead of this, we will create one class that includes the methods and all new classes
    will inherent from the class.
     */

    // we use either protected or public here to use driver in other classes that inherent this class
    protected WebDriver driver;  // we declare webDriver class in class that we can reach driver in anywhere in that class.
    protected Actions actions;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        // It will run before each test case
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions = new Actions(driver); // initialize the action class here
        wait = new WebDriverWait(driver, 10); // initialize wait object here.
        driver.get(ConfigurationReader.get("url")); // get the url from configuration.properties file for each test case
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        Driver.closeDriver(); // closing the driver at the end.

    }



}
