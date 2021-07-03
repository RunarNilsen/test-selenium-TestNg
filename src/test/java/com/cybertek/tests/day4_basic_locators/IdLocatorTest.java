package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        // Test case step1: Open web browser
        WebDriver driver = WebDriverFactory.getDriver("CHROME");

        // Test case step2: Navigate to the website(Link)
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(1000);

        // Test case step3: Find and click "Don't click!"  button
        WebElement dontClickButton = driver.findElement(By.id("disappearing_button")); // it returns webElement
        dontClickButton.click(); // click the "retrieve password"  button

        /*
        ID locatorı unıque dir ama dinamik olabilir yani sürekli değişken olabilir. ID nin dinamik oldugu
        durumlarda static olan bir locator bulup onun üzerinden işlem yapmalıyız.
        Peki ID nin dinamik oldugunu nereden anlayabiliriz?
        Sayfayı 3-4 defa refresh yaptıgınızda ID değişmiyorsa statictir.

        */





    }
}
