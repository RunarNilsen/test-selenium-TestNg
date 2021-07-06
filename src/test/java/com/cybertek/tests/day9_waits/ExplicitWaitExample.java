package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitExample {

     /*
    Some elements may not be visible while the page is loading. In this case, we get No Such ELement error. That's why
    We need to use dynamic wait.
    Explicit way also checks the element intermittently until it finds it. When it finds the element, it takes action.
    If it cannot find the element in a certain time, it will throw an error.

    IMPORTANT NOTE: WE USE  THIS FOR ELEMENTS THAT INITIALLY WAS PART OF HTML BUT IT TAKES TIME TO BE VISIBLE.
 WE CANNOT USE THIS FOR ELEMENTS THAT ARE NOT PART OF HTML BEFORE IT IS VISIBLE.
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
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        driver.findElement(By.tagName("button")).click();

        WebElement usernameInput = driver.findElement(By.id("username"));

        // HOW TO WAIT EXPLICITLY?
        // Create Explicit wait object. DYNAMIC WAY OF WAITING
        WebDriverWait wait = new WebDriverWait(driver, 10); // wait object is ready. now Write conditons

        // wait until usernameInput element is visible
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.sendKeys("MIKE SMITH");

    }

    @Test
    public void testImplicitWait2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        // click enable
        driver.findElement(By.xpath("//*[.='Enable']")).click();

        // fınd inputbox
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(inputBox)); // wait until element is clickable
        inputBox.sendKeys(" MIKE SMITH");



    }

}
