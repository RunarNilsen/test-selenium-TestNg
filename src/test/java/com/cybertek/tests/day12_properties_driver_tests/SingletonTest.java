package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

    @Test
    public void testDriverSingleton(){
        // first object
        WebDriver driver = Driver.get(); // getting driver object with the browser.
        driver.get("https://www.cybertekschool.com");
    }

    @Test
    public void testDriverSingleton2(){
        WebDriver driver = Driver.get();
        // second object
        driver.get("https://www.amazon.com");
    }



}
