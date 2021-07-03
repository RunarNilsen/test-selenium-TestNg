package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUrlNotChanged {

    public static void main(String[] args) throws InterruptedException {

        // Test case step1: Open web browser
        WebDriver driver = WebDriverFactory.getDriver("CHROME");

        // Test case step2: Navigate to the website(Link)
        driver.get("http://practice.cybertekschool.com/forgot_password");
        Thread.sleep(1000);

        // getting current url and assign the url to the variable
        String currentUrl = driver.getCurrentUrl();

        // Test case step3: Find and click "retrieve password"  button
        // Bunun için bu button ı inspect kısmından bulup varsa id si üzerinden bu button a selenium un ulaşmasını saglayacagız.
        // websitesindeki hersey selenium için web elementtir bunlara ulaşmak için WebElement classını kullanırız.

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit")); // it returns webElement
        retrievePasswordButton.click(); // click the "retrieve password"  button

        // Test case step4: check if URL changed after clicking the button.
        String currentUrl1 = driver.getCurrentUrl();

        if(currentUrl.equals(currentUrl1)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        driver.quit();








    }
}
