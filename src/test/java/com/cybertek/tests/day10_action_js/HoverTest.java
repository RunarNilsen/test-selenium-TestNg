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

import javax.swing.plaf.TableHeaderUI;
import java.util.List;

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
    * verify each name:user text is displayed.
    * try to Use for loop. try to not use web element if it is possible
     */


    @Test
    public void hwForHoversForOneImage() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");


        // Action Class --> that contains all the user interactions
        // how to create actions object? --> passing driver as a constructor.
        Actions actions = new Actions(driver);

        WebElement image = driver.findElement(By.tagName("img"));
        actions.moveToElement(image).perform();
        WebElement userName = driver.findElement(By.xpath("//h5[.='name: user1']"));
        String expectedText = "name: user1";
        String actualText = userName.getText();
        Assert.assertEquals(expectedText, actualText, "Verify that name: user1");

    }

    @Test
    public void homeworkForHoversOtherSolution() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        Actions actions = new Actions(driver);

        for (int i = 1; i <= 3; i++) {
            WebElement image = driver.findElement(By.xpath("(//img)[" + i + "]"));
            actions.moveToElement(image).perform();
            WebElement userName = driver.findElement(By.xpath("//h5[.='name: user" + i + "']"));
            String expectedText = "name: user" + i;
            String actualText = userName.getText();
            Assert.assertEquals(expectedText, actualText, "Verify that name: user" + i);
        }
    }


}
