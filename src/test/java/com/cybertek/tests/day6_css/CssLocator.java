package com.cybertek.tests.day6_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssLocator {
    public static void main(String[] args) throws InterruptedException {

        // Test case step1: Open web browser
        WebDriver driver = WebDriverFactory.getDriver("CHROME");

        // Test case step2: Navigate to the website(Link)
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(1000);

        // click button
        WebElement cssDontClick = driver.findElement(By.cssSelector("button#disappearing_button")); // it returns webElement
        cssDontClick.click();



    }
}
