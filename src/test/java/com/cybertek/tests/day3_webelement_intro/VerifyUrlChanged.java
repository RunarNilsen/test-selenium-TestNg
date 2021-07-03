package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUrlChanged {
    public static void main(String[] args) throws InterruptedException {

        // Test case step1: Open web browser
        WebDriver driver = WebDriverFactory.getDriver("CHROME");

        // Test case step2: Navigate to the website(Link)
        driver.get("http://practice.cybertekschool.com/forgot_password");
        Thread.sleep(1000);

        // Test case step3: find email_box and type email there
        String email = "mike@cybertek.com";
        // Eğer web element olarak id yoksa name e bakarız.
        WebElement emailBox = driver.findElement(By.name("email")); // it returns webElement
        emailBox.sendKeys(email); // typing email in the email_box

        //  // Test case step4: Find and click "retrieve password"  button
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit")); // it returns webElement
        retrievePasswordButton.click(); // click the "retrieve password"  button

        // Test case step5: check if Current URL is the same with the expected url after clicking the button.
        String expectedUrl = "http://practice.cybertekschool.com/email_sent";
        String currentUrl = driver.getCurrentUrl();

        if(currentUrl.equals(expectedUrl)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        driver.quit();


    }
}
