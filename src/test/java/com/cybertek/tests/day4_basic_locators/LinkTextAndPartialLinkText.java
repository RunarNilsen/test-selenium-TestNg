package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTextAndPartialLinkText {
    public static void main(String[] args) throws InterruptedException {

        // linklerle çalışırken kullanırız bu locatorları. Linklerin olduğu yerdeki yazıları(text) locator
        // olarak kullanırız.

        // Test case step1: Open web browser
        WebDriver driver = WebDriverFactory.getDriver("CHROME");

        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        Thread.sleep(1000);

        WebElement link1 = driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger")); // linke gider.
        link1.click(); // linke tıklar.


        /*
        // linkte uniqe olan bir kısmı vererekte bu işlem yapılabilir.
        WebElement linkPartial = driver.findElement(By.partialLinkText("Example 2")); // linke gider.
        linkPartial.click(); // linke tıklar.

         */



    }
}
