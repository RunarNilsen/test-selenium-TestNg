package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        // Test case step1: Open web browser
        WebDriver driver = WebDriverFactory.getDriver("CHROME");

        // Test case step2: Navigate to the website(Link)
        driver.get("http://practice.cybertekschool.com/sign_up");
        Thread.sleep(1000);

        // Test case step3: find email_box and type email there
        String fullName = "Mike Smith";
        // Eğer web element olarak id yoksa name e bakarız.
        WebElement fullNameInputBox = driver.findElement(By.name("full_name")); // it returns webElement
        fullNameInputBox.sendKeys(fullName); // typing email in the email_box

        // Test case step3: find email_box and type email there
        String expectedEmail = "mike@smith.com";
        // Eğer web element olarak id yoksa name e bakarız.
        // This is the proper way
        //WebElement emailInputBox = driver.findElement(By.name("email")); // it returns webElement
        //emailInputBox.sendKeys(expectedEmail); // typing email in the email_box
        // this is the LAZY WAY
        driver.findElement(By.name("email")).sendKeys(expectedEmail);

        // Test case step5: Find and click "Sign up"  button
        //WebElement signUpButton = driver.findElement(By.id("wooden_spoon")); // it returns webElement
        //signUpButton.click(); // click the "Sign Up"  button
        //LAZY WAY
        driver.findElement(By.name("wooden_spoon")).click();

        /*
        name locatorı neredeyse hiç dynamic olmaz ama çoklamış olabilir.
        Bu durumda ne yapmak gerekiyor?

        NOT: EHER id ve name yoksa ya da işimize yaramazsa tagName ile işlem yaparız.
         */




    }
}
