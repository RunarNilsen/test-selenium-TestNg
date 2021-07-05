package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IsDisplayed {
    // It can be an element in html but not directly on the page. The element in this case is called a hidden element.
    // that is, like opening the login page when pressing the start button.
    // If element is not displayed, we cannot interact with the element.
    @Test
    public void testDisabled() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        // we can reach the input box element but we cannot write anything on it.
        WebElement userNameInput = driver.findElement(By.id("username"));
        Assert.assertFalse(userNameInput.isDisplayed(), "Verify inputbox is not displayed");

        WebElement startButton = driver.findElement(By.xpath("//div[@id ='start']/button"));
        startButton.click();
        // IMPORTANT : WE HAVE TO WAIT UNTILL PAGE IS OPENED. THATS WHY WE USE 6 SECOND WAIT.
        Thread.sleep(6000);

        Assert.assertTrue(userNameInput.isDisplayed(), "Verify inputbox is displayed");
        userNameInput.sendKeys("Martin Smith");

        Thread.sleep(2000);
        driver.quit();


    }
}
