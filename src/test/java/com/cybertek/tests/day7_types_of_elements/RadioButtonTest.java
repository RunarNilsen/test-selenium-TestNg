package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void testRadio1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        // there can be default selection in radioButtons.WHen you open the page, it is already selected.
        // We will learn how to verify if radioButton is selected or not. THEN we will learn how to select the button.


        // Locating radio buttons
        WebElement blueRadioButton = driver.findElement(By.cssSelector("#blue"));
        WebElement redRadioButton = driver.findElement(By.cssSelector("#red"));

        // for blue button
        // now checking if the default blue is selected or not. we ganna use "isSelected()" method.
        Assert.assertTrue(blueRadioButton.isSelected(), "verify that blue is selected");

        // for red button
        // now checking if the red button isnot selected.
        Assert.assertFalse(redRadioButton.isSelected(), "verify that red is not selected");

        Thread.sleep(3000);

        // clicking red button and
        redRadioButton.click();

        // for blue button
        // now checking if the default blue is selected or not. we ganna use "isSelected()" method.
        Assert.assertFalse(blueRadioButton.isSelected(), "verify that blue is NOT selected");

        // for red button
        // now checking if the red button is selected.
        Assert.assertTrue(redRadioButton.isSelected(), "verify that red is selected");

        driver.quit();

    }


}
