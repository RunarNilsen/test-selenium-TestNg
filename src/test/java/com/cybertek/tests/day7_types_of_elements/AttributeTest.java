package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test
    public void testAttribute() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        // Locating radio buttons
        WebElement blueRadioButton = driver.findElement(By.cssSelector("#blue"));
        blueRadioButton.getAttribute("value");

        // getting type attribute of blue radio button
        System.out.println(blueRadioButton.getAttribute("type"));

        // getting name attribute of blue radio button
        System.out.println(blueRadioButton.getAttribute("name"));

        // get the value of checked
        // Since "checked" attribute does not keep any value, it will return true or false based on the conditions.
        System.out.println(blueRadioButton.getAttribute("checked"));

        // trying to get attribute that doesnot exist

        // getting name attribute of blue radio button.
        // IF ATTRIBUTE DOESNOT EXIST, IT WILL RETURN "NULL"
        System.out.println(blueRadioButton.getAttribute("href"));

        // BY USİNG "outerHTML", WE CAN GET ALL ınformation of an element.
        // LİKE THİS   "<input type="radio" id="blue" name="color" checked=""> "
        System.out.println(blueRadioButton.getAttribute("outerHTML"));

        // BY USİNG "innerHTML", WE CAN GET text part of an element.
        System.out.println(blueRadioButton.getAttribute("innerHTML"));


        driver.quit();

    }



}
