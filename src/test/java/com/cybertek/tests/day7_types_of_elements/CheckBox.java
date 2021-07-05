package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBox {


    @Test
    public void testCheckBox() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement inputBox1 = driver.findElement(By.cssSelector("#box1"));
        WebElement inputBox2 = driver.findElement(By.cssSelector("#box2"));

        // checking if the checkbox
        Assert.assertFalse(inputBox1.isSelected(), "Verify checkbox1 is not selected");
        inputBox1.click(); // clicking the checkbox
        Assert.assertTrue(inputBox2.isSelected(), "Verify checkbox2 is selected");

        Thread.sleep(2000);
        driver.quit();

    }
}
