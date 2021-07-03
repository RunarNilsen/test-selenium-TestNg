package com.cybertek.tests.day5_xPath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathLocator {
    public static void main(String[] args) throws InterruptedException {

        // Test case step1: Open web browser
        WebDriver driver = WebDriverFactory.getDriver("CHROME");

        // Test case step2: Navigate to the website(Link)
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(1000);

        // Test case step5: Find and click button
        WebElement xpathClickButton2 = driver.findElement(By.xpath("//button[@onclick = 'button2()']")); // it returns webElement
        xpathClickButton2.click(); // click the "retrieve password"  button

        Thread.sleep(2000);
        // Test case step5: Find and click button
        WebElement xpathClickButton6 = driver.findElement(By.xpath("//button[@name = 'button6']")); // it returns webElement
        xpathClickButton6.click(); // click the "retrieve password"  button

        Thread.sleep(2000);
        // Test case step5: Find and click button
        WebElement xpathClickButton1 = driver.findElement(By.xpath("//button[text()='Button 1']")); // it returns webElement
        xpathClickButton1.click(); // click the "retrieve password"  button


        Thread.sleep(2000);
        // Test case step5: Find and click button
        WebElement xpathClickButton3 = driver.findElement(By.xpath("//button[starts-with(@id, 'button_')]")); // it returns webElement
        xpathClickButton3.click(); // click the "retrieve password"  button


    }
}
