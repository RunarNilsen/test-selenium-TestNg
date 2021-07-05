package com.cybertek.tests.day8_types_of_element2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

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
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
    }

    // How we get all of the button elements in one shot?
    // We should look one locator that will point all of the elements.
    @Test
    public void testFindelements2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        // getting all buttons whose tag name is equal to "button"
        List<WebElement> buttons =  driver.findElements(By.tagName("button"));

        System.out.println("button.size() : " + buttons.size());
        Assert.assertEquals(buttons.size(), 6, "Verify button size is 6");

        // write "iter" and enter to write for loop quickly.
        for (WebElement webElement:buttons){
            System.out.println(webElement.getText());
            Assert.assertTrue(webElement.isDisplayed(), "verify button is displayed");
            Thread.sleep(2000);
            if (webElement.getText().equals("Button 2")){
                webElement.click();
            }
        }

        // we can click button 3 by selecting third web element from the list like that.
        buttons.get(2).click();
    }

    // ANOTHER IMPORTANT FEATURE OF THE FINDELEMENTS:
    /*
    when we use tagName that doesnot exist, "findelement method" will throw error BUT
    "findelements method"  will NOT THROW ERROR. THAT'S WHY WE NEED TO CHECK THE SİZE
    OF THE WEB ELEMENTS LİST. IF İT İS ZERO, THERE İS PROBLEM.
     */

    @Test
    public void testFindelements3() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        // getting all buttons whose tag name is equal to "button".
        // ALT + ENTER for shortcut
        List<WebElement> buttons = driver.findElements(By.tagName("buttonASASA"));
        System.out.println("buttons.size() : " + buttons.size());



    }


    }
