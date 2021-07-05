package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {

    @Test
    public void testDisabledButton() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenRadioButton = driver.findElement(By.cssSelector("#green"));

        // if an element is not eneabled, it is not clickable.
        Assert.assertFalse(greenRadioButton.isEnabled(), " Verify that green radio button is not enabled");
    }

    @Test
    public void testDisabledButton2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.xpath("//form[@id='input-example']/input"));

        // if an element is not eneabled, it is not clickable.
        Assert.assertFalse(inputBox.isEnabled(), " Verify that inputBox is not enabled");
    }





}
