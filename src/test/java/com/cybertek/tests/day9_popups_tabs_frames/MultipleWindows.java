package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

    //

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
    public void testMultipleWindows() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/windows");

        System.out.println("Title before new window = " + driver.getTitle());

        driver.findElement(By.linkText("Click Here")).click(); // It will open page on new window.
        // It will give the long ID number of the current window. We need to navigate it to the new window.
        String currentWindowHandle = driver.getWindowHandle();
        System.out.println("currentWindowHandle = " + currentWindowHandle); // this is dynamic

        // getWindowHandles()   take the all open windows and put them in a set.
        Set<String> windowHandles = driver.getWindowHandles();

        // we use both handles method to switch to the new window.(IF WE HAVE 2 WİNDOWS.)
        for (String windowHandle : windowHandles) {
            if(!windowHandle.equals(currentWindowHandle)){
                driver.switchTo().window(windowHandle); // switching the new window.
            }

        }
        System.out.println("Title After new window = " + driver.getTitle());
    }

    @Test
    public void testMoreThanTwoWindows() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/windows");

        System.out.println("Title before new window = " + driver.getTitle());

        driver.findElement(By.linkText("Click Here")).click(); // It will open page on new window.

        // getWindowHandles()   take the all open windows and put them in a set.
        Set<String> windowHandles = driver.getWindowHandles();

        // We will switching until we are in desired window, and we stop switching.
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle); // switching the new window.
            // whenever title is equal to the expected title.STOP switching.
            // we have to determine expected title manually.
            if(driver.getTitle().equals("New Window")){
                break;
            }

        }
        System.out.println("Title After new window = " + driver.getTitle());
    }




}
