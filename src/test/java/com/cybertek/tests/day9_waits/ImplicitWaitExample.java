package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {

    /*
    Some elements may not be visible while the page is loading. In this case, we get No Such ELement error. That's why
    We need to use dynamic wait.
    Explicit way also checks the element intermittently until it finds it. When it finds the element, it takes action.
    If it cannot find the element in a certain time, it will throw an error.

    IMPORTANT NOTE: WE CANNOT USE THIS FOR ELEMENTS THAT INITIALLY WAS PART OF HTML BUT IT TAKES TIME TO BE VISIBLE.
 WE USE THIS FOR ELEMENTS THAT ARE NOT PART OF HTML BEFORE IT IS VISIBLE.
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
    public void testImplicitWait() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");

        // To open web element, we need to wait some times like 6 seconds to make web element visible
        // It will check the page during 20 seconds. If ıt doesnot find in 20 seconds, ıt will give error.
        // We run this just once and it will run for all of web element in same class. we can add this to the BeforeMethod.
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //DYNAMIC WAY (maximum 30 seconds logical)
        WebElement element = driver.findElement(By.cssSelector("#finish"));
        System.out.println(element.getText());

    }

}
